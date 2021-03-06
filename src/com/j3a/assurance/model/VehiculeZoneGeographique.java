package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VehiculeZoneGeographique generated by hbm2java
 */
@Entity
@Table(name = "vehicule_zone_geographique", catalog = "zeusbd")
public class VehiculeZoneGeographique implements java.io.Serializable {

	private VehiculeZoneGeographiqueId id;
	private Vehicule vehicule;
	private ZoneGeographique zoneGeographique;
	private Date dateRouler;

	public VehiculeZoneGeographique() {
	}

	public VehiculeZoneGeographique(VehiculeZoneGeographiqueId id,
			Vehicule vehicule, ZoneGeographique zoneGeographique) {
		this.id = id;
		this.vehicule = vehicule;
		this.zoneGeographique = zoneGeographique;
	}

	public VehiculeZoneGeographique(VehiculeZoneGeographiqueId id,
			Vehicule vehicule, ZoneGeographique zoneGeographique,
			Date dateRouler) {
		this.id = id;
		this.vehicule = vehicule;
		this.zoneGeographique = zoneGeographique;
		this.dateRouler = dateRouler;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeVehicule", column = @Column(name = "CODE_VEHICULE", nullable = false, length = 30)),
			@AttributeOverride(name = "codeZoneGeo", column = @Column(name = "CODE_ZONE_GEO", nullable = false, length = 15)) })
	public VehiculeZoneGeographiqueId getId() {
		return this.id;
	}

	public void setId(VehiculeZoneGeographiqueId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_VEHICULE", nullable = false, insertable = false, updatable = false)
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ZONE_GEO", nullable = false, insertable = false, updatable = false)
	public ZoneGeographique getZoneGeographique() {
		return this.zoneGeographique;
	}

	public void setZoneGeographique(ZoneGeographique zoneGeographique) {
		this.zoneGeographique = zoneGeographique;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ROULER", length = 10)
	public Date getDateRouler() {
		return this.dateRouler;
	}

	public void setDateRouler(Date dateRouler) {
		this.dateRouler = dateRouler;
	}

}
