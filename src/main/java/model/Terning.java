package model;

public class Terning {
	private int verdi;
	private boolean keep;
	
	public Terning() {
		super();
		this.keep = false;
		trill();
	}
	
	public void trill(double seed) {
		if(!keep) {
		this.verdi = (int) Math.floor(((seed)*6)+1);
		}
	}
	
	public void trill() {
		if(!keep) {
		this.verdi = (int) Math.floor(((Math.random())*6)+1);
		}
	}
	
	public int getVerdi() {
		return verdi;
	}
	public void setVerdi(int verdi) {
		this.verdi = verdi;
	}
	public boolean isKeeping() {
		return keep;
	}
	public void setKeep(boolean keep) {
		this.keep = keep;
	}
	

}
