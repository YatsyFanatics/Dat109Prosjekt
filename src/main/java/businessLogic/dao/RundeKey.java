package businessLogic.dao;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import model.Yatzyspill;

public class RundeKey implements Serializable{

	public RundeKey(int rundenr, Integer yatzyspill) {
		this.rundenr = rundenr;
		this.spillid = yatzyspill;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@JoinColumn(name = "rundenr")
	private int rundenr;

	@Id
	@ManyToOne
	@JoinColumn(name = "spillid")
	private Integer spillid;
}
