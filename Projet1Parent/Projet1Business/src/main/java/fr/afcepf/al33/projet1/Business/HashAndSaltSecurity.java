package fr.afcepf.al33.projet1.Business;

import java.security.SecureRandom;

public class HashAndSaltSecurity {
	
	
	private static final String ALGO_HASH = "MD5"; 
	private byte [] salt = generateSalt();
	

	public static byte[] generateSalt()
	{
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[3];
		sr.nextBytes(salt);
		return salt;
	}
	
	
}
