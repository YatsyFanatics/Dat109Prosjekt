package model.test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import model.common.Poengtabell;

public class TestPoengtabell {
	Poengtabell tabellen = new Poengtabell();
	
	@Test
	public void testEnere() {
		int[] arr = {1,2,6,1,1};
		tabellen.enere(0,arr);
		assertEquals(3,tabellen.hentVerdi(0,0));
	}
	
	@Test
	public void testToere() {
		int[] arr = {1,2,6,2,1};
		tabellen.toere(0,arr);
		assertEquals(4,tabellen.hentVerdi(1,0));
	}
	@Test
	public void testTreere() {
		int[] arr = {3,3,3,3,1};
		tabellen.treere(0,arr);
		assertEquals(12,tabellen.hentVerdi(2,0));
	}
	@Test
	public void testFirere() {
		int[] arr = {4,3,3,3,1};
		tabellen.firere(0,arr);
		assertEquals(4,tabellen.hentVerdi(3,0));
	}
	@Test
	public void testFemere() {
		int[] arr = {3,5,3,3,5};
		tabellen.femere(0,arr);
		assertEquals(10,tabellen.hentVerdi(4,0));
	}
	@Test
	public void testSeksere() {
		int[] arr = {6,6,6,3,6};
		tabellen.seksere(0,arr);
		assertEquals(24,tabellen.hentVerdi(5,0));
	}
	@Test
	public void testSum() {
		tabellen.sum(0);
		int sum = 
				tabellen.hentVerdi(1,0)+tabellen.hentVerdi(1,1)
				+tabellen.hentVerdi(1,2)+tabellen.hentVerdi(1,3)
				+tabellen.hentVerdi(1,4)+tabellen.hentVerdi(1,4);
		
		assertEquals(sum,tabellen.hentVerdi(0,6));
	}
	@Test
	public void testBonus() {
		
	}
	@Test
	public void testEttPar() {
		
	}
	
	@Test
	public void testToPar() {
		
	}
	@Test
	public void testTreLike() {
		
	}
	@Test
	public void testFireLike() {
		
	}
	@Test
	public void testLitenStright() {
		
	}
	@Test
	public void testStorStright() {
		
	}
	
	@Test
	public void testHus() {
		
	}
	@Test
	public void testSjanse() {
		
	}
	
	@Test
	public void testYatzy() {
		
	}
	
	@Test
	public void testTotal() {
		
	}

}
