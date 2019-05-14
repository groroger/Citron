package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Client;
import fr.afcepf.al33.citron.entity.Facture;

public interface FactureIBusiness {
	
	public Facture add(Facture facture);
	public Boolean delete(Facture facture);
	public Facture update(Facture facture);
	public Facture searchById(Integer id);
	public List<Facture> getAllToProcess();
	public List<Facture> getAllByClient (Client client);

}
