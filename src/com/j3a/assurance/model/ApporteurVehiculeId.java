package com.j3a.assurance.model;

// Generated 15 juin 2015 17:23:41 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ApporteurVehiculeId generated by hbm2java
 */
@Embeddable
public class ApporteurVehiculeId implements java.io.Serializable {

	private String codeApporteur;
	private String codeVehicule;

	public ApporteurVehiculeId() {
	}

	public ApporteurVehiculeId(String codeApporteur, String codeVehicule) {
		this.codeApporteur = codeApporteur;
		this.codeVehicule = codeVehicule;
	}

	@Column(name = "CODE_APPORTEUR", nullable = false, length = 10)
	public String getCodeApporteur() {
		return this.codeApporteur;
	}

	public void setCodeApporteur(String codeApporteur) {
		this.codeApporteur = codeApporteur;
	}

	@Column(name = "CODE_VEHICULE", nullable = false, length = 30)
	public String getCodeVehicule() {
		return this.codeVehicule;
	}

	public void setCodeVehicule(String codeVehicule) {
		this.codeVehicule = codeVehicule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ApporteurVehiculeId))
			return false;
		ApporteurVehiculeId castOther = (ApporteurVehiculeId) other;

		return ((this.getCodeApporteur() == castOther.getCodeApporteur()) || (this
				.getCodeApporteur() != null
				&& castOther.getCodeApporteur() != null && this
				.getCodeApporteur().equals(castOther.getCodeApporteur())))
				&& ((this.getCodeVehicule() == castOther.getCodeVehicule()) || (this
						.getCodeVehicule() != null
						&& castOther.getCodeVehicule() != null && this
						.getCodeVehicule().equals(castOther.getCodeVehicule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeApporteur() == null ? 0 : this.getCodeApporteur()
						.hashCode());
		result = 37
				* result
				+ (getCodeVehicule() == null ? 0 : this.getCodeVehicule()
						.hashCode());
		return result;
	}

}
