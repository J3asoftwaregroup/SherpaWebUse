package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VehiculesAssures generated by hbm2java
 */
@Entity
@Table(name = "vehicules_assures", catalog = "zeusbd")
public class VehiculesAssures implements java.io.Serializable {

	private String idVehiculesAssures;
	private Date dateVehiculesAssures;
	private Set<Avenant> avenants = new HashSet<Avenant>(0);
	private Set<Vehicule> vehicules = new HashSet<Vehicule>(0);

	public VehiculesAssures() {
	}

	public VehiculesAssures(String idVehiculesAssures) {
		this.idVehiculesAssures = idVehiculesAssures;
	}

	public VehiculesAssures(String idVehiculesAssures,
			Date dateVehiculesAssures, Set<Avenant> avenants,
			Set<Vehicule> vehicules) {
		this.idVehiculesAssures = idVehiculesAssures;
		this.dateVehiculesAssures = dateVehiculesAssures;
		this.avenants = avenants;
		this.vehicules = vehicules;
	}

	@Id
	@Column(name = "ID_VEHICULES_ASSURES", unique = true, nullable = false, length = 35)
	public String getIdVehiculesAssures() {
		return this.idVehiculesAssures;
	}

	public void setIdVehiculesAssures(String idVehiculesAssures) {
		this.idVehiculesAssures = idVehiculesAssures;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_VEHICULES_ASSURES", length = 19)
	public Date getDateVehiculesAssures() {
		return this.dateVehiculesAssures;
	}

	public void setDateVehiculesAssures(Date dateVehiculesAssures) {
		this.dateVehiculesAssures = dateVehiculesAssures;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculesAssures")
	public Set<Avenant> getAvenants() {
		return this.avenants;
	}

	public void setAvenants(Set<Avenant> avenants) {
		this.avenants = avenants;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehiculesAssures")
	public Set<Vehicule> getVehicules() {
		return this.vehicules;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

}
