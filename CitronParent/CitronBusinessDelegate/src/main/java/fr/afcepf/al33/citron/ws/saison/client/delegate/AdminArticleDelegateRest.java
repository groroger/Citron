package fr.afcepf.al33.citron.ws.saison.client.delegate;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import fr.afcepf.al33.citron.ws.saison.client.dto.ArticleDto;
import fr.afcepf.al33.citron.ws.saison.client.dto.CategorieDto;

public class AdminArticleDelegateRest implements AdminArticleDelegate {

	private Client jaxrs2client;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("application");
	private String wsHost = bundle.getString("webservice.host");
	private String wsPort = bundle.getString("webservice.port");

	private String debutUrlCategories="http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/categories";
	private String debutUrlCategoriesPublic="http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/categories";

	private String debutUrlArticles="http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/articles";
	private String debutUrlArticlesPublic="http://" + wsHost + ":" + wsPort + "/articlesSaison/rest/public/articles";
	
	public AdminArticleDelegateRest() {
		this.jaxrs2client = ClientBuilder.newClient()
				            .register(JacksonFeature.class);
		System.out.println("adresse du web service lue dans application.properties : " + wsHost + ":" + wsPort + "\n");
	}
	

	public CategorieDto categorieParId(int id) {
		WebTarget categoriesTarget = jaxrs2client.target(debutUrlCategoriesPublic + "/" + id);
		CategorieDto categorie = 
				categoriesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(CategorieDto.class);
		return categorie;
	}


	public List<CategorieDto> listeCategories() {
		WebTarget categoriesTarget = jaxrs2client.target(debutUrlCategoriesPublic);
		CategorieDto[] tabCategories= 
				categoriesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(CategorieDto[].class);
		return Arrays.asList(tabCategories);
	}


	public CategorieDto sauvegarderCategorie(CategorieDto categorie) {
		WebTarget categoriesTarget = jaxrs2client.target(debutUrlCategories);
		Response responseSavedCategorie =  
				categoriesTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .post(Entity.entity(categorie, MediaType.APPLICATION_JSON_TYPE) );
		if(responseSavedCategorie.getStatus()==200 /*OK*/) {
			return responseSavedCategorie.readEntity(CategorieDto.class);
		}
		else 
			return null;
	}


	public void supprimerCategorieParId(int id) {
		WebTarget categoriesTarget = jaxrs2client.target(debutUrlCategories + "/" + id);
		categoriesTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
		return;
	}


	public ArticleDto articleParId(int id) {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticlesPublic + "/" + id);
		ArticleDto article = 
				articlesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(ArticleDto.class);
		return article;
	}


	public List<ArticleDto> listeArticles() {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticlesPublic);
		ArticleDto[] tabArticles= 
				articlesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(ArticleDto[].class);
		return Arrays.asList(tabArticles);
	}

	public ArticleDto sauvegarderArticle(ArticleDto article) {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticles);
		Response responseSavedArticle =  
				articlesTarget.request(MediaType.APPLICATION_JSON_TYPE)
		            .post(Entity.entity(article, MediaType.APPLICATION_JSON_TYPE) );
		if(responseSavedArticle.getStatus()==200 /*OK*/) {
			return responseSavedArticle.readEntity(ArticleDto.class);
		}
		else 
			return null;
	}

	public void supprimerArticleParId(int id) {
		WebTarget articlesTarget = jaxrs2client.target(debutUrlArticles + "/" + id);
		articlesTarget.request(MediaType.APPLICATION_JSON_TYPE).delete();
		return;
	}

}
