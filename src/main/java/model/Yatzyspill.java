package model;

import javax.persistence.Id;

public class Yatzyspill {

	private final int ANTALLTERNINGER = 5;
	
	@Id
	private int spillid;
	private int rundeNr;
	private Bruker admin; //mulig vi må lagre admin som String for brukeren sin id/brukernavn
	private int spillerSinTur;
	private Bruker vinner;
	private Poengtabell poengtabell;
	private int antallKast;
	
	//one to many eller noe sånt
	private Bruker[] spillere;
	private Terning[] terninger;
	
	public Yatzyspill(int spillid, Bruker admin, Bruker[] spillere) {
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
	
	public void startSpill() {
		
	}
	
	public void spillTur() {
		
	}
	
	public void terningKast() {
		
	}
	
	public void kick() {
		
	}
	
	public void purre() {
		
	}
	
	public void regnUtVinner() {
		
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
}
