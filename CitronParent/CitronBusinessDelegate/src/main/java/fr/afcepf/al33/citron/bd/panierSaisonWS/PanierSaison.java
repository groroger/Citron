package fr.afcepf.al33.citron.bd.panierSaisonWS;

import javax.jws.WebParam;
import javax.jws.WebService;

import fr.afcepf.al33.citron.bd.panierSaisonWS.data.Article;

@WebService
public interface PanierSaison {
    public double exemple(@WebParam(name="montant")double montant , 
							@WebParam(name="codeMonnaieSource")String codeMonnaieSource, 
							@WebParam(name="codeMonnaieCible")String codeMonnaieCible);
    public Article[] getAllArticles();
    public String getHelloWorld();
}
