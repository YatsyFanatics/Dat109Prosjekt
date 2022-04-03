package businessLogic.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class YatzyspillDAO {

	@PersistenceContext(name="BrukerPU")
	private EntityManager em;
}
