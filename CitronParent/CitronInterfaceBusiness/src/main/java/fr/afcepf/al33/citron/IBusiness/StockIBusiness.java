package fr.afcepf.al33.citron.IBusiness;

import java.util.List;

import fr.afcepf.al33.citron.entity.Categorie;
import fr.afcepf.al33.citron.entity.Stock;

public interface StockIBusiness {
	
	public Stock add(Stock stock);
	public Boolean delete(Stock stock);
	public Stock update(Stock stock);
	public Stock searchById(Integer id);
	public List<Stock> getByIdCategorie(Categorie c);
	
	public List<Stock> getAll() ;
	List<Stock> getByQuantity();
	public List<Stock> getRupture();
	String getTotalQuantity();
	String getVirtualQuantity();

}
