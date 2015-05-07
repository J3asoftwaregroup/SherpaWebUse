package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Etatc10b generated by hbm2java
 */
@Entity
@Table(name = "etatc10b", catalog = "zeusbd")
public class Etatc10b implements java.io.Serializable {

	private String codeetatc10b;
	private EtatCima etatCima;
	private Date dateetatc10b;
	private Set<Etatc10bCategorie> etatc10bCategories = new HashSet<Etatc10bCategorie>(
			0);

	public Etatc10b() {
	}

	public Etatc10b(String codeetatc10b) {
		this.codeetatc10b = codeetatc10b;
	}

	public Etatc10b(String codeetatc10b, EtatCima etatCima, Date dateetatc10b,
			Set<Etatc10bCategorie> etatc10bCategories) {
		this.codeetatc10b = codeetatc10b;
		this.etatCima = etatCima;
		this.dateetatc10b = dateetatc10b;
		this.etatc10bCategories = etatc10bCategories;
	}

	@Id
	@Column(name = "CODEETATC10B", unique = true, nullable = false, length = 20)
	public String getCodeetatc10b() {
		return this.codeetatc10b;
	}

	public void setCodeetatc10b(String codeetatc10b) {
		this.codeetatc10b = codeetatc10b;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_ETAT_CIMA")
	public EtatCima getEtatCima() {
		return this.etatCima;
	}

	public void setEtatCima(EtatCima etatCima) {
		this.etatCima = etatCima;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATEETATC10B", length = 10)
	public Date getDateetatc10b() {
		return this.dateetatc10b;
	}

	public void setDateetatc10b(Date dateetatc10b) {
		this.dateetatc10b = dateetatc10b;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "etatc10b")
	public Set<Etatc10bCategorie> getEtatc10bCategories() {
		return this.etatc10bCategories;
	}

	public void setEtatc10bCategories(Set<Etatc10bCategorie> etatc10bCategories) {
		this.etatc10bCategories = etatc10bCategories;
	}

}
