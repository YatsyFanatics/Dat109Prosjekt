package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "spilldeltakelse", schema = "oblig3")
public class Spilldeltakelse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spilldeltakelseid;
	
	@ManyToOne
	@JoinColumn(name = "spillerid")
	private Bruker spiller;
	
	@ManyToOne
	@JoinColumn(name = "spillid")
	private Yatzyspill yatzyspill;
	
	public Spilldeltakelse() {	
	}
	
	public Spilldeltakelse(Bruker bruker, Yatzyspill yatzyspill) {
		this.spiller = bruker;
		this.yatzyspill = yatzyspill;
	}

	public int getSpilldeltakelseid() {
		return spilldeltakelseid;
	}

	public void setSpilldeltakelseid(int spilldeltakelseid) {
		this.spilldeltakelseid = spilldeltakelseid;
	}

	public Bruker getSpiller() {
		return spiller;
	}

	public void setSpiller(Bruker spiller) {
		this.spiller = spiller;
	}

	public Yatzyspill getYatzyspill() {
		return yatzyspill;
	}

	public void setYatzyspill(Yatzyspill yatzyspill) {
		this.yatzyspill = yatzyspill;
	}
}
