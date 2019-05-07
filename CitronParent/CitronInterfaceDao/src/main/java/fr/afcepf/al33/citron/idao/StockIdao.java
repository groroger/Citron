package fr.afcepf.al33.citron.idao;

import java.util.List;

import fr.afcepf.al33.citron.entity.Categorie;
import fr.afcepf.al33.citron.entity.Stock;

public interface StockIdao extends GenericIdao<Stock>{
	
	public List<Stock> getAll();
	public List<Stock> getByIdCategorie(Categorie c);
	public List<Stock> getByQuantity();
	public String getVirtualQuantity();
	public String getTotalQuantity();
	public List<Stock> getRupture();
}
