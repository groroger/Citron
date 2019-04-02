package fr.afcepf.al33.projet1.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


import fr.afcepf.al33.projet1.IBusiness.ClientIBusiness;
import fr.afcepf.al33.projet1.entity.Client;
import fr.afcepf.al33.projet1.idao.ClientIdao;


@Remote(ClientIBusiness.class)
@Stateless
public class ClientBusiness implements ClientIBusiness{

	@EJB
	private ClientIdao proxyClient;


	private static String algoHash = "SHA-256"; 
//	private static byte [] salt = genererSalt();

	@Override
	public Client add(Client client) {
		proxyClient.ajouter(client);
		return client;
	}


	@Override
	public Boolean delete(Client client) {
		proxyClient.supprimer(client);
		return true;
	}


	@Override
	public Client update(Client client) {
		proxyClient.modifier(client);
		return client;
	}


	@Override
	public Client searchById(Integer id) {
		Client client = proxyClient.rechercherParId(id);

		return client;
	}
	
	@Override
	public Client adherentByIdJPQL(int id) {
		Client client = proxyClient.findById(id);
		return client;
	}


	@Override
	public Client rechercheParLoginEtPassword(String l, String p) {
		
		Client client = proxyClient.findByLoginAndPassword(l, p);
		return client;
	}

	

	@Override
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<Client>();

		clients=proxyClient.getAll();

		return clients;
	}


	@Override
	public Client seConnecter(String login, String password) {
		Client client = proxyClient.getByLogin(login);
		
		System.out.println(client.getPassword() + "  salt client: " + client.getSalt());
		if ( verifierPassword(client.getPassword(), password, client.getSalt()))
		{
			return client;
		}
		
		return null;
	}

	public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes;
    }
	
	public static String bytetoString(byte[] input) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
    }
	
	public static byte[] stringToByte(String input) {
        if ( org.apache.commons.codec.binary.Base64.isBase64(input)) {
            return  org.apache.commons.codec.binary.Base64.decodeBase64(input);

        } else {
            return  org.apache.commons.codec.binary.Base64.encodeBase64(input.getBytes());
        }
    }
	
	public static byte[] getHashWithSalt(String passwordToHash, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algoHash);
        digest.reset();
        digest.update(salt);
        byte[] hashedBytes = digest.digest(stringToByte(passwordToHash));
        return hashedBytes;
        
    }
	
	
	
//	public static byte[] genererSalt()
//	{
//		SecureRandom sr = new SecureRandom();
//		byte[] salt = new byte[3];
//		sr.nextBytes(salt);
//		return salt;
//	}
//
//	private static String genererHash(String passwordToHash) 
//
//	{
//
//		String passwordCree = null;
//		MessageDigest md;
//		try 
//		{
//			md = MessageDigest.getInstance(algoHash);
//	
//			md.update(salt);
//			byte [] hash = md.digest(passwordToHash.getBytes());
//			StringBuilder sb = new StringBuilder();
//			for(int i=0; i< hash.length ;i++)
//			{
//				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
//			}
//			//Get complete hashed password in hex format
//			passwordCree = sb.toString();
//
//		} 
//		catch (NoSuchAlgorithmException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return passwordCree;
//
//	}
	
	public boolean verifierPassword(String passwordEnregistre,String  passwordAValide, String salt)
	{
		boolean passwordVerifie = false;
		
//		MessageDigest md;
		try 
		{
			byte [] hash = getHashWithSalt(passwordAValide, stringToByte(salt));
		
			passwordAValide = bytetoString(hash);
			
			System.out.println("mot de passe à vérifier:  " + passwordAValide + "salt: " + salt);
			
//			md = MessageDigest.getInstance(algoHash);
//			
//			md.update(salt.getBytes());
//			byte [] hash = md.digest(passwordAValide.getBytes());		
//			StringBuilder sb = new StringBuilder();
//			for(int i=0; i< hash.length ;i++)
//			{
//				sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
//			}
//			//Get complete hashed password in hex format
//			passwordAValide = sb.toString();
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

}
