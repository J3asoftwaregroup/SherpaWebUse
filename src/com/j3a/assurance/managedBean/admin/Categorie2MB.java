package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.RcTarif2;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.objetService.ObjectService;

@Component
public class Categorie2MB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
    ObjectService objectService;
	private RcTarif2 rcTarif2;
	private Tarif tarif;
	
	
	public void addCategorie(){
	try {
		rcTarif2.setCodeRcTarif2("Tarif2");	
		getObjectService().addObject(rcTarif2);	
		tarif.setCodeTarif(rcTarif2.getCodeRcTarif2());
		tarif.setRcTarif2(rcTarif2);
		getObjectService().addObject(tarif);	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Success", "Enregistrement effectué"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Echec", "Enregistrement non effectué"));		

	}		

	}


	public ObjectService getObjectService() {
		return objectService;
	}


	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}


	public RcTarif2 getRcTarif2() {
		return rcTarif2;
	}


	public void setRcTarif2(RcTarif2 rcTarif2) {
		this.rcTarif2 = rcTarif2;
	}


	public Tarif getTarif() {
		return tarif;
	}


	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}
	
	
}
