package businessLogic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;

import org.junit.jupiter.api.Test;

import businessLogic.common.BrukerDAO;
import model.common.Bruker;

public class BrukerDAOTest {

	@EJB
	private BrukerDAO bDAO;
	
	@Test
	public void testgetBruker() {
		assertEquals(bDAO.getBruker("tester").getEtternavn(), "testesen");
	}
	
	@Test
	public void testnyBruker() {
		Bruker b = new Bruker("tester2000", "teste2", "testesen2", "t.testesen2@gmail.com", "tester123");
		bDAO.nyBruker(b);
		assertEquals(b, bDAO.getBruker("tester2000"));
	}
	
	@Test
	public void testerLedig() {
		assertFalse(bDAO.erLedig("tester"));
	}
	
	@Test
	public void testslettBruker() {
		bDAO.slettBruker("tester2000");
		assertTrue(bDAO.erLedig("tester2000"));
	}
}
