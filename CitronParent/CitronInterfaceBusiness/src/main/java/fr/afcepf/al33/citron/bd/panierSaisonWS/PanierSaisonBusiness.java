package fr.afcepf.al33.citron.bd.panierSaisonWS;


import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al33.citron.bd.panierSaisonWS.data.ArticlePanier;
import fr.afcepf.al33.citron.bd.panierSaisonWS.data.RefPanier;

public class PanierSaisonBusiness implements PanierSaison {
	public static String URL_PANIER_SAISON = "http://localhost:7676/panierSaisonWS/PanierSaisonImpl?wsdl";
	


	@Override
	public List<ArticlePanier> getAllArticles() {
		
		List<ArticlePanier> articles = null;
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

	@Override
	public List<RefPanier> getPanier(String categorie, double prix) {
		List<RefPanier> articles = null;
		try {
			URL wsdlURL = new URL(URL_PANIER_SAISON);
			QName SERVICE_NAME = new QName("http://panierSaisonWS.bd.citron.al33.afcepf.fr/","PanierSaisonImplService");
			Service service = Service.create(wsdlURL, SERVICE_NAME);
			QName PORT_NAME = new QName("http://panierSaisonWS.bd.citron.al33.afcepf.fr/","PanierSaisonImplPort");
			PanierSaison wsPanier = (PanierSaison) service.getPort(PORT_NAME, PanierSaison.class);
			articles = wsPanier.getPanier(categorie, prix);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

}
