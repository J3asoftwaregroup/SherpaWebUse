package com.j3a.assurance.managedBean.Auto;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
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
import com.j3a.assurance.model.Exercice;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.reporting.design.ConditionPartAuto;
import com.j3a.assurance.reporting.design.QuittanceDesignAuto;
import com.j3a.assurance.utilitaire.IdGenerateur;
import com.j3a.assurance.utilitaire.QuittanceAuto;
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
	    @Autowired
		private QuittanceAuto quittanceAuto;
		private Conducteur cduc;
		private Boolean showNavBar = false;
		private Exercice exercice;
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
			getContratMB().setUtilisateur(getContratMB().utlsateur());
			String pv = getContratMB().getUtilisateur().getCodePointVente()
					.getId();
			String util = getContratMB().getUtilisateur().getId();
			getContratMB().getContrat().setNumPolice(
					getIdGenerateur().getPoliceID(pv, util, "AUT"));
			String idAven = getIdGenerateur().getIdNewAvenant(
					getContratMB().getContrat().getNumPolice());
			getContratMB().getAvenant().setNumAvenant(idAven);
			getContratMB().setDureeEnjour((long) 365);
			getManagedQuittanceAuto().setQuittanceid(
					getIdGenerateur().getIdQuittance(idAven));
			setExercice(getContratMB().getExerciceOuvert()); 
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

			getCarteGriseMB().getConduHab().setDateNaissCond(
					getClientMB().getMaPersonne().getDatePers());
			getCarteGriseMB().getConduHab().setNonCond(
					getClientMB().getMaPersonne().getNomRaisonSociale());
			String lieunaiss = null, prenom = null;
			
			getCarteGriseMB().getConduHab().setPrenomsCond(prenom);
			getCarteGriseMB().getConduHab().setLieuNaisCond(lieunaiss);
			String numpiece = null;
			
			getCarteGriseMB().getConduHab().setNumCond(numpiece);
			getCarteGriseMB().getConduHab().setDureepermiscond((short) 0);
			System.out.println("+++++++Conducteur habituel du Vehicule+++++++"
					+ getCarteGriseMB().getConduHab().getNonCond());

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
			// Methode lanc� lorsque le user saisit un num�ro de conducteur
			// Fctionnemt lorsque le conducteur est choisi la methode permet de
			// v�rifier en BD si un tel conducteur exite
			// Si oui ses valeur st charg�es ds les champs
			// Si non le processus continue normalement
			// logs.info(">>>>/ INSIDE -chxConducteur-");
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
			// logs.info(">>>>/ END -chxConducteur-");
		}

		public void validerGarantie() {
			getGarantieMB().validerGarantie();
			getCarteGriseMB().getSlctdVehiRw().getListegaranties().clear();
	if(!getGarantieMB().getListeGarantiesSelect().isEmpty()){
			getCarteGriseMB().getSlctdVehiRw().getListegaranties()
					.addAll(getGarantieMB().getListeGarantiesSelect());
			getCarteGriseMB().getSlctdVehiRw().setPrimeNette(
					getGarantieMB().getPrimeTotale());
			// calcul de l'accessoire de l'apporteur
			BigDecimal d = BigDecimal.ZERO;
			d = getCarteGriseMB()
					.getSlctdVehiRw()
					.getPrimeNette()
					.multiply(
							getCarteGriseMB().getSlctdVehiRw()
									.getTauxCommissionApporteur())
					.divide(BigDecimal.valueOf(100.0));
			getCarteGriseMB().getSlctdVehiRw().setCommissionApporteur(d);
			getCarteGriseMB().setButtonSavVehicule(false);

			System.out
					.println("<<<<<<<<<Commission de l'apporteur ds vehiculeRow>>>>>>"
							+ getCarteGriseMB().getSlctdVehiRw()
									.getCommissionApporteur());
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

			// TRAITEMENT POUR LE PASSAGE DE CLIENT A CONTRAT

			if (newStep.equalsIgnoreCase("ongletContrat")
					&& oldStep.equalsIgnoreCase("ongletClient")) { // /+Dob
				if (!getClientMB().getStatutRechercheClient()) {
					a = oldStep;
					FacesMessage msg = new FacesMessage(
							"Vous devez Selectionner/Creer un client");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}

			// TRAITEMENT POUR LE PASSAGE DE CONTRAT A VEHICULE
			if (newStep.equalsIgnoreCase("ongletVehicule")
					&& oldStep.equalsIgnoreCase("ongletContrat")) {

				
					getContratMB().getContrat().setSocieteAssurance(
							getContratMB().getSocieteAssurance());
					// getContratMB().getContrat().setId(getContratMB().getId());
				
					getContratMB().getContrat().setPointVente(
							getContratMB().getPointVente());
					getContratMB().getContrat().setPersonne(
							getClientMB().getMaPersonne());
					// getContratMB().getAvenant().setId(
					// getContratMB().getNumAvenant());
					getContratMB().getContrat().setCodeRisque(
							getContratMB().getRisque("1"));
					getContratMB().getAvenant().setCodeUtilisateur(
							getContratMB().getUtilisateur());
					getContratMB().getAvenant().setDuree(
							getContratMB().getDureeEnjour().shortValue());
					getGarantieMB().setCodeRisque("1");
					getContratMB().getAvenant().setEffet(
							getContratMB().getEffet());
					getContratMB().getAvenant().setEcheance(
							getContratMB().getEcheance());
					System.out.println("xxxpersonnexxx"
							+ getContratMB().getContrat().getPersonne()
									.getNumSouscripteur());

					majConducteur();
					getCarteGriseMB().choixSousCat();
				}
			

			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
			if (newStep.equalsIgnoreCase("ongletQuittance")
					&& oldStep.equalsIgnoreCase("ongletVehicule")) {

				if (getCarteGriseMB().getVehiculeList().size() == 0) {
					// on reste sur la page des Engins
					a = oldStep;
					FacesMessage msg = new FacesMessage(
							"Vous devez editer au moins un v�hcule !");
					FacesContext.getCurrentInstance().addMessage(null, msg);

				} else {

					getManagedQuittanceAuto().setDisableaddContrats(true);
					// gestion des apporteur dans la quittance

					getManagedQuittanceAuto().getListVehicules().clear();
					getManagedQuittanceAuto().getListVehicules().addAll(
							getCarteGriseMB().getVehiculeList());
				/*	System.out.println(getCarteGriseMB().getSlctdVehiRw()
							.getConduHab());*/
					System.out.println("********Avenant date Effet = "
							+ getContratMB().getAvenant().getEffet()
							+ " Date Ech�ance = "
							+ getContratMB().getAvenant().getEcheance());

					getManagedQuittanceAuto().setAvenant(
							getContratMB().getAvenant());

					getManagedQuittanceAuto().setExercice(getExercice().getCodeexercice());// A corriger

					System.out
							.println("********Quittance Auto Avenant date Effet = "
									+ getManagedQuittanceAuto().getAvenant()
											.getEffet()
									+ " Date Ech�ance = "
									+ getManagedQuittanceAuto().getAvenant()
											.getEcheance());
					getManagedQuittanceAuto().calculPrime();
					getManagedQuittanceAuto().calculQuittance();

					if (getContratMB().getContrat().getPersonne()
							.getNumSouscripteur().equals(null)) {
						getManagedQuittanceAuto().setDisableaddContrats(false);

					}
					if (getCarteGriseMB().getVehiculeList().size() >= 1) {
						getManagedQuittanceAuto().setDisableaddContrats(false);

					}
				}

			}

			return a;
		}

		public void addContrats() {

			try {
				// System.out.println("********Exercice dans add Contrat  Chiffre d'affaire= "+getExercice().getChiffreAffExo()+
				// " Prime Exo = "+getExercice().getPrimeExercice()+" Prime Repporter = "+getExercice().getPrimeAReporterExo()+
				// " Prec = "+getExercice().getPrecExo());
				String idQuitt = "";
				idQuitt = getManagedQuittanceAuto().getQuittanceid();
				// MAJ des champs de l'Exercice
				// getExercice().getChiffreAffExo().add(getManagedQuittanceAuto().getQuittanceAuto().getPrimeTotale());
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

		public QuittanceAuto getQuittanceAuto() {
			return quittanceAuto;
		}

		public void setQuittanceAuto(
				QuittanceAuto quittanceAuto) {
			this.quittanceAuto = quittanceAuto;
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

	
	
	

