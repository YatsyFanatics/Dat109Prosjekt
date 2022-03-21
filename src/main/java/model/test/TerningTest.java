package model.test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.common.Terning;


public class TerningTest {
	Terning testTerning = new Terning();
	private double maxRandomValue = 0.9;
	private double minRandomValue = 0.0;
	
	
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testMaxRandom() {
		assertTrue(testTerning.trill(maxRandomValue) == 6);
	}
	
	@Test
	public void testMinRandom() {
		assertTrue(testTerning.trill(minRandomValue) == 1);
		
	}
		
	
	
	
	
	
	
}
