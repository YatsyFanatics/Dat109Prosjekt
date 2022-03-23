package model.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import model.common.Terning;

public class TerningTest {
	private double minRandomValue = 0.0; // random går fra og med 0.0
	private double maxRandomValue = 0.9999; // random går opp til, men ikke med 1.0
	Terning terning = new Terning();
	
	
	
	@Test
	public void testUnrolled() {
		assertTrue((terning.getVerdi() == 0));
	}
	
	@Test
	public void testMaxRandom() {
		terning.trill(maxRandomValue);
		assertTrue(terning.getVerdi() == 6);
	}
	
	@Test
	public void testMinRandom() {
		terning.trill(minRandomValue);
		assertTrue(terning.getVerdi() == 1);
	}
	
	
	@Test
	public void testRange() {
		
		for (double i = 0.0; i < maxRandomValue; i+= 0.01) {
			
			terning.trill(i);
			System.out.print((terning.getVerdi()));
			
		}
	}

}