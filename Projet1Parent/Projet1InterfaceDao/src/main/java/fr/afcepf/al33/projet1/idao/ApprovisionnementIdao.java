package fr.afcepf.al33.projet1.idao;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Stock;

public interface ApprovisionnementIdao extends GenericIdao<Approvisionnement> {
	
	List<Approvisionnement> getAllApproByIdArticle (Stock stock);

}
