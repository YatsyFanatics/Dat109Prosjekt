package model;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import businessLogic.dao.RundeoversiktDAO;
import businessLogic.dao.YatzyspillDAO;

@Entity
@Table(name = "yatzyspill", schema = "oblig3")
public class Yatzyspill implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * @EJB
	 * 
	 * @Transient private RundeoversiktDAO rundeDAO;
	 */
	@Transient
	private static final int ANTALLTERNINGER = 5;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillid;

	@OneToOne
	@JoinColumn(name = "admin")
	private Bruker admin;

	@Transient
	private int rundeNr;

	@Transient
	private int forrigeRunde;

	@Transient
	private int spillerSinTur;

	@Transient
	private Bruker vinner;

	@Transient
	private Poengtabell poengtabell;

	@Transient
	private int antallKast;

	@Transient
	private Bruker[] spillere;

	@Transient
	private Terning[] terninger;

	public Yatzyspill(int spillid, Bruker admin, Bruker[] spillere) {
		rundeNr = 0;
		antallKast = 0;
		spillerSinTur = 0;
		poengtabell = new Poengtabell();
		this.spillid = spillid;
		this.admin = admin;
		this.spillere = spillere;
		terninger = new Terning[5];

		for (int i = 0; i < ANTALLTERNINGER; i++) {
			terninger[i] = new Terning();
		}
	}

	public Yatzyspill(Bruker[] spillere) {
		rundeNr = 0;
		antallKast = 0;
		spillerSinTur = 0;
		poengtabell = new Poengtabell();
		terninger = new Terning[5];

		for (int i = 0; i < ANTALLTERNINGER; i++) {
			terninger[i] = new Terning();
		}

		this.spillere = spillere;
		admin = spillere[0];
	}

	public Yatzyspill() {
	}

	public boolean spillTur(String command, boolean[] terningTilstand) {
		boolean oppdater = false;

		if (command.equalsIgnoreCase("trill") && antallKast < 3 && antallKast > 0) {
			oppdaterTerninger(terningTilstand);
			terningKast();
		} else if (command.equalsIgnoreCase("ferdig") && antallKast > 0) {
			antallKast = 0;

			if (poengtabell.sjekkYatzy(getTerningVerdier()) && !harYatzy(spillerSinTur)) {

				poengtabell.yatzy(spillerSinTur, getTerningVerdier());

//				rundeDAO.nyRundeOversikt(new Rundeoversikt(16,spillid,poengtabell.hentRad(16)));

			} else {

				if (harYatzy(spillerSinTur)) {
					poengtabell.regnUt(spillerSinTur, forrigeRunde, getTerningVerdier());
//				rundeDAO.oppdater(new Rundeoversikt(forrigeRunde,spillid,poengtabell.hentRad(forrigeRunde)));
				} else {
					poengtabell.regnUt(spillerSinTur, rundeNr, getTerningVerdier());
//					Rundeoversikt ro = new Rundeoversikt(rundeNr,spillid,poengtabell.hentRad(rundeNr));
//					System.out.print(ro.toString());
//					rundeDAO.nyRundeOversikt(ro);
//					poengtabell.persistRad(spillid, rundeNr);
					oppdater = true;
				}

			}
			resetTerninger();
			nesteSpiller();
		} else if (command.equalsIgnoreCase("trill") && antallKast == 0) {

			resetTerninger();

			terningKast();
		}
		return oppdater;
	}

	public void resetTerninger() {
		boolean[] boolArr = { false, false, false, false, false };

		oppdaterTerninger(boolArr);
	}

	public void oppdaterTerninger(boolean[] boolArr) {
		for (int i = 0; i < terninger.length; i++) {
			terninger[i].setKeep(boolArr[i]);
		}
	}

	private void nesteSpiller() {
		// TODO sjekke om spiller er aktiv
		spillerSinTur = (spillerSinTur + 1) % spillere.length;
		nesteRunde();
	}

	private void nesteRunde() {
		if (spillerSinTur == 0) {
			forrigeRunde = rundeNr;
			rundeNr++;
		}

		if (rundeNr == 6) {
			for (int i = 0; i < spillere.length; i++) {
				if (!harYatzy(i)) {
					poengtabell.regnUt(i, rundeNr, getTerningVerdier());
				}
			}
			rundeNr = 8;

		} else if (rundeNr == 8) {
			for (int i = 0; i < spillere.length; i++) {
				if (harYatzy(i)) {
					poengtabell.regnUt(i, forrigeRunde, getTerningVerdier());
				}
			}
		} else if (rundeNr == 16 && !harYatzy(spillerSinTur)) {

			poengtabell.regnUt(spillerSinTur, rundeNr, getTerningVerdier());

		} else if (rundeNr == 17) {
			for (int i = 0; i < spillere.length; i++) {
				poengtabell.regnUt(i, rundeNr, getTerningVerdier());
			}
			regnUtVinner();
		}
	}

	public void terningKast() {
		for (Terning t : terninger) {
			t.trill();
		}

		antallKast++;
	}

	public void kick() {
		// TODO
	}

	public void purre() {
		// TODO
	}

	public void regnUtVinner() {
		// TODO sjekk etter lik score og inaktive brukere
		Integer[] totalScore = poengtabell.hentRad(17);
		int vinnerScore = totalScore[0];
		vinner = spillere[0];

		for (int i = 1; i < totalScore.length; i++) {
			if (totalScore[i] > vinnerScore) {
				vinnerScore = totalScore[i];
				vinner = spillere[i];
			}
		}
	}

	public Bruker hentSpillerSinTur() {
		return spillere[getSpillerSinTur()];
	}

	public int[] getTerningVerdier() {
		int[] verdier = { terninger[0].getVerdi(), terninger[1].getVerdi(), terninger[2].getVerdi(),
				terninger[3].getVerdi(), terninger[4].getVerdi() };
		return verdier;
	}

	public int getSpillid() {
		return spillid;
	}

	public void setSpillid(int spillid) {
		this.spillid = spillid;
	}

	public int getRundeNr() {
		return rundeNr;
	}

	public void setRundeNr(int rundeNr) {
		this.rundeNr = rundeNr;
	}

	public Bruker getAdmin() {
		return admin;
	}

	public void setAdmin(Bruker admin) {
		this.admin = admin;
	}

	public int getSpillerSinTur() {
		return spillerSinTur;
	}

	public void setSpillerSinTur(int spillerSinTur) {
		this.spillerSinTur = spillerSinTur;
	}

	public Bruker getVinner() {
		return vinner;
	}

	public void setVinner(Bruker vinner) {
		this.vinner = vinner;
	}

	public Poengtabell getPoengtabell() {
		return poengtabell;
	}

	public void setPoengtabell(Poengtabell poengtabell) {
		this.poengtabell = poengtabell;
	}

	public int getAntallKast() {
		return antallKast;
	}

	public void setAntallKast(int antallKast) {
		this.antallKast = antallKast;
	}

	public Bruker[] getSpillere() {
		return spillere;
	}

	public void setSpillere(Bruker[] spillere) {
		this.spillere = spillere;
	}

	public Terning[] getTerninger() {
		return terninger;
	}

	public void setTerninger(Terning[] terninger) {
		this.terninger = terninger;
	}

	public String[] hentSpillerPoeng(int spillerNr) {
		return poengtabell.hentSpillerPoeng(spillerNr);
	}

	public String[] hentSpillereString() {
		String[] s = new String[spillere.length];
		for (int i = 0; i < spillere.length; i++) {
			s[i] = spillere[i].getBrukernavn();
		}
		return s;
	}

	public boolean harYatzy(int spillerNr) {
		return poengtabell.hentVerdi(16, spillerNr) == 50;
	}

	public boolean[] terningStatus() {
		boolean[] keeper = { terninger[0].isKeeping(), terninger[1].isKeeping(), terninger[2].isKeeping(),
				terninger[3].isKeeping(), terninger[4].isKeeping() };
		return keeper;
	}

	public int getForrigeRunde() {
		return forrigeRunde;
	}

	public void setForrigeRunde(int forrigeRunde) {
		this.forrigeRunde = forrigeRunde;
	}
}
