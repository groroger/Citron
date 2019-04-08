package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al33.projet1.IBusiness.CommandeIBusiness;
import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Commande;
import fr.afcepf.al33.projet1.entity.Stock;

@ManagedBean(name="mbAccueilAdmin")
@SessionScoped
public class AccueilAdminManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List <Stock> stockQuantity;
	private List <Stock> stockPeremption;
	private List<Commande> commandesEnAttente;
	
	private String stockTotal;
	private String stockVirtuel;

	@EJB
	private StockIBusiness proxyStock;
	
	@EJB
	private CommandeIBusiness proxyCommande;
	
	@PostConstruct
	public void init() {
		setStockQuantity(proxyStock.getByQuantity());
		//setStockPeremption(proxyStock.getByPeremption());
		setStockTotal(proxyStock.getTotalQuantity());
		setStockVirtuel(proxyStock.getVirtualQuantity());
		setCommandesEnAttente(proxyCommande.getAllToProcess());
		
	}

	public List <Stock> getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(List <Stock> stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List <Stock> getStockPeremption() {
		return stockPeremption;
	}

	public void setStockPeremption(List <Stock> stockPeremption) {
		this.stockPeremption = stockPeremption;
	}

	public String getStockTotal() {
		return stockTotal;
	}

	public void setStockTotal(String stockTotal) {
		this.stockTotal = stockTotal;
	}

	public String getStockVirtuel() {
		return stockVirtuel;
	}

	public void setStockVirtuel(String stockVirtuel) {
		this.stockVirtuel = stockVirtuel;
	}

	public List<Commande> getCommandesEnAttente() {
		return commandesEnAttente;
	}

	public void setCommandesEnAttente(List<Commande> commandesEnAttente) {
		this.commandesEnAttente = commandesEnAttente;
	}
	
}
