package com.j3a.assurance.managedBean.Auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Conducteur;
import com.j3a.assurance.model.ConducteurSinistre;
import com.j3a.assurance.model.ConduireVehicule;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Facture;
import com.j3a.assurance.model.Garantie;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Sinistre;
import com.j3a.assurance.model.SinistreConducteur;
import com.j3a.assurance.model.SinistreConducteurId;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.model.VehiculeSinistre;
import com.j3a.assurance.model.VehiculeSinistreId;
import com.j3a.assurance.model.VehiculesAssures;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.ContratResum;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ManagedSinistre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  Logger logger=Logger.getLogger(ManagedSinistre.class);
	@Autowired
	private IdGenerateur idGenerateur;
	@Autowired
	private ObjectService objectService;

	private Sinistre sinistre = new Sinistre();
	private ConducteurSinistre conducteurSinistre = new ConducteurSinistre();
    private VehiculeSinistre vehiculeSinistre = new VehiculeSinistre();
    private Conducteur conducteur;
	private String optionRech ="1"; 
	private String optionConducteur = "1";
	private String valeurDeRecherche;
	private ContratResum monContratResum;
	private List<ContratResum> listeContratResum = new ArrayList<>();
	private List<Sinistre> listSinistre = new ArrayList<Sinistre>();
	private List<ContratResum> listContratVehicule = new ArrayList<>();
	private ContratResum selectedContratResum;
	private ContratResum selectedContratResumVeh = new ContratResum();
	private List<Sinistre> listSinistreEnCours = new ArrayList<Sinistre>();
	private Date dateDeclaration = Calendar.getInstance().getTime();
	
	private String numPolice = "";
	private String codeVehicule;
	private Facture facture;
    private String libelleDomageCorp;
	private String typeFiltre;
	private String filtre;
   private BigDecimal rcAssure=new BigDecimal(0);
	

	
		Boolean etatRecherche = false;
		private Contrat resultacontrat = new Contrat();
		private Personne resultatPersonne = new Personne();
		private List<Garantie> listeGarantieSelected = new ArrayList<>();
	
		
		public String onFlowProcess(FlowEvent event) {
		 String oldStep = event.getOldStep();
		 String newStep = event.getNewStep();
		 
	        if(selectedContratResum != null) {
	        	 return event.getNewStep();
	        }else{
	        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur!", "Veuillez selectionner le vehicule"));
	        	return event.getOldStep();
	        }
	    }
	

	public void creeSinitre(){//By Alekerand
		
		//Declaration necessaire pour la création du sinistre
		vehiculeSinistre = new VehiculeSinistre();
        SinistreConducteur sinistreConducteur = new SinistreConducteur();
		
		//Generation du code du sinistre
	sinistre.setCodeSinistre(getIdGenerateur().getIdSinistre(getMonContratResum().getPoliceResum()));
	sinistre.setContrat(getMonContratResum().getPoliceResum());
	sinistre.setDateDeclaration(dateDeclaration);
	

	//Créer le conducteur du sinistre
		conducteurSinistre.setCodeConducteurSinistre(getIdGenerateur().getIdCondSinistre());
		//Creer vehiculeSinistre
        VehiculeSinistreId vehiculeSinistreId = new VehiculeSinistreId(getSinistre().getCodeSinistre(), getMonContratResum().getVehiculeResum().getCodeVehicule());
        vehiculeSinistre.setId(vehiculeSinistreId);
        

		//créer ConducteurSinistre
		SinistreConducteurId sinistreConducteurId = new SinistreConducteurId(getConducteurSinistre().getCodeConducteurSinistre(), getSinistre().getCodeSinistre());
        sinistreConducteur.setId(sinistreConducteurId);
		sinistreConducteur.setDateConducteurSinistre(Calendar.getInstance().getTime());

		//Enregistrement
		getObjectService().addObject(sinistre);
		getObjectService().addObject(conducteurSinistre);
		getObjectService().addObject(vehiculeSinistre);
        getObjectService().addObject(sinistreConducteur);
        
        //mettre à jour les mail et le téléphone
        	getObjectService().updateObject(monContratResum.getPersonneResum());        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sinistre déclaré et enregistré!", ""));
        //Vder le formulaire
        viderObjet();
	}
	
	
	public void viderObjet(){
		//Vider la recherche
		setValeurDeRecherche("");
		//Effacer le sinistre
		sinistre.setDateSurvenance(null);
		sinistre.setDateDeclaration(null);
		sinistre.setCirconstance(null);
		
		//Effacer conducteur sinistre
		conducteurSinistre.setNomCondSinistre(null);
		conducteurSinistre.setPrenomCondSinistre(null);
		conducteurSinistre.setDateNaissCondSinistre(null);
		conducteurSinistre.setNumPermis(null);
		conducteurSinistre.setCategoriePermis(numPolice);
		conducteurSinistre.setAdresse(null);
		conducteurSinistre.setTelFixe(null);
		conducteurSinistre.setTelCell(null);
		conducteurSinistre.setEmail(null);
		
		//Vider VehiculeSininistre
		vehiculeSinistre.setLieuSinistre(numPolice);
		vehiculeSinistre.setNbreBlesse(null);
		vehiculeSinistre.setNbreDeces(null);
		vehiculeSinistre.setRcAssure(null);
		vehiculeSinistre.setLibelleDomageCorp(null);
		vehiculeSinistre.setLibelleDomageMat(null);
		
		setMonContratResum(null);
		//Vider l'objet contratresum
				
		//Vider la liste 
		listeContratResum.clear();	
		listContratVehicule.clear();
	}
	
	@Transactional
	public void rechercherDossierProduction(){//By ALekerand
		//Vider la liste a chaque fois que la methode est appele
		listeContratResum.clear();
		
		monContratResum = new ContratResum();
		if(optionRech.equalsIgnoreCase(null)){
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Info", "Faites un choix!"));

		}else{
		switch (optionRech) {
		
		case "1"://Recherche par le num police
			//recherche le contrat
			Contrat contrat = new Contrat();
			contrat = (Contrat) getObjectService().getObjectById(valeurDeRecherche, "Contrat");
			
			//Si le contrat existe recuperer les autres infos
			if(!(contrat==null)){
				ContratResum contratResum = new ContratResum();
				contratResum.setPoliceResum(contrat);
				
				//Recuperer le souscripteur
				contratResum.setPersonneResum(contrat.getPersonne());
				
				//Nature de la personne
				if(contrat.getPersonne().getPhysique() != null){
					contratResum.setPhysiqueResum(contrat.getPersonne().getPhysique());
				}else{
					contratResum.setMoraleResum(contrat.getPersonne().getMorale());
				}
				
				//recuperer le dernier avenant
				 contratResum.setAvenantResum(getObjectService().DernierAvenant(contrat.getNumPolice()));
				 
				 //Recuperation de la liste de vehicule
				 VehiculesAssures vehiculesAssures = contratResum.getAvenantResum().getVehiculesAssures();
				 for(Vehicule vat: vehiculesAssures.getVehicules()){

					//Ajouter le Vehicule
					contratResum.setVehiculeResum(vat);
				}
				 
				 //Recuperer le conducteur
				 contratResum.setConducteurResum(recupererCondHabituel(contratResum.getVehiculeResum()));
				 
				  //Editer le conducteur sinistre
				 chargerConducteurSinistre(contratResum.getConducteurResum(), conducteurSinistre);
				 
				 setMonContratResum(contratResum);
				 listeContratResum.add(contratResum);
			}
			
			break;
		
		case"2"://Recherche par l'imatricultion vehicule
			listContratVehicule.clear();
			
			//Rechercher le vehicule
			 List<Vehicule> vehiculeList = getObjectService().trouverVehicules(valeurDeRecherche);
			//Recuperer tous les contrat lier à cette imatriculation
			for(Vehicule vehicul : vehiculeList){
				ContratResum contratResum = new ContratResum();
				contratResum.setVehiculeResum(vehicul);
				
				//Recuperer vehicule_Assure
				VehiculesAssures vehiculesAssures = vehicul.getVehiculesAssures();
				//Recuperer la liste des avenants
				List<Avenant> listeAvenant = new ArrayList<Avenant>();
				for(Avenant avenant:vehiculesAssures.getAvenants()){
					listeAvenant.add(avenant);
				}
				
				//Recuperer le Contrat
				Contrat contrat2 = listeAvenant.get(0).getContrat();
				contratResum.setPoliceResum(contrat2);
				
				//Recuperer le dernier avenant
				contratResum.setAvenantResum(getObjectService().DernierAvenant(contrat2.getNumPolice()));
				 
				 //Recuperer la prsonne
				 contratResum.setPersonneResum(contrat2.getPersonne());
				 listContratVehicule.add(contratResum);
				 
				//Nature de la personne
					if(contrat2.getPersonne().getPhysique() != null){
						contratResum.setPhysiqueResum(contrat2.getPersonne().getPhysique());
					}else{
						contratResum.setMoraleResum(contrat2.getPersonne().getMorale());
					}
				}
				//lEVER LA BOITE DE DIALOG POUR LE CHOIX DU CONTRAT
				RequestContext.getCurrentInstance().execute("contrat_Dialog.show();");
				
			break;
		}
		}
	}
	
	
	@Transactional
	public void chargerlechoix(){
		//Charger la liste
		listeContratResum.add(selectedContratResumVeh);
		//Renseigner info de base
		setMonContratResum(selectedContratResumVeh);
		
		//Recuperer le conducteur
		monContratResum.setConducteurResum(recupererCondHabituel(monContratResum.getVehiculeResum()));

		//Charger 
		chargerConducteurSinistre(monContratResum.getConducteurResum(), conducteurSinistre);
	}
	
	
	public Conducteur recupererCondHabituel(Vehicule vehicule){
		ConduireVehicule conduireVehicule = getObjectService().recupConduireVehicule(vehicule.getCodeVehicule());
		//Recuperation du conducteur
		conducteur = new Conducteur();
		try {
			conducteur = conduireVehicule.getConducteur();
		} catch (Exception e) {
			conducteur = new Conducteur(getIdGenerateur().getIdConducteur(monContratResum.getPersonneResum()));
			setOptionConducteur("2");
		}
		return conducteur;
	}


	public void chargerConducteurSinistre(Conducteur paramCond, ConducteurSinistre paramCondSinist){
		//Renseigner le conducteurSinistre par les info du conducteur
		paramCondSinist.setNomCondSinistre(paramCond.getNonCond());
		paramCondSinist.setPrenomCondSinistre(paramCond.getPrenomsCond());
		paramCondSinist.setDateNaissCondSinistre(paramCond.getDateNaissCond());
		paramCondSinist.setNumPermis(paramCond.getNumpermiscond());
	}

	
	public void clearSinistre() {
		// instancier sinistre afin de cree une nouvelle donnÃ©e
		numPolice = "";
		codeVehicule = "";
	//	sinistre = new Sinistre();
	}

	public String getNumPolice() {
		
		return numPolice;
	}
	
	
	public Contrat recherchePoliceContrat(String paramPolice){//By ALekerand
		etatRecherche = false;
			try {
				resultacontrat = (Contrat) getObjectService().getObjectById(paramPolice, "Contrat");
				if(!(resultacontrat==null)){
					etatRecherche = true;
					System.out.println("Contrat trouvï¿½!");//clean After
				}
			} catch (Exception e) {
				logger.error("Erreur lors de la recherche d'un contrat en production");
				e.printStackTrace();
			}
		return resultacontrat;
	}
	
	
	public Personne recupererPersonne(String paramNumSous){//By ALekerand
		etatRecherche = false;
			try {
				resultatPersonne = (Personne) getObjectService().getObjectById(paramNumSous, "Personne");
				if(!(resultatPersonne == null)){
					etatRecherche = true;
				}
			} catch (Exception e) {
				logger.error("Erreur lors de la recherche d'une Personne liï¿½ ï¿½ un contrat en production" );
				e.printStackTrace();
			}
				return resultatPersonne;
		}
	

	/*******************************ACCESSEUR recherche****************/

	public Sinistre getSinistre() {
		return sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}
	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}

	
	public List<Sinistre> getListSinistre() {
		return listSinistre;
	}

	public void setListSinistre(List<Sinistre> listSinistre) {
		this.listSinistre = listSinistre;
	}

	public String getTypeFiltre() {
		return typeFiltre;
	}

	public void setTypeFiltre(String typeFiltre) {
		this.typeFiltre = typeFiltre;
	}

	public String getFiltre() {
		return filtre;
	}

	public void setFiltre(String filtre) {
		this.filtre = filtre;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public List<Sinistre> getListSinistreEnCours() {
		return listSinistreEnCours;
	}

	public void setListSinistreEnCours(List<Sinistre> listSinistreEnCours) {
		this.listSinistreEnCours = listSinistreEnCours;
	}

	
	public String getCodeVehicule() {
		return codeVehicule;
	}

	public void setCodeVehicule(String codeVehicule) {
		this.codeVehicule = codeVehicule;
	}

	public ConducteurSinistre getConducteurSinistre() {
		return conducteurSinistre;
	}

	public void setConducteurSinistre(ConducteurSinistre conducteurSinistre) {
		this.conducteurSinistre = conducteurSinistre;
	}

	public IdGenerateur getIdGenerateur() {
		return idGenerateur;
	}

	public void setIdGenerateur(IdGenerateur idGenerateur) {
		this.idGenerateur = idGenerateur;
	}

	public VehiculeSinistre getVehiculeSinistre() {
		return vehiculeSinistre;
	}

	public void setVehiculeSinistre(VehiculeSinistre vehiculeSinistre) {
		this.vehiculeSinistre = vehiculeSinistre;
	}

	public String getLibelleDomageCorp() {
		return libelleDomageCorp;
	}

	public void setLibelleDomageCorp(String libelleDomageCorp) {
		this.libelleDomageCorp = libelleDomageCorp;
	}

	public BigDecimal getRcAssure() {
		return rcAssure;
	}

	public void setRcAssure(BigDecimal rcAssure) {
		this.rcAssure = rcAssure;
	}

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}


	public String getValeurDeRecherche() {
		return valeurDeRecherche;
	}


	public void setValeurDeRecherche(String valeurDeRecherche) {
		this.valeurDeRecherche = valeurDeRecherche;
	}

	public String getOptionRech() {
		return optionRech;
	}

	public void setOptionRech(String optionRech) {
		this.optionRech = optionRech;
	}

	public Personne getResultatPersonne() {
		return resultatPersonne;
	}

	public void setResultatPersonne(Personne resultatPersonne) {
		this.resultatPersonne = resultatPersonne;
	}

	public List<Garantie> getListeGarantieSelected() {
		return listeGarantieSelected;
	}

	public void setListeGarantieSelected(List<Garantie> listeGarantieSelected) {
		this.listeGarantieSelected = listeGarantieSelected;
	}

	public ContratResum getMonContratResum() {
		return monContratResum;
	}

	public void setMonContratResum(ContratResum monContratResum) {
		this.monContratResum = monContratResum;
	}

	public ContratResum getSelectedContratResum() {
		return selectedContratResum;
	}

	public void setSelectedContratResum(ContratResum selectedContratResum) {
		this.selectedContratResum = selectedContratResum;
	}

	public List<ContratResum> getListeContratResum() {
		return listeContratResum;
	}

	public void setListeContratResum(List<ContratResum> listeContratResum) {
		this.listeContratResum = listeContratResum;
	}

	public List<ContratResum> getListContratVehicule() {
		return listContratVehicule;
	}

	public void setListContratVehicule(List<ContratResum> listContratVehicule) {
		this.listContratVehicule = listContratVehicule;
	}

	public ContratResum getSelectedContratResumVeh() {
		return selectedContratResumVeh;
	}

	public void setSelectedContratResumVeh(ContratResum selectedContratResumVeh) {
		this.selectedContratResumVeh = selectedContratResumVeh;
	}


	public String getOptionConducteur() {
		return optionConducteur;
	}


	public void setOptionConducteur(String optionConducteur) {
		this.optionConducteur = optionConducteur;
	}


	public Date getDateDeclaration() {
		return dateDeclaration;
	}


	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

}
