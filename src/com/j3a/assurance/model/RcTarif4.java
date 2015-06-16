package com.j3a.assurance.model;

// Generated 16 juin 2015 16:25:09 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * RcTarif4 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif4", catalog = "zeusbd")
public class RcTarif4 implements java.io.Serializable {

	private String codeRcTarif4;
	private BigDecimal nbPlTaxi1Zone1;
	private BigDecimal nbPlTaxi1Zone2;
	private BigDecimal nbPlTaxi1Zone3;
	private BigDecimal nbPlTaxi2Zone1;
	private BigDecimal nbPlTaxi2Zone2;
	private BigDecimal nbPlTaxi2Zone3;
	private BigDecimal nbPlCar1Zone1;
	private BigDecimal nbPlCar1Zone2;
	private BigDecimal nbPlCar1Zone3;
	private BigDecimal nbPlCar2Zone1;
	private BigDecimal nbPlCar2Zone2;
	private BigDecimal nbPlCar2Zone3;
	private BigDecimal nbPlCar3Zone1;
	private BigDecimal nbPlCar3Zone2;
	private BigDecimal nbPlCar3Zone3;
	private Float tauxRemorquet4;
	private Float tauxPermis1t4;
	private Float tauxPermis2t4;
	private Set<Tarif> tarifs = new HashSet<Tarif>(0);

	public RcTarif4() {
	}

	public RcTarif4(String codeRcTarif4) {
		this.codeRcTarif4 = codeRcTarif4;
	}

	public RcTarif4(String codeRcTarif4, BigDecimal nbPlTaxi1Zone1,
			BigDecimal nbPlTaxi1Zone2, BigDecimal nbPlTaxi1Zone3,
			BigDecimal nbPlTaxi2Zone1, BigDecimal nbPlTaxi2Zone2,
			BigDecimal nbPlTaxi2Zone3, BigDecimal nbPlCar1Zone1,
			BigDecimal nbPlCar1Zone2, BigDecimal nbPlCar1Zone3,
			BigDecimal nbPlCar2Zone1, BigDecimal nbPlCar2Zone2,
			BigDecimal nbPlCar2Zone3, BigDecimal nbPlCar3Zone1,
			BigDecimal nbPlCar3Zone2, BigDecimal nbPlCar3Zone3,
			Float tauxRemorquet4, Float tauxPermis1t4, Float tauxPermis2t4,
			Set<Tarif> tarifs) {
		this.codeRcTarif4 = codeRcTarif4;
		this.nbPlTaxi1Zone1 = nbPlTaxi1Zone1;
		this.nbPlTaxi1Zone2 = nbPlTaxi1Zone2;
		this.nbPlTaxi1Zone3 = nbPlTaxi1Zone3;
		this.nbPlTaxi2Zone1 = nbPlTaxi2Zone1;
		this.nbPlTaxi2Zone2 = nbPlTaxi2Zone2;
		this.nbPlTaxi2Zone3 = nbPlTaxi2Zone3;
		this.nbPlCar1Zone1 = nbPlCar1Zone1;
		this.nbPlCar1Zone2 = nbPlCar1Zone2;
		this.nbPlCar1Zone3 = nbPlCar1Zone3;
		this.nbPlCar2Zone1 = nbPlCar2Zone1;
		this.nbPlCar2Zone2 = nbPlCar2Zone2;
		this.nbPlCar2Zone3 = nbPlCar2Zone3;
		this.nbPlCar3Zone1 = nbPlCar3Zone1;
		this.nbPlCar3Zone2 = nbPlCar3Zone2;
		this.nbPlCar3Zone3 = nbPlCar3Zone3;
		this.tauxRemorquet4 = tauxRemorquet4;
		this.tauxPermis1t4 = tauxPermis1t4;
		this.tauxPermis2t4 = tauxPermis2t4;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF4", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif4() {
		return this.codeRcTarif4;
	}

	public void setCodeRcTarif4(String codeRcTarif4) {
		this.codeRcTarif4 = codeRcTarif4;
	}

