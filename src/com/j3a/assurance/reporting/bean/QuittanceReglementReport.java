package com.j3a.assurance.reporting.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.Quittance;
import com.j3a.assurance.model.Utilisateur;

@Component
public class QuittanceReglementReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Quittance quittance = new Quittance();
	private Contrat contrat = new Contrat();
	private Avenant avenant = new Avenant();
	private Personne personne = new Personne();
	private Physique personPhysique = new Physique();
	private Personne personMorale = new Morale();
	private Utilisateur utilisateur = new Utilisateur();
	private BigDecimal resteApayer = new BigDecimal(0);
	private BigDecimal solde = new BigDecimal(0);
	private BigDecimal acompte = new BigDecimal(0);
	private BigDecimal montantReglement = new BigDecimal(0);
	private String etatQuittance = "";
	
	
	/******************************ACCESEURS****************/
	public Quittance getQuittance() {
		return quittance;
	}
	public void setQuittance(Quittance quittance) {
		this.quittance = quittance;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	public Avenant getAvenant() {
		return avenant;
	}
	public void setAvenant(Avenant avenant) {
		this.avenant = avenant;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Personne getPersonMorale() {
		return personMorale;
	}
	public void setPersonMorale(Personne personMorale) {
		this.personMorale = personMorale;
	}
	public Physique getPersonPhysique() {
		return personPhysique;
	}
	public void setPersonPhysique(Physique personPhysique) {
		this.personPhysique = personPhysique;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public BigDecimal getResteApayer() {
		return resteApayer;
	}
	public void setResteApayer(BigDecimal resteApayer) {
		this.resteApayer = resteApayer;
	}
	public BigDecimal getSolde() {
		return solde;
	}
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
	public BigDecimal getAcompte() {
		return acompte;
	}
	public void setAcompte(BigDecimal acompte) {
		this.acompte = acompte;
	}
	public BigDecimal getMontantReglement() {
		return montantReglement;
	}
	public void setMontantReglement(BigDecimal montantReglement) {
		this.montantReglement = montantReglement;
	}
	public String getEtatQuittance() {
		return etatQuittance;
	}
	public void setEtatQuittance(String etatQuittance) {
		this.etatQuittance = etatQuittance;
	}
}
