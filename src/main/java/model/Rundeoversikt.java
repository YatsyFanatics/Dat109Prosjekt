package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import businessLogic.dao.RundeKey;

@Entity
@Table(name = "rundeoversikt", schema = "oblig3")
@IdClass(RundeKey.class)
public class Rundeoversikt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rundeoversikt() {
	}

	public Rundeoversikt(int rundenr, Integer yatzyspill, Integer spiller1score, Integer spiller2score,
			Integer spiller3score, Integer spiller4score, Integer spiller5score, Integer spiller6score) {
		this.rundenr = rundenr;
		this.spillid = yatzyspill;
		this.spiller1score = spiller1score;
		this.spiller2score = spiller2score;
		this.spiller3score = spiller3score;
		this.spiller4score = spiller4score;
		this.spiller5score = spiller5score;
		this.spiller6score = spiller6score;
	}

	public Rundeoversikt(int rundenr, Integer yatzyspill, Integer[] terningArray) {

		this.rundenr = rundenr;
		this.spillid = yatzyspill;
		if (terningArray != null) {
			if (terningArray[0] != null) {
				this.spiller1score = terningArray[0];
			}
			if (terningArray[1] != null) {
				this.spiller2score = terningArray[1];
			}
			if (terningArray[2] != null) {
				this.spiller3score = terningArray[2];
			}
			if (terningArray[3] != null) {
				this.spiller4score = terningArray[3];
			}
			if (terningArray[4] != null) {
				this.spiller5score = terningArray[4];
			}
			if (terningArray[5] != null) {
				this.spiller6score = terningArray[5];
			}
		} else {
			this.spiller1score = null;
			this.spiller2score = null;
			this.spiller3score = null;
			this.spiller4score = null;
			this.spiller5score = null;
			this.spiller6score = null;
		}
	}

	@Id
	@JoinColumn(name = "rundenr")
	private int rundenr;

	@Id
	@JoinColumn(name = "spillid")
	private Integer spillid;

	@JoinColumn(name = "spiller1score")
	private Integer spiller1score;

	@JoinColumn(name = "spiller2score")
	private Integer spiller2score;

	@JoinColumn(name = "spiller3score")
	private Integer spiller3score;

	@JoinColumn(name = "spiller4score")
	private Integer spiller4score;

	@JoinColumn(name = "spiller5score")
	private Integer spiller5score;

	@JoinColumn(name = "spiller6score")
	private Integer spiller6score;

	public int getRundenr() {
		return rundenr;
	}

	public void setRundenr(int rundenr) {
		this.rundenr = rundenr;
	}

	public Integer getYatzyspill() {
		return spillid;
	}

	public void setYatzyspill(Integer yatzyspill) {
		this.spillid = yatzyspill;
	}

	public int getSpiller1score() {
		return spiller1score;
	}

	public void setSpiller1score(int spiller1score) {
		this.spiller1score = spiller1score;
	}

	public int getSpiller2score() {
		return spiller2score;
	}

	public void setSpiller2score(int spiller2score) {
		this.spiller2score = spiller2score;
	}

	public int getSpiller3score() {
		return spiller3score;
	}

	public void setSpiller3score(int spiller3score) {
		this.spiller3score = spiller3score;
	}

	public int getSpiller4score() {
		return spiller4score;
	}

	public void setSpiller4score(int spiller4score) {
		this.spiller4score = spiller4score;
	}

	public int getSpiller5score() {
		return spiller5score;
	}

	public void setSpiller5score(int spiller5score) {
		this.spiller5score = spiller5score;
	}

	public int getSpiller6score() {
		return spiller5score;
	}

	public void setSpiller6score(int spiller5score) {
		this.spiller5score = spiller5score;
	}

	@Override
	public String toString() {
		return "Rundeoversikt [rundenr=" + rundenr + ", spillid=" + spillid + ", spiller1score=" + spiller1score
				+ ", spiller2score=" + spiller2score + ", spiller3score=" + spiller3score + ", spiller4score="
				+ spiller4score + ", spiller5score=" + spiller5score + ", spiller6score=" + spiller6score + "]";
	}

}
