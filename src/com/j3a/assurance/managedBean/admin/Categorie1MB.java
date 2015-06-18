package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.RcTarif1;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.objetService.ObjectService;

@Component
public class Categorie1MB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
    ObjectService objectService;
	private RcTarif1 rcTarif1;
	private Tarif tarif;
	
	
	public void addCategorie(){
	try {
		rcTarif1.setCodeRcTarif1("RcTarif1");	
		getObjectService().addObject(rcTarif1);	
		tarif.setCodeTarif("Tarif1");
		tarif.setRcTarif1(rcTarif1);
		getObjectService().addObject(tarif);	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Success", "Enregistrement effectué"));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Echec", "Enregistrement non effectué"));		

	}		

	}
	
	
	public RcTarif1 getRcTarif1() {
		return rcTarif1;
	}


	public void setRcTarif1(RcTarif1 rcTarif1) {
		this.rcTarif1 = rcTarif1;
	}


	public Tarif getTarif() {
		return tarif;
	}


	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}


	public ObjectService getObjectService() {
		return objectService;
	}
	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}
	
}
