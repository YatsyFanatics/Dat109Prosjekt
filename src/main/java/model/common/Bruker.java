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
	private String email;
	private String passord; //forandres til object ref om vi tar i bruk en seperat Klasse for passord(om vi beholder denne, må salt string legges til)
	
	public Bruker() {
		
	}

	public Bruker(String brukernavn, String fornavn, String etternavn, String email, String passord) {
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}
	
}