package com.j3a.assurance.model;

// Generated 15 juin 2015 17:51:51 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ville generated by hbm2java
 */
@Entity
@Table(name = "ville", catalog = "zeusbd")
public class Ville implements java.io.Serializable {

	private String codeVille;
	private Province province;
	private ZoneGeographique zoneGeographique;
	private String libelleVille;
	private Set<PointVente> pointVentes = new HashSet<PointVente>(0);

	public Ville() {
	}

	public Ville(String codeVille, Province province,
			ZoneGeographique zoneGeographique) {
		this.codeVille = codeVille;
		this.province = province;
		this.zoneGeographique = zoneGeographique;
	}

	public Ville(String codeVille, Province province,
			ZoneGeographique zoneGeographique, String libelleVille,
			Set<PointVente> pointVentes) {
		this.codeVille = codeVille;
		this.province = province;
		this.zoneGeographique = zoneGeographique;
		this.libelleVille = libelleVille;
		this.pointVentes = pointVentes;
	}

	@Id
	@Column(name = "CODE_VILLE", unique = true, nullable = false, length = 15)
	public String getCodeVille() {
		return this.codeVille;
	}

	public void setCodeVille(String codeVille) {
		this.codeVille = codeVille;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_PROVINCE", nullable = false)
	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ZONE_GEO", nullable = false)
	public ZoneGeographique getZoneGeographique() {
		return this.zoneGeographique;
	}

	public void setZoneGeographique(ZoneGeographique zoneGeographique) {
		this.zoneGeographique = zoneGeographique;
	}

	@Column(name = "LIBELLE_VILLE", length = 35)
	public String getLibelleVille() {
		return this.libelleVille;
	}

	public void setLibelleVille(String libelleVille) {
		this.libelleVille = libelleVille;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ville")
	public Set<PointVente> getPointVentes() {
		return this.pointVentes;
	}

	public void setPointVentes(Set<PointVente> pointVentes) {
		this.pointVentes = pointVentes;
	}

}
