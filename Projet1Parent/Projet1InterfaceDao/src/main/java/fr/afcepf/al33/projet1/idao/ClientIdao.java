package fr.afcepf.al33.projet1.idao;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Client;




public interface ClientIdao extends GenericIdao<Client> {
	
	Client findById(int i);
	Client findByLoginAndPassword(String l, String p);
	List<Client> getAll();

}
