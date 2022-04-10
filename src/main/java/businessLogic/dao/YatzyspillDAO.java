package businessLogic.dao;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Bruker;
import model.Yatzyspill;

@Stateless
public class YatzyspillDAO {

	@PersistenceContext(name="BrukerPU")
	private EntityManager em;
	
	public void nyttSpill(Yatzyspill yatzyspill) {
		em.persist(yatzyspill);
	}
	
	public Yatzyspill getSpill(String spillid) {
		return em.find(Yatzyspill.class, spillid);
	}
	
	//Usikker p� hvilke av de under det faktisk er behov for.
	
	public Bruker getAdmin(String spillid) {
		return getSpill(spillid).getAdmin();
	}
}
