package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import fr.afcepf.al33.projet1.IBusiness.ApprovisionnementIBusiness;
import fr.afcepf.al33.projet1.IBusiness.ArticleIBusiness;
import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.ArticleCommande;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.entity.Stock;


@ManagedBean(name="mbFindCommandeATraiter")
@SessionScoped
public class RechercherCommandeATraiterManagedBean implements Serializable {

	final Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private CommandeIBusiness proxyCommande;

	@EJB
	private ArticleIBusiness proxyArticle;
	
	@EJB
	private ApprovisionnementIBusiness proxyApprovisionnement;

	@EJB
	private StockIBusiness proxyStock;
	
	private Commande foundCommande;
	private List<Commande> commandes;

	

	
	public void onSelect(Commande cde) {
	
		foundCommande = cde;
	  		
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		 session.setAttribute("foundCommande", foundCommande);
		 facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceAdmin/ficheCommande.xhtml?faces-redirect=true");
	}
	
	
	@PostConstruct
	public void init() {
		logger.debug("init()");
		commandes = proxyCommande.getAllToProcess();
		
	}


	public CommandeIBusiness getProxyCommande() {
		return proxyCommande;
	}


	public void setProxyCommande(CommandeIBusiness proxyCommande) {
		this.proxyCommande = proxyCommande;
	}


	public Commande getFoundCommande() {
		return foundCommande;
	}


	public void setFoundCommande(Commande foundCommande) {
		this.foundCommande = foundCommande;
	}


	public List<Commande> getCommandes() {
		return commandes;
	}


	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	// formatage date commande
	public String getDateToString(Date date) {
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
												DateFormat.SHORT,
												DateFormat.SHORT);
		
        return shortDateFormat.format(date);
    }
	
	public boolean traiterCommande(Commande cde) {
		boolean result = true;
		// traitement de la commande
		if(logger.isDebugEnabled()) {
			logger.debug("traiterCommande() id=" + cde.getId());
		}
		for (ArticleCommande article : cde.getArticlesCommandes()) {
			// pour chaque article 
			int quantitePreparee = 0;
			Stock stock = proxyStock.searchById(article.getArticle().getId());
			if(logger.isDebugEnabled()) {
				logger.debug("stock avant pour " + article.getArticle().getNom() 
						+ " physique = " + stock.getQuantiteDispoPhysique()
						+ " internet = " + stock.getQuantiteDispoSiteInternet());
			}
			List<Approvisionnement> approvisionnements = proxyApprovisionnement.getAllApproByStock(stock);
			// tri par date de péremption de la plus ancienne à la plus récente
			Collections.sort(approvisionnements, new Comparator<Approvisionnement>() {
				  public int compare(Approvisionnement a1, Approvisionnement a2) {
					  // a1 et a2 dans l'ordre pour un tri ascendant (option choisie ici)
					  // a2 et a1 en ordre inverse pour tri descendant
				      return a1.getDateApprovisionnement().compareTo(a2.getDateApprovisionnement());
				  }
				});			
			for (Approvisionnement approvisionnement : approvisionnements) {
				// dans les approvisionnements classés par ordre de date de péremption croissante
				// prendre la quantité nécessaire ou disponible 
				int quantiteAPrendre = Integer.min(article.getQuantite() - quantitePreparee, approvisionnement.getQuantiteRestante());
				if(logger.isDebugEnabled()) {
					logger.debug("quantité approvisionnement avant pour " 
							+ " lot " + approvisionnement.getLot()
							+ " date péremption " + approvisionnement.getDatePeremption()
							+ " = " + approvisionnement.getQuantiteRestante());
				}
				// décrémenter le stock dans l'approvisionnement
				approvisionnement.setQuantiteRestante(approvisionnement.getQuantiteRestante() - quantiteAPrendre);
				// modifier le stock
				proxyApprovisionnement.update(approvisionnement);
				if(logger.isDebugEnabled()) {
					logger.debug("quantité approvisionnement après pour " 
							+ " lot " + approvisionnement.getLot()
							+ " date péremption " + approvisionnement.getDatePeremption()
							+ " = " + approvisionnement.getQuantiteRestante());
				}
				quantitePreparee += quantiteAPrendre;
				// jusqu'à satisfaire la quantité commandée
				if(logger.isDebugEnabled()) {
					logger.debug("quantité préparée pour " + article.getArticle().getNom() 
							+ " = " + quantitePreparee + " / " + article.getQuantite());
				}
				if (quantitePreparee == article.getQuantite()) {
					if(logger.isDebugEnabled()) {
						logger.debug("quantité intégralement préparée pour " + article.getArticle().getNom());
					}
					break;					
				}
			}
			// si quantité insuffisante emettre un message d'alerte pour l'administrateur
			// création d'un message
			if (quantitePreparee < article.getQuantite()) {
				result = false;
				// modification de la quantité commandée à la quantité disponible
				article.setQuantite(quantitePreparee);
				// update fait par l'update de proxyCommande
				if(logger.isDebugEnabled()) {
					logger.debug("quantité commande ramenée à " + article.getQuantite() 
								+ " pour " + article.getArticle().getNom());
				}
				FacesMessage message = new FacesMessage("Pour la commande " + cde.getId() 
													+ " seulement " + quantitePreparee
													+ " sur " + article.getQuantite()
													+ " " + article.getArticle().getNom());
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				// ajout à la liste des messages à afficher
				FacesContext.getCurrentInstance().addMessage(null, message);
			}			
			// maj quantite physique dans Stock
			stock.setQuantiteDispoPhysique(stock.getQuantiteDispoPhysique() - quantitePreparee);
			proxyStock.update(stock);
			if(logger.isDebugEnabled()) {
				logger.debug("stock après pour " + article.getArticle().getNom() 
						+ " physique = " + stock.getQuantiteDispoPhysique());
			}
		}
		// mise à jour date expédition commande
		cde.setDateExpedition(new Date());
		proxyCommande.update(cde);
		
		// rechargement des commandes à traiter
		commandes = proxyCommande.getAllToProcess();
		
		return result;
	}
		
}
