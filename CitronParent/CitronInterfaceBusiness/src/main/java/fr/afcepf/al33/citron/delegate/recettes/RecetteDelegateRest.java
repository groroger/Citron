package fr.afcepf.al33.citron.delegate.recettes;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al33.dto.RecetteSelectionnee;

public class RecetteDelegateRest implements RecetteDelegate {

	private Client jaxrs2client;
	private String debutUrlRecettePublic="http://localhost:9393/springBootWebService/rest/public/recettes";
	public RecetteDelegateRest() {
		this.jaxrs2client = ClientBuilder.newClient();
				           /* .register(JacksonFeature.class); */
	}
	

	@Override
	
	public List<RecetteSelectionnee> recettesSelectionnees(List<String> listeArticle) {
			
		WebTarget recettesTarget = jaxrs2client.target(debutUrlRecettePublic)
										.path("selectionner");
		for(String a : listeArticle) {
			recettesTarget = recettesTarget.queryParam("listeArticle",a);
		}
						               
		RecetteSelectionnee[] tabRecettes= 
				recettesTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(RecetteSelectionnee[].class);
		return Arrays.asList(tabRecettes);
		
	}
	
	
}
