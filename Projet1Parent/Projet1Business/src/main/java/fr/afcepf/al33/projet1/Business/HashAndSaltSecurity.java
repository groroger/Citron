package fr.afcepf.al33.projet1.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

public class HashAndSaltSecurity {


	private static String algoHash = "SHA-256"; 
	private static byte [] salt = genererSalt();


	public static byte[] genererSalt()
	{
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	private static String genererHash(String passwordToHash) 

	{

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

		System.out.println("entrez un mot de passe");
		
		Scanner sc = new Scanner(System.in);
		
		String mdp = sc.nextLine();

		System.out.println(genererHash(mdp));
		System.out.println(salt);

// 
//		[B@355da254
//		 8d25bbeda5e87c45535455962d64bd710e99e8d83d558b078dda73bf2cc433cd
	}
}
