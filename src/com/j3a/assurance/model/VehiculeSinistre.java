package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * VehiculeSinistre generated by hbm2java
 */
@Entity
@Table(name = "vehicule_sinistre", catalog = "zeusbd")
public class VehiculeSinistre implements java.io.Serializable {

	private VehiculeSinistreId id;
	private Sinistre sinistre;
	private Vehicule vehicule;
	private String lieuSinistre;
	private Integer nbreDeces;
	private Integer nbreBlesse;
	private BigDecimal rcAssure;
	private Boolean domageMat;
	private Boolean domageCorp;
	private String libelleDomageMat;
	private String libelleDomageCorp;
	private Date dateSinistreAuto;

	public VehiculeSinistre() {
	}

	public VehiculeSinistre(VehiculeSinistreId id, Sinistre sinistre,
			Vehicule vehicule) {
		this.id = id;
		this.sinistre = sinistre;
		this.vehicule = vehicule;
	}

	public VehiculeSinistre(VehiculeSinistreId id, Sinistre sinistre,
			Vehicule vehicule, String lieuSinistre, Integer nbreDeces,
			Integer nbreBlesse, BigDecimal rcAssure, Boolean domageMat,
			Boolean domageCorp, String libelleDomageMat,
			String libelleDomageCorp, Date dateSinistreAuto) {
		this.id = id;
		this.sinistre = sinistre;
		this.vehicule = vehicule;
		this.lieuSinistre = lieuSinistre;
		this.nbreDeces = nbreDeces;
		this.nbreBlesse = nbreBlesse;
		this.rcAssure = rcAssure;
		this.domageMat = domageMat;
		this.domageCorp = domageCorp;
		this.libelleDomageMat = libelleDomageMat;
		this.libelleDomageCorp = libelleDomageCorp;
		this.dateSinistreAuto = dateSinistreAuto;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeSinistre", column = @Column(name = "CODE_SINISTRE", nullable = false, length = 40)),
			@AttributeOverride(name = "codeVehicule", column = @Column(name = "CODE_VEHICULE", nullable = false, length = 30)) })
	public VehiculeSinistreId getId() {
		return this.id;
	}

	public void setId(VehiculeSinistreId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_SINISTRE", nullable = false, insertable = false, updatable = false)
	public Sinistre getSinistre() {
		return this.sinistre;
	}

	public void setSinistre(Sinistre sinistre) {
		this.sinistre = sinistre;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CODE_VEHICULE", nullable = false, insertable = false, updatable = false)
	public Vehicule getVehicule() {
		return this.vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	@Column(name = "LIEU_SINISTRE", length = 60)
	public String getLieuSinistre() {
		return this.lieuSinistre;
	}

	public void setLieuSinistre(String lieuSinistre) {
		this.lieuSinistre = lieuSinistre;
	}

	@Column(name = "NBRE_DECES")
	public Integer getNbreDeces() {
		return this.nbreDeces;
	}

	public void setNbreDeces(Integer nbreDeces) {
		this.nbreDeces = nbreDeces;
	}

	@Column(name = "NBRE_BLESSE")
	public Integer getNbreBlesse() {
		return this.nbreBlesse;
	}

	public void setNbreBlesse(Integer nbreBlesse) {
		this.nbreBlesse = nbreBlesse;
	}

	@Column(name = "RC_ASSURE", precision = 15, scale = 3)
	public BigDecimal getRcAssure() {
		return this.rcAssure;
	}

	public void setRcAssure(BigDecimal rcAssure) {
		this.rcAssure = rcAssure;
	}

	@Column(name = "DOMAGE_MAT")
	public Boolean getDomageMat() {
		return this.domageMat;
	}

	public void setDomageMat(Boolean domageMat) {
		this.domageMat = domageMat;
	}

	@Column(name = "DOMAGE_CORP")
	public Boolean getDomageCorp() {
		return this.domageCorp;
	}

	public void setDomageCorp(Boolean domageCorp) {
		this.domageCorp = domageCorp;
	}

	@Column(name = "LIBELLE_DOMAGE_MAT", length = 65535)
	public String getLibelleDomageMat() {
		return this.libelleDomageMat;
	}

	public void setLibelleDomageMat(String libelleDomageMat) {
		this.libelleDomageMat = libelleDomageMat;
	}

	@Column(name = "LIBELLE_DOMAGE_CORP", length = 65535)
	public String getLibelleDomageCorp() {
		return this.libelleDomageCorp;
	}

	public void setLibelleDomageCorp(String libelleDomageCorp) {
		this.libelleDomageCorp = libelleDomageCorp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_SINISTRE_AUTO", length = 19)
	public Date getDateSinistreAuto() {
		return this.dateSinistreAuto;
	}

	public void setDateSinistreAuto(Date dateSinistreAuto) {
		this.dateSinistreAuto = dateSinistreAuto;
	}

}
