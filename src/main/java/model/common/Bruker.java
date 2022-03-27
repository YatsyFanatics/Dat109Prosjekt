package model.common;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bruker", schema = "oblig3")
public class Bruker {

	@Id
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private String epost;
	private String passord; //forandres til object ref om vi tar i bruk en seperat Klasse for passord(om vi beholder denne, må salt string legges til)
	
	public Bruker() {
		
	}

	public Bruker(String brukernavn, String fornavn, String etternavn, String epost, String passord) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.epost = epost;
		this.passord = passord;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getEpost() {
		return epost;
	}

	public void setEpost(String epost) {
		this.epost = epost;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}
	
}