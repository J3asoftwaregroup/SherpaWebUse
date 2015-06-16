package com.j3a.assurance.managedBean.admin;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.j3a.assurance.managedBean.ManagedGarantie;
import com.j3a.assurance.model.Apporteur;
import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Exercice;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.PointVente;
import com.j3a.assurance.model.Quittance;
import com.j3a.assurance.model.RcTarif3;
import com.j3a.assurance.model.RcTarif4;
import com.j3a.assurance.model.Risque;
import com.j3a.assurance.model.SocieteAssurance;
import com.j3a.assurance.model.SousCatVehicule;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.model.Utilisateur;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ManagedTarif4 implements Serializable{

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
		private RcTarif4 rcTarif4 = new RcTarif4();
		
		
		
		public  void enregistrer(){
		try{	
		rcTarif4.setCodeRcTarif4("RcTarif4");
		getObjectService().addObject(rcTarif4);
		
		
		
		
		
		
		tarif.setCodeTarif("tarif4");
		tarif.setLibelleTarif("Tarif4");
		getObjectService().addObject(tarif);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Succes", "Enregistrement effectu�"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Echec", "Enregistrement non effectu�"));		

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



		public RcTarif4 getRcTarif4() {
			return rcTarif4;
		}


		public void setRcTarif4(RcTarif4 rcTarif4) {
			this.rcTarif4 = rcTarif4;
		}



		
		
		
		
		
		
	}



