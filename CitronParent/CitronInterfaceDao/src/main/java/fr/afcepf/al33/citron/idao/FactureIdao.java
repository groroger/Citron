package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Facture;

public interface FactureIdao extends GenericIdao<Facture> {
	
	List<Facture> getAll ();
	List<Facture> getAllToProcess ();
	List<Facture> getAllByClient (Client client);
}
