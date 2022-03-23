package businessLogic.common;

import no.hvl.dat108.Passord;
import no.hvl.dat108.PassordUtil;
import presentation.common.Deltager;

public class Validator {

	public static final String ANY_LETTER_SPACE_OR_HYPHEN = "[a-zA-ZæøåÆØÅ -]";
    public static final String ANY_LETTER_OR_HYPHEN = "[a-zA-ZæøåÆØÅ-]";
    public static final String ANY_CAPITAL_LETTER = "[A-ZÆØÅ]";
	public static final String ANY_DIGIT = "[0-9]";
	public static final String ANY_SYMBOL = "[@$!%*#?&]";
	
	public static final String EIGHT_TIMES = "{8}";
	public static final String ZERO_OR_MORE_TIMES = "*";
    public static final String TWO_TO_TWNTY_TIMES = "{2,20}";
    public static final String MIN_MAX_PASSWORD = "{8,100}";
    
    

	  
	    public static boolean isValidEpost(String epost) {
	        return epost != null;
	        		//&& epost.matches("^" + ANY_DIGIT + EIGHT_TIMES + "$");
	    }
	    
	    public static boolean isValidFornavn(String fornavn) {
	        return fornavn != null 
	        		&& fornavn.matches("^" + ANY_CAPITAL_LETTER
	                + ANY_LETTER_SPACE_OR_HYPHEN + TWO_TO_TWNTY_TIMES + "$");
	    }


	    public static boolean isValidEtternavn(String etternavn) {
	        return etternavn != null 
	        		&& etternavn.matches("^" + ANY_CAPITAL_LETTER
	                + ANY_LETTER_OR_HYPHEN + TWO_TO_TWNTY_TIMES + "$");
	    }



		public static boolean isValidPassordForst(String passordForst) {
			return passordForst != null && 
					passordForst.matches( ".*[" + ANY_LETTER_OR_HYPHEN + 
			                ANY_DIGIT  + ANY_SYMBOL +"]"+ MIN_MAX_PASSWORD + "$");
	        }
			


		public static boolean isValidPassordRepetert(String passordRepetert, String passordForst) {
			if (passordRepetert == null || passordRepetert.isBlank()) {
	            return false;
	        }
			return passordRepetert.equals(passordForst);
		}


		public static boolean isValidKjonn(String kjonn) {

	        return kjonn != null 
	        		&& (kjonn.equals("mann") || kjonn.equals("kvinne"));
	        	    }
		
		
		public static boolean finnPassord(Deltager x, String passord) {
			boolean ok = false;
			Passord dp = x.getPassord();
			String salt = dp.getSalt();
			String hash = dp.getHash();
			String nyhash = PassordUtil.hashMedSalt(passord, salt);
			
			if (hash.equals(nyhash)) {
				ok = true;
			} else {
			
			ok = false;
			}
			return ok;
		}
}
