/**
 * 
 */
package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Entrepot;
import fr.afcepf.al33.citron.entity.Ville;



/**
 * Add by Amin
 *
 */
public interface EntrepotIBusiness {
	
	public Entrepot add(Entrepot entrepot);
	public Boolean delete(Entrepot entrepot);
	public Entrepot update(Entrepot entrepot);
	public Entrepot searchById(Integer id);
	public List<Entrepot> getAllByVille(Ville ville);
	
}
