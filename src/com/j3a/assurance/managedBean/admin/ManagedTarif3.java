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
import com.j3a.assurance.model.Risque;
import com.j3a.assurance.model.SocieteAssurance;
import com.j3a.assurance.model.SousCatVehicule;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.model.Utilisateur;
import com.j3a.assurance.model.Vehicule;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;

@Component
public class ManagedTarif3 implements Serializable{

	/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private static final String succes = "succes";
		private static final String ERROR = "error";
		
		@Autowired
		ObjectService objectService;
		@Autowired
		IdGenerateur idGenerateur;
		
		
		
		private Tarif tarif = new Tarif();
		private RcTarif3 rcTarif3 = new RcTarif3();
		
		
		
		public  void enregistrer(){
			
		try{
			
			
			if (getRcTarif3().getCodeRcTarif3() != null) {
				rcTarif3.setCodeRcTarif3("Rctarif3");
				getObjectService().addObject(rcTarif3);
				
				tarif.setCodeTarif("tarif3");
				tarif.setLibelleTarif("Tarif 3");
				getObjectService().addObject(tarif);
				
			}
				else{
				
					getObjectService().updateObject(rcTarif3);
					
					getObjectService().updateObject(tarif);
			}
		
		
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("succes", "Enregistrement effectué"));
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



		public RcTarif3 getRcTarif3() {
			return rcTarif3;
		}



		public void setRcTarif3(RcTarif3 rcTarif3) {
			this.rcTarif3 = rcTarif3;
		}
		
		
		
		
		
		
	}



