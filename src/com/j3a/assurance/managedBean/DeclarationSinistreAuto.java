package com.j3a.assurance.managedBean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.objetService.ObjectService;

@Component
public class DeclarationSinistreAuto {
	
	//Injection Spring
	@Autowired
	ObjectService objectService;
	
	private boolean skip;
	private String optionRech ="1";
	private String valeurDeRecherche;
	private Contrat monContrat = new Contrat();
	
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	
	
	public void rechercherDossierProduction(){//By ALekerand
		
		switch (optionRech) {
		
		case "1"://Recherche par le num police
			//recherche le contrat
			Contrat contrat = new Contrat();
			contrat = (Contrat) getObjectService().getObjectById(valeurDeRecherche, "Contrat");
			if (!(contrat==null)) {
				//ok
				setMonContrat(contrat);
			} else {
				//Message
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info", "Rechercehe infructueuse!. Veuillez vérifier la saisie"));
			}
			
			
		}	
	}







/**********************ACCESSEURS***************************/
	public String getOptionRech() {
		return optionRech;
	}








	public void setOptionRech(String optionRech) {
		this.optionRech = optionRech;
	}







	public String getValeurDeRecherche() {
		return valeurDeRecherche;
	}







	public void setValeurDeRecherche(String valeurDeRecherche) {
		this.valeurDeRecherche = valeurDeRecherche;
	}



	public ObjectService getObjectService() {
		return objectService;
	}



	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}



	public Contrat getMonContrat() {
		return monContrat;
	}



	public void setMonContrat(Contrat monContrat) {
		this.monContrat = monContrat;
	}

}
