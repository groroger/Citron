package fr.afcepf.al33.projet1.IBusiness;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Stock;

public interface ApprovisionnementIBusiness {
	
	public Approvisionnement addApprovisionnement(Approvisionnement a);
	
	List<Approvisionnement> getAllApproByIdArticle (Stock stock);

}
