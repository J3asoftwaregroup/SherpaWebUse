package com.j3a.sherpawebuser.view.Auto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

import com.j3a.sherpawebuser.controller.ObjectService;
import com.j3a.sherpawebuser.dbEntityClasses.ApporteurVehicule;
import com.j3a.sherpawebuser.dbEntityClasses.ApporteurVehiculePK;
import com.j3a.sherpawebuser.dbEntityClasses.Avenant;
import com.j3a.sherpawebuser.dbEntityClasses.ConduireVehicule;
import com.j3a.sherpawebuser.dbEntityClasses.ConduireVehiculePK;
import com.j3a.sherpawebuser.dbEntityClasses.Contrat;
import com.j3a.sherpawebuser.dbEntityClasses.Garantie;
import com.j3a.sherpawebuser.dbEntityClasses.GarantieChoisie;
import com.j3a.sherpawebuser.dbEntityClasses.GarantieGarantieChoisie;
import com.j3a.sherpawebuser.dbEntityClasses.GarantieGarantieChoisiePK;
import com.j3a.sherpawebuser.dbEntityClasses.HistoMouvement;
import com.j3a.sherpawebuser.dbEntityClasses.HistoProprietesVehicule;
import com.j3a.sherpawebuser.dbEntityClasses.Vehicule;
import com.j3a.sherpawebuser.dbEntityClasses.VehiculeZoneGeographique;
import com.j3a.sherpawebuser.dbEntityClasses.VehiculeZoneGeographiquePK;
import com.j3a.sherpawebuser.dbEntityClasses.VehiculesAssures;
import com.j3a.sherpawebuser.utilitaire.Garanties;
import com.j3a.sherpawebuser.utilitaire.HistoProprietesVehiTool;
import com.j3a.sherpawebuser.dbEntityClasses.Conducteur;
import com.j3a.sherpawebuser.dbEntityClasses.SousCatVehicule;
import com.j3a.sherpawebuser.dbEntityClasses.Ville;
import com.j3a.sherpawebuser.entityClassesSessionBeans.VilleFacade;
import com.j3a.sherpawebuser.utilitaire.VehiculeRow;
import com.j3a.sherpawebuser.view.IdGenerateur;

/**
 *
 * @author J3A-Herve
 */
@Named
@RequestScoped
public class CarteGriseMB implements Serializable {
		private static final long serialVersionUID = 1L;
		@EJB
		private VilleFacade villeFacade;
		@Inject
		private ObjectService objectService;
		@Inject
		private IdGenerateur idGenerateur;
		// private static Logger logs=Logger.getLogger(ManagedCarteGrise.class);
		private VehiculeRow slctdVehiRw = new VehiculeRow();
		private VehiculeRow slctdVehiRwTb = new VehiculeRow();
		private String warnMsg;
		private List<SousCatVehicule> scategList;
		private Ville slctdville;
		private List<Ville> villeList;
		private List<VehiculeRow> vehiculeList = new ArrayList<VehiculeRow>();
		private Boolean editGarEtat = true;
		private Boolean validVehiEtat = true;
		private Conducteur cduc;
		private Conducteur conduHab = new Conducteur();
		private InputText inputPf;
		private InputText inputPr;
		private InputText inputPlcCab;
		private InputText inputPlcHcab;
		private InputText inputPoidV;
		private InputText inputCu;
		private InputText inputValNeuv;
		private InputText inputValVen;
		private InputText inputPlace;
		private Boolean buttonSavVehicule = true;
		private Boolean buttonAddVehicule;
		private Boolean buttonDelVehicule = true;
		private Boolean buttonEditGar = true;
		private Boolean buttonPropVehicule;
        private String libelleRisque, renouvellement, remorque ="non";
		
