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
	public List<GarantieGarantieChoisie> getPrimeByGarantie(
			GarantieChoisie garantieChoisie) {
		// objet qui recup�re la collection de PrimeByGarantie
		List<GarantieGarantieChoisie> listPrimeGaranties = new ArrayList<GarantieGarantieChoisie>();
		// recup�re la collection de garantie
<<<<<<< HEAD
		Set<GarantieGarantieChoisie> listGarantieGarantieChoisie = garantieChoisie.getGarantieGarantieChoisies();
		for (GarantieGarantieChoisie ggc : listGarantieGarantieChoisie) {
			//GarantieGarantieChoisieId id = new GarantieGarantieChoisieId();
			//PrimeByGarantie primeByGarantie = new PrimeByGarantie();
=======
		Set<Garantie> listGaranties = garantieChoisie.getGaranties();
		// pour chaque garantie de la list
		for (Garantie garantie : listGaranties) {
			GarantieGarantieChoisieId pk = new GarantieGarantieChoisieId();
			PrimeByGarantie primeByGarantie = new PrimeByGarantie();
>>>>>>> branch 'master' of https://github.com/J3asoftwaregroup/SherpaWebUse
			// contruire la cl� primaire de GarantieGarantieChoisie
<<<<<<< HEAD
		//	id.setCodeGarantieChoisie(garantieChoisie.getCodeGarantieChoisie());
			//id.setCodeGarantie(garantie.getCodeGarantie());
=======
			pk.setCodeGarantieChoisie(garantieChoisie.getCodeGarantieChoisie());
			pk.setCodeGarantie(garantie.getCodeGarantie());
>>>>>>> branch 'master' of https://github.com/J3asoftwaregroup/SherpaWebUse
			// recup�re GarantieGarantieChoisie par pk
			//GarantieGarantieChoisie choisie = (GarantieGarantieChoisie) getObjectService()
					//.getObjectById(pk, "GarantieGarantieChoisie");
<<<<<<< HEAD
			// GarantieGarantieChoisie choisie =(GarantieGarantieChoisie)getObjectService().getByIdPK(id, "garantieGarantieChoisie");
			//System.out.println("id de GarantieGarantieChoisie :" + ggc.getPrimeNetteProrata());
			System.out.println("prime prorata de GarantieGarantieChoisie :" + ggc.getPrimeAnnuelle());
			// constuire l'objet PrimebyGarantie
			//primeByGarantie.setChoisie(ggc.getGarantieChoisie());
			//primeByGarantie.setGarantie(ggc.getGarantie());
			// ajouter a la list des primeByGarantie
			listPrimeGaranties.add(ggc);
		}
		
		
		
		
		// pour chaque garantie de la list
		/*for (Garantie garantie : listGaranties) {
			GarantieGarantieChoisieId id = new GarantieGarantieChoisieId();
			PrimeByGarantie primeByGarantie = new PrimeByGarantie();
			// contruire la cl� primaire de GarantieGarantieChoisie
			id.setCodeGarantieChoisie(garantieChoisie.getCodeGarantieChoisie());
			id.setCodeGarantie(garantie.getCodeGarantie());
			// recup�re GarantieGarantieChoisie par pk
			//GarantieGarantieChoisie choisie = (GarantieGarantieChoisie) getObjectService()
					//.getObjectById(pk, "GarantieGarantieChoisie");
			 GarantieGarantieChoisie choisie =(GarantieGarantieChoisie)getObjectService().getByIdPK(id, "garantieGarantieChoisie");
=======
			 GarantieGarantieChoisie choisie =(GarantieGarantieChoisie)selectInfo.getById(pk);
>>>>>>> branch 'master' of https://github.com/J3asoftwaregroup/SherpaWebUse
			System.out.println("id de GarantieGarantieChoisie :" + choisie.getId().getCodeGarantieChoisie());
			System.out.println("prime prorata de GarantieGarantieChoisie :" + choisie.getPrimeAnnuelle());
			// constuire l'objet PrimebyGarantie
			primeByGarantie.setChoisie(choisie);
			primeByGarantie.setGarantie(garantie);
			// ajouter a la list des primeByGarantie
			listPrimeGaranties.add(primeByGarantie);
		}*/
		return listPrimeGaranties;

	}
	
	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	
}