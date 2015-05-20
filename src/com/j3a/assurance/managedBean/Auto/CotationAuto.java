package com.j3a.assurance.managedBean.Auto;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Conducteur;
import com.j3a.assurance.model.ConduireVehicule;
import com.j3a.assurance.model.ConduireVehiculeId;
import com.j3a.assurance.model.Exercice;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.Quittance;
import com.j3a.assurance.reporting.bean.ReportingAuto;
import com.j3a.assurance.reporting.design.ConditionPartAuto;
import com.j3a.assurance.reporting.design.QuittanceDesignAuto;
import com.j3a.assurance.utilitaire.IdGenerateur;
import com.j3a.assurance.utilitaire.VehiculeRow;

@Component
public class CotationAuto implements Serializable{
	Logger logger = Logger.getLogger(CotationAuto.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    @Autowired
		private ContratMB contratMB;
	    @Autowired
		private ClientMB clientMB;
	    @Autowired
		private CarteGriseMB carteGriseMB;
		private Conducteur cduc;
		private Boolean showNavBar = false;
		private Exercice exercice = new Exercice();
		@Autowired
		private ManagedQuittanceAuto managedQuittanceAuto;
		@Autowired
		private GarantieMB garantieMB;

		private String nomclient, adresseclient, sousCategorieV, risque;

		@Autowired
		IdGenerateur idGenerateur;
		@Autowired
		ConditionPartAuto conditionPartAuto;
		@Autowired
		private QuittanceDesignAuto quittanceDesignAuto;

		@PostConstruct
		public void postConstru() {
			risque = "Automobile";
			//getContratMB().setUtilisateur(getContratMB().utlsateur());
			/*String pv = getContratMB().getUtilisateur().getCodePointVente()
					.getId();
			String util = getContratMB().getUtilisateur().getId();
			getContratMB().getContrat().setNumPolice(
					getIdGenerateur().getPoliceID(pv, util, "AUT"));
			String idAven = getIdGenerateur().getIdNewAvenant(
					getContratMB().getContrat().getNumPolice());
			getContratMB().getAvenant().setNumAvenant(idAven);*/
			getContratMB().setDureeEnjour((long) 365);
			/*getManagedQuittanceAuto().setQuittanceid(
					getIdGenerateur().getIdQuittance(idAven));*/
			setExercice(getContratMB().getExerciceOuvert()); 
			System.out.println("+++++++Exercice+++++++"
					+getExercice().getCodeexercice() );
			
		}

		
		
		//irene
		public void validerContrat(){
			     //client
		    	getClientMB().addPersonnePhysique();
		    	
		    	//contrat
				String pv = getContratMB().getUtilisateur().getPointVente()
				.getCodePointVente();
				String util =getContratMB().getUtilisateur().getCodeUtilisateur();
				getContratMB().getContrat().setNumPolice(getIdGenerateur().getPoliceID(pv, util, "AUT"));
				getContratMB().getContrat().setPointVente(getContratMB().getUtilisateur().getPointVente());
				getContratMB().getContrat().setPersonne(getClientMB().getPhysique().getPersonne());
				getContratMB().getContrat().setRisque(getContratMB().getRisque());
				getContratMB().getContrat().setSocieteAssurance(getContratMB().getSocieteAssurance());
				getContratMB().getObjectService().addObject(getContratMB().getContrat());
				
				//avenant
				String idAven = getIdGenerateur().getIdNewAvenant(getContratMB().getContrat().getNumPolice());
				getContratMB().getAvenant().setNumAvenant(idAven);
				short d = (short) (getContratMB().getDuree()* 30);
				int mail = 1;
				getContratMB().getAvenant().setDateAvenant(getContratMB().getdateAvenant());
				getContratMB().getAvenant().setEffet(getContratMB().getEffet());
				getContratMB().getAvenant().setDateEmission(getContratMB().getEmission());
				getContratMB().getAvenant().setMouvement(getContratMB().getMouvement());
				getContratMB().getAvenant().setEcheance(getContratMB().getEcheance());
				getContratMB().getAvenant().setContrat(getContratMB().getContrat());
				getContratMB().getAvenant().setUtilisateur(getContratMB().getUtilisateur());
				getContratMB().getObjectService().addObject(getContratMB().getAvenant());
				
				//conducteur
				//getClientMB().addConducteur();
				
				/*//conduireVehicule
				ConduireVehicule conduireVehicule =new ConduireVehicule();
				ConduireVehiculeId conduireVehiculeId =new ConduireVehiculeId();
				conduireVehiculeId.setCodeVehicule(getCarteGriseMB().getSlctdVehiRw().getVehi().getCodeVehicule());
				conduireVehiculeId.setNumCond(getClientMB().getConducteur().getNumCond());
				conduireVehicule.setId(conduireVehiculeId);
				conduireVehicule.setDateConduite(Calendar.getInstance().getTime());
				getClientMB().getObjectService().addObject(conduireVehicule);*/
				
		}


		
		
		
		public void choixSousCat() {
			// recup�ration du taux de l'apporteur et l'apporteur
			//getCarteGriseMB().getSlctdVehiRw().setApporteur(
			//		getContratMB().getCodeApporteur());

		/*	getContratMB().getCalculCommission().getTauxCommissionApporteur(
					getCarteGriseMB().getSlctdVehiRw().getApporteur().getCodeApporteur(),
					getCarteGriseMB().getSlctdVehiRw().getSouCatVehi()
							.getCategorie().getCodeCategorie());*/
			//getCarteGriseMB().getSlctdVehiRw().setTauxCommissionApporteur(
				//	getContratMB().getCalculCommission().getTauxCommission());
			getCarteGriseMB().choixSousCat();
		}

		// les methodes de choix Avenant Affaire Nouvelle
		public void tabChange() {
			// good
			getGarantieMB().setDuree(getContratMB().getDuree());
			getGarantieMB().getListeGroupGaranties().clear();
			getGarantieMB().getListegaranties().clear();
			getGarantieMB().getListegarantieFiltre().clear();
			getGarantieMB().cleanChamps();
			getGarantieMB().setCodeRisque("1");
			
			getGarantieMB().affichegarantiesAuto(
					getCarteGriseMB().getSlctdVehiRw());
		}

		// methode de validation de la prime
		/*public void rechercherClient() {
			getClientMB().rechercherClient();
			if (getClientMB().getStatutRechercheClient() == true) {
				showNavBar = true;
			}

		}*/

		
		

		public void validerPrime() {
			//getGarantieMB().validerPrime();

			// listGarantieparVehicule
			getCarteGriseMB().getSlctdVehiRw().getListGarantieparVehicule()
					.clear();

			getCarteGriseMB().getSlctdVehiRw().getListegaranties().clear();
			getCarteGriseMB().getSlctdVehiRw().getListegaranties()
					.addAll(getGarantieMB().getListegaranties());

			getCarteGriseMB().setValidVehiEtat(false);
		}

		public void majConducteur() {

			getCarteGriseMB().getSlctdVehiRw().getConduHab().setDateNaissCond(
					getClientMB().getMaPersonne().getDatePers());
			getCarteGriseMB().getSlctdVehiRw().getConduHab().setNonCond(
					getClientMB().getMaPersonne().getNomRaisonSociale());
			
			getCarteGriseMB().getSlctdVehiRw().getConduHab().setPrenomsCond(getClientMB().getMonPhysique().getPrenomPers());
			getCarteGriseMB().getSlctdVehiRw().getConduHab().setLieuNaisCond(getClientMB().getMonPhysique().getLieuNaissPers());
			
			
			getCarteGriseMB().getSlctdVehiRw().getConduHab().setNumCond(getClientMB().getMonPhysique().getNumPiecePers());
			getCarteGriseMB().getSlctdVehiRw().getConduHab().setDureepermiscond((short) 0);
			System.out.println("+++++++Conducteur habituel du Vehicule+++++++"
					+ getCarteGriseMB().getSlctdVehiRw().getConduHab().getNonCond());

		}

		public boolean isClientConduc() {
			String numpiece = "";
			if (getClientMB().getMaPersonne().getPhysique()!=null) {
				numpiece = (getClientMB().getMaPersonne().getPhysique())
						.getNumPiecePers();
			}
			if (getClientMB().getMaPersonne().getMorale()!=null) {
				numpiece = (getClientMB().getMaPersonne().getMorale()).getNumRc();
			}

			return numpiece.equalsIgnoreCase(getCarteGriseMB()
					.getSlctdVehiRw().getConduHab().getNumCond());
		}

		public void chxConducteur() {
			if (isClientConduc()) {
				majConducteur();
			} else {
				cduc = (Conducteur) getCarteGriseMB().getObjectService()
						.getObjectById(
								getCarteGriseMB().getSlctdVehiRw()
										.getConduHab().getNumCond(), "Conducteur");
				if (cduc != null) {
					getCarteGriseMB().getSlctdVehiRw().setConduHab(cduc);
				} else {
					getCarteGriseMB().getSlctdVehiRw().setConduHab(
							new Conducteur(getCarteGriseMB().getSlctdVehiRw()
									.getConduHab().getNumCond()));
				}
			}
		}

		public void ValiderCotation() {
			getGarantieMB().validerGarantie();
			getCarteGriseMB().getSlctdVehiRw().getListegaranties().clear();
	if(!getGarantieMB().getListeGarantiesSelect().isEmpty()){
			getCarteGriseMB().getSlctdVehiRw().getListegaranties()
					.addAll(getGarantieMB().getListeGarantiesSelect());
			getCarteGriseMB().getSlctdVehiRw().setPrimeNette(
					getGarantieMB().getPrimeTotale());
			// calcul de l'accessoire de l'apporteur
			getCarteGriseMB().getSlctdVehiRw().setCommissionApporteur(BigDecimal.ZERO);
			getCarteGriseMB().validerVehicule();

		
	}
	
	
		}
		public String voirQuittance(){
			getManagedQuittanceAuto().getListVehicules().clear();
			getManagedQuittanceAuto().getListVehicules().addAll(
					getCarteGriseMB().getVehiculeList());
		
			getContratMB().getAvenant().setEffet(getContratMB().getEffet());
			getContratMB().getAvenant().setDateEmission(getContratMB().getEmission());
			getContratMB().getAvenant().setEcheance(getContratMB().getEcheance());
			
			getManagedQuittanceAuto().setAvenant(
					getContratMB().getAvenant());

			getManagedQuittanceAuto().setExercice(getExercice().getCodeexercice());// A corriger

			getManagedQuittanceAuto().calculPrime();
			getManagedQuittanceAuto().calculQuittance();

			return "Validation";
		}
		
		public void sendDevis(){
			//chargement des donn�es pour le rapport pdf
			ReportingAuto report = new ReportingAuto();
			report.setAvenant(getContratMB().getAvenant());
			report.setContrat(getContratMB().getContrat());
			report.setListVehiculeRow(getCarteGriseMB().getVehiculeList());
			Quittance quit = new Quittance();
			quit.setAccessoire(getManagedQuittanceAuto().getQuittanceAuto().getAccessoire());
			quit.setTaxes(getManagedQuittanceAuto().getQuittanceAuto().getTaxeEnr());
			quit.setFga(getManagedQuittanceAuto().getQuittanceAuto().getTaxeFGA());
			quit.setNetAPayer(getManagedQuittanceAuto().getQuittanceAuto().getNetteApayer());
			report.setQuittance(quit);
			report.setNom("Devis");
			report.setPersonne(getClientMB().getMaPersonne());
			if(getContratMB().getUtilisateur().getPointVente()!=null){
			report.setPointVente(getContratMB().getUtilisateur().getPointVente());
			}
			report.setRisque(getContratMB().getRisque());
			report.setSocieteAssurance(getContratMB().getSocieteAssurance());
			try{
			getConditionPartAuto().setReportingAuto(report);
			getConditionPartAuto().editerConditionPart(report, (HttpServletRequest) FacesContext.getCurrentInstance()
							.getExternalContext().getRequest(),
					(HttpServletResponse) FacesContext.getCurrentInstance()
							.getExternalContext().getResponse());
		} catch (IOException e) {
			logger.error("Erreur d'�dition de piece", e);
		} catch (Exception e) {
			logger.error(
					"Erreur lors de l'enregistrement du enregistrement du contrat Auto",
					e);
		}
		}
		

		public void validerVehicule() {
			if (!getCarteGriseMB().getVehiculeList().contains(
					getCarteGriseMB().getSlctdVehiRw())) {
				getCarteGriseMB().getSlctdVehiRw().setNumOrdr(
						getCarteGriseMB().getVehiculeList().size() + 1);
				getCarteGriseMB().getVehiculeList().add(
						getCarteGriseMB().getSlctdVehiRw());

			}
			getCarteGriseMB().setSlctdVehiRw(new VehiculeRow());
			majConducteur();
			getCarteGriseMB().setEditGarEtat(true);
			getCarteGriseMB().setValidVehiEtat(true);
			getCarteGriseMB().setSlctdVehiRwTb(null);
			// System.out.println("���������������������������������������"+getContratMB().getBaremes());
		}
		public String handleflow(FlowEvent event) {
			
			String oldStep = event.getOldStep();
			String newStep = event.getNewStep();
			String a = newStep;
			// TRAITEMENT POUR LE PASSAGE DE Immat A categorie
			if (newStep.equalsIgnoreCase("ongletCategorie")
					&& oldStep.equalsIgnoreCase("ongletImmatriculation")) {
				System.out.println("TRAITEMENT POUR LE PASSAGE DE Immat A categorie");
				getContratMB().getAvenant().setEffet(getContratMB().getEffet());
				getContratMB().getAvenant().setDateEmission(getContratMB().getEmission());
				getContratMB().getAvenant().setEcheance(getContratMB().getEcheance());
			
				//V�rification des conditions
				if (getCarteGriseMB().getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("")) {
							
			//on reste sur la partie
					FacesMessage msg = new FacesMessage(
							"Cat�gorie du vehicule non renseign�e");
					FacesContext.getCurrentInstance().addMessage(null, msg);
					a = oldStep;
			}
			}
			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
			if (newStep.equalsIgnoreCase("ongletCategorie")
					&& oldStep.equalsIgnoreCase("ongletVehicule")) {
				System.out.println("TRAITEMENT POUR LE PASSAGE DE categorie A vehicule");
			}
			
			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
						if (newStep.equalsIgnoreCase("ongletConducteur")
								&& oldStep.equalsIgnoreCase("ongletVehicule")) {
							if (getClientMB().isEtatClient()==true){
								getClientMB().majconducteur();
								majConducteur();
								//System.out.println("conducteur"+getCarteGriseMB().getSlctdVehiRw().getConduHab().getNumCond());
								getCarteGriseMB().getSlctdVehiRw().setConduHab(getClientMB().getConducteur());
							}
							System.out.println("TRAITEMENT POUR LE PASSAGE DE Vehicule A conducteur");
						}
						
			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
						if (newStep.equalsIgnoreCase("ongletGarantie")
								&& oldStep.equalsIgnoreCase("ongletConducteur")) {
							System.out.println("TRAITEMENT POUR LE PASSAGE du conducteur aux garanties");
							getCarteGriseMB().validerProp();
							tabChange();
							
							
							
						}
			//logs.info(">>>>/ END -handleflow-");
			return a;
		}

		public void addContrats() {
			  //client
	    	getClientMB().addPersonnePhysique();
	    	
	    	//contrat
			String pv = getContratMB().getUtilisateur().getPointVente()
			.getCodePointVente();
			String util =getContratMB().getUtilisateur().getCodeUtilisateur();
			getContratMB().getContrat().setNumPolice(getIdGenerateur().getPoliceID(pv, util, "AUT"));
			getContratMB().getContrat().setPointVente(getContratMB().getUtilisateur().getPointVente());
			getContratMB().getContrat().setPersonne(getClientMB().getPhysique().getPersonne());
			getContratMB().getContrat().setRisque(getContratMB().getRisque());
			getContratMB().getContrat().setSocieteAssurance(getContratMB().getSocieteAssurance());
			//getContratMB().getObjectService().addObject(getContratMB().getContrat());
			
			//avenant
			String idAven = getIdGenerateur().getIdNewAvenant(getContratMB().getContrat().getNumPolice());
			getContratMB().getAvenant().setNumAvenant(idAven);
			short d = (short) (getContratMB().getDuree()* 30);
			int mail = 1;
			getContratMB().getAvenant().setDateAvenant(getContratMB().getdateAvenant());
			getContratMB().getAvenant().setEffet(getContratMB().getEffet());
			getContratMB().getAvenant().setDateEmission(getContratMB().getEmission());
			getContratMB().getAvenant().setMouvement(getContratMB().getMouvement());
			getContratMB().getAvenant().setEcheance(getContratMB().getEcheance());
			getContratMB().getAvenant().setContrat(getContratMB().getContrat());
			getContratMB().getAvenant().setUtilisateur(getContratMB().getUtilisateur());
			//getContratMB().getObjectService().addObject(getContratMB().getAvenant());
			
			getManagedQuittanceAuto().setQuittanceid(
			getIdGenerateur().getIdQuittance(idAven));
			
			try {
				// System.out.println("********Exercice dans add Contrat  Chiffre d'affaire= "+getExercice().getChiffreAffExo()+
				// " Prime Exo = "+getExercice().getPrimeExercice()+" Prime Repporter = "+getExercice().getPrimeAReporterExo()+
				// " Prec = "+getExercice().getPrecExo());
				String idQuitt = "";
				idQuitt = getManagedQuittanceAuto().getQuittanceid();
				// MAJ des champs de l'Exercice
				 getExercice().getChiffreAffExo().add(getManagedQuittanceAuto().getQuittanceAuto().getPrimeTotale());
				double CA = getExercice().getChiffreAffExo().doubleValue()
						+ getManagedQuittanceAuto().getQuittanceAuto()
								.getPrimeTotale().doubleValue();
				double PE = getExercice().getPrimeExercice().doubleValue()
						+ getManagedQuittanceAuto().getQuittanceAuto()
								.getPrimeExoEncours().doubleValue();
				double PR = getExercice().getPrimeAReporterExo().doubleValue()
						+ getManagedQuittanceAuto().getQuittanceAuto()
								.getPrimeReport().doubleValue();
				double PREC = getExercice().getPrecExo().doubleValue()
						+ getManagedQuittanceAuto().getQuittanceAuto().getPrec()
								.doubleValue();

				getExercice().setChiffreAffExo(
						BigDecimal.valueOf(CA).setScale(0, BigDecimal.ROUND_UP));
				getExercice().setPrimeExercice(BigDecimal.valueOf(PE));
				getExercice().setPrimeAReporterExo(BigDecimal.valueOf(PR));
				getExercice().setPrecExo(BigDecimal.valueOf(PREC));
				getExercice().setLibelleExercice("" + getExercice().getCodeexercice() + "");
				System.out
						.println("********Quittance dans add Contrat  Chiffre d'affaire= "
								+ getManagedQuittanceAuto().getQuittanceAuto()
										.getPrimeTotale()
								+ " Prime Exo = "
								+ getManagedQuittanceAuto().getQuittanceAuto()
										.getPrimeExoEncours()
								+ " Prime Repporter = "
								+ getManagedQuittanceAuto().getQuittanceAuto()
										.getPrimeReport()
								+ " Prec = "
								+ getManagedQuittanceAuto().getQuittanceAuto()
										.getPrec());

				System.out
						.println("********Exercice dans add Contrat  Chiffre d'affaire= "
								+ getExercice().getChiffreAffExo()
								+ " Prime Exo = "
								+ getExercice().getPrimeExercice()
								+ " Prime Repporter = "
								+ getExercice().getPrimeAReporterExo()
								+ " Prec = "
								+ getExercice().getPrecExo());

				getContratMB().setExercice(getExercice());
				getContratMB().addContrat();
				getContratMB().majExercice();
				getCarteGriseMB().gestionCarteGrise(
						getContratMB().getAvenant());
				getManagedQuittanceAuto().addQuittance(
						getContratMB().getAvenant());
				System.out.println("------->>> Edition  condition particuli�re");// Clean
																					// after
				FacesMessage msg = new FacesMessage(
						"Le Contrat est Enregistr� avec la Quittance " + idQuitt
								+ " !");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				// Edition des pieces
				/*getConditionPartAuto().editerConditionPart(
						idQuitt,
						(HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest(),
						(HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse());*/
				getQuittanceDesignAuto().editerQuittance(
						idQuitt,
						(HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest(),
						(HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse());
			} catch (IOException e) {
				logger.error("Erreur d'�dition de piece", e);
			} catch (Exception e) {
				logger.error(
						"Erreur lors de l'enregistrement du enregistrement du contrat Auto",
						e);
			}

		}

		public String okEtNewContrat() {
			addContrats();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			sessionMap.clear();

			return "/pages/Auto/producteur/AffaireNouvelle?faces-redirect=true";
		}

		public String okContrat() {
			addContrats();
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			sessionMap.clear();

			return "/pages/Auto/producteur/MapPointVente?faces-redirect=true";
		}

		public void testRecord() {
			// addContrats();
			getCarteGriseMB().gestionCarteGrise(
					getContratMB().getAvenant());
		}

		public String getNomclient() {
			try {
				Personne personne = getClientMB().getMaPersonne();

				if (personne.getPhysique()!=null) {
					Physique physique = personne.getPhysique();

					nomclient = physique.getNomRaisonSociale() + " "
							+ physique.getPrenomPers();
				} else {
					if (personne.getMorale()!=null) {
						Morale morale =  personne.getMorale();
						nomclient = morale.getNomRaisonSociale();
					}
				}

			} catch (Exception e) { //
				// log.error("Erreur dans la m�thode getNomclient !", e);
			}

			return nomclient;
		}

		public void setNomclient(String nomclient) {
			this.nomclient = nomclient;
		}

		public String getAdresseclient() {

			try {
				Personne personne = getClientMB().getMaPersonne();

				adresseclient = personne.getAdresse();
			} catch (Exception e) { //
				// log.error("Erreur dans la m�thode getNomclient !", e);
			}

			return adresseclient;
		}

		public void setAdresseclient(String adresseclient) {
			this.adresseclient = adresseclient;
		}


		public CarteGriseMB getCarteGriseMB() {
			return carteGriseMB;
		}

		public void setManagedCarteGrise(CarteGriseMB carteGriseMB) {
			this.carteGriseMB = carteGriseMB;
		}

		public String getSousCategorieV() {
			return sousCategorieV;
		}

		public void setSousCategorieV(String sousCategorieV) {
			this.sousCategorieV = sousCategorieV;
		}

		public Boolean getShowNavBar() {
			return showNavBar;
		}

		public void setShowNavBar(Boolean showNavBar) {
			this.showNavBar = showNavBar;
		}

		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}

		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}

		

		public String getRisque() {
			return risque;
		}

		public void setRisque(String risque) {
			this.risque = risque;
		}

		public ConditionPartAuto getConditionPartAuto() {
			return conditionPartAuto;
		}

		public void setConditionPartAuto(ConditionPartAuto conditionPartAuto) {
			this.conditionPartAuto = conditionPartAuto;
		}

		public QuittanceDesignAuto getQuittanceDesignAuto() {
			return quittanceDesignAuto;
		}

		public void setQuittanceDesignAuto(QuittanceDesignAuto quittanceDesignAuto) {
			this.quittanceDesignAuto = quittanceDesignAuto;
		}

		public Exercice getExercice() {
			return exercice;
		}

		public void setExercice(Exercice exercice) {
			this.exercice = exercice;
		}

		public Conducteur getCduc() {
			return cduc;
		}

		public void setCduc(Conducteur cduc) {
			this.cduc = cduc;
		}

		public void setCarteGriseMB(CarteGriseMB carteGriseMB) {
			this.carteGriseMB = carteGriseMB;
		}

		public ManagedQuittanceAuto getManagedQuittanceAuto() {
			return managedQuittanceAuto;
		}

		public void setManagedQuittanceAuto(ManagedQuittanceAuto managedQuittanceAuto) {
			this.managedQuittanceAuto = managedQuittanceAuto;
		}

		public GarantieMB getGarantieMB() {
			return garantieMB;
		}

		public void setGarantieMB(GarantieMB garantieMB) {
			this.garantieMB = garantieMB;
		}

		public ContratMB getContratMB() {
			return contratMB;
		}

		public void setContratMB(ContratMB contratMB) {
			this.contratMB = contratMB;
		}

		public ClientMB getClientMB() {
			return clientMB;
		}

		public void setClientMB(ClientMB clientMB) {
			this.clientMB = clientMB;
		}

		

	}

	
	
	

