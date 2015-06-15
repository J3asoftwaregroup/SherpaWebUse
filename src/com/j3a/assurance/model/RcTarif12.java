package com.j3a.assurance.model;

// Generated 15 juin 2015 12:08:18 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * RcTarif12 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif12", catalog = "zeusbd")
public class RcTarif12 implements java.io.Serializable {

	private String codeRcTarif12;
	private Tarif tarif;
	private BigDecimal pfEss1t12Zone1;
	private BigDecimal pfEss2t12Zone1;
	private BigDecimal pfEss3t12Zone1;
	private BigDecimal pfEss4t12Zone1;
	private BigDecimal pfEss5t12Zone1;
	private BigDecimal pfEss1t12Zone2;
	private BigDecimal pfEss2t12Zone2;
	private BigDecimal pfEss3t12Zone2;
	private BigDecimal pfEss4t12Zone2;
	private BigDecimal pfEss5t12Zone2;
	private BigDecimal pfEss1t12Zone3;
	private BigDecimal pfEss2t12Zone3;
	private BigDecimal pfEss3t12Zone3;
	private BigDecimal pfEss4t12Zone3;
	private BigDecimal pfEss5t12Zone3;
	private BigDecimal pfDie1t12Zone1;
	private BigDecimal pfDie2t12Zone1;
	private BigDecimal pfDie3t12Zone1;
	private BigDecimal pfDie4t12Zone1;
	private BigDecimal pfDie5t12Zone1;
	private BigDecimal pfDie1t12Zone2;
	private BigDecimal pfDie2t12Zone2;
	private BigDecimal pfDie3t12Zone2;
	private BigDecimal pfDie4t12Zone2;
	private BigDecimal pfDie5t12Zone2;
	private BigDecimal pfDie1t12Zone3;
	private BigDecimal pfDie2t12Zone3;
	private BigDecimal pfDie3t12Zone3;
	private BigDecimal pfDie4t12Zone3;
	private BigDecimal pfDie5t12Zone3;
	private Float tauxMajredt12Remorque;
	private Float tauxMajredt12Permi1;
	private Float tauxMajredt12Permis2;
	private Float tauxMajredt12Statutproa;
	private Float tauxMajredt12Statutprob;
	private Float tauxMajredt12Statutproc;
	private Float tauxMajredt12Statutproautres;
	private Set tarifs = new HashSet(0);

	public RcTarif12() {
	}

	public RcTarif12(String codeRcTarif12) {
		this.codeRcTarif12 = codeRcTarif12;
	}

