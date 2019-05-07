package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Fournisseur;

public interface FournisseurIdao extends GenericIdao<Fournisseur>{

	
	List<Fournisseur> getAll();
}