	@Column(name = "NB_PL_TAXI1_ZONE1", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi1Zone1() {
		return this.nbPlTaxi1Zone1;
	}

	public void setNbPlTaxi1Zone1(BigDecimal nbPlTaxi1Zone1) {
		this.nbPlTaxi1Zone1 = nbPlTaxi1Zone1;
	}

	@Column(name = "NB_PL_TAXI1_ZONE2", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi1Zone2() {
		return this.nbPlTaxi1Zone2;
	}

	public void setNbPlTaxi1Zone2(BigDecimal nbPlTaxi1Zone2) {
		this.nbPlTaxi1Zone2 = nbPlTaxi1Zone2;
	}

	@Column(name = "NB_PL_TAXI1_ZONE3", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi1Zone3() {
		return this.nbPlTaxi1Zone3;
	}

	public void setNbPlTaxi1Zone3(BigDecimal nbPlTaxi1Zone3) {
		this.nbPlTaxi1Zone3 = nbPlTaxi1Zone3;
	}

	@Column(name = "NB_PL_TAXI2_ZONE1", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi2Zone1() {
		return this.nbPlTaxi2Zone1;
	}

	public void setNbPlTaxi2Zone1(BigDecimal nbPlTaxi2Zone1) {
		this.nbPlTaxi2Zone1 = nbPlTaxi2Zone1;
	}

	@Column(name = "NB_PL_TAXI2_ZONE2", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi2Zone2() {
		return this.nbPlTaxi2Zone2;
	}

	public void setNbPlTaxi2Zone2(BigDecimal nbPlTaxi2Zone2) {
		this.nbPlTaxi2Zone2 = nbPlTaxi2Zone2;
	}

	@Column(name = "NB_PL_TAXI2_ZONE3", precision = 16, scale = 3)
	public BigDecimal getNbPlTaxi2Zone3() {
		return this.nbPlTaxi2Zone3;
	}

	public void setNbPlTaxi2Zone3(BigDecimal nbPlTaxi2Zone3) {
		this.nbPlTaxi2Zone3 = nbPlTaxi2Zone3;
	}

	@Column(name = "NB_PL_CAR1_ZONE1", precision = 16, scale = 3)
	public BigDecimal getNbPlCar1Zone1() {
		return this.nbPlCar1Zone1;
	}

	public void setNbPlCar1Zone1(BigDecimal nbPlCar1Zone1) {
		this.nbPlCar1Zone1 = nbPlCar1Zone1;
	}

	@Column(name = "NB_PL_CAR1_ZONE2", precision = 16, scale = 3)
	public BigDecimal getNbPlCar1Zone2() {
		return this.nbPlCar1Zone2;
	}

	public void setNbPlCar1Zone2(BigDecimal nbPlCar1Zone2) {
		this.nbPlCar1Zone2 = nbPlCar1Zone2;
	}

	@Column(name = "NB_PL_CAR1_ZONE3", precision = 16, scale = 3)
	public BigDecimal getNbPlCar1Zone3() {
		return this.nbPlCar1Zone3;
	}

	public void setNbPlCar1Zone3(BigDecimal nbPlCar1Zone3) {
		this.nbPlCar1Zone3 = nbPlCar1Zone3;
	}

	@Column(name = "NB_PL_CAR2_ZONE1", precision = 16, scale = 3)
	public BigDecimal getNbPlCar2Zone1() {
		return this.nbPlCar2Zone1;
	}

	public void setNbPlCar2Zone1(BigDecimal nbPlCar2Zone1) {
		this.nbPlCar2Zone1 = nbPlCar2Zone1;
	}

	@Column(name = "NB_PL_CAR2_ZONE2", precision = 16, scale = 3)
	public BigDecimal getNbPlCar2Zone2() {
		return this.nbPlCar2Zone2;
	}

	public void setNbPlCar2Zone2(BigDecimal nbPlCar2Zone2) {
		this.nbPlCar2Zone2 = nbPlCar2Zone2;
	}

	@Column(name = "NB_PL_CAR2_ZONE3", precision = 16, scale = 3)
	public BigDecimal getNbPlCar2Zone3() {
		return this.nbPlCar2Zone3;
	}

	public void setNbPlCar2Zone3(BigDecimal nbPlCar2Zone3) {
		this.nbPlCar2Zone3 = nbPlCar2Zone3;
	}

	@Column(name = "NB_PL_CAR3_ZONE1", precision = 15, scale = 3)
	public BigDecimal getNbPlCar3Zone1() {
		return this.nbPlCar3Zone1;
	}

	public void setNbPlCar3Zone1(BigDecimal nbPlCar3Zone1) {
		this.nbPlCar3Zone1 = nbPlCar3Zone1;
	}

	@Column(name = "NB_PL_CAR3_ZONE2", precision = 16, scale = 3)
	public BigDecimal getNbPlCar3Zone2() {
		return this.nbPlCar3Zone2;
	}

	public void setNbPlCar3Zone2(BigDecimal nbPlCar3Zone2) {
		this.nbPlCar3Zone2 = nbPlCar3Zone2;
	}

	@Column(name = "NB_PL_CAR3_ZONE3", precision = 16, scale = 3)
	public BigDecimal getNbPlCar3Zone3() {
		return this.nbPlCar3Zone3;
	}

	public void setNbPlCar3Zone3(BigDecimal nbPlCar3Zone3) {
		this.nbPlCar3Zone3 = nbPlCar3Zone3;
	}

	@Column(name = "TAUX_REMORQUET4", precision = 12, scale = 0)
	public Float getTauxRemorquet4() {
		return this.tauxRemorquet4;
	}

	public void setTauxRemorquet4(Float tauxRemorquet4) {
		this.tauxRemorquet4 = tauxRemorquet4;
	}

	@Column(name = "TAUX_PERMIS1T4", precision = 12, scale = 0)
	public Float getTauxPermis1t4() {
		return this.tauxPermis1t4;
	}

	public void setTauxPermis1t4(Float tauxPermis1t4) {
		this.tauxPermis1t4 = tauxPermis1t4;
	}

	@Column(name = "TAUX_PERMIS2T4", precision = 12, scale = 0)
	public Float getTauxPermis2t4() {
		return this.tauxPermis2t4;
	}

	public void setTauxPermis2t4(Float tauxPermis2t4) {
		this.tauxPermis2t4 = tauxPermis2t4;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif4")
	public Set<Tarif> getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

}
