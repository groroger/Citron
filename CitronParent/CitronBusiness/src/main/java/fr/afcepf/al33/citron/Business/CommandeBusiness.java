package fr.afcepf.al33.citron.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.citron.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Commande;
import fr.afcepf.al33.citron.idao.CommandeIdao;

@Remote(CommandeIBusiness.class)
@Stateless
public class CommandeBusiness implements CommandeIBusiness{

	@EJB
	private CommandeIdao proxyCommande;
	
	@Override
	public List<Commande> getAllToProcess() {
		List<Commande> commandes=null;
		commandes= proxyCommande.getAllToProcess();
		return commandes;
	}

	@Override
	public Commande add(Commande commande) {
		proxyCommande.ajouter(commande);
		return commande;
	}

	@Override
	public Boolean delete(Commande commande) {
		proxyCommande.supprimer(commande);
		return true;
	}

	@Override
	public Commande update(Commande commande) {
		proxyCommande.modifier(commande);
		return commande;
	}

	@Override
	public Commande searchById(Integer id) {
		Commande commande = proxyCommande.rechercherParId(id);
		return commande;
	}

	@Override
	public List<Commande> getAllByClient(Client client) {
		List<Commande> commandes = proxyCommande.getAllByClient(client);
		return commandes;
	}
	
}
