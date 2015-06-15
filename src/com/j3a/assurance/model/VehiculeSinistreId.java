package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VehiculeSinistreId generated by hbm2java
 */
@Embeddable
public class VehiculeSinistreId implements java.io.Serializable {

	private String codeSinistre;
	private String codeVehicule;

	public VehiculeSinistreId() {
	}

	public VehiculeSinistreId(String codeSinistre, String codeVehicule) {
		this.codeSinistre = codeSinistre;
		this.codeVehicule = codeVehicule;
	}

	@Column(name = "CODE_SINISTRE", nullable = false, length = 40)
	public String getCodeSinistre() {
		return this.codeSinistre;
	}

	public void setCodeSinistre(String codeSinistre) {
		this.codeSinistre = codeSinistre;
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
		if (!(other instanceof VehiculeSinistreId))
			return false;
		VehiculeSinistreId castOther = (VehiculeSinistreId) other;

		return ((this.getCodeSinistre() == castOther.getCodeSinistre()) || (this
				.getCodeSinistre() != null
				&& castOther.getCodeSinistre() != null && this
				.getCodeSinistre().equals(castOther.getCodeSinistre())))
				&& ((this.getCodeVehicule() == castOther.getCodeVehicule()) || (this
						.getCodeVehicule() != null
						&& castOther.getCodeVehicule() != null && this
						.getCodeVehicule().equals(castOther.getCodeVehicule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeSinistre() == null ? 0 : this.getCodeSinistre()
						.hashCode());
		result = 37
				* result
				+ (getCodeVehicule() == null ? 0 : this.getCodeVehicule()
						.hashCode());
		return result;
	}

}
