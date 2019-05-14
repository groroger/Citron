package fr.afcepf.al33.citron.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.citron.IBusiness.FactureIBusiness;
import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Facture;
import fr.afcepf.al33.citron.idao.FactureIdao;

@Remote(FactureIBusiness.class)
@Stateless
public class FactureBusiness implements FactureIBusiness {

	@EJB
	private FactureIdao proxyFacture;
	
	@Override
	public List<Facture> getAllToProcess() {
		List<Facture> factures=null;
		factures= proxyFacture.getAllToProcess();
		return factures;
	}

	@Override
	public Facture add(Facture facture) {
		proxyFacture.ajouter(facture);
		return facture;
	}

	@Override
	public Boolean delete(Facture facture) {
		proxyFacture.supprimer(facture);
		return true;
	}

	@Override
	public Facture update(Facture facture) {
		proxyFacture.modifier(facture);
		return facture;
	}

	@Override
	public Facture searchById(Integer id) {
		Facture facture = proxyFacture.rechercherParId(id);
		return facture;
	}

	@Override
	public List<Facture> getAllByClient(Client client) {
		List<Facture> factures = proxyFacture.getAllByClient(client);
		return factures;
	}

}
