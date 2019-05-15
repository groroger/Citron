package fr.afcepf.al33.citron.bd.panierSaisonWS;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al33.citron.bd.panierSaisonWS.data.ArticlePanier;
import fr.afcepf.al33.citron.bd.panierSaisonWS.data.RefPanier;

@WebService
public interface PanierSaison {
	public String getHelloWorld();
	public List<ArticlePanier> getAllArticles();
	public List<RefPanier> getPanier(@WebParam(name="categorie")String categorie, 
							@WebParam(name="prix")double prix);
}
