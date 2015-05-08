package com.j3a.assurance.reporting.bean.factory;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.j3a.assurance.model.Attestation;
import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.objetService.ObjectService;

/*creer une collection d'attestation report*/
public class AttestationReportFactory {
	private static Logger logger = Logger.getLogger(AttestationReportFactory.class);
	// Spring inject la propriété
	ObjectService objectService;
	AttestationReport reportField;
	private String idAttestation;
	private SelectInfoAttestation selectInfo;

	public AttestationReport getAttestationReports() {

		try {
			System.out.println("getIdAttestation()"+getIdAttestation());
			// recupère l'attestation
			Attestation attestation = (Attestation) getObjectService()
					.getObjectById(getIdAttestation(), "Attestation");

			// recupère le vehicule lié a l'attestation
			Vehicule vehicule = attestation.getCodeVehicule();

			// recupère les propriétés valides du vehicule
			/*ProprietesVehicule propriete = getSelectInfo().getProprietesValide(
					vehicule.getId());*/

			// renseigne les champs du rapport liées au vehicule
			getReportField().setGenre(vehicule.getGenre());
			getReportField().setMarque(vehicule.getMarque());
			getReportField().setImmatriculation(vehicule.getNumImmat());

			// recuperer les infos liées au contrat
			Avenant avenant = getSelectInfo().getContratLie(getIdAttestation());
			System.out.println("Avenant 2 :" + avenant);
			Contrat contrat = avenant.getNumPolice();
			System.out.println("Verifions le contrat " + contrat);
			Personne personne = contrat.getNumSouscripteur();
			getReportField().setPolice(contrat.getId());

			if (!(getObjectService()
					.getObjectById(personne.getId(), "Physique").equals(null))) {
				Physique physique = (Physique) getObjectService()
						.getObjectById(personne.getId(), "Physique");
			/*	getReportField().setNom(personne.getNomRaisonSocial());*/
				getReportField().setPrenom(physique.getPrenomPers());
				getReportField().setProfession(physique.getProfession());
			} else {
				Morale morale = (Morale) getObjectService().getObjectById(
						personne.getId(), "Physique");
				/*getReportField().setNom(personne.getNomRaisonSocial());*/
			}

			logger.info("conditions particulières générées");
			
			return getReportField();
		} catch (IndexOutOfBoundsException | HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Avenant inexistant");
			//e.printStackTrace();
			logger.error("erreur de génération des conditions particulières");
			return null;
		}
	}

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	public String getIdAttestation() {
		return idAttestation;
	}

	public void setIdAttestation(String idAttestation) {
		this.idAttestation = idAttestation;
	}

	public SelectInfoAttestation getSelectInfo() {
		return selectInfo;
	}

	public void setSelectInfo(SelectInfoAttestation selectInfo) {
		this.selectInfo = selectInfo;
	}

	public AttestationReport getReportField() {
		return reportField;
	}

	public void setReportField(AttestationReport reportField) {
		this.reportField = reportField;
	}
}
