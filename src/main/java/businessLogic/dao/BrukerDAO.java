package businessLogic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Bruker;

@Stateless
public class BrukerDAO {

	@PersistenceContext(name="BrukerPU")
	private EntityManager em;

	public void nyBruker(Bruker bruker) {
		em.persist(bruker);
	}
	
	public Bruker getBruker(String brukernavn) {
		return em.find(Bruker.class, brukernavn);
	}
	
	public boolean erLedig(String brukernavn) {
		return getBruker(brukernavn) == null;
	}
	
	//Hovedsakelig her for testing atm
	public void slettBruker(String brukernavn) {
		em.createNativeQuery("DELETE FROM Oblig3.bruker WHERE brukernavn = :brukernavn", Bruker.class).setParameter("brukernavn", brukernavn);  //bruker med stor bokstav muligens? ogs� usiker p� om "bruker.class" skal v�re der
	}
	public List<Bruker> hentAlleBrukere() {
		return em.createQuery("select d from Bruker d", Bruker.class).getResultList();
	}
	//flere metoder etter behov
}