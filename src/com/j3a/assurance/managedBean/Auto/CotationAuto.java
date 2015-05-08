package com.j3a.assurance.managedBean.Auto;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		/*private ContratMB contrat;
		private ClientMB client;
		private CarteGriseMB carteGriseMB;
		private QuittanceAuto quittanceAuto;
		private Conducteur cduc;
		private Boolean showNavBar = false;
		private Exercice exercice;
		private ManagedQuittanceAuto managedQuittanceAuto;

		private String nomclient, adresseclient, sousCategorieV, risque;

		@Autowired
		IdGenerateur idGenerateur;
				@Autowired
		ConditionPartAuto conditionPartAuto;
		@Autowired
		private QuittanceDesignAuto quittanceDesignAuto;
*/
	/*	@PostConstruct
		public void postConstru() {
			risque = "Automobile";
			getContrat().setUtilisateur(getContrat().utlsateur());
			String pv = getContrat().getUtilisateur().getCodePointVente()
					.getId();
			String util = getContrat().getUtilisateur().getId();
			getContrat().getContrat().setId(
					getIdGenerateur().getPoliceID(pv, util, "AUT"));
			String idAven = getIdGenerateur().getIdNewAvenant(
					getContrat().getContrat().getId());
			getContrat().getAvenant().setId(idAven);
			getContrat().setDureeEnjour((long) 365);
			getManagedQuittanceAuto().setQuittanceid(
					getIdGenerateur().getIdQuittance(idAven));
			setExercice(getInfoAvenantContrat().exerciceOuvert());
		}*/

		/*public void chxApporteur() {

			getContrat().chxApporteur();
		}

		public void choixSousCat() {
			// recupération du taux de l'apporteur et l'apporteur
			getCarteGriseMB().getSlctdVehiRw().setApporteur(
					getContrat().getCodeApporteur());

			getContrat().getCalculCommission().getTauxCommissionApporteur(
					getCarteGriseMB().getSlctdVehiRw().getApporteur().getId(),
					getCarteGriseMB().getSlctdVehiRw().getSouCatVehi()
							.getCodeCategorie().getId());
			getCarteGriseMB().getSlctdVehiRw().setTauxCommissionApporteur(
					getContrat().getCalculCommission().getTauxCommission());
			getCarteGriseMB().choixSousCat();
		}*/

		// les methodes de choix Avenant Affaire Nouvelle
		public void tabChange() {
			// good
			/*getManagedGarantieAuto().setDuree(getContrat().getDuree());
			getManagedGarantieAuto().getListeGroupGaranties().clear();
			getManagedGarantieAuto().getListegaranties().clear();
			getManagedGarantieAuto().getListegarantieFiltre().clear();
			getManagedGarantieAuto().cleanChamps();
			
			getManagedGarantieAuto().affichegarantiesAuto(
			*/	//	getCarteGriseMB().getSlctdVehiRw());
		}

		/*// methode de validation de la prime
		public void rechercherClient() {
			getClient().rechercherClient();
			if (getClient().getStatutRechercheClient() == true) {
				showNavBar = true;
			}

	//	*///}

		
		
