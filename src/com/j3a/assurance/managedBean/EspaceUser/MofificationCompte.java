package com.j3a.assurance.managedBean.EspaceUser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.j3a.assurance.managedBean.Auto.ManagedSinistre;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.objetService.ObjectService;

public class MofificationCompte {
	private static  Logger logger=Logger.getLogger(ManagedSinistre.class);
	
	@Autowired
	private ObjectService objectService;
	
private	Personne personneModif = new Personne();
private	Personne personneConneter;
private	Physique physiqueConnecte;

private String confirmeMdp;
	
	
	@PostConstruct
	public void chargerUtilisateur(){
		personneConneter = new Personne();
		physiqueConnecte = new Physique();
		
		personneConneter = getObjectService().RecupererUtilisateurCourrant();
		Physique physiqueConnecte = (Physique) getObjectService().getObjectById(personneConneter.getNumSouscripteur(), "Physique");
		personneModif.setNumSouscripteur(personneConneter.getNumSouscripteur());
		personneModif.setLoginPers(personneConneter.getLoginPers());
	}
	
	public void modifierCompte(){
		getObjectService().updateObject(personneModif);
	}
	
	public void verifierLogin(){
		List<Personne> listPerLogin = new ArrayList<>();
		listPerLogin = getObjectService().personneByLogin(personneModif.getLoginPers());
	}
	
	/************************ACCESSEUR*************************************/

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	public Personne getPersonneConneter() {
		return personneConneter;
	}

	public void setPersonneConneter(Personne personneConneter) {
		this.personneConneter = personneConneter;
	}

	public Physique getPhysiqueConnecte() {
		return physiqueConnecte;
	}

	public void setPhysiqueConnecte(Physique physiqueConnecte) {
		this.physiqueConnecte = physiqueConnecte;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		MofificationCompte.logger = logger;
	}

	public Personne getPersonneModif() {
		return personneModif;
	}

	public void setPersonneModif(Personne personneModif) {
		this.personneModif = personneModif;
	}

	public String getConfirmeMdp() {
		return confirmeMdp;
	}

	public void setConfirmeMdp(String confirmeMdp) {
		this.confirmeMdp = confirmeMdp;
	}
}
