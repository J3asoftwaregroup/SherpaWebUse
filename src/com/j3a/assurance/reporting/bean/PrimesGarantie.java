package com.j3a.assurance.reporting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.j3a.assurance.model.Garantie;
import com.j3a.assurance.model.GarantieChoisie;
import com.j3a.assurance.model.GarantieGarantieChoisie;
import com.j3a.assurance.model.GarantieGarantieChoisieId;
import com.j3a.assurance.objetService.ObjectService;

public class PrimesGarantie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObjectService objectService;
	
	/**
	 * methode qui construit l'objet {@link PrimeByGarantie} du vehicule
	 * 
	 * @param garantieChoisie
	 * @return List<PrimeByGarantie>
	 */
	public List<PrimeByGarantie> getPrimeByGarantie(
			GarantieChoisie garantieChoisie) {
		SelectInfoAttestation selectInfo = getSelectInfoAttestation();
		// objet qui recupère la collection de PrimeByGarantie
		List<PrimeByGarantie> listPrimeGaranties = new ArrayList<PrimeByGarantie>();
		// recupère la collection de garantie
		Set<Garantie> listGaranties = garantieChoisie.getGaranties();
		// pour chaque garantie de la list
		for (Garantie garantie : listGaranties) {
			GarantieGarantieChoisieId pk = new GarantieGarantieChoisieId();
			PrimeByGarantie primeByGarantie = new PrimeByGarantie();
			// contruire la clé primaire de GarantieGarantieChoisie
			pk.setCodeGarantieChoisie(garantieChoisie.getCodeGarantieChoisie());
			pk.setCodeGarantie(garantie.getCodeGarantie());
			// recupère GarantieGarantieChoisie par pk
			//GarantieGarantieChoisie choisie = (GarantieGarantieChoisie) getObjectService()
					//.getObjectById(pk, "GarantieGarantieChoisie");
			 GarantieGarantieChoisie choisie =(GarantieGarantieChoisie)selectInfo.getById(pk);
			System.out.println("id de GarantieGarantieChoisie :" + choisie.getId().getCodeGarantieChoisie());
			System.out.println("prime prorata de GarantieGarantieChoisie :" + choisie.getPrimeAnnuelle());
			// constuire l'objet PrimebyGarantie
			primeByGarantie.setChoisie(choisie);
			primeByGarantie.setGarantie(garantie);
			// ajouter a la list des primeByGarantie
			listPrimeGaranties.add(primeByGarantie);
		}
		return listPrimeGaranties;

	}
	
	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	public SelectInfoAttestation getSelectInfoAttestation() {
		return selectInfoAttestation;
	}

	public void setSelectInfoAttestation(SelectInfoAttestation selectInfoAttestation) {
		this.selectInfoAttestation = selectInfoAttestation;
	}

	
}
