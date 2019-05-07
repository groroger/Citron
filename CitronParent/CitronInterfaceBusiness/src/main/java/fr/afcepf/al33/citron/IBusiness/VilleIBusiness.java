package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Ville;

public interface VilleIBusiness {
	
	public List<Ville> getAll();
	public Ville searchById(Integer id);
	public Ville rechercherParVilleEtCodePostal(String nom, String cp);

}
