package fr.afcepf.al33.citron.bd.panierSaisonWS;


import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al33.citron.bd.panierSaisonWS.data.Article;

public class PanierSaisonBusiness implements PanierSaison {
	public static String URL_PANIER_SAISON = "http://localhost:7979/panierSaisonWS/PanierSaisonImpl?wsdl";
	
	@Override
	public double exemple(double montant, String codeMonnaieSource, String codeMonnaieCible) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article[] getAllArticles() {
		
		Article[] articles = null;
		try {
			URL wsdlURL = new URL(URL_PANIER_SAISON);
			QName SERVICE_NAME = new QName("http://panierSaisonWS.bd.citron.al33.afcepf.fr/","PanierSaisonImplService");
			Service service = Service.create(wsdlURL, SERVICE_NAME);
			QName PORT_NAME = new QName("http://panierSaisonWS.bd.citron.al33.afcepf.fr/","PanierSaisonImplPort");
			PanierSaison wsPanier = (PanierSaison) service.getPort(PORT_NAME, PanierSaison.class);
			articles = wsPanier.getAllArticles();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
		
	}

	@Override
	public String getHelloWorld() {
		// TODO Auto-generated method stub
		return null;
	}

}
