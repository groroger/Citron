package fr.afcepf.al33.projet1.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Stock;





@ManagedBean(name="mbStock")
@SessionScoped
public class AfficherStockManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private List <Stock> stocks;

	
	@EJB
	private StockIBusiness proxyStock;
		
	

	@PostConstruct
	public void init() {
		stocks=proxyStock.getAll();
		
	}
	
	


	public List<Stock> getStocks() {
		return stocks;
	}




	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}




	public StockIBusiness getProxyStock() {
		return proxyStock;
	}




	public void setProxyStock(StockIBusiness proxyStock) {
		this.proxyStock = proxyStock;
	}

	
	

}
