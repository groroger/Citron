package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;

public interface CommandeIdao extends GenericIdao<Commande> {
	
	List<Commande> getAll ();
	List<Commande> getAllToProcess ();
	List<Commande> getAllByClient (Client client);

}