/*
		public void validerPrime() {
			//getManagedGarantieAuto().validerPrime();

			// listGarantieparVehicule
			getCarteGriseMB().getSlctdVehiRw().getListGarantieparVehicule()
					.clear();

			getCarteGriseMB().getSlctdVehiRw().getListegaranties().clear();
			//getCarteGriseMB().getSlctdVehiRw().getListegaranties()
					.addAll(getManagedGarantieAuto().getListegaranties());

			getCarteGriseMB().setValidVehiEtat(false);
		}

		public void majConducteur() {

			getCarteGriseMB().getConduHab().setDateNaissCond(
					getClient().getMaPersonne().getDatePers());
			getCarteGriseMB().getConduHab().setNonCond(
					getClient().getMaPersonne().getNomRaisonSociale());
			String lieunaiss = null, prenom = null;
			
			getCarteGriseMB().getConduHab().setPrenomsCond(prenom);
			getCarteGriseMB().getConduHab().setLieuNaisCond(lieunaiss);
			String numpiece = null;
			
			getCarteGriseMB().getConduHab().setId(numpiece);
			getCarteGriseMB().getConduHab().setDureepermiscond((short) 0);
			System.out.println("+++++++Conducteur habituel du Vehicule+++++++"
					+ getCarteGriseMB().getConduHab().getNonCond());

		}

		

		public void chxConducteur() {
			// Methode lancé lorsque le user saisit un numéro de conducteur
			// Fctionnemt lorsque le conducteur est choisi la methode permet de
			// vérifier en BD si un tel conducteur exite
			// Si oui ses valeur st chargées ds les champs
			// Si non le processus continue normalement
			// logs.info(">>>>/ INSIDE -chxConducteur-");
			if (isClientConduc()) {
				majConducteur();
			} else {
				cduc = (Conducteur) getCarteGriseMB().getObjectService()
						.getObjectById(
								getCarteGriseMB().getSlctdVehiRw()
										.getConduHab().getId(), "Conducteur");
				if (cduc != null) {
					getCarteGriseMB().getSlctdVehiRw().setConduHab(cduc);
				} else {
					getCarteGriseMB().getSlctdVehiRw().setConduHab(
							new Conducteur(getCarteGriseMB().getSlctdVehiRw()
									.getConduHab().getId()));
				}
			}
			// logs.info(">>>>/ END -chxConducteur-");
		}

		public void validerGarantie() {
			getManagedGarantieAuto().validerGarantie();
			getCarteGriseMB().getSlctdVehiRw().getListegaranties().clear();
	if(!getManagedGarantieAuto().getListeGarantiesSelect().isEmpty()){
			getCarteGriseMB().getSlctdVehiRw().getListegaranties()
					.addAll(getManagedGarantieAuto().getListeGarantiesSelect());
			getCarteGriseMB().getSlctdVehiRw().setPrimeNette(
					getManagedGarantieAuto().getPrimeTotale());
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
		}*/

		/*public void validerVehicule() {
			if (!getCarteGriseMB().getVehiculeList().contains(
					getCarteGriseMB().getSlctdVehiRw())) {
				getCarteGriseMB().getSlctdVehiRw().setNumOrdr(
						getCarteGriseMB().getVehiculeList().size() + 1);
				getCarteGriseMB().getVehiculeList().add(
						getCarteGriseMB().getSlctdVehiRw());

			}
			getCarteGriseMB().setSlctdVehiRw(new VehiculeRow());
			//majConducteur();
			getCarteGriseMB().setEditGarEtat(true);
			getCarteGriseMB().setValidVehiEtat(true);
			getCarteGriseMB().setSlctdVehiRwTb(null);
			// System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù"+getManagedContrat().getBaremes());
		}*/

		/*public String handleflow(FlowEvent event) {

			String oldStep = event.getOldStep();
			String newStep = event.getNewStep();
			String a = newStep;

			// TRAITEMENT POUR LE PASSAGE DE CLIENT A CONTRAT

			if (newStep.equalsIgnoreCase("ongletContrat")
					&& oldStep.equalsIgnoreCase("ongletClient")) { // /+Dob
				if (!getClient().getStatutRechercheClient()) {
					a = oldStep;
					FacesMessage msg = new FacesMessage(
							"Vous devez Selectionner/Creer un client");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}
			}

			// TRAITEMENT POUR LE PASSAGE DE CONTRAT A VEHICULE
			if (newStep.equalsIgnoreCase("ongletVehicule")
					&& oldStep.equalsIgnoreCase("ongletContrat")) {

				if (getContrat().getCodeApporteur() == null) {
					a = oldStep;
					FacesMessage msg = new FacesMessage(
							"Vous devez saisir un Apporteur valide");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				} else {
					getContrat().getContrat().setCodeSocieteAssurance(
							getContrat().getSocieteAssurance());
					// getManagedContrat().getContrat().setId(getManagedContrat().getId());
					getContrat().getContrat().setCodeApporteur(
							getContrat().getCodeApporteur());
					getContrat().getContrat().setCodePointVente(
							getContrat().getCodePointVente());
					getContrat().getContrat().setNumSouscripteur(
							getClient().getMaPersonne());
					// getManagedContrat().getAvenant().setId(
					// getManagedContrat().getNumAvenant());
					getContrat().getContrat().setCodeRisque(
							getContrat().getRisq("1"));
					getContrat().getAvenant().setCodeUtilisateur(
							getContrat().getUtilisateur());
					getContrat().getAvenant().setDuree(
							getContrat().getDureeEnjour().shortValue());
					getManagedGarantieAuto().setCodeRisque("1");
					getContrat().getAvenant().setEffet(
							getContrat().getEffet());
					getContrat().getAvenant().setEcheance(
							getManagedContrat().getEcheance());
					System.out.println("xxxpersonnexxx"
							+ getManagedContrat().getContrat().getNumSouscripteur()
									.getId());

					majConducteur();
					getCarteGriseMB().choixSousCat();
		}
			}

			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
			if (newStep.equalsIgnoreCase("ongletQuittance")
					&& oldStep.equalsIgnoreCase("ongletVehicule")) {

				if (getCarteGriseMB().getVehiculeList().size() == 0) {
					// on reste sur la page des Engins
					a = oldStep;
					FacesMessage msg = new FacesMessage(
							"Vous devez editer au moins un véhcule !");
					FacesContext.getCurrentInstance().addMessage(null, msg);

				} else {

					getManagedQuittanceAuto().setDisableaddContrats(true);
					// gestion des apporteur dans la quittance

					getManagedQuittanceAuto().getListVehicules().clear();
					getManagedQuittanceAuto().getListVehicules().addAll(
							getCarteGriseMB().getVehiculeList());
					System.out.println(getCarteGriseMB().getSlctdVehiRw()
							.getConduHab());
					System.out.println("********Avenant date Effet = "
							+ getManagedContrat().getAvenant().getEffet()
							+ " Date Echéance = "
							+ getManagedContrat().getAvenant().getEcheance());

					getManagedQuittanceAuto().setAvenant(
							getManagedContrat().getAvenant());

					getManagedQuittanceAuto().setExercice(getExercice().getId());// A corriger

					System.out
							.println("********Quittance Auto Avenant date Effet = "
									+ getManagedQuittanceAuto().getAvenant()
											.getEffet()
									+ " Date Echéance = "
									+ getManagedQuittanceAuto().getAvenant()
											.getEcheance());
					getManagedQuittanceAuto().calculPrime();
					getManagedQuittanceAuto().calculQuittance();

					if (getManagedContrat().getContrat().getNumSouscripteur()
							.getId().equals(null)) {
						getManagedQuittanceAuto().setDisableaddContrats(false);

					}
					if (getCarteGriseMB().getVehiculeList().size() >= 1) {
						getManagedQuittanceAuto().setDisableaddContrats(false);

					}
				}

			}

			return a;
		}*/

		/*public void addContrats() {

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
				getExercice().setLibelleExercice("" + getExercice().getId() + "");
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

				getManagedContrat().setExercice(getExercice());
				getManagedContrat().addContrat();
				getManagedContrat().majExercice();
				getCarteGriseMB().gestionCarteGrise(
						getManagedContrat().getAvenant());
				getManagedQuittanceAuto().addQuittance(
						getManagedContrat().getAvenant());
				getManagedQuittanceAuto().addcommissionApporteur(getManagedContrat().getCodeApporteur(), getManagedContrat().getAvenant());

				System.out.println("------->>> Edition  condition particulière");// Clean
																					// after
				FacesMessage msg = new FacesMessage(
						"Le Contrat est Enregistré avec la Quittance " + idQuitt
								+ " !");
				FacesContext.getCurrentInstance().addMessage(null, msg);

				// Edition des pieces
				getConditionPartAuto().editerConditionPart(
						idQuitt,
						(HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest(),
						(HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse());
				getQuittanceDesignAuto().editerQuittance(
						idQuitt,
						(HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest(),
						(HttpServletResponse) FacesContext.getCurrentInstance()
								.getExternalContext().getResponse());
			} catch (IOException e) {
				logger.error("Erreur d'édition de piece", e);
			} catch (Exception e) {
				logger.error(
						"Erreur lors de l'enregistrement du enregistrement du contrat Auto",
						e);
			}

		}
*/
	

		

		/*public void setNomclient(String nomclient) {
			this.nomclient = nomclient;
		}

		public String getAdresseclient() {

			try {
				Personne personne = getClient().getMaPersonne();

				adresseclient = personne.getAdresse();
			} catch (Exception e) { //
				// log.error("Erreur dans la méthode getNomclient !", e);
			}

			return adresseclient;
		}

		public void setAdresseclient(String adresseclient) {
			this.adresseclient = adresseclient;
		}

		public ContratMB getContrat() {
			return contrat;
		}

		public void setContrat(ContratMB contrat) {
			this.contrat = contrat;
		}

		public ClientMB getClient() {
			return client;
		}

		public void setClient(ClientMB client) {
			this.client = client;
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

		
*/
	}

	
	
	

