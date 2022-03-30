package model;

public class Terning {
	private int verdi;
	private boolean keep;
	
	public Terning() {
		super();
		this.keep = false;
	}
	
	public void trill(double seed) {
		this.verdi = (int) Math.floor(((seed)*6)+1);
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