package com.j3a.assurance.model;

// Generated 22 juin 2015 11:50:15 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * HistoMouvement generated by hbm2java
 */
@Entity
@Table(name = "histo_mouvement", catalog = "zeusbd")
public class HistoMouvement implements java.io.Serializable {

	private String codeHistoMouvement;
	private Vehicule vehicule;
	private String idAvenant;
	private Date dateHistoMouvement;
	private String libelleHistoMouvement;

	public HistoMouvement() {
	}

	public HistoMouvement(String codeHistoMouvement) {
		this.codeHistoMouvement = codeHistoMouvement;
	}

	public HistoMouvement(String codeHistoMouvement, Vehicule vehicule,
			String idAvenant, Date dateHistoMouvement,
			String libelleHistoMouvement) {
		this.codeHistoMouvement = codeHistoMouvement;
		this.vehicule = vehicule;
		this.idAvenant = idAvenant;
		this.dateHistoMouvement = dateHistoMouvement;
		this.libelleHistoMouvement = libelleHistoMouvement;
	}

	@Id
	@Column(name = "CODE_HISTO_MOUVEMENT", unique = true, nullable = false, length = 30)
	public String getCodeHistoMouvement() {
		return this.codeHistoMouvement;
	}

	public void setCodeHistoMouvement(String codeHistoMouvement) {
		this.codeHistoMouvement = codeHistoMouvement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_VEHICULE")
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Column(name = "ID_AVENANT", length = 60)
	public String getIdAvenant() {
		return this.idAvenant;
	}

	public void setIdAvenant(String idAvenant) {
		this.idAvenant = idAvenant;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_HISTO_MOUVEMENT", length = 19)
	public Date getDateHistoMouvement() {
		return this.dateHistoMouvement;
	}

	public void setDateHistoMouvement(Date dateHistoMouvement) {
		this.dateHistoMouvement = dateHistoMouvement;
	}

	@Column(name = "LIBELLE_HISTO_MOUVEMENT", length = 60)
	public String getLibelleHistoMouvement() {
		return this.libelleHistoMouvement;
	}

	public void setLibelleHistoMouvement(String libelleHistoMouvement) {
		this.libelleHistoMouvement = libelleHistoMouvement;
	}

}
