package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonneNationaliteId generated by hbm2java
 */
@Embeddable
public class PersonneNationaliteId implements java.io.Serializable {

	private int codeNationalite;
	private String numSouscripteur;

	public PersonneNationaliteId() {
	}

	public PersonneNationaliteId(int codeNationalite, String numSouscripteur) {
		this.codeNationalite = codeNationalite;
		this.numSouscripteur = numSouscripteur;
	}

	@Column(name = "CODE_NATIONALITE", nullable = false)
	public int getCodeNationalite() {
		return this.codeNationalite;
	}

	public void setCodeNationalite(int codeNationalite) {
		this.codeNationalite = codeNationalite;
	}

	@Column(name = "NUM_SOUSCRIPTEUR", nullable = false, length = 15)
	public String getNumSouscripteur() {
		return this.numSouscripteur;
	}

	public void setNumSouscripteur(String numSouscripteur) {
		this.numSouscripteur = numSouscripteur;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonneNationaliteId))
			return false;
		PersonneNationaliteId castOther = (PersonneNationaliteId) other;

		return (this.getCodeNationalite() == castOther.getCodeNationalite())
				&& ((this.getNumSouscripteur() == castOther
						.getNumSouscripteur()) || (this.getNumSouscripteur() != null
						&& castOther.getNumSouscripteur() != null && this
						.getNumSouscripteur().equals(
								castOther.getNumSouscripteur())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCodeNationalite();
		result = 37
				* result
				+ (getNumSouscripteur() == null ? 0 : this.getNumSouscripteur()
						.hashCode());
		return result;
	}

}
