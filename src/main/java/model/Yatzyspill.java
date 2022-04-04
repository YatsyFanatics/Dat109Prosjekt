package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yatzyspill", schema = "oblig3")
public class Yatzyspill {

	private final int ANTALLTERNINGER = 5;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spillid;
	private int rundeNr;
//	private Bruker admin; //mulig vi m� lagre admin som String for brukeren sin id/brukernavn
	private String admin;
	private int spillerSinTur;
	private Bruker vinner;
	private Poengtabell poengtabell;
	private int antallKast;
	
	//one to many eller noe s�nt
	private Bruker[] spillere;
	private Terning[] terninger;
	
	public Yatzyspill(int spillid, String admin, Bruker[] spillere) {
		rundeNr = 0;
		antallKast = 0;
		spillerSinTur = 0;
		poengtabell = new Poengtabell(spillere.length);
		this.spillid = spillid;
		this.admin = admin;
		this.spillere = spillere;
		
		for(int i = 0; i < ANTALLTERNINGER; i++) {
			terninger[i] = new Terning();
		}
	}
	
	public Yatzyspill(Bruker spiller) {
		rundeNr = 0;
		antallKast = 0;
		spillerSinTur = 0;
		spillere = new Bruker[1];
		spillere[0] = spiller;
		poengtabell = new Poengtabell(1);
		
		for(int i = 0; i < ANTALLTERNINGER; i++) {
			terninger[i] = new Terning();
		}
	}
	
	public void startSpill() {
		//??
	}
	
	public void spillTur(String command, boolean[] terningTilstand) {
		if(command.equalsIgnoreCase("trill") && antallKast < 3) {
			terningKast(terningTilstand);
		}else if(command.equalsIgnoreCase("ferdig")) {
			antallKast = 0;
			//TODO rundeNr - 1 om spilleren har hatt yatzy
			poengtabell.regnUt(getSpillerSinTur(), getRundeNr(), getTerningVerdier());
			nesteSpiller();
		}
	}
	
	private void nesteSpiller() {
		//TODO sjekke om spiller er aktiv
		spillerSinTur = (spillerSinTur+1) % spillere.length;
		nesteRunde();
	}

	private void nesteRunde() {
		if(spillerSinTur == 0) {
			rundeNr++;
		}
		
		if(rundeNr == 6) {
			for(int i = 0; i < spillere.length; i++) {
				poengtabell.regnUt(i, rundeNr, getTerningVerdier());
			}
			rundeNr = 8;
		}
		
		if(rundeNr == 17) {
			for(int i = 0; i < spillere.length; i++) {
				poengtabell.regnUt(i, rundeNr, getTerningVerdier());
			}
			regnUtVinner();
		}
	}

	public void terningKast(boolean[] terningTilstand) {
		for(int i = 0; i < terninger.length; i++) {
			if(terningTilstand[i]) {
				terninger[i].trill();
			}
		}
		
		antallKast++;
	}
	
	public void kick() {
		
	}
	
	public void purre() {
		
	}
	
	public void regnUtVinner() {
		//TODO sjekk etter lik score og inaktive brukere
		int[] totalScore = poengtabell.hentRad(17);
		int vinnerScore = totalScore[0];
		vinner = spillere[0];	
		
		for(int i = 1; i < totalScore.length; i++) {
			if(totalScore[i] > vinnerScore) {
				vinnerScore = totalScore[i];
				vinner = spillere[i];
			}
		}
	}
	
	public Bruker hentSpillerSinTur() {
		return spillere[getSpillerSinTur()];
	}
	
	public int[] getTerningVerdier() {
		int[] verdier = {terninger[0].getVerdi(), terninger[1].getVerdi(), terninger[2].getVerdi(), terninger[3].getVerdi(), terninger[4].getVerdi()};
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

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
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
}
