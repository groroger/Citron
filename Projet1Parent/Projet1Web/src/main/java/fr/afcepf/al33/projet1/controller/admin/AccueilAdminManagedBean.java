package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Stock;

@ManagedBean(name="mbAccueilAdmin")
@SessionScoped
public class AccueilAdminManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List <Stock> stockQuantity;
	private List <Stock> stockPeromption;
	
//	private int stockTotal;
//	private int stockVirtuel;

	@EJB
	private StockIBusiness proxyStock;
	
	@PostConstruct
	public void init() {
//		setStockQuantity(proxyStock.getByQuantity());
//		setStockPeromption(proxyStock.getByPeromption());
//		setStockTotal(proxyStock.getTotalQuantity());
//		setStockVirtuel(proxyStock.getVirtualQuantity());
		
	}

	public List <Stock> getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(List <Stock> stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public List <Stock> getStockPeromption() {
		return stockPeromption;
	}

	public void setStockPeromption(List <Stock> stockPeromption) {
		this.stockPeromption = stockPeromption;
	}

//	public int getStockTotal() {
//		return stockTotal;
//	}
//
//	public void setStockTotal(int stockTotal) {
//		this.stockTotal = stockTotal;
//	}
//
//	public int getStockVirtuel() {
//		return stockVirtuel;
//	}
//
//	public void setStockVirtuel(int stockVirtuel) {
//		this.stockVirtuel = stockVirtuel;
//	}
	
}
