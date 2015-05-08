package com.j3a.assurance.reporting.bean.factory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Garantie;
import com.j3a.assurance.model.GarantieChoisie;
import com.j3a.assurance.model.GarantieGarantieChoisie;
import com.j3a.assurance.model.GarantieGarantieChoisieId;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.Quittance;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.reporting.bean.ContratReport;
import com.j3a.assurance.reporting.bean.PrimeByGarantie;
import com.j3a.assurance.reporting.bean.VehiculeAttributsBean;

/**
 * Classe qui peuple les attributs du bean de gestion de la condition
 * particuli�re {@link ContratReport}
 * 
 * @author N'ZI
 * 
 */
public class ContratReportFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectService objectService;
	private ContratReport contratReport;
	private transient SelectInfoAttestation selectInfoAttestation;
	private boolean etatRech = false;
	private static Logger logger = Logger.getLogger(ContratReportFactory.class);

	public void ContratReportProvider(String idQuittance) throws NullPointerException {

		// recup�re la quittance
		Quittance quittance = (Quittance) getObjectService().getObject(
				idQuittance, "Quittance");
		
		System.out.println("qqqqqqqqqqqqqtrouve"+quittance.getCodeQuittance());
		// renseigne la quittance
		getContratReport().setQuittance(quittance);
		System.out.println("qqqqqqqqqqqqqiiiiiiiiiiiiiiiiii"+quittance.getCodeQuittance());
		// recup�re l'avenant
		Avenant avenant = quittance.getAvenant();
		System.out.println("aaaaaaaaaaaaaaaaaaaaiiiiiiiiiiiiiiiiii"+avenant.getNumAvenant());
		// renseigne l'avenant
		getContratReport().setAvenant(avenant);
		// recup�re le contrat
		Contrat contrat = avenant.getContrat();
		System.out.println("esaitestghhg"+contrat.getNumPolice());
		// renseigne le contrat
		getContratReport().setContrat(contrat);
		// recup�re le souscripteur
		Personne personne = contrat.getPersonne();
		// renseigne le souscripteur
		getContratReport().setPersonne(personne);
		// Donner la nature de la personne
		chargerNaturePersonne();
		// renseigne la propri�t� listVehiculeAttributs
		List<VehiculeAttributsBean> listVehiculeAttributsbean = propertiesProvider(contrat);
	
		
		System.out.println("<<<>>> listeVehiculeattribut size :"
				+ listVehiculeAttributsbean.size());
		getContratReport().setListVehiculeAttributs(listVehiculeAttributsbean);
	}

	/**
	 * methode qui recup�re la liste des vehicules d'un avenant, parcourt la
	 * liste et pour chaque vehicule de cette liste l'encapsule dans la classe
	 * enveloppe @see VehiculeAttributsBean avec ses garanties et ses propri�t�s
	 * 
	 * @param avenant
	 * @return list<VehiculeAttributsBean>
	 */
	public List<VehiculeAttributsBean> propertiesProvider(Contrat contrat) {
		SelectInfoAttestation selectInfo = getSelectInfoAttestation();
		// classe enveloppe
		// encapsule la liste des classe enveloppant le vehicule et ses
		// garanties
		List<VehiculeAttributsBean> listVehiculeAttributsbean = new ArrayList<VehiculeAttributsBean>();
		// encapsule la liste de vehicule
		List<Vehicule> listVehicules = new ArrayList<Vehicule>();

		// recup�re la list des vehicules actifs du contrat
		try {

			listVehicules = selectInfo.getListVehiculesContrat(contrat.getNumPolice());

		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println("Element " + contrat.getNumPolice() + " non trouv�");
			logger.error("erreur de chargement des propri�t� de la C.P");
			e.printStackTrace();
		}

		if (!listVehicules.isEmpty()) {// list non vide
			Iterator<Vehicule> i1 = listVehicules.iterator();

			while (i1.hasNext()) {
				Vehicule vehicule = i1.next();
				VehiculeAttributsBean vehiculeAttributsBean = new VehiculeAttributsBean();
				// associe le v�hicule � la classe enveloppe
				vehiculeAttributsBean.setVehicule(vehicule);
				System.out.println("-----dffffffffffffffffffffffffffffffffdd> Code du vehicule :"
						+ vehicule.getNumImmat());
				// associe la propri�t� du vehicule
				/*
				 * ProprietesVehicule proprietesVehicule = selectInfo
				 * .getProprietesValide(vehicule.getId());
				 * vehiculeAttributsBean.
				 * setProprietesVehicule(proprietesVehicule);
				 */
				// associe la garantieChoisie au vehicule

				GarantieChoisie garantieChoisie = selectInfo
						.getGarantie(vehicule.getNumImmat());
				System.out.println("-----> Code garantieChoisie :"
						+ garantieChoisie.getCodeGarantieChoisie());
				vehiculeAttributsBean.setGarantieChoisie(garantieChoisie);
				// associe la list des primes par garanties du vehicule
				vehiculeAttributsBean
						.setListPrimeGaranties(getPrimeByGarantie(garantieChoisie));
				// peuple la list des classes enveloppes
				listVehiculeAttributsbean.add(vehiculeAttributsBean);

			}

		}

		return listVehiculeAttributsbean;
	}

	/**
	 * methode qui construit l'objet {@link PrimeByGarantie} du vehicule
	 * 
	 * @param garantieChoisie
	 * @return List<PrimeByGarantie>
	 */
	public List<PrimeByGarantie> getPrimeByGarantie(
			GarantieChoisie garantieChoisie) {
		SelectInfoAttestation selectInfo = getSelectInfoAttestation();
		// objet qui recup�re la collection de PrimeByGarantie
		List<PrimeByGarantie> listPrimeGaranties = new ArrayList<PrimeByGarantie>();
		// recup�re la collection de garantie
		Set<Garantie> listGaranties = garantieChoisie.getGaranties();
		// pour chaque garantie de la list
		for (Garantie garantie : listGaranties) {
			GarantieGarantieChoisieId pk = new GarantieGarantieChoisieId();
			PrimeByGarantie primeByGarantie = new PrimeByGarantie();
			// contruire le cl� primaire de GarantieGarantieChoisie
			pk.setCodeGarantieChoisie(garantieChoisie.getCodeGarantieChoisie());
			pk.setCodeGarantie(garantie.getCodeGarantie());
			// recup�re GarantieGarantieChoisie par pk
			GarantieGarantieChoisie choisie = (GarantieGarantieChoisie) getObjectService()
					.getObject(pk, "GarantieGarantieChoisie");
			// GarantieGarantieChoisie choisie =selectInfo.getById(pk);
			System.out.println("GarantieGarantieChoisie :" + choisie);
			// contuire l'objet PrimebyGarantie
			primeByGarantie.setChoisie(choisie);
			primeByGarantie.setGarantie(garantie);
			// ajouter a la list des primeByGarantie
			listPrimeGaranties.add(primeByGarantie);
		}
		return listPrimeGaranties;

	}

	/**
	 * Methode permetant la recherche d'une personne Physique � partir du numero
	 * de souscripteur
	 * 
	 * @param paramNumPersonne
	 * @return
	 */
	public Physique chargerPersPhysique(String paramNumPersonne) {
		etatRech = false;
		Physique unphysique = (Physique) getObjectService().getObject(
				paramNumPersonne, "Personne");
		if (!(unphysique.equals(null))) {
			etatRech = true;
			getContratReport().setPhysique(unphysique);
		}
		return getContratReport().getPhysique();
	}

	/**
	 * Methode permetant la recherche d'une personne Morale � partir du numero
	 * de souscripteur
	 * 
	 * @param paramNumPersonne
	 * @return
	 */
	public Morale chargerMorale(String paramNumPersonne) {
		etatRech = false;
		Morale uneMorale = (Morale) getObjectService().getObject(
				paramNumPersonne, "Morale");
		if (!(uneMorale.equals(null))) {
			etatRech = true;
			getContratReport().setMorale(uneMorale);
		}
		return getContratReport().getMorale();
	}

	public void chargerNaturePersonne() {
		chargerPersPhysique(getContratReport().getPersonne().getNumSouscripteur());
		if (etatRech == false)
			chargerMorale(getContratReport().getPersonne().getNumSouscripteur());
	}

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	public ContratReport getContratReport() {
		return contratReport;
	}

	public void setContratReport(ContratReport contratReport) {
		this.contratReport = contratReport;
	}

	public SelectInfoAttestation getSelectInfoAttestation() {
		return selectInfoAttestation;
	}

	public void setSelectInfoAttestation(
			SelectInfoAttestation selectInfoAttestation) {
		this.selectInfoAttestation = selectInfoAttestation;
	}
}
