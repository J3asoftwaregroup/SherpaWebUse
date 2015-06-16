package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ZoneGeographique generated by hbm2java
 */
@Entity
@Table(name = "zone_geographique", catalog = "zeusbd")
public class ZoneGeographique implements java.io.Serializable {

	private String codeZoneGeo;
	private String libelleZoneGeo;
	private Set<Ville> villes = new HashSet<Ville>(0);
	private Set<VehiculeZoneGeographique> vehiculeZoneGeographiques = new HashSet<VehiculeZoneGeographique>(
			0);

	public ZoneGeographique() {
	}

	public ZoneGeographique(String codeZoneGeo) {
		this.codeZoneGeo = codeZoneGeo;
	}

	public ZoneGeographique(String codeZoneGeo, String libelleZoneGeo,
			Set<Ville> villes,
			Set<VehiculeZoneGeographique> vehiculeZoneGeographiques) {
		this.codeZoneGeo = codeZoneGeo;
		this.libelleZoneGeo = libelleZoneGeo;
		this.villes = villes;
		this.vehiculeZoneGeographiques = vehiculeZoneGeographiques;
	}

	@Id
	@Column(name = "CODE_ZONE_GEO", unique = true, nullable = false, length = 15)
	public String getCodeZoneGeo() {
		return this.codeZoneGeo;
	}

	public void setCodeZoneGeo(String codeZoneGeo) {
		this.codeZoneGeo = codeZoneGeo;
	}

	@Column(name = "LIBELLE_ZONE_GEO", length = 50)
	public String getLibelleZoneGeo() {
		return this.libelleZoneGeo;
	}

	public void setLibelleZoneGeo(String libelleZoneGeo) {
		this.libelleZoneGeo = libelleZoneGeo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zoneGeographique")
	public Set<Ville> getVilles() {
		return this.villes;
	}

	public void setVilles(Set<Ville> villes) {
		this.villes = villes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "zoneGeographique")
	public Set<VehiculeZoneGeographique> getVehiculeZoneGeographiques() {
		return this.vehiculeZoneGeographiques;
	}

	public void setVehiculeZoneGeographiques(
			Set<VehiculeZoneGeographique> vehiculeZoneGeographiques) {
		this.vehiculeZoneGeographiques = vehiculeZoneGeographiques;
	}

}
