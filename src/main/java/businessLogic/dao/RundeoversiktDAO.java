package businessLogic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Rundeoversikt;
import model.Yatzyspill;

@Stateless
public class RundeoversiktDAO {

	@PersistenceContext(name = "BrukerPU")
	private EntityManager em;

	public void nyRundeOversikt(Rundeoversikt rundeoversikt) {
		
		//if (!rundeFinnes(rundeoversikt)) {
			em.persist(rundeoversikt);
		/*} else {
			oppdater(rundeoversikt);
		}
		*/
	}
	
	public void oppdater(Rundeoversikt rundeoversikt) {
		em.merge(rundeoversikt);
	}

	public Rundeoversikt getrundeoversikt(Rundeoversikt rundeoversikt) {
		RundeKey rk = new RundeKey(rundeoversikt.getRundenr(),rundeoversikt.getYatzyspill());
		return em.find(Rundeoversikt.class, rk);
	}

	public boolean rundeFinnes(Rundeoversikt rundeoversikt) {
		return getrundeoversikt(rundeoversikt) != null;
	}

}
