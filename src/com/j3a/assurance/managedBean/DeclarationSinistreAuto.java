package com.j3a.assurance.managedBean;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Sinistre;
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
	private String lieu;
	private String domageCorps;
	private String domageMat;
	private int nbreBlesse;
	private int nbreDeces;
	private BigDecimal rcAssure=new BigDecimal(0);
	private Sinistre sinistre = new Sinistre();
	
	
	
	
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


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public Sinistre getSinistre() {
		return sinistre;
	}


	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}


	public String getDomageCorps() {
		return domageCorps;
	}


	public void setDomageCorps(String domageCorps) {
		this.domageCorps = domageCorps;
	}


	public String getDomageMat() {
		return domageMat;
	}


	public void setDomageMat(String domageMat) {
		this.domageMat = domageMat;
	}


	public int getNbreBlesse() {
		return nbreBlesse;
	}


	public void setNbreBlesse(int nbreBlesse) {
		this.nbreBlesse = nbreBlesse;
	}


	public int getNbreDeces() {
		return nbreDeces;
	}


	public void setNbreDeces(int nbreDeces) {
		this.nbreDeces = nbreDeces;
	}

}
