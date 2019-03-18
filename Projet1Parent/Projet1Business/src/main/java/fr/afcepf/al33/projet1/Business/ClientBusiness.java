package fr.afcepf.al33.projet1.Business;

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
	public Client rechercheParLoginetPassword(String l, String p) {
		Client client = proxyClient.findByLoginAndPassword(l, p);
		return client;
	}


	@Override
	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<Client>();

		clients=proxyClient.getAll();

		return clients;
	}




}
