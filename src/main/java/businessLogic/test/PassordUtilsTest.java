package businessLogic.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.Test;

import businessLogic.common.PassordUtils;

public class PassordUtilsTest {
	PassordUtils passUtil = new PassordUtils();
	
	@Test
	public void basicPassordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pass = "passord123";
		String hash = passUtil.generateStorngPasswordHash(pass);
		Boolean validated = PassordUtils.validatePassword(pass, hash);
		assertTrue(validated);
	}
	
	@Test
	public void feilPassordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pass = "correcthorsebatterystaple";
		String hash = passUtil.generateStorngPasswordHash(pass);
		Boolean validated = PassordUtils.validatePassword("passord123", hash);
		assertFalse(validated);
	}
	

}
