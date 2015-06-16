package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApporteurAssureId generated by hbm2java
 */
@Embeddable
public class ApporteurAssureId implements java.io.Serializable {

	private String codeApporteur;
	private String numIdentification;

	public ApporteurAssureId() {
	}

	public ApporteurAssureId(String codeApporteur, String numIdentification) {
		this.codeApporteur = codeApporteur;
		this.numIdentification = numIdentification;
	}

	@Column(name = "CODE_APPORTEUR", nullable = false, length = 10)
	public String getCodeApporteur() {
		return this.codeApporteur;
	}

	public void setCodeApporteur(String codeApporteur) {
		this.codeApporteur = codeApporteur;
	}

	@Column(name = "NUM_IDENTIFICATION", nullable = false, length = 25)
	public String getNumIdentification() {
		return this.numIdentification;
	}

	public void setNumIdentification(String numIdentification) {
		this.numIdentification = numIdentification;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ApporteurAssureId))
			return false;
		ApporteurAssureId castOther = (ApporteurAssureId) other;

		return ((this.getCodeApporteur() == castOther.getCodeApporteur()) || (this
				.getCodeApporteur() != null
				&& castOther.getCodeApporteur() != null && this
				.getCodeApporteur().equals(castOther.getCodeApporteur())))
				&& ((this.getNumIdentification() == castOther
						.getNumIdentification()) || (this
						.getNumIdentification() != null
						&& castOther.getNumIdentification() != null && this
						.getNumIdentification().equals(
								castOther.getNumIdentification())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeApporteur() == null ? 0 : this.getCodeApporteur()
						.hashCode());
		result = 37
				* result
				+ (getNumIdentification() == null ? 0 : this
						.getNumIdentification().hashCode());
		return result;
	}

}
