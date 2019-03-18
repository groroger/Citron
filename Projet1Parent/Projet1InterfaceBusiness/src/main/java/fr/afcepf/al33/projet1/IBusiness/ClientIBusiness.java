package fr.afcepf.al33.projet1.IBusiness;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Client;

public interface ClientIBusiness {
	
	public Client add(Client client);
	public Boolean delete(Client client);
	public Client update(Client client);
	public Client searchById(Integer id);
	public Client adherentByIdJPQL(int id);
	public Client rechercheParLoginetPassword (String l, String p);
	public List<Client> getAllClients();

}


