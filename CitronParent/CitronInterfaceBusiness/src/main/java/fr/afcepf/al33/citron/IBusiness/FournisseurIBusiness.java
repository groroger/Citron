package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Fournisseur;

public interface FournisseurIBusiness {
	
	public Fournisseur add(Fournisseur fournisseur);
	public Boolean delete(Fournisseur fournisseur);
	public Fournisseur update(Fournisseur fournisseur);
	public Fournisseur searchById(Integer id);
	public List<Fournisseur> getAll();
}