	public RcTarif12(String codeRcTarif12, Tarif tarif,
			BigDecimal pfEss1t12Zone1, BigDecimal pfEss2t12Zone1,
			BigDecimal pfEss3t12Zone1, BigDecimal pfEss4t12Zone1,
			BigDecimal pfEss5t12Zone1, BigDecimal pfEss1t12Zone2,
			BigDecimal pfEss2t12Zone2, BigDecimal pfEss3t12Zone2,
			BigDecimal pfEss4t12Zone2, BigDecimal pfEss5t12Zone2,
			BigDecimal pfEss1t12Zone3, BigDecimal pfEss2t12Zone3,
			BigDecimal pfEss3t12Zone3, BigDecimal pfEss4t12Zone3,
			BigDecimal pfEss5t12Zone3, BigDecimal pfDie1t12Zone1,
			BigDecimal pfDie2t12Zone1, BigDecimal pfDie3t12Zone1,
			BigDecimal pfDie4t12Zone1, BigDecimal pfDie5t12Zone1,
			BigDecimal pfDie1t12Zone2, BigDecimal pfDie2t12Zone2,
			BigDecimal pfDie3t12Zone2, BigDecimal pfDie4t12Zone2,
			BigDecimal pfDie5t12Zone2, BigDecimal pfDie1t12Zone3,
			BigDecimal pfDie2t12Zone3, BigDecimal pfDie3t12Zone3,
			BigDecimal pfDie4t12Zone3, BigDecimal pfDie5t12Zone3,
			Float tauxMajredt12Remorque, Float tauxMajredt12Permi1,
			Float tauxMajredt12Permis2, Float tauxMajredt12Statutproa,
			Float tauxMajredt12Statutprob, Float tauxMajredt12Statutproc,
			Float tauxMajredt12Statutproautres, Set tarifs) {
		this.codeRcTarif12 = codeRcTarif12;
		this.tarif = tarif;
		this.pfEss1t12Zone1 = pfEss1t12Zone1;
		this.pfEss2t12Zone1 = pfEss2t12Zone1;
		this.pfEss3t12Zone1 = pfEss3t12Zone1;
		this.pfEss4t12Zone1 = pfEss4t12Zone1;
		this.pfEss5t12Zone1 = pfEss5t12Zone1;
		this.pfEss1t12Zone2 = pfEss1t12Zone2;
		this.pfEss2t12Zone2 = pfEss2t12Zone2;
		this.pfEss3t12Zone2 = pfEss3t12Zone2;
		this.pfEss4t12Zone2 = pfEss4t12Zone2;
		this.pfEss5t12Zone2 = pfEss5t12Zone2;
		this.pfEss1t12Zone3 = pfEss1t12Zone3;
		this.pfEss2t12Zone3 = pfEss2t12Zone3;
		this.pfEss3t12Zone3 = pfEss3t12Zone3;
		this.pfEss4t12Zone3 = pfEss4t12Zone3;
		this.pfEss5t12Zone3 = pfEss5t12Zone3;
		this.pfDie1t12Zone1 = pfDie1t12Zone1;
		this.pfDie2t12Zone1 = pfDie2t12Zone1;
		this.pfDie3t12Zone1 = pfDie3t12Zone1;
		this.pfDie4t12Zone1 = pfDie4t12Zone1;
		this.pfDie5t12Zone1 = pfDie5t12Zone1;
		this.pfDie1t12Zone2 = pfDie1t12Zone2;
		this.pfDie2t12Zone2 = pfDie2t12Zone2;
		this.pfDie3t12Zone2 = pfDie3t12Zone2;
		this.pfDie4t12Zone2 = pfDie4t12Zone2;
		this.pfDie5t12Zone2 = pfDie5t12Zone2;
		this.pfDie1t12Zone3 = pfDie1t12Zone3;
		this.pfDie2t12Zone3 = pfDie2t12Zone3;
		this.pfDie3t12Zone3 = pfDie3t12Zone3;
		this.pfDie4t12Zone3 = pfDie4t12Zone3;
		this.pfDie5t12Zone3 = pfDie5t12Zone3;
		this.tauxMajredt12Remorque = tauxMajredt12Remorque;
		this.tauxMajredt12Permi1 = tauxMajredt12Permi1;
		this.tauxMajredt12Permis2 = tauxMajredt12Permis2;
		this.tauxMajredt12Statutproa = tauxMajredt12Statutproa;
		this.tauxMajredt12Statutprob = tauxMajredt12Statutprob;
		this.tauxMajredt12Statutproc = tauxMajredt12Statutproc;
		this.tauxMajredt12Statutproautres = tauxMajredt12Statutproautres;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF12", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif12() {
		return this.codeRcTarif12;
	}

