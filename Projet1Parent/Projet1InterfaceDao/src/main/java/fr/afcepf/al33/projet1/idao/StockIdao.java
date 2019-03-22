package fr.afcepf.al33.projet1.idao;

import java.util.List;

import fr.afcepf.al33.projet1.entity.Stock;

public interface StockIdao extends GenericIdao<Stock>{
	
	public List<Stock> getAll();

}
