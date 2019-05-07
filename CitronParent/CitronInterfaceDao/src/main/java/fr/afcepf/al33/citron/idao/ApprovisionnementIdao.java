package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Approvisionnement;
import fr.afcepf.al33.citron.entity.Stock;

public interface ApprovisionnementIdao extends GenericIdao<Approvisionnement> {
	
	List<Approvisionnement> getAllApproByStock (Stock stock);
	List<Approvisionnement> getOutOfDateAppro(int nbJours);
	List<Approvisionnement> getApproRupture();
	List<Approvisionnement> getAllApproPerimes();
}
