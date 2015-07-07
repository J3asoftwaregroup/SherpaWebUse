package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VehiculeZoneGeographiqueId generated by hbm2java
 */
@Embeddable
public class VehiculeZoneGeographiqueId implements java.io.Serializable {

	private String codeVehicule;
	private String codeZoneGeo;

	public VehiculeZoneGeographiqueId() {
	}

	public VehiculeZoneGeographiqueId(String codeVehicule, String codeZoneGeo) {
		this.codeVehicule = codeVehicule;
		this.codeZoneGeo = codeZoneGeo;
	}

	@Column(name = "CODE_VEHICULE", nullable = false, length = 30)
	public String getCodeVehicule() {
		return this.codeVehicule;
	}

	public void setCodeVehicule(String codeVehicule) {
		this.codeVehicule = codeVehicule;
	}

	@Column(name = "CODE_ZONE_GEO", nullable = false, length = 15)
	public String getCodeZoneGeo() {
		return this.codeZoneGeo;
	}

	public void setCodeZoneGeo(String codeZoneGeo) {
		this.codeZoneGeo = codeZoneGeo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VehiculeZoneGeographiqueId))
			return false;
		VehiculeZoneGeographiqueId castOther = (VehiculeZoneGeographiqueId) other;

		return ((this.getCodeVehicule() == castOther.getCodeVehicule()) || (this
				.getCodeVehicule() != null
				&& castOther.getCodeVehicule() != null && this
				.getCodeVehicule().equals(castOther.getCodeVehicule())))
				&& ((this.getCodeZoneGeo() == castOther.getCodeZoneGeo()) || (this
						.getCodeZoneGeo() != null
						&& castOther.getCodeZoneGeo() != null && this
						.getCodeZoneGeo().equals(castOther.getCodeZoneGeo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeVehicule() == null ? 0 : this.getCodeVehicule()
						.hashCode());
		result = 37
				* result
				+ (getCodeZoneGeo() == null ? 0 : this.getCodeZoneGeo()
						.hashCode());
		return result;
	}

}
