package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.RcTarif12;
import com.j3a.assurance.model.RcTarif12b;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ManagedTarif12 implements Serializable{

	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private static final String SUCCESS = "succes";
		private static final String ERROR = "error";
		
		@Autowired
		ObjectService objectService;
		@Autowired
		IdGenerateur idGenerateur;
		
		
		
		private Tarif tarif = new Tarif();
		private RcTarif12 rcTarif12 = new RcTarif12();
		private RcTarif12b rcTarif12b = new RcTarif12b();
		
		
		public  void enregistrer(){
		try{	
		rcTarif12.setCodeRcTarif12("codeRcTarif12");
		getObjectService().addObject(rcTarif12);
		
		
		
		
		
		
		tarif.setCodeTarif("tarif12");
		tarif.setLibelleTarif("Tarif12");
		getObjectService().addObject(tarif);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Succes", "Enregistrement effectué"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Echec", "Enregistrement non effectué"));		

		}		
		
		}

		
		
		
		
		
		

		
		
		
		

//getters et setters
		public ObjectService getObjectService() {
			return objectService;
		}



		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}



		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}



		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}



		public Tarif getTarif() {
			return tarif;
		}



		public void setTarif(Tarif tarif) {
			this.tarif = tarif;
		}



		public RcTarif12 getRcTarif12() {
			return rcTarif12;
		}


		public void setRcTarif12(RcTarif12 rcTarif12) {
			this.rcTarif12 = rcTarif12;
		}













		public RcTarif12b getRcTarif12b() {
			return rcTarif12b;
		}





		public void setRcTarif12b(RcTarif12b rcTarif12b) {
			this.rcTarif12b = rcTarif12b;
		}


	
		
	}



