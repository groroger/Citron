package fr.afcepf.al33.projet1.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.idao.CommandeIdao;

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
	
}
