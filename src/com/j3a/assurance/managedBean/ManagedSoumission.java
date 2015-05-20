package com.j3a.assurance.managedBean;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.ActeMedical;
import com.j3a.assurance.model.Intervenant;
import com.j3a.assurance.model.Intervention;
import com.j3a.assurance.model.Sinistre;
import com.j3a.assurance.objetService.ObjectService;
import com.j3a.assurance.utilitaire.IdGenerateur;


@Component
public class ManagedSoumission {
	//Injection Spring
		@Autowired
		ObjectService objectService;
		@Autowired
		IdGenerateur idGenerateur;
		
		private UploadedFile filePv;
		private UploadedFile fileRap;
		private UploadedFile fileActMed;
		
		private boolean bPv, bRap, bActMed;
		private boolean etatPv=true, etatRap=true, etatActMed=true;
		private Sinistre sinistre = new Sinistre();
		private Intervention intervention = new Intervention();
		private Intervenant intervenant = new Intervenant();
		private ActeMedical acteMedical = new ActeMedical();
		
		
		public void ChangeValueChexBox(){
			//bouton PV
			if (isbPv()==true ){
				setEtatPv(false);
			}
			else{
				setEtatPv(true);
			}
			 //bouton rappor
			if (isbRap()==true){
				setEtatRap(false);
			}
			else{
				setEtatRap(true);
			}
			
			//Bouton Acte
			if(isbActMed()==true){
				setEtatActMed(false);
			}
			else{
				setEtatActMed(true);
			}
		}
		
		public void AjouPv(){
			intervention.setRefIntervention(getIdGenerateur().getIdIntervention(getSinistre()));
			intervention.setTypeRapport("Rapport Intervenant");

		}
		
		public void AjouActMed(){
			
		}
		
		public void AjouRap(){
			
		}
		 
	    public UploadedFile getFilePv() {
	        return filePv;
	    }
	 
	    public void setFilePv(UploadedFile filePv) {
	        this.filePv = filePv;
	    }

		public ObjectService getObjectService() {
			return objectService;
		}

		public void setObjectService(ObjectService objectService) {
			this.objectService = objectService;
		}

		public UploadedFile getFileRap() {
			return fileRap;
		}

		public void setFileRap(UploadedFile fileRap) {
			this.fileRap = fileRap;
		}

		public UploadedFile getFileActMed() {
			return fileActMed;
		}

		public void setFileActMed(UploadedFile fileActMed) {
			this.fileActMed = fileActMed;
		}

		public boolean isbPv() {
			return bPv;
		}

		public void setbPv(boolean bPv) {
			this.bPv = bPv;
		}

		public boolean isbRap() {
			return bRap;
		}

		public void setbRap(boolean bRap) {
			this.bRap = bRap;
		}

		public boolean isbActMed() {
			return bActMed;
		}

		public void setbActMed(boolean bActMed) {
			this.bActMed = bActMed;
		}

		public boolean isEtatPv() {
			return etatPv;
		}

		public void setEtatPv(boolean etatPv) {
			this.etatPv = etatPv;
		}

		public boolean isEtatRap() {
			return etatRap;
		}

		public void setEtatRap(boolean etatRap) {
			this.etatRap = etatRap;
		}

		public boolean isEtatActMed() {
			return etatActMed;
		}

		public void setEtatActMed(boolean etatActMed) {
			this.etatActMed = etatActMed;
		}

		public Sinistre getSinistre() {
			return sinistre;
		}

		public void setSinistre(Sinistre sinistre) {
			this.sinistre = sinistre;
		}

		public Intervention getIntervention() {
			return intervention;
		}

		public void setIntervention(Intervention intervention) {
			this.intervention = intervention;
		}

		public Intervenant getIntervenant() {
			return intervenant;
		}

		public void setIntervenant(Intervenant intervenant) {
			this.intervenant = intervenant;
		}

		public ActeMedical getActeMedical() {
			return acteMedical;
		}

		public void setActeMedical(ActeMedical acteMedical) {
			this.acteMedical = acteMedical;
		}

		public IdGenerateur getIdGenerateur() {
			return idGenerateur;
		}

		public void setIdGenerateur(IdGenerateur idGenerateur) {
			this.idGenerateur = idGenerateur;
		}
	
}
