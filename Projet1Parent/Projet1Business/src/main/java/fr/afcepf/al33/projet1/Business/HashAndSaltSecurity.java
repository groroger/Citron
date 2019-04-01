package fr.afcepf.al33.projet1.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class HashAndSaltSecurity {


	private static String algoHash = "SHA-256"; 
	private static byte [] salt; 
	//	private static String salt = "123";


		
		public static byte[] genererSalt()
		{
			SecureRandom sr = new SecureRandom();
			byte [] salt = new byte[3];
			sr.nextBytes(salt);
			
			String string = new String(salt);
			System.out.println(string);
			
			return salt;
		}
		
//	public static byte[] genererSalt()
//	{
//		SecureRandom sr = new SecureRandom();
//		byte[] salt = new byte[1];
//		sr.nextBytes(salt);
//		return salt;
//	}

	private static String genererHash(String passwordToHash) 

	{
		salt = genererSalt();
		String string = new String(salt);
		System.out.println(string);
		String passwordCree = null;
		MessageDigest md;
		try 
		{
			md = MessageDigest.getInstance(algoHash);
	
			md.update(salt);
			System.out.println(salt);
			byte [] hash = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< hash.length ;i++)
			{
				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			passwordCree = sb.toString();
			
			StringBuilder sbSalt = new StringBuilder();
			for(int i=0; i< salt.length ;i++)
			{
				sbSalt.append(Integer.toString((salt[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			String saltString = sbSalt.toString();
			System.out.println("salt client : " + saltString);

		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return passwordCree;

	}
	
	public boolean verifierPassword(String passwordEnregistre,String  passwordAValide, String salt)
	{
		boolean passwordVerifie = false;
		
		MessageDigest md;
		try 
		{
			md = MessageDigest.getInstance(algoHash);
	
			md.update(salt.getBytes());
			System.out.println("salt client : " + salt);
			byte [] hash = md.digest(passwordAValide.getBytes());
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< hash.length ;i++)
			{
				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
			}
			//Get complete hashed password in hex format
			passwordAValide = sb.toString();
			System.out.println("passwordAValide :" + passwordAValide);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if ( passwordAValide.equals(passwordEnregistre))
		{
			passwordVerifie = true;
		}
		
		return passwordVerifie;
	}

//	TEST EN CONSOLE DU HASH AND SALT 
	
	public static void main(String[] args) {

		String s = "123";
		byte[] b = s.getBytes();
		String s2 = new String(b);
		System.out.println("s:" + s);
		System.out.println("s2:" + s2);
		
		
//		genererSalt();
//		
		System.out.println("entrez un mot de passe");
		
		Scanner sc = new Scanner(System.in);
		
		String mdp = sc.nextLine();

		
		System.out.println(genererHash(mdp));
		
		String saltFabrique = new String(salt);
		
		System.out.println(saltFabrique);


	}
}
