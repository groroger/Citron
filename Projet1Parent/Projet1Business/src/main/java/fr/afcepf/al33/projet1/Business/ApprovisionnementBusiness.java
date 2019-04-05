package fr.afcepf.al33.projet1.Business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.projet1.IBusiness.ApprovisionnementIBusiness;
import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.entity.Stock;
import fr.afcepf.al33.projet1.idao.ApprovisionnementIdao;

@Remote(ApprovisionnementIBusiness.class)
@Stateless
public class ApprovisionnementBusiness implements ApprovisionnementIBusiness{

	@EJB
	private ApprovisionnementIdao proxyApprovisionnement;
	
	@Override
	public Approvisionnement addApprovisionnement(Approvisionnement a) {
		
		proxyApprovisionnement.ajouter(a);
		return a;
	}

	@Override
	public List<Approvisionnement> getAllApproByStock(Stock stock) {
		List<Approvisionnement> approvisionnements=null;
		approvisionnements= proxyApprovisionnement.getAllApproByStock(stock);
		return approvisionnements;
	}

	@Override
	public Boolean delete(Approvisionnement approvisionnement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande update(Approvisionnement approvisionnement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Approvisionnement searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	

	

}
