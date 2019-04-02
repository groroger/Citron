package fr.afcepf.al33.projet1.controller.admin;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
	
	private Stock selectedStock;

	
	@EJB
	private StockIBusiness proxyStock;
		
	

	@PostConstruct
	public void init() {
		stocks=proxyStock.getAll();
		
	}
	
	public void afficherApprovisionnements(Stock stock) {
		 selectedStock = stock;

		 System.out.println(selectedStock.getId());
		 
		 FacesContext facesContext = FacesContext.getCurrentInstance();
		 HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
		 session.setAttribute("selectedStock", selectedStock);
		 facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext,null,"/interfaceAdmin/afficherApprovisionnements.xhtml?faces-redirect=true");
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

	public Stock getSelectedStock() {
		return selectedStock;
	}

	public void setSelectedStock(Stock selectedStock) {
		this.selectedStock = selectedStock;
	}

	
	

}
