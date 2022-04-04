package businessLogic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
	//Usikker på hvilke av de under det faktisk er behov for.
	
	public String getAdmin(String spillid) {
		return getSpill(spillid).getAdmin();
	}
}