	public void setCodeRcTarif12(String codeRcTarif12) {
		this.codeRcTarif12 = codeRcTarif12;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_TARIF")
	public Tarif getTarif() {
		return this.tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	@Column(name = "PF_ESS1T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfEss1t12Zone1() {
		return this.pfEss1t12Zone1;
	}

	public void setPfEss1t12Zone1(BigDecimal pfEss1t12Zone1) {
		this.pfEss1t12Zone1 = pfEss1t12Zone1;
	}

	@Column(name = "PF_ESS2T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfEss2t12Zone1() {
		return this.pfEss2t12Zone1;
	}

	public void setPfEss2t12Zone1(BigDecimal pfEss2t12Zone1) {
		this.pfEss2t12Zone1 = pfEss2t12Zone1;
	}

	@Column(name = "PF_ESS3T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfEss3t12Zone1() {
		return this.pfEss3t12Zone1;
	}

	public void setPfEss3t12Zone1(BigDecimal pfEss3t12Zone1) {
		this.pfEss3t12Zone1 = pfEss3t12Zone1;
	}

	@Column(name = "PF_ESS4T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfEss4t12Zone1() {
		return this.pfEss4t12Zone1;
	}

	public void setPfEss4t12Zone1(BigDecimal pfEss4t12Zone1) {
		this.pfEss4t12Zone1 = pfEss4t12Zone1;
	}

	@Column(name = "PF_ESS5T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfEss5t12Zone1() {
		return this.pfEss5t12Zone1;
	}

	public void setPfEss5t12Zone1(BigDecimal pfEss5t12Zone1) {
		this.pfEss5t12Zone1 = pfEss5t12Zone1;
	}

	@Column(name = "PF_ESS1T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfEss1t12Zone2() {
		return this.pfEss1t12Zone2;
	}

	public void setPfEss1t12Zone2(BigDecimal pfEss1t12Zone2) {
		this.pfEss1t12Zone2 = pfEss1t12Zone2;
	}

	@Column(name = "PF_ESS2T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfEss2t12Zone2() {
		return this.pfEss2t12Zone2;
	}

	public void setPfEss2t12Zone2(BigDecimal pfEss2t12Zone2) {
		this.pfEss2t12Zone2 = pfEss2t12Zone2;
	}

	@Column(name = "PF_ESS3T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfEss3t12Zone2() {
		return this.pfEss3t12Zone2;
	}

	public void setPfEss3t12Zone2(BigDecimal pfEss3t12Zone2) {
		this.pfEss3t12Zone2 = pfEss3t12Zone2;
	}

	@Column(name = "PF_ESS4T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfEss4t12Zone2() {
		return this.pfEss4t12Zone2;
	}

	public void setPfEss4t12Zone2(BigDecimal pfEss4t12Zone2) {
		this.pfEss4t12Zone2 = pfEss4t12Zone2;
	}

	@Column(name = "PF_ESS5T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfEss5t12Zone2() {
		return this.pfEss5t12Zone2;
	}

	public void setPfEss5t12Zone2(BigDecimal pfEss5t12Zone2) {
		this.pfEss5t12Zone2 = pfEss5t12Zone2;
	}

	@Column(name = "PF_ESS1T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfEss1t12Zone3() {
		return this.pfEss1t12Zone3;
	}

	public void setPfEss1t12Zone3(BigDecimal pfEss1t12Zone3) {
		this.pfEss1t12Zone3 = pfEss1t12Zone3;
	}

	@Column(name = "PF_ESS2T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfEss2t12Zone3() {
		return this.pfEss2t12Zone3;
	}

	public void setPfEss2t12Zone3(BigDecimal pfEss2t12Zone3) {
		this.pfEss2t12Zone3 = pfEss2t12Zone3;
	}

	@Column(name = "PF_ESS3T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfEss3t12Zone3() {
		return this.pfEss3t12Zone3;
	}

	public void setPfEss3t12Zone3(BigDecimal pfEss3t12Zone3) {
		this.pfEss3t12Zone3 = pfEss3t12Zone3;
	}

	@Column(name = "PF_ESS4T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfEss4t12Zone3() {
		return this.pfEss4t12Zone3;
	}

	public void setPfEss4t12Zone3(BigDecimal pfEss4t12Zone3) {
		this.pfEss4t12Zone3 = pfEss4t12Zone3;
	}

	@Column(name = "PF_ESS5T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfEss5t12Zone3() {
		return this.pfEss5t12Zone3;
	}

	public void setPfEss5t12Zone3(BigDecimal pfEss5t12Zone3) {
		this.pfEss5t12Zone3 = pfEss5t12Zone3;
	}

	@Column(name = "PF_DIE1T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfDie1t12Zone1() {
		return this.pfDie1t12Zone1;
	}

	public void setPfDie1t12Zone1(BigDecimal pfDie1t12Zone1) {
		this.pfDie1t12Zone1 = pfDie1t12Zone1;
	}

	@Column(name = "PF_DIE2T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfDie2t12Zone1() {
		return this.pfDie2t12Zone1;
	}

	public void setPfDie2t12Zone1(BigDecimal pfDie2t12Zone1) {
		this.pfDie2t12Zone1 = pfDie2t12Zone1;
	}

	@Column(name = "PF_DIE3T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfDie3t12Zone1() {
		return this.pfDie3t12Zone1;
	}

	public void setPfDie3t12Zone1(BigDecimal pfDie3t12Zone1) {
		this.pfDie3t12Zone1 = pfDie3t12Zone1;
	}

	@Column(name = "PF_DIE4T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfDie4t12Zone1() {
		return this.pfDie4t12Zone1;
	}

	public void setPfDie4t12Zone1(BigDecimal pfDie4t12Zone1) {
		this.pfDie4t12Zone1 = pfDie4t12Zone1;
	}

	@Column(name = "PF_DIE5T12_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfDie5t12Zone1() {
		return this.pfDie5t12Zone1;
	}

	public void setPfDie5t12Zone1(BigDecimal pfDie5t12Zone1) {
		this.pfDie5t12Zone1 = pfDie5t12Zone1;
	}

	@Column(name = "PF_DIE1T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfDie1t12Zone2() {
		return this.pfDie1t12Zone2;
	}

	public void setPfDie1t12Zone2(BigDecimal pfDie1t12Zone2) {
		this.pfDie1t12Zone2 = pfDie1t12Zone2;
	}

	@Column(name = "PF_DIE2T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfDie2t12Zone2() {
		return this.pfDie2t12Zone2;
	}

	public void setPfDie2t12Zone2(BigDecimal pfDie2t12Zone2) {
		this.pfDie2t12Zone2 = pfDie2t12Zone2;
	}

	@Column(name = "PF_DIE3T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfDie3t12Zone2() {
		return this.pfDie3t12Zone2;
	}

	public void setPfDie3t12Zone2(BigDecimal pfDie3t12Zone2) {
		this.pfDie3t12Zone2 = pfDie3t12Zone2;
	}

	@Column(name = "PF_DIE4T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfDie4t12Zone2() {
		return this.pfDie4t12Zone2;
	}

	public void setPfDie4t12Zone2(BigDecimal pfDie4t12Zone2) {
		this.pfDie4t12Zone2 = pfDie4t12Zone2;
	}

	@Column(name = "PF_DIE5T12_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfDie5t12Zone2() {
		return this.pfDie5t12Zone2;
	}

	public void setPfDie5t12Zone2(BigDecimal pfDie5t12Zone2) {
		this.pfDie5t12Zone2 = pfDie5t12Zone2;
	}

	@Column(name = "PF_DIE1T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfDie1t12Zone3() {
		return this.pfDie1t12Zone3;
	}

	public void setPfDie1t12Zone3(BigDecimal pfDie1t12Zone3) {
		this.pfDie1t12Zone3 = pfDie1t12Zone3;
	}

	@Column(name = "PF_DIE2T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfDie2t12Zone3() {
		return this.pfDie2t12Zone3;
	}

	public void setPfDie2t12Zone3(BigDecimal pfDie2t12Zone3) {
		this.pfDie2t12Zone3 = pfDie2t12Zone3;
	}

	@Column(name = "PF_DIE3T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfDie3t12Zone3() {
		return this.pfDie3t12Zone3;
	}

	public void setPfDie3t12Zone3(BigDecimal pfDie3t12Zone3) {
		this.pfDie3t12Zone3 = pfDie3t12Zone3;
	}

	@Column(name = "PF_DIE4T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfDie4t12Zone3() {
		return this.pfDie4t12Zone3;
	}

	public void setPfDie4t12Zone3(BigDecimal pfDie4t12Zone3) {
		this.pfDie4t12Zone3 = pfDie4t12Zone3;
	}

	@Column(name = "PF_DIE5T12_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfDie5t12Zone3() {
		return this.pfDie5t12Zone3;
	}

	public void setPfDie5t12Zone3(BigDecimal pfDie5t12Zone3) {
		this.pfDie5t12Zone3 = pfDie5t12Zone3;
	}

	@Column(name = "TAUX_MAJREDT12_REMORQUE", precision = 12, scale = 0)
	public Float getTauxMajredt12Remorque() {
		return this.tauxMajredt12Remorque;
	}

	public void setTauxMajredt12Remorque(Float tauxMajredt12Remorque) {
		this.tauxMajredt12Remorque = tauxMajredt12Remorque;
	}

	@Column(name = "TAUX_MAJREDT12_PERMI1", precision = 12, scale = 0)
	public Float getTauxMajredt12Permi1() {
		return this.tauxMajredt12Permi1;
	}

	public void setTauxMajredt12Permi1(Float tauxMajredt12Permi1) {
		this.tauxMajredt12Permi1 = tauxMajredt12Permi1;
	}

	@Column(name = "TAUX_MAJREDT12_PERMIS2", precision = 12, scale = 0)
	public Float getTauxMajredt12Permis2() {
		return this.tauxMajredt12Permis2;
	}

	public void setTauxMajredt12Permis2(Float tauxMajredt12Permis2) {
		this.tauxMajredt12Permis2 = tauxMajredt12Permis2;
	}

	@Column(name = "TAUX_MAJREDT12_STATUTPROA", precision = 12, scale = 0)
	public Float getTauxMajredt12Statutproa() {
		return this.tauxMajredt12Statutproa;
	}

	public void setTauxMajredt12Statutproa(Float tauxMajredt12Statutproa) {
		this.tauxMajredt12Statutproa = tauxMajredt12Statutproa;
	}

	@Column(name = "TAUX_MAJREDT12_STATUTPROB", precision = 12, scale = 0)
	public Float getTauxMajredt12Statutprob() {
		return this.tauxMajredt12Statutprob;
	}

	public void setTauxMajredt12Statutprob(Float tauxMajredt12Statutprob) {
		this.tauxMajredt12Statutprob = tauxMajredt12Statutprob;
	}

	@Column(name = "TAUX_MAJREDT12_STATUTPROC", precision = 12, scale = 0)
	public Float getTauxMajredt12Statutproc() {
		return this.tauxMajredt12Statutproc;
	}

	public void setTauxMajredt12Statutproc(Float tauxMajredt12Statutproc) {
		this.tauxMajredt12Statutproc = tauxMajredt12Statutproc;
	}

	@Column(name = "TAUX_MAJREDT12_STATUTPROAUTRES", precision = 12, scale = 0)
	public Float getTauxMajredt12Statutproautres() {
		return this.tauxMajredt12Statutproautres;
	}

	public void setTauxMajredt12Statutproautres(
			Float tauxMajredt12Statutproautres) {
		this.tauxMajredt12Statutproautres = tauxMajredt12Statutproautres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif12")
	public Set getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set tarifs) {
		this.tarifs = tarifs;
	}

}