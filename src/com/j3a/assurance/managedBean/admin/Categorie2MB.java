package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.RcTarif1;
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
	private RcTarif2 rcTarif2 = new RcTarif2();
	private Tarif tarif = new Tarif();
	private  String code;
	private  String codetar;
	
	
	@PostConstruct
	public void PostConst(){
		try {
			setRcTarif2( (RcTarif2) getObjectService().getObjectById("Rctarif2", "RcTarif2"));
			setTarif( (Tarif) getObjectService().getObjectById("tarif2", "Tarif"));
			System.out.println("ok Enregistrement recuperee");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("non ok !Enregistrement non recuperée");		

		}		
		
		}
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodetar() {
		return codetar;
	}

	public void setCodetar(String codetar) {
		this.codetar = codetar;
	}
	
	
}
