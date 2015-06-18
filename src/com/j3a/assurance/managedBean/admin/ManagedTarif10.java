package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.RcTarif10;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ManagedTarif10 implements Serializable{

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
		private RcTarif10 rcTarif10 = new RcTarif10();
		
		
		
		public  void enregistrer(){
		try{	
		rcTarif10.setCodeRcTarif10("RcTarif10");
		getObjectService().addObject(rcTarif10);
		
		
		
		
		
		tarif.setCodeTarif("tarif10");
		tarif.setLibelleTarif("Tarif10");
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



		public RcTarif10 getRcTarif10() {
			return rcTarif10;
		}


		public void setRcTarif10(RcTarif10 rcTarif10) {
			this.rcTarif10 = rcTarif10;
		}


	
		
	}



