package businessLogic.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.Test;

import static businessLogic.utils.PassordUtil.*;

public class PassordUtilTest {
	
	@Test
	public void basicPassordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pass = "passord123";
		String hash = generateStrongPasswordHash(pass);
		Boolean validated = validatePassword(pass, hash);
		assertTrue(validated);
	}
	
	@Test
	public void feilPassordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pass = "correcthorsebatterystaple";
		String hash = generateStrongPasswordHash(pass);
		Boolean validated = validatePassword("passord123", hash);
		assertFalse(validated);
	}
	

}
