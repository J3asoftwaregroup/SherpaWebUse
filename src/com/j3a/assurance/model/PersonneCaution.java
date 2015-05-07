package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * PersonneCaution generated by hbm2java
 */
@Entity
@Table(name = "personne_caution", catalog = "zeusbd")
public class PersonneCaution implements java.io.Serializable {

	private String codePersCaut;
	private String nomPersCaut;
	private String prenomsPersCaut;
	private String qualificationPersCaut;
	private String objetCautionPersCaut;
	private Set<EtatCima> etatCimas = new HashSet<EtatCima>(0);

	public PersonneCaution() {
	}

	public PersonneCaution(String codePersCaut) {
		this.codePersCaut = codePersCaut;
	}

	public PersonneCaution(String codePersCaut, String nomPersCaut,
			String prenomsPersCaut, String qualificationPersCaut,
			String objetCautionPersCaut, Set<EtatCima> etatCimas) {
		this.codePersCaut = codePersCaut;
		this.nomPersCaut = nomPersCaut;
		this.prenomsPersCaut = prenomsPersCaut;
		this.qualificationPersCaut = qualificationPersCaut;
		this.objetCautionPersCaut = objetCautionPersCaut;
		this.etatCimas = etatCimas;
	}

	@Id
	@Column(name = "CODE_PERS_CAUT", unique = true, nullable = false, length = 20)
	public String getCodePersCaut() {
		return this.codePersCaut;
	}

	public void setCodePersCaut(String codePersCaut) {
		this.codePersCaut = codePersCaut;
	}

	@Column(name = "NOM_PERS_CAUT", length = 20)
	public String getNomPersCaut() {
		return this.nomPersCaut;
	}

	public void setNomPersCaut(String nomPersCaut) {
		this.nomPersCaut = nomPersCaut;
	}

	@Column(name = "PRENOMS_PERS_CAUT", length = 50)
	public String getPrenomsPersCaut() {
		return this.prenomsPersCaut;
	}

	public void setPrenomsPersCaut(String prenomsPersCaut) {
		this.prenomsPersCaut = prenomsPersCaut;
	}

	@Column(name = "QUALIFICATION__PERS_CAUT", length = 30)
	public String getQualificationPersCaut() {
		return this.qualificationPersCaut;
	}

	public void setQualificationPersCaut(String qualificationPersCaut) {
		this.qualificationPersCaut = qualificationPersCaut;
	}

	@Column(name = "OBJET_CAUTION_PERS_CAUT", length = 30)
	public String getObjetCautionPersCaut() {
		return this.objetCautionPersCaut;
	}

	public void setObjetCautionPersCaut(String objetCautionPersCaut) {
		this.objetCautionPersCaut = objetCautionPersCaut;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "personneCautions")
	public Set<EtatCima> getEtatCimas() {
		return this.etatCimas;
	}

	public void setEtatCimas(Set<EtatCima> etatCimas) {
		this.etatCimas = etatCimas;
	}

}
