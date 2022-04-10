package businessLogic.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Spilldeltakelse;

@Stateless
public class SpilldeltakelseDAO {

	@PersistenceContext(name="BrukerPU")
	private EntityManager em;
	
	public void nySpilldeltakelse(Spilldeltakelse sd) {
		em.persist(sd);
	}
	
	public List<Spilldeltakelse> getSpilldeltakelse(int spillid){
		return em.createNativeQuery("SELECT sd FROM spilldeltakelse sd WHERE sd.spillid.spillid = :spillid", Spilldeltakelse.class)
				.setParameter("spillid", spillid).getResultList();
	}
}