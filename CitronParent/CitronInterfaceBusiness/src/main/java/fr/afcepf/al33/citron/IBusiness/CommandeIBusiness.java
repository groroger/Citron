package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;

public interface CommandeIBusiness {
		
	public Commande add(Commande commande);
	public Boolean delete(Commande commande);
	public Commande update(Commande commande);
	public Commande searchById(Integer id);
	public List<Commande> getAllToProcess();
	public List<Commande> getAllByClient (Client client);

}