		//Logger logs = Logger.getLogger(CarteGriseMB.class);
		/*@PostConstruct
		public void postConstuct(){
			System.out.println("Testte BD EJB"+ villeFacade.findAll().size());
			for(Ville v:villeFacade.findAll()){
				System.out.println("Testte BD EJB"+ v.getLibelleVille());	
			}
			
		}*/
		public void gestionCarteGrise(Avenant Avn) {

			try {
				Date date = new Date();
				date = Calendar.getInstance().getTime();

				VehiculesAssures vehiAss = new VehiculesAssures();
				vehiAss.setIdVehiculesAssures(getIdGenerateur().getIdVehiAss(Avn.getNumPolice()));
				Vehicule vehi = new Vehicule();

				if (Avn.getMouvement().equalsIgnoreCase("AFFAIRE NOUVELLE")) {
					Avn.setIdVehiculesAssures(vehiAss);
					getObjectService().getVehiculesAssuresFacade().edit(vehiAss);
				}

				getObjectService().getAvenantFacade().edit(Avn);

				// int numOrdV=Avn.getIdVehiculesAssures().getVehicules().size()+1;
				int numOrdV = 1;
				int sizeVehicules = getVehiculeList().size();
				for (VehiculeRow F : getVehiculeList()) {

					HistoProprietesVehicule histoPropVehi = new HistoProprietesVehicule();

					HistoMouvement histoMouvement = new HistoMouvement();

					VehiculeZoneGeographique VehiZoneGeo = new VehiculeZoneGeographique();
					VehiculeZoneGeographiquePK VehiZoneGeoPK = new VehiculeZoneGeographiquePK();

					ConduireVehicule conduirVehi = new ConduireVehicule();
					ConduireVehiculePK conduirVehiPK = new ConduireVehiculePK();

					ApporteurVehicule ApporteurVehi = new ApporteurVehicule();
					ApporteurVehiculePK ApporteurVehiPK = new ApporteurVehiculePK();

					// on enregistre ici
					String numOrdVSt = String.format("%02d", numOrdV);

					vehi = F.getVehi();
					// vehi.setId(vehiAss.getId() + "-V" + numOrdVSt);
					vehi.setCodeVehicule(getIdGenerateur().getIdVehicule(Avn.getNumPolice()));
					vehi.setIdVehiculesAssures(vehiAss);
					vehi.setNumImmat(vehi.getNumImmat().toUpperCase());
					vehi.setNumImmatPrec(vehi.getNumImmatPrec().toUpperCase());
					
					numOrdV++;
					vehi.setCodeSousCatVehicule(F.getSouCatVehi());
					if (sizeVehicules == 1) {
						vehi.setStatut("actif");

					} else {
						vehi.setStatut("actif");
					}

					VehiZoneGeoPK.setCodeVehicule(vehi.getCodeVehicule());
					VehiZoneGeoPK.setCodeZoneGeo(F.getZonGeo().getCodeZoneGeo());

					VehiZoneGeo.setVehiculeZoneGeographiquePK(VehiZoneGeoPK);
					VehiZoneGeo.setDateRouler(date);

					histoPropVehi.setCodeHistoVehicule(getIdGenerateur().getIdHistoPropVehi(
							vehi.getCodeVehicule()));
					HistoProprietesVehiTool.setProperties(histoPropVehi, vehi);
					histoPropVehi.setCodeVehicule(vehi);
					histoPropVehi.setDateHisto(date);

					histoMouvement.setCodeHistoMouvement(getIdGenerateur().getIdHistoMvmt(vehi));
					histoMouvement.setCodeVehicule(vehi);
					histoMouvement.setDateHistoMouvement(Calendar.getInstance()
							.getTime());
					histoMouvement.setIdAvenant(Avn.getNumAvenant());
					histoMouvement.setLibelleHistoMouvement(Avn.getMouvement());

					conduirVehiPK.setCodeVehicule(vehi.getCodeVehicule());
					conduirVehiPK.setNumCond(F.getConduHab().getNumCond());

					conduirVehi.setConduireVehiculePK(conduirVehiPK);
					conduirVehi.setDateConduite(date);

					ApporteurVehiPK.setCodeVehicule(vehi.getCodeVehicule());
					ApporteurVehiPK.setCodeApporteur(F.getApporteur().getCodeApporteur());

					ApporteurVehi.setApporteurVehiculePK(ApporteurVehiPK);
					ApporteurVehi.setDateApporteurVehicule(date);
					ApporteurVehi
							.setMontantComApporteur(F.getCommissionApporteur());
					ApporteurVehi.setTauxComApporteur(F
							.getTauxCommissionApporteur());
					// conduirVehi.setDateConduite(date);

					// recup de l'id du vehicule
					getObjectService().getVehiculeFacade().create(vehi);
					getObjectService().getVehiculeZoneGeographiqueFacade().create(VehiZoneGeo);
					getObjectService().getApporteurVehiculeFacade().create(ApporteurVehi);

					getObjectService().getHistoProprietesVehiculeFacade().create(histoPropVehi);
					getObjectService().getHistoMouvementFacade().create(histoMouvement);
					// add Cond habituel
					cduc = (Conducteur) getObjectService().getConducteurFacade().find(
							F.getConduHab().getNumCond());
					if (cduc == null) {
						getObjectService().getConducteurFacade().create(F.getConduHab());
					} else {
						getObjectService().getConducteurFacade().edit(F.getConduHab());
					}

					getObjectService().getConduireVehiculeFacade().create(conduirVehi);

					Vehicule V = new Vehicule();

					int index = getObjectService().getVehiculeFacade().findAll()
							.lastIndexOf(vehi);
					V = (Vehicule) getObjectService().getVehiculeFacade().findAll().get(
							index);

					System.out.println("index du vehicule:::::::::::" + index);
					System.out.println("id du dernier vehicule:::::::::::"
							+ V.getCodeVehicule());
					// int v1 = V.getId();

					// add Garanties
					GarantieChoisie garchoi = new GarantieChoisie();

					garchoi.setCodeGarantieChoisie(vehi.getCodeVehicule() + "GA");
					garchoi.setDateGarantieChoisie(date);
					garchoi.setCodeVehicule(F.getVehi());
					garchoi.setLibelleGarantieChosie("Garanties Automobile");
					garchoi.setCodeAvenantAuto(Avn.getNumAvenant());

					// Garantie Garantie choisie

					List<GarantieGarantieChoisie> garantieGarantieChoisieList = new ArrayList<GarantieGarantieChoisie>();

					for (Garanties G : F.getListegaranties()) {

						// on calcul la prime

						Garantie gar = new Garantie();
						GarantieGarantieChoisie garantieGarantieChoisie = new GarantieGarantieChoisie();
						GarantieGarantieChoisiePK garantieGarantieChoisiePK = new GarantieGarantieChoisiePK();

						gar.setCodeGarantie(G.getCodeGarantie());
						garantieGarantieChoisiePK.setCodeGarantie(gar.getCodeGarantie());
						garantieGarantieChoisiePK.setCodeGarantieChoisie(garchoi.getCodeGarantieChoisie());

						garantieGarantieChoisie.setGarantieGarantieChoisiePK(garantieGarantieChoisiePK);

						garantieGarantieChoisie
								.setDateGarantieGarantieChoisie(date);
						garantieGarantieChoisie.setPrimeAnnuelle(G
								.getPrimesAnnuelle());
						garantieGarantieChoisie.setPrimeNetteAnnuelle(G
								.getPrimesNetteAnnuelle());
						garantieGarantieChoisie.setPrimeNetteProrata(G
								.getPrimesProrata());
						garantieGarantieChoisie.setMontantReduction(G
								.getReductions());

						garantieGarantieChoisie.setAutreReduction(BigDecimal.ZERO);
						garantieGarantieChoisie.setBonus(G.getBonus());
						garantieGarantieChoisie.setMalus(G.getMalus());
						garantieGarantieChoisie.setReductionFlotte(BigDecimal.ZERO);
						garantieGarantieChoisie.setReductionPermis(BigDecimal.ZERO);
						garantieGarantieChoisie
								.setTauxAutreReduction(BigDecimal.ZERO);
						garantieGarantieChoisie.setTauxBonus(G.getBonus());
						garantieGarantieChoisie.setTauxMalus(G.getMalus());
						garantieGarantieChoisie.setTauxFlotte(BigDecimal.ZERO);
						garantieGarantieChoisie.setTauxPermis(BigDecimal.ZERO);

						// on ajoute l'ensemble dans la liste des garantiesChoisies
						garantieGarantieChoisieList.add(garantieGarantieChoisie);

					}

					// Calcul du montant de la prime de la somme des garanties pour
					// garantie choiosie
					BigDecimal prime = BigDecimal.ZERO, primeAnnuelle = BigDecimal.ZERO, primeNetteAnnuelle = BigDecimal.ZERO, red = BigDecimal.ZERO, com = BigDecimal.ZERO, ges = BigDecimal.ZERO, con = BigDecimal.ZERO, interm = BigDecimal.ZERO, taxe = BigDecimal.ZERO, coass;
					for (GarantieGarantieChoisie GC : garantieGarantieChoisieList) {
						prime = prime.add(GC.getPrimeNetteProrata());
						primeAnnuelle = primeAnnuelle.add(GC.getPrimeAnnuelle());
						primeNetteAnnuelle = primeNetteAnnuelle.add(GC
								.getPrimeNetteAnnuelle());
						red = red.add(GC.getMontantReduction());
						/*
						 * com =
						 * com.add(GC.getTauxCom().multiply(prime).divide(BigDecimal
						 * .valueOf(100))); con =
						 * con.add(GC.getTauxConsIa().multiply
						 * (prime).divide(BigDecimal.valueOf(100))); interm =
						 * interm.
						 * add(GC.getTauxintermIa().multiply(prime).divide(BigDecimal
						 * .valueOf(100))); ges =
						 * ges.add(GC.getTauxGesIa().multiply(
						 * prime).divide(BigDecimal.valueOf(100)));
						 */
						// coass = coass+GT.getT*prime/100;
						taxe = taxe.add(prime.divide(BigDecimal.valueOf(0.03), 2));
					}
					garchoi.setPrimeNetteProrata(prime);
					garchoi.setPrimeNetteAnnuelle(primeAnnuelle);
					garchoi.setPrimeAnnuelle(primeNetteAnnuelle);
					garchoi.setCodeAvenantAuto(Avn.getNumAvenant());

					garchoi.setBonus(BigDecimal.ZERO);
					garchoi.setMalus(BigDecimal.ZERO);
					garchoi.setReductionSocioProf(BigDecimal.ZERO);
					garchoi.setReductionPermis(BigDecimal.ZERO);
					garchoi.setReductionCommercial(BigDecimal.ZERO);
					garchoi.setAutre(BigDecimal.ZERO);
					garchoi.setMontantReduction(BigDecimal.ZERO);

					garchoi.setAccessoireauto(BigDecimal.ZERO);
					// garchoi.setMontantGarantieIa(G.getMontantGarantie());
					// garchoi.setTaux(new Float(G.getTaux()));
					// Ajout taux de la franchise

					// ajout de garantie choisie
					try {
						getObjectService().getGarantieChoisieFacade().create(garchoi);
					} catch (Exception e) {
						//logs.error("Error add GarantieChoisieAuto", e);
					}

					// ajout de garantie garantie choisie
					for (GarantieGarantieChoisie GC : garantieGarantieChoisieList) {

						try {
							getObjectService().getGarantieGarantieChoisieFacade().create(GC);
						} catch (Exception e) {
						//	logs.error("Error add GarantieGarantieChoisieAuto", e);
						}
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//setWarnMsg("pbe à l'enregistrement des véhicules et leurs garanties <br/> <<"
				//		+ e.getMessage() + ">>");
				RequestContext.getCurrentInstance().execute("NoSlctd.show()");

			}
		}

		public void testidVehicule() {
			Contrat c = new Contrat();
			// 001KA1015AUT010
			c.setNumPolice("001KA1015AUT012");
			String idVehicule = getIdGenerateur().getIdVehicule(c);
			System.out.println("id du vehicule:::::::::::" + idVehicule);
			int idv = new BigDecimal(idVehicule.substring(17)).intValue();
			System.out.println("id du vehicule en int:::::::::::" + idv);
		}

		public void addRenouvellementAuto(Avenant Avn) {
			Date date = new Date();
			date = Calendar.getInstance().getTime();

			Avenant avn = new Avenant();
			avn.setCodeUtilisateur(Avn.getCodeUtilisateur());
			avn.setDateAvenant(date);
			avn.setDateEmission(Avn.getDateEmission());
			avn.setDuree(Avn.getDuree());
			avn.setEcheance(Avn.getEcheance());
			avn.setEffet(Avn.getEffet());
			avn.setNumAvenant(Avn.getNumAvenant());
			avn.setMouvement("Renouvellement");
			avn.setNumPolice(Avn.getNumPolice());
			avn.setObservation(Avn.getObservation());
			avn.setResiliation(Avn.getResiliation());
			avn.setIdVehiculesAssures(Avn.getIdVehiculesAssures());

			try {
				// Date date = new Date();
				// date = Calendar.getInstance().getTime();

				// VehiculesAssures vehiAss = new VehiculesAssures();
				/*
				 * vehiAss.setId(getIdGenerateur().getIdVehiAss(avn));
				 * avn.setIdVehiculesAssures(vehiAss);
				 */
				// Vehicule vehi = new Vehicule();

				getObjectService().getAvenantFacade().create(avn);
				// getObjectService().addObject(vehiAss);
				// gestion des vehicules pour l'enregistrement dans la base de
				// donnée

				int sizeVehicules = getVehiculeList().size();
				for (VehiculeRow F : getVehiculeList()) {
					Vehicule vehi = new Vehicule();
					HistoProprietesVehicule histoPropVehi = new HistoProprietesVehicule();
					HistoMouvement histoMouvement = new HistoMouvement();
					vehi = F.getVehi();
					// ajout du vehicule ds la BD s'il n'existe pas
					if (F.getStatutVehiculeBD() == false) {

						vehi.setCodeSousCatVehicule(F.getSouCatVehi());
						vehi.setCodeVehicule(getIdGenerateur().getIdVehicule(
								avn.getNumPolice()));
						vehi.setIdVehiculesAssures(avn.getIdVehiculesAssures());
						VehiculeZoneGeographique VehiZoneGeo = new VehiculeZoneGeographique();
						VehiculeZoneGeographiquePK VehiZoneGeoPK = new VehiculeZoneGeographiquePK();

						ConduireVehicule conduirVehi = new ConduireVehicule();
						ConduireVehiculePK conduirVehiPK = new ConduireVehiculePK();

						ApporteurVehicule ApporteurVehi = new ApporteurVehicule();
						ApporteurVehiculePK ApporteurVehiPK = new ApporteurVehiculePK();

						// on enregistre ici

						if (sizeVehicules == 1) {
							vehi.setStatut("actif");

						} else {
							vehi.setStatut("actif");
						}

						VehiZoneGeoPK.setCodeVehicule(vehi.getCodeVehicule());
						VehiZoneGeoPK.setCodeZoneGeo(F.getZonGeo().getCodeZoneGeo());

						VehiZoneGeo.setVehiculeZoneGeographiquePK(VehiZoneGeoPK);
						VehiZoneGeo.setDateRouler(date);

						conduirVehiPK.setCodeVehicule(vehi.getCodeVehicule());
						conduirVehiPK.setNumCond(F.getConduHab().getNumCond());

						conduirVehi.setConduireVehiculePK(conduirVehiPK);

						ApporteurVehiPK.setCodeVehicule(vehi.getCodeVehicule());
						ApporteurVehiPK.setCodeApporteur(F.getApporteur().getCodeApporteur());

						ApporteurVehi.setApporteurVehiculePK(ApporteurVehiPK);
						ApporteurVehi.setDateApporteurVehicule(date);
						ApporteurVehi
								.setMontantComApporteur(F.getCommissionApporteur()
										.add(F.getTauxCommissionApporteur()
												.multiply(F.getPrimeNette())
												.divide(BigDecimal.valueOf(100.0))));
						ApporteurVehi.setTauxComApporteur(F
								.getTauxCommissionApporteur());
						// conduirVehi.setDateConduite(date);

						// recup de l'id du vehicule

						getObjectService().getVehiculeFacade().create(vehi);
						getObjectService().getVehiculeZoneGeographiqueFacade().create(VehiZoneGeo);
						getObjectService().getApporteurVehiculeFacade().create(ApporteurVehi);

						// add Cond habituel
						cduc = (Conducteur) getObjectService().getConducteurFacade().find(
								F.getConduHab().getNumCond());
						if (cduc == null) {
							getObjectService().getConducteurFacade().create(F.getConduHab());
						} else {
							getObjectService().getConducteurFacade().edit(F.getConduHab());
						}

						getObjectService().getConduireVehiculeFacade().create(conduirVehi);

						// int v1 = V.getId();
					}
					// ajout des infos supplementaires du vehicule

					histoMouvement.setCodeHistoMouvement(getIdGenerateur().getIdHistoMvmt(vehi));
					histoMouvement.setCodeVehicule(vehi);
					histoMouvement.setDateHistoMouvement(Calendar.getInstance()
							.getTime());
					histoMouvement.setIdAvenant(avn.getNumAvenant());
					histoMouvement.setLibelleHistoMouvement(avn.getMouvement());
					histoPropVehi.setCodeHistoVehicule(getIdGenerateur().getIdHistoPropVehi(
							vehi.getCodeVehicule()));
					HistoProprietesVehiTool.setProperties(histoPropVehi, vehi);
					histoPropVehi.setCodeVehicule(vehi);
					histoPropVehi.setDateHisto(date);

					getObjectService().getHistoProprietesVehiculeFacade().create(histoPropVehi);
					getObjectService().getHistoMouvementFacade().create(histoMouvement);

					// add Garanties
					GarantieChoisie garchoi = new GarantieChoisie();

					String idGarchoi = getIdGenerateur().getIdGarChoisieAuto(
							F.getVehi());
					garchoi.setCodeGarantieChoisie(idGarchoi);
					garchoi.setDateGarantieChoisie(date);
					garchoi.setCodeVehicule(F.getVehi());
					garchoi.setLibelleGarantieChosie("Garanties Automobile");
					garchoi.setCodeAvenantAuto(Avn.getNumAvenant());

					// Garantie Garantie choisie

					List<GarantieGarantieChoisie> garantieGarantieChoisieList = new ArrayList<GarantieGarantieChoisie>();

					for (Garanties G : F.getListegaranties()) {

						// on calcul la prime

						Garantie gar = new Garantie();
						GarantieGarantieChoisie garantieGarantieChoisie = new GarantieGarantieChoisie();
						GarantieGarantieChoisiePK garantieGarantieChoisiePK = new GarantieGarantieChoisiePK();

						gar.setCodeGarantie(G.getCodeGarantie());
						garantieGarantieChoisiePK.setCodeGarantie(gar.getCodeGarantie());
						garantieGarantieChoisiePK.setCodeGarantieChoisie(garchoi.getCodeGarantieChoisie());

						garantieGarantieChoisie.setGarantieGarantieChoisiePK(garantieGarantieChoisiePK);

						garantieGarantieChoisie
								.setDateGarantieGarantieChoisie(date);
						garantieGarantieChoisie.setPrimeAnnuelle(G
								.getPrimesAnnuelle());
						garantieGarantieChoisie.setPrimeNetteAnnuelle(G
								.getPrimesNetteAnnuelle());
						garantieGarantieChoisie.setPrimeNetteProrata(G
								.getPrimesProrata());
						garantieGarantieChoisie.setMontantReduction(G
								.getReductions());

						garantieGarantieChoisie.setAutreReduction(BigDecimal.ZERO);
						garantieGarantieChoisie.setBonus(G.getBonus());
						garantieGarantieChoisie.setMalus(G.getMalus());
						garantieGarantieChoisie.setReductionFlotte(BigDecimal.ZERO);
						garantieGarantieChoisie.setReductionPermis(BigDecimal.ZERO);
						garantieGarantieChoisie
								.setTauxAutreReduction(BigDecimal.ZERO);
						garantieGarantieChoisie.setTauxBonus(G.getBonus());
						garantieGarantieChoisie.setTauxMalus(G.getMalus());
						garantieGarantieChoisie.setTauxFlotte(BigDecimal.ZERO);
						garantieGarantieChoisie.setTauxPermis(BigDecimal.ZERO);

						// on ajoute l'ensemble dans la liste des garantiesChoisies
						garantieGarantieChoisieList.add(garantieGarantieChoisie);

					}

					// Calcul du montant de la prime de la somme des garanties pour
					// garantie choiosie
					BigDecimal prime = BigDecimal.ZERO, primeAnnuelle = BigDecimal.ZERO, primeNetteAnnuelle = BigDecimal.ZERO, red = BigDecimal.ZERO, com = BigDecimal.ZERO, ges = BigDecimal.ZERO, con = BigDecimal.ZERO, interm = BigDecimal.ZERO, taxe = BigDecimal.ZERO, coass;
					for (GarantieGarantieChoisie GC : garantieGarantieChoisieList) {
						prime = prime.add(GC.getPrimeNetteProrata());
						primeAnnuelle = primeAnnuelle.add(GC.getPrimeAnnuelle());
						primeNetteAnnuelle = primeNetteAnnuelle.add(GC
								.getPrimeNetteAnnuelle());
						red = red.add(GC.getMontantReduction());
						/*
						 * com =
						 * com.add(GC.getTauxCom().multiply(prime).divide(BigDecimal
						 * .valueOf(100))); con =
						 * con.add(GC.getTauxConsIa().multiply
						 * (prime).divide(BigDecimal.valueOf(100))); interm =
						 * interm.
						 * add(GC.getTauxintermIa().multiply(prime).divide(BigDecimal
						 * .valueOf(100))); ges =
						 * ges.add(GC.getTauxGesIa().multiply(
						 * prime).divide(BigDecimal.valueOf(100)));
						 */
						// coass = coass+GT.getT*prime/100;
						taxe = taxe.add(prime.divide(BigDecimal.valueOf(0.03), 2));
					}
					garchoi.setPrimeNetteProrata(prime);
					garchoi.setPrimeNetteAnnuelle(primeAnnuelle);
					garchoi.setPrimeAnnuelle(primeNetteAnnuelle);
					garchoi.setCodeAvenantAuto(Avn.getNumAvenant());

					garchoi.setBonus(BigDecimal.ZERO);
					garchoi.setMalus(BigDecimal.ZERO);
					garchoi.setReductionSocioProf(BigDecimal.ZERO);
					garchoi.setReductionPermis(BigDecimal.ZERO);
					garchoi.setReductionCommercial(BigDecimal.ZERO);
					garchoi.setAutre(BigDecimal.ZERO);
					garchoi.setMontantReduction(BigDecimal.ZERO);

					garchoi.setAccessoireauto(BigDecimal.ZERO);
					// garchoi.setMontantGarantieIa(G.getMontantGarantie());
					// garchoi.setTaux(new Float(G.getTaux()));
					// Ajout taux de la franchise

					// ajout de garantie choisie
					try {
						getObjectService().getGarantieChoisieFacade().create(garchoi);
					} catch (Exception e) {
						//logs.error("Error add GarantieChoisieAuto", e);
					}

					// ajout de garantie garantie choisie
					for (GarantieGarantieChoisie GC : garantieGarantieChoisieList) {

						try {
							getObjectService().getGarantieGarantieChoisieFacade().create(GC);
						} catch (Exception e) {
							//logs.error("Error add GarantieGarantieChoisieAuto", e);
						}
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				setWarnMsg("pbe à l'enregistrement des véhicules et leurs garanties <br/> <<"
						+ e.getMessage() + ">>");
				RequestContext.getCurrentInstance().execute("NoSlctd.show()");

			}
		}

		public void gestionAvenantModifContrat() {

			Date date = new Date();
			date = Calendar.getInstance().getTime();

			for (VehiculeRow F : getVehiculeList()) {

				Vehicule V = new Vehicule();

				int index = getObjectService().getVehiculeFacade().findAll().lastIndexOf(
						F.getVehi());
				V = (Vehicule) getObjectService().getVehiculeFacade().findAll().get(index);

				System.out.println("index du vehicule:::::::::::" + index);
				System.out.println("id du dernier vehicule:::::::::::" + V.getCodeVehicule());
				// int v1 = V.getId();

				// add Garantiechoisie
				for (int i = 0; i < F.getListGarantieparVehicule().size(); i++) {
					GarantieChoisie garchoi = new GarantieChoisie();
					garchoi = F.getListGarantieparVehicule().get(i)
							.getGarantieChoisie();

					int k = getObjectService().getGarantieChoisieFacade().findAll().size();
					// garchoi.setId(k+1);
					// int v1 = getObjectService().getObjects("Vehicule").size();
					// F.getVehi().setId(v1);
					garchoi.setCodeVehicule(F.getVehi());
					garchoi.setDateGarantieChoisie(date);

					getObjectService().getGarantieChoisieFacade().create(garchoi);

					// enreg de GarantieGarantieChoisie
					for (int j = 0; j < F.getListGarantieparVehicule().get(i)
							.getGarantieGarantieChoisieList().size(); j++) {

						GarantieGarantieChoisie GarantieGarantieChoisie = new GarantieGarantieChoisie();
						GarantieGarantieChoisie = F.getListGarantieparVehicule()
								.get(i).getGarantieGarantieChoisieList().get(j);
						GarantieGarantieChoisie.setGarantieGarantieChoisiePK(F
								.getListGarantieparVehicule().get(i)
								.getGarantieGarantieChoisiePKList().get(j));
						GarantieGarantieChoisie
								.setDateGarantieGarantieChoisie(date);

						getObjectService().getGarantieGarantieChoisieFacade().create(GarantieGarantieChoisie);
					}
				}

			}

			// enregistrement des Garanties

		}

		public void resetManagedCartegrise() {
			slctdVehiRw = new VehiculeRow();
			slctdVehiRwTb = new VehiculeRow();
			warnMsg = "";
			slctdville = null;
			vehiculeList = new ArrayList<VehiculeRow>();
			editGarEtat = true;
			validVehiEtat = true;

		}

		public void onRowSelect() {
			System.out.println("Inside onRow select...........................");
			setSlctdVehiRw(getSlctdVehiRwTb());
			setValidVehiEtat(false);
			setEditGarEtat(false);
			System.out.println("...........................onRow select well done");
			System.out
					.println("...........................souscatvehi ofSlctdVehiEtat"
							+ getSlctdVehiRw().getVehi().getCodeVehicule());
		}

		public void onRowUnSelect() {
			setSlctdVehiRw(new VehiculeRow());
			setValidVehiEtat(false);
		}

		public void ajoutVehicule() {
			int numOrdre = 0;
			numOrdre = getVehiculeList().size() + 1;
			VehiculeRow vehiculeRow = new VehiculeRow();
			vehiculeRow.setConduHab(conduHab);
			setSlctdVehiRw(vehiculeRow);
			getSlctdVehiRw().setNumOrdr(numOrdre);
		}
		

		public String handleflow(FlowEvent event) {
			// Methode lancée lorsque une navigation est faite dans le wizard
			// Fctionnemet on recupère l'ancienne et la nouvelle étape et en fontion
			// de ces données et del la logique métier
			// on contrôle la navigation ds notre cas si la nouvelle étape est la
			// quittance on vérifie que les garanties
			// des véhicules ont été setté si c pas le cas on reste sur lancienne
			// étape et on envoie une boite de dialogue
			// à l'utilisateur pour lui indiquer les véhicules sans garanties
			//logs.info(">>>>/ INSIDE -handleflow-");
			// System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù"+getManagedContrat().getBaremes().getLibelleBareme());
			String oldStep = event.getOldStep();
			String newStep = event.getNewStep();
			String a = newStep;
			// TRAITEMENT POUR LE PASSAGE DE CONTRAT A VEHICULE
			if (newStep.equalsIgnoreCase("ongletVehicule")
					&& oldStep.equalsIgnoreCase("ongletContrat")) {

			}

			// TRAITEMENT POUR LE PASSAGE DE VEHICULE A QUITTANCE
			if (newStep.equalsIgnoreCase("ongletQuittance")
					&& oldStep.equalsIgnoreCase("ongletVehicule")) {

			}
			//logs.info(">>>>/ END -handleflow-");
			return a;
		}

		public void verificationPropV() {
			if (getSlctdVehiRw().getVehi().getNumImmat().equalsIgnoreCase("")) {
				FacesMessage msg = new FacesMessage(
						"Saisir une Immatriculation Valide !");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}

		public void validerProp() {
			System.out.println("---------------------------------Testte BD EJB------------------------------------");
			System.out.println("Testte BD EJB"+ villeFacade.findAll().size());
			for(Ville v:villeFacade.findAll()){
				System.out.println("Testte BD EJB"+ v.getLibelleVille());	
			}
			// setEditGarEtat(false);
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("")
					&& (getSlctdVehiRw().getVehi().getPuissFisc()
							.equals(BigDecimal.ZERO) || getSlctdVehiRw().getVehi()
							.getPuissReelle().equals(BigDecimal.ZERO))
					|| getSlctdVehiRw().getZonGeo().getLibelleZoneGeo()
							.equalsIgnoreCase("")) {

				if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("")) {
					FacesMessage msg = new FacesMessage(
							"Catégorie du vehicule non renseignée");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}

				if (getSlctdVehiRw().getVehi().getPuissFisc()
						.equals(BigDecimal.ZERO)
						&& getSlctdVehiRw().getVehi().getPuissReelle()
								.equals(BigDecimal.ZERO)) {
					FacesMessage msg = new FacesMessage(
							"Choisir une puissance fiscale ou Réelle");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}

				if (getSlctdVehiRw().getZonGeo().getLibelleZoneGeo()
						.equalsIgnoreCase("")) {
					FacesMessage msg = new FacesMessage(
							"Choisir une zone geographique");
					FacesContext.getCurrentInstance().addMessage(null, msg);
				}

			} else {

				System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù"
						+ getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule());
				getSlctdVehiRw().getVehi().setCodeSousCatVehicule(getSlctdVehiRw().getSouCatVehi());
				getSlctdVehiRw().getListeVehicules().clear();
				
				getSlctdVehiRw().getListeVehicules().add(getSlctdVehiRw());
				
				
				
				setButtonAddVehicule(true);
				setButtonEditGar(false);
				RequestContext.getCurrentInstance().execute("editVehicule.hide();");

			}
			System.out.println("NumOrdre de getSlctdVehiRw()=== "+getSlctdVehiRw().getNumOrdr());

		}
		public void modifProp() {
			getSlctdVehiRw().getListegaranties().clear();
		}
		
		
		public void supprimeProp() {
			if (getVehiculeList().contains(getSlctdVehiRw())) {
				getVehiculeList().remove(getSlctdVehiRw());
				ajoutVehicule();
			}else{
				ajoutVehicule();
			}
			//setSlctdVehiRw(new VehiculeRow());
			setButtonEditGar(true);
			setButtonAddVehicule(false);
			setButtonSavVehicule(true);
			setSlctdVehiRwTb(null);	
		}


		public void validerVehicule() {
			if (!getVehiculeList().contains(getSlctdVehiRw())) {
				getSlctdVehiRw().setNumOrdr(getVehiculeList().size() + 1);
				getVehiculeList().add(getSlctdVehiRw());

			}
			//setSlctdVehiRw(new VehiculeRow());
			setButtonEditGar(true);
			setButtonAddVehicule(false);
			setSlctdVehiRwTb(null);
			// System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù"+getManagedContrat().getBaremes());
		}

		public void chxVille() {
			// Methode lancé lorsque le user choisit la ville de circulation du
			// véhicule
			// Fctionnemt lorsque la ville est choisit la methode permet de setter
			// la zone Géo correspondante ds le slctdVehiRw
			//logs.info(">>>>/ INSIDE -chxVille-");
			//logs.info(">>>>/ set de la Zone Geo correspondante à la ville choisit ds SlctdVehiRw");
			getSlctdVehiRw().setZonGeo(getSlctdville().getCodeZoneGeo());
			// System.out.println("ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù"+getManagedContrat().getTypeContrat()+getManagedContrat().getBaremes());
			//logs.info(">>>>/ END -chxVille-");
		}
		
		public void chxNbrTran(){
			short nbrT = 0;
			nbrT = (short) (getSlctdVehiRw().getVehi().getNbrePlaceCab()+getSlctdVehiRw().getVehi().getNbrePlaceHorscab());
			getSlctdVehiRw().getVehi().setNbreTransporte(nbrT);
		}
		public void choixRemorque(){
			if(getRemorque().equalsIgnoreCase("oui")){
				getSlctdVehiRw().getVehi().setRemorque(true);
			}else{
				getSlctdVehiRw().getVehi().setRemorque(false);	
			}
			System.out.println("Statut Remorque :"+getSlctdVehiRw().getVehi().getRemorque());	
		}

		public void chxConducteur() {
			// Methode lancé lorsque le user saisit un numéro de conducteur
			// Fctionnemt lorsque le conducteur est choisi la methode permet de
			// vérifier en BD si un tel conducteur exite
			// Si oui ses valeur st chargées ds les champs
			// Si non le processus continue normalement
			//logs.info(">>>>/ INSIDE -chxConducteur-");
			cduc =  getObjectService().getConducteurFacade().find(getSlctdVehiRw().getConduHab().getNumCond());
			if (cduc != null) {
				getSlctdVehiRw().setConduHab(cduc);
			}
			//logs.info(">>>>/ END -chxConducteur-");
		}

		public void changedateImmat() {
			try {
				getSlctdVehiRw().getVehi().setDateImmatPrec(
						getSlctdVehiRw().getVehi().getDateImmat());
				getSlctdVehiRw().getVehi().setDatePremiereCirc(
						getSlctdVehiRw().getVehi().getDateImmat());
			} catch (Exception e) {

			}

		}

		public void changedateImmatprec() {
			try {

				getSlctdVehiRw().getVehi().setDatePremiereCirc(
						getSlctdVehiRw().getVehi().getDateImmatPrec());
			} catch (Exception e) {

			}

		}

		public void choixSousCat() {

			// default
			inputPr.setDisabled(true);
			inputPf.setDisabled(true);
			inputPlcCab.setDisabled(true);
			inputPlcHcab.setDisabled(true);
			inputPoidV.setDisabled(true);
			inputCu.setDisabled(true);
			inputValNeuv.setDisabled(true);
			inputValVen.setDisabled(true);
			
			inputValNeuv.setRequired(false);
			inputValVen.setRequired(false);
			inputPf.setRequired(false);
			inputPr.setRequired(false);
			inputCu.setRequired(false);

			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT1")||getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT10")) {
				inputPr.setDisabled(true);
				inputPf.setDisabled(false);
				inputPlcCab.setDisabled(false);
				inputPlcHcab.setDisabled(false);
				inputPoidV.setDisabled(true);
				inputCu.setDisabled(true);
				inputValNeuv.setDisabled(false);
				inputValVen.setDisabled(false);


				inputValNeuv.setRequired(true);
				inputValVen.setRequired(true);
				inputPf.setRequired(true);
				inputPr.setRequired(false);
				inputCu.setRequired(false);
			}
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT2")||getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT3")) {
				inputPr.setDisabled(true);
				inputPf.setDisabled(true);
				inputPlcCab.setDisabled(false);
				inputPlcHcab.setDisabled(false);
				inputPoidV.setDisabled(false);
				inputCu.setDisabled(false);
				inputCu.setRequired(true);
				inputValNeuv.setDisabled(true);
				inputValVen.setDisabled(true);
				
				inputValNeuv.setRequired(false);
				inputValVen.setRequired(false);
				inputPf.setRequired(false);
				inputPr.setRequired(false);
				inputCu.setRequired(false);
			}
			/*if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT4")) {
				inputPr.setDisabled(true);
				inputPf.setDisabled(true);
				inputPlcCab.setDisabled(false);
				inputPlcHcab.setDisabled(false);
				inputPoidV.setDisabled(true);
				inputCu.setDisabled(true);
				inputValNeuv.setDisabled(true);
				inputValVen.setDisabled(true);
				
				inputValNeuv.setRequired(false);
				inputValVen.setRequired(false);
				inputPf.setRequired(false);
				inputPr.setRequired(false);
				inputCu.setRequired(false);
			}*/
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT5")) {
				inputPr.setDisabled(false);
				inputPf.setDisabled(true);
				inputPlcCab.setDisabled(true);
				inputPlcHcab.setDisabled(true);
				inputPoidV.setDisabled(true);
				inputCu.setDisabled(true);
				inputValNeuv.setDisabled(true);
				inputValVen.setDisabled(true);
				
				inputValNeuv.setRequired(false);
				inputValVen.setRequired(false);
				inputPf.setRequired(false);
				inputPr.setRequired(true);
				inputCu.setRequired(false);
			}
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT6")||getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT9")) {
				
			}
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT7")||getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT8")||
					getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT12")	) {
				inputPr.setDisabled(true);
				inputPf.setDisabled(false);
				inputPlcCab.setDisabled(false);
				inputPlcHcab.setDisabled(false);
				inputPoidV.setDisabled(false);
				inputCu.setDisabled(false);
				inputValNeuv.setDisabled(false);
				inputValVen.setDisabled(false);
				
				inputValNeuv.setRequired(false);
				inputValVen.setRequired(false);
				inputPf.setRequired(false);
				inputPr.setRequired(false);
				inputCu.setRequired(false);
			}
			
			
			if (getSlctdVehiRw().getSouCatVehi().getCodeSousCatVehicule().equalsIgnoreCase("SCAT10")) {
				inputPr.setDisabled(false);
				inputPf.setDisabled(true);
				inputPlcCab.setDisabled(true);
				inputPlcHcab.setDisabled(true);
				inputPoidV.setDisabled(true);
				inputCu.setDisabled(true);
				inputValNeuv.setDisabled(true);
				inputValVen.setDisabled(true);
				
				inputValNeuv.setRequired(false);
				inputValVen.setRequired(false);
				inputPf.setRequired(false);
				inputPr.setRequired(true);
				inputCu.setRequired(false);
			}
		}

		public VehiculeRow getSlctdVehiRw() {
			return slctdVehiRw;
		}

		public void setSlctdVehiRw(VehiculeRow slctdVehiRw) {
			this.slctdVehiRw = slctdVehiRw;
		}

		public VehiculeRow getSlctdVehiRwTb() {
			return slctdVehiRwTb;
		}

		public void setSlctdVehiRwTb(VehiculeRow slctdVehiRwTb) {
			this.slctdVehiRwTb = slctdVehiRwTb;
		}

		public List<SousCatVehicule> getScategList() {
			return scategList;
		}

		public void setScategList(List<SousCatVehicule> scategList) {
			this.scategList = scategList;
		}

		public Ville getSlctdville() {
			return slctdville;
		}

		public void setSlctdville(Ville slctdville) {
			this.slctdville = slctdville;
		}

		public List<Ville> getVilleList() {
			return villeList;
		}

		public void setVilleList(List<Ville> villeList) {
			this.villeList = villeList;
		}

		public List<VehiculeRow> getVehiculeList() {
			return vehiculeList;
		}

		public void setVehiculeList(List<VehiculeRow> vehiculeList) {
			this.vehiculeList = vehiculeList;
		}

		public Boolean getEditGarEtat() {
			return editGarEtat;
		}

		public void setEditGarEtat(Boolean editGarEtat) {
			this.editGarEtat = editGarEtat;
		}

		public Boolean getValidVehiEtat() {
			return validVehiEtat;
		}

		public void setValidVehiEtat(Boolean validVehiEtat) {
			this.validVehiEtat = validVehiEtat;
		}

		public Conducteur getCduc() {
			return cduc;
		}

		public void setCduc(Conducteur cduc) {
			this.cduc = cduc;
		}

		public Conducteur getConduHab() {
			return conduHab;
		}

		public void setConduHab(Conducteur conduHab) {
			this.conduHab = conduHab;
		}

		public InputText getInputPf() {
			return inputPf;
		}

		public void setInputPf(InputText inputPf) {
			this.inputPf = inputPf;
		}

		public InputText getInputPr() {
			return inputPr;
		}

		public void setInputPr(InputText inputPr) {
			this.inputPr = inputPr;
		}

		public InputText getInputPlcCab() {
			return inputPlcCab;
		}

		public void setInputPlcCab(InputText inputPlcCab) {
			this.inputPlcCab = inputPlcCab;
		}

		public InputText getInputPlcHcab() {
			return inputPlcHcab;
		}

		public void setInputPlcHcab(InputText inputPlcHcab) {
			this.inputPlcHcab = inputPlcHcab;
		}

		public InputText getInputPoidV() {
			return inputPoidV;
		}

		public void setInputPoidV(InputText inputPoidV) {
			this.inputPoidV = inputPoidV;
		}

		public InputText getInputCu() {
			return inputCu;
		}

		public void setInputCu(InputText inputCu) {
			this.inputCu = inputCu;
		}

		public InputText getInputValNeuv() {
			return inputValNeuv;
		}

		public void setInputValNeuv(InputText inputValNeuv) {
			this.inputValNeuv = inputValNeuv;
		}

		public InputText getInputValVen() {
			return inputValVen;
		}

		public void setInputValVen(InputText inputValVen) {
			this.inputValVen = inputValVen;
		}

		public InputText getInputPlace() {
			return inputPlace;
		}

		public void setInputPlace(InputText inputPlace) {
			this.inputPlace = inputPlace;
		}

		public Boolean getButtonSavVehicule() {
			return buttonSavVehicule;
		}

		public void setButtonSavVehicule(Boolean buttonSavVehicule) {
			this.buttonSavVehicule = buttonSavVehicule;
		}

		public Boolean getButtonAddVehicule() {
			return buttonAddVehicule;
		}

		public void setButtonAddVehicule(Boolean buttonAddVehicule) {
			this.buttonAddVehicule = buttonAddVehicule;
		}

		public Boolean getButtonDelVehicule() {
			return buttonDelVehicule;
		}

		public void setButtonDelVehicule(Boolean buttonDelVehicule) {
			this.buttonDelVehicule = buttonDelVehicule;
		}

		public Boolean getButtonEditGar() {
			return buttonEditGar;
		}

		public void setButtonEditGar(Boolean buttonEditGar) {
			this.buttonEditGar = buttonEditGar;
		}

		public Boolean getButtonPropVehicule() {
			return buttonPropVehicule;
		}

		public void setButtonPropVehicule(Boolean buttonPropVehicule) {
			this.buttonPropVehicule = buttonPropVehicule;
		}

		public String getLibelleRisque() {
			return libelleRisque;
		}

		public void setLibelleRisque(String libelleRisque) {
			this.libelleRisque = libelleRisque;
		}

		public String getRenouvellement() {
			return renouvellement;
		}

		public void setRenouvellement(String renouvellement) {
			this.renouvellement = renouvellement;
		}

		public String getRemorque() {
			return remorque;
		}

		public void setRemorque(String remorque) {
			this.remorque = remorque;
		}

		public ObjectService getObjectService() {
			return objectService;
		}

		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}

		public String getWarnMsg() {
			return warnMsg;
		}

		public void setWarnMsg(String warnMsg) {
			this.warnMsg = warnMsg;
		}

		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}

		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}


}
