package model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Poengtabell;

public class TestPoengtabell {
	Poengtabell tabellen = new Poengtabell();


	@BeforeEach
	public void init() {
		int[] arr1 = { 1, 2, 6, 1, 1 };
		tabellen.enere(0, arr1);
		
		int[] arr2 = { 1, 2, 6, 2, 1 };
		tabellen.toere(0, arr2);
		
		int[] arr3 = { 3, 3, 3, 3, 1 };
		tabellen.treere(0, arr3);
		
		int[] arr4 = { 4, 3, 3, 3, 1 };
		tabellen.firere(0, arr4);
		
		int[] arr5 = { 3, 5, 3, 3, 5 };
		tabellen.femere(0, arr5);
		
		int[] arr6 = { 6, 6, 6, 3, 6 };
		tabellen.seksere(0, arr6);

		tabellen.sum(0);

		int[] arr7 = { 4, 6, 4, 3, 6 };
		tabellen.ettPar(0, arr7);
		
		int[] arr8 = { 4, 6, 4, 3, 6 };
		tabellen.toPar(0, arr8);
		
		int[] arr9 = { 2, 6, 2, 3, 2 };
		tabellen.treLike(0, arr9);
		
		int[] arr10 = { 6, 6, 6, 3, 6 };
		tabellen.fireLike(0, arr10);
		
		int[] arr11 = { 1, 2, 3, 4, 5 };
		tabellen.litenStright(0, arr11);
		
		int[] arr12 = { 6, 2, 3, 4, 5 };
		tabellen.storStright(0, arr12);
		
		int[] arr13 = { 2, 2, 3, 3, 3 };
		tabellen.hus(0, arr13);
		
		int[] arr14 = { 3, 3, 4, 2, 6 };
		tabellen.sjanse(0, arr14);
		
		int[] arr15 = { 1, 1, 1, 1, 1 };
		tabellen.yatzy(0, arr15);
		
		tabellen.total(0);

	}

	@Test
	public void testEnere() {
		assertEquals(3, tabellen.hentVerdi(0, 0));
	}

	@Test
	public void testToere() {

		assertEquals(4, tabellen.hentVerdi(1, 0));
	}

	@Test
	public void testTreere() {

		assertEquals(12, tabellen.hentVerdi(2, 0));
	}

	@Test
	public void testFirere() {

		assertEquals(4, tabellen.hentVerdi(3, 0));
	}

	@Test
	public void testFemere() {

		assertEquals(10, tabellen.hentVerdi(4, 0));
	}

	@Test
	public void testSeksere() {

		assertEquals(24, tabellen.hentVerdi(5, 0));
	}

	@Test
	public void testSum() {

		int sum = tabellen.hentVerdi(1, 0) + tabellen.hentVerdi(2, 0) + tabellen.hentVerdi(3, 0)
				+ tabellen.hentVerdi(4, 0) + tabellen.hentVerdi(5, 0) + tabellen.hentVerdi(0, 0);

		assertEquals(sum, tabellen.hentVerdi(6, 0));
	}

	@Test
	public void testBonus50() {
		assertEquals(50, tabellen.hentVerdi(7, 0));

	}


	@Test
	public void testEttPar() {
		assertEquals(12, tabellen.hentVerdi(8, 0));
	}

	@Test
	public void testToPar() {
		assertEquals(20, tabellen.hentVerdi(9, 0));
	}

	@Test
	public void testTreLike() {
		assertEquals(6, tabellen.hentVerdi(10, 0));
	}

	@Test
	public void testFireLike() {
		assertEquals(24, tabellen.hentVerdi(11, 0));
	}

	@Test
	public void testLitenStright() {
		assertEquals(15, tabellen.hentVerdi(12, 0));
	}

	@Test
	public void testStorStright() {
		assertEquals(20, tabellen.hentVerdi(13, 0));
	}

	@Test
	public void testHus() {
		assertEquals(13, tabellen.hentVerdi(14, 0));
	}

	@Test
	public void testSjanse() {
		assertEquals(18, tabellen.hentVerdi(15, 0));
	}

	@Test
	public void testYatzy() {
		assertEquals(50, tabellen.hentVerdi(16, 0));
	}

	@Test
	public void testTotal() {
		int total = tabellen.hentVerdi(6, 0) + tabellen.hentVerdi(7, 0) + tabellen.hentVerdi(8, 0)
		+ tabellen.hentVerdi(9, 0) + tabellen.hentVerdi(10, 0) + tabellen.hentVerdi(11, 0)+ tabellen.hentVerdi(12, 0)
		+ tabellen.hentVerdi(13, 0) + tabellen.hentVerdi(14, 0) + tabellen.hentVerdi(15, 0)+ tabellen.hentVerdi(16, 0);

		assertEquals(total, tabellen.hentVerdi(17, 0));
	}
	
	@Test
	public void testHentRad() {
		int[] arrEnere = {tabellen.hentVerdi(0, 0),0,0,0,0,0};
		assertEquals(arrEnere[0], tabellen.hentRad(0)[0]);
	}

}
