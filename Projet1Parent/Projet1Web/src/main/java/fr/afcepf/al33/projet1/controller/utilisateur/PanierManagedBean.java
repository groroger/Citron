package fr.afcepf.al33.projet1.controller.utilisateur;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.afcepf.al33.projet1.IBusiness.ArticleCommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.entity.Article;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Client;
import fr.afcepf.al33.projet1.entity.Commande;



@ManagedBean(name="mbPanier")
@SessionScoped
public class PanierManagedBean implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  @ManagedProperty(value="#{mbCatalogueClient.articlesCommandes}")
  private List<ArticleCommande> articlesCommandes;
  
  @ManagedProperty(value="#{mbCatalogueClient.quantiteSaisie}")
  private int quantiteSaisie;
  
  @ManagedProperty(value="#{mbConnectionUtilisateur.clientConnecte}")
  private Client client;
  
  private double prixTotal;
  

  private Article selectedArticle;
  
  
  private Commande commande;
  
  @EJB
  private CommandeIBusiness proxyCommande;
  
  @EJB
  private ArticleCommandeIBusiness proxyArticleCommande;
  

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {


		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		client = (Client) session.getAttribute("clientConnecte");
		if ((List<ArticleCommande>) session.getAttribute("listeArticlesCommandes") != null)
		{
			articlesCommandes = (List<ArticleCommande>) session.getAttribute("listeArticlesCommandes");
		}
		
	
	
	
	}
    
  public void payer() {
	  
	  if (client != null) {
		  Commande cde = new Commande();
		  cde.setPrixTotal(prixTotal);
		  cde.setDateCreation(new Date());
		  cde.setClient(client);
		  proxyArticleCommande.add(cde, articlesCommandes);
	  } else {
		  FacesContext facesContext = FacesContext.getCurrentInstance();
		  HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);facesContext.getApplication()
						.getNavigationHandler()
						.handleNavigation(facesContext,null,"/interfaceClient/accueilClient.xhtml#test?faces-redirect=true");
		System.out.println("Merci de votre visite");
			
	  }
	  
	  
  }
  
  public double calculerPanier() {
		prixTotal = 0;
		Iterator<ArticleCommande> ite = articlesCommandes.iterator();
		while(ite.hasNext()) {
			ArticleCommande ac = ite.next();
			prixTotal += ac.getQuantite()*ac.getArticle().getPrix();
			}
		return prixTotal;
  		}
		
  
  
  public List<ArticleCommande> getArticlesCommandes() {
    return articlesCommandes;
  }



  public void setArticlesCommandes(List<ArticleCommande> articlesCommandes) {
    this.articlesCommandes = articlesCommandes;
  }



  public int getQuantiteSaisie() {
    return quantiteSaisie;
  }



  public void setQuantiteSaisie(int quantiteSaisie) {
    this.quantiteSaisie = quantiteSaisie;
  }


public Article getSelectedArticle() {
	return selectedArticle;
}

public void setSelectedArticle(Article selectedArticle) {
	this.selectedArticle = selectedArticle;
}

public double getPrixTotal() {
	return prixTotal;
}

public void setPrixTotal(double prixTotal) {
	this.prixTotal = prixTotal;
}

public Commande getCommande() {
	return commande;
}

public void setCommande(Commande commande) {
	this.commande = commande;
}



public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public CommandeIBusiness getProxyCommande() {
	return proxyCommande;
}

public void setProxyCommande(CommandeIBusiness proxyCommande) {
	this.proxyCommande = proxyCommande;
}




}