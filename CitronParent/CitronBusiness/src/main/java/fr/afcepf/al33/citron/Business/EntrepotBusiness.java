/**
 * 
 */
package fr.afcepf.al33.citron.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.citron.IBusiness.EntrepotIBusiness;
import fr.afcepf.al33.citron.entity.Entrepot;
import fr.afcepf.al33.citron.entity.Ville;
import fr.afcepf.al33.citron.idao.EntrepotIdao;


/**
 * Add by Amin
 *
 */

@Remote(EntrepotIBusiness.class)
@Stateless
public class EntrepotBusiness implements EntrepotIBusiness {
	
	@EJB
	private EntrepotIdao proxyEntrepot;

	@Override
	public Entrepot add(Entrepot entrepot) {
		proxyEntrepot.ajouter(entrepot);
		return entrepot;
	}

	@Override
	public Boolean delete(Entrepot entrepot) {
		proxyEntrepot.supprimer(entrepot);
		return true;
	}

	@Override
	public Entrepot update(Entrepot entrepot) {
		proxyEntrepot.modifier(entrepot);
		return entrepot;
	}

	@Override
	public Entrepot searchById(Integer id) {
		Entrepot entrepot = proxyEntrepot.rechercherParId(id);
		return entrepot;
	}

	@Override
	public List<Entrepot> getAllByVille(Ville ville) {
		List<Entrepot> entrepots = proxyEntrepot.getAllByVille(ville);
		return entrepots;
	}

	

}
