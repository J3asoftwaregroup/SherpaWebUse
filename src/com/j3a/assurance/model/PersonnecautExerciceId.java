package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonnecautExerciceId generated by hbm2java
 */
@Embeddable
public class PersonnecautExerciceId implements java.io.Serializable {

	private String codeEtatCima;
	private String codePersCaut;

	public PersonnecautExerciceId() {
	}

	public PersonnecautExerciceId(String codeEtatCima, String codePersCaut) {
		this.codeEtatCima = codeEtatCima;
		this.codePersCaut = codePersCaut;
	}

	@Column(name = "CODE_ETAT_CIMA", nullable = false, length = 20)
	public String getCodeEtatCima() {
		return this.codeEtatCima;
	}

	public void setCodeEtatCima(String codeEtatCima) {
		this.codeEtatCima = codeEtatCima;
	}

	@Column(name = "CODE_PERS_CAUT", nullable = false, length = 20)
	public String getCodePersCaut() {
		return this.codePersCaut;
	}

	public void setCodePersCaut(String codePersCaut) {
		this.codePersCaut = codePersCaut;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonnecautExerciceId))
			return false;
		PersonnecautExerciceId castOther = (PersonnecautExerciceId) other;

		return ((this.getCodeEtatCima() == castOther.getCodeEtatCima()) || (this
				.getCodeEtatCima() != null
				&& castOther.getCodeEtatCima() != null && this
				.getCodeEtatCima().equals(castOther.getCodeEtatCima())))
				&& ((this.getCodePersCaut() == castOther.getCodePersCaut()) || (this
						.getCodePersCaut() != null
						&& castOther.getCodePersCaut() != null && this
						.getCodePersCaut().equals(castOther.getCodePersCaut())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeEtatCima() == null ? 0 : this.getCodeEtatCima()
						.hashCode());
		result = 37
				* result
				+ (getCodePersCaut() == null ? 0 : this.getCodePersCaut()
						.hashCode());
		return result;
	}

}