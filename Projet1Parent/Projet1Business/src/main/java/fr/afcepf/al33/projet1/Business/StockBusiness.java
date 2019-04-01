package fr.afcepf.al33.projet1.Business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al33.projet1.IBusiness.StockIBusiness;
import fr.afcepf.al33.projet1.entity.Approvisionnement;
import fr.afcepf.al33.projet1.entity.Stock;
import fr.afcepf.al33.projet1.idao.StockIdao;

@Remote(StockIBusiness.class)
@Stateless
public class StockBusiness implements StockIBusiness{

	@EJB
	private StockIdao proxyStockIDao;
	
	
	@Override
	public Stock add(Stock stock) {
		proxyStockIDao.ajouter(stock);
		return stock;
	}

	@Override
	public Boolean delete(Stock stock) {
		proxyStockIDao.supprimer(stock);
		return null;
	}

	@Override
	public Stock update(Stock stock) {
		proxyStockIDao.modifier(stock);
		return stock;
	}

	@Override
	public Stock searchById(Integer id) {
		Stock stock = proxyStockIDao.rechercherParId(id);
		return stock;
	}

	@Override
	public List<Stock> getAll() {
		List<Stock> stocks=new ArrayList<Stock>();
		stocks=proxyStockIDao.getAll();
		Date aujourdhui = new Date();
		
		for (Stock stock : stocks) {
			for (Approvisionnement approvisionnement : stock.getApprovisionnement()) {
				if (approvisionnement.getDatePeremption().after(aujourdhui))
					{
						stock.setQuantiteDispoPhysique(stock.getQuantiteDispoPhysique() + approvisionnement.getQuantiteRestante());
						stock.setQuantiteDispoSiteInternet(stock.getQuantiteDispoSiteInternet() + approvisionnement.getQuantiteRestante());
					}
			}
		}
		return stocks;
	}
}