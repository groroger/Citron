/**
 * 
 */
package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Entrepot;
import fr.afcepf.al33.citron.entity.Ville;



/**
 * add by Amin
 *
 */
public interface EntrepotIdao extends GenericIdao<Entrepot> {
	
	Entrepot findById(int id);
	List<Entrepot> getAll();
	List<Entrepot> getAllByVille(Ville ville);
	Entrepot rechercherParVilleEtCodePostal(String nom, String cp); // not yet implemented correctly :(

}
