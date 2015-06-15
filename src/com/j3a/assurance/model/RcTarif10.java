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
 * RcTarif10 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif10", catalog = "zeusbd")
public class RcTarif10 implements java.io.Serializable {

	private String codeRcTarif10;
	private Tarif tarif;
	private BigDecimal paEss1Zone1;
	private BigDecimal paEss1Zone2;
	private BigDecimal paEss1Zone3;
	private BigDecimal paEss2Zone1;
	private BigDecimal paEss2Zone2;
	private BigDecimal paEss2Zone3;
	private BigDecimal paEss3Zone1;
	private BigDecimal paEss3Zone2;
	private BigDecimal paEss3Zone3;
	private BigDecimal paEss4Zone1;
	private BigDecimal paEss4Zone2;
	private BigDecimal paEss4Zone3;
	private BigDecimal paEss5Zone1;
	private BigDecimal paEss5Zone2;
	private BigDecimal paEss5Zone3;
	private BigDecimal paDies1Zone1;
	private BigDecimal paDies1Zone2;
	private BigDecimal paDies1Zone3;
	private BigDecimal paDies2Zone1;
	private BigDecimal paDies2Zone2;
	private BigDecimal paDies2Zone3;
	private BigDecimal paDies3Zone1;
	private BigDecimal paDies3Zone2;
	private BigDecimal paDies3Zone3;
	private BigDecimal paDies4Zone1;
	private BigDecimal paDies4Zone2;
	private BigDecimal paDies4Zone3;
	private BigDecimal paDies5Zone1;
	private BigDecimal paDies5Zone2;
	private BigDecimal paDies5Zone3;
	private Set tarifs = new HashSet(0);

	public RcTarif10() {
	}

	public RcTarif10(String codeRcTarif10) {
		this.codeRcTarif10 = codeRcTarif10;
	}

	public RcTarif10(String codeRcTarif10, Tarif tarif, BigDecimal paEss1Zone1,
			BigDecimal paEss1Zone2, BigDecimal paEss1Zone3,
			BigDecimal paEss2Zone1, BigDecimal paEss2Zone2,
			BigDecimal paEss2Zone3, BigDecimal paEss3Zone1,
			BigDecimal paEss3Zone2, BigDecimal paEss3Zone3,
			BigDecimal paEss4Zone1, BigDecimal paEss4Zone2,
			BigDecimal paEss4Zone3, BigDecimal paEss5Zone1,
			BigDecimal paEss5Zone2, BigDecimal paEss5Zone3,
			BigDecimal paDies1Zone1, BigDecimal paDies1Zone2,
			BigDecimal paDies1Zone3, BigDecimal paDies2Zone1,
			BigDecimal paDies2Zone2, BigDecimal paDies2Zone3,
			BigDecimal paDies3Zone1, BigDecimal paDies3Zone2,
			BigDecimal paDies3Zone3, BigDecimal paDies4Zone1,
			BigDecimal paDies4Zone2, BigDecimal paDies4Zone3,
			BigDecimal paDies5Zone1, BigDecimal paDies5Zone2,
			BigDecimal paDies5Zone3, Set tarifs) {
		this.codeRcTarif10 = codeRcTarif10;
		this.tarif = tarif;
		this.paEss1Zone1 = paEss1Zone1;
		this.paEss1Zone2 = paEss1Zone2;
		this.paEss1Zone3 = paEss1Zone3;
		this.paEss2Zone1 = paEss2Zone1;
		this.paEss2Zone2 = paEss2Zone2;
		this.paEss2Zone3 = paEss2Zone3;
		this.paEss3Zone1 = paEss3Zone1;
		this.paEss3Zone2 = paEss3Zone2;
		this.paEss3Zone3 = paEss3Zone3;
		this.paEss4Zone1 = paEss4Zone1;
		this.paEss4Zone2 = paEss4Zone2;
		this.paEss4Zone3 = paEss4Zone3;
		this.paEss5Zone1 = paEss5Zone1;
		this.paEss5Zone2 = paEss5Zone2;
		this.paEss5Zone3 = paEss5Zone3;
		this.paDies1Zone1 = paDies1Zone1;
		this.paDies1Zone2 = paDies1Zone2;
		this.paDies1Zone3 = paDies1Zone3;
		this.paDies2Zone1 = paDies2Zone1;
		this.paDies2Zone2 = paDies2Zone2;
		this.paDies2Zone3 = paDies2Zone3;
		this.paDies3Zone1 = paDies3Zone1;
		this.paDies3Zone2 = paDies3Zone2;
		this.paDies3Zone3 = paDies3Zone3;
		this.paDies4Zone1 = paDies4Zone1;
		this.paDies4Zone2 = paDies4Zone2;
		this.paDies4Zone3 = paDies4Zone3;
		this.paDies5Zone1 = paDies5Zone1;
		this.paDies5Zone2 = paDies5Zone2;
		this.paDies5Zone3 = paDies5Zone3;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF10", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif10() {
		return this.codeRcTarif10;
	}

	public void setCodeRcTarif10(String codeRcTarif10) {
		this.codeRcTarif10 = codeRcTarif10;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_TARIF")
	public Tarif getTarif() {
		return this.tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	@Column(name = "PA_ESS1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaEss1Zone1() {
		return this.paEss1Zone1;
	}

	public void setPaEss1Zone1(BigDecimal paEss1Zone1) {
		this.paEss1Zone1 = paEss1Zone1;
	}

	@Column(name = "PA_ESS1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaEss1Zone2() {
		return this.paEss1Zone2;
	}

	public void setPaEss1Zone2(BigDecimal paEss1Zone2) {
		this.paEss1Zone2 = paEss1Zone2;
	}

	@Column(name = "PA_ESS1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaEss1Zone3() {
		return this.paEss1Zone3;
	}

	public void setPaEss1Zone3(BigDecimal paEss1Zone3) {
		this.paEss1Zone3 = paEss1Zone3;
	}

	@Column(name = "PA_ESS2_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaEss2Zone1() {
		return this.paEss2Zone1;
	}

	public void setPaEss2Zone1(BigDecimal paEss2Zone1) {
		this.paEss2Zone1 = paEss2Zone1;
	}

	@Column(name = "PA_ESS2_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaEss2Zone2() {
		return this.paEss2Zone2;
	}

	public void setPaEss2Zone2(BigDecimal paEss2Zone2) {
		this.paEss2Zone2 = paEss2Zone2;
	}

	@Column(name = "PA_ESS2_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaEss2Zone3() {
		return this.paEss2Zone3;
	}

	public void setPaEss2Zone3(BigDecimal paEss2Zone3) {
		this.paEss2Zone3 = paEss2Zone3;
	}

	@Column(name = "PA_ESS3_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaEss3Zone1() {
		return this.paEss3Zone1;
	}

	public void setPaEss3Zone1(BigDecimal paEss3Zone1) {
		this.paEss3Zone1 = paEss3Zone1;
	}

	@Column(name = "PA_ESS3_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaEss3Zone2() {
		return this.paEss3Zone2;
	}

	public void setPaEss3Zone2(BigDecimal paEss3Zone2) {
		this.paEss3Zone2 = paEss3Zone2;
	}

	@Column(name = "PA_ESS3_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaEss3Zone3() {
		return this.paEss3Zone3;
	}

	public void setPaEss3Zone3(BigDecimal paEss3Zone3) {
		this.paEss3Zone3 = paEss3Zone3;
	}

	@Column(name = "PA_ESS4_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaEss4Zone1() {
		return this.paEss4Zone1;
	}

	public void setPaEss4Zone1(BigDecimal paEss4Zone1) {
		this.paEss4Zone1 = paEss4Zone1;
	}

	@Column(name = "PA_ESS4_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaEss4Zone2() {
		return this.paEss4Zone2;
	}

	public void setPaEss4Zone2(BigDecimal paEss4Zone2) {
		this.paEss4Zone2 = paEss4Zone2;
	}

	@Column(name = "PA_ESS4_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaEss4Zone3() {
		return this.paEss4Zone3;
	}

	public void setPaEss4Zone3(BigDecimal paEss4Zone3) {
		this.paEss4Zone3 = paEss4Zone3;
	}

	@Column(name = "PA_ESS5_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaEss5Zone1() {
		return this.paEss5Zone1;
	}

	public void setPaEss5Zone1(BigDecimal paEss5Zone1) {
		this.paEss5Zone1 = paEss5Zone1;
	}

	@Column(name = "PA_ESS5_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaEss5Zone2() {
		return this.paEss5Zone2;
	}

	public void setPaEss5Zone2(BigDecimal paEss5Zone2) {
		this.paEss5Zone2 = paEss5Zone2;
	}

	@Column(name = "PA_ESS5_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaEss5Zone3() {
		return this.paEss5Zone3;
	}

	public void setPaEss5Zone3(BigDecimal paEss5Zone3) {
		this.paEss5Zone3 = paEss5Zone3;
	}

	@Column(name = "PA_DIES1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaDies1Zone1() {
		return this.paDies1Zone1;
	}

	public void setPaDies1Zone1(BigDecimal paDies1Zone1) {
		this.paDies1Zone1 = paDies1Zone1;
	}

	@Column(name = "PA_DIES1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaDies1Zone2() {
		return this.paDies1Zone2;
	}

	public void setPaDies1Zone2(BigDecimal paDies1Zone2) {
		this.paDies1Zone2 = paDies1Zone2;
	}

	@Column(name = "PA_DIES1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaDies1Zone3() {
		return this.paDies1Zone3;
	}

	public void setPaDies1Zone3(BigDecimal paDies1Zone3) {
		this.paDies1Zone3 = paDies1Zone3;
	}

	@Column(name = "PA_DIES2_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaDies2Zone1() {
		return this.paDies2Zone1;
	}

	public void setPaDies2Zone1(BigDecimal paDies2Zone1) {
		this.paDies2Zone1 = paDies2Zone1;
	}

	@Column(name = "PA_DIES2_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaDies2Zone2() {
		return this.paDies2Zone2;
	}

	public void setPaDies2Zone2(BigDecimal paDies2Zone2) {
		this.paDies2Zone2 = paDies2Zone2;
	}

	@Column(name = "PA_DIES2_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaDies2Zone3() {
		return this.paDies2Zone3;
	}

	public void setPaDies2Zone3(BigDecimal paDies2Zone3) {
		this.paDies2Zone3 = paDies2Zone3;
	}

	@Column(name = "PA_DIES3_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaDies3Zone1() {
		return this.paDies3Zone1;
	}

	public void setPaDies3Zone1(BigDecimal paDies3Zone1) {
		this.paDies3Zone1 = paDies3Zone1;
	}

	@Column(name = "PA_DIES3_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaDies3Zone2() {
		return this.paDies3Zone2;
	}

	public void setPaDies3Zone2(BigDecimal paDies3Zone2) {
		this.paDies3Zone2 = paDies3Zone2;
	}

	@Column(name = "PA_DIES3_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaDies3Zone3() {
		return this.paDies3Zone3;
	}

	public void setPaDies3Zone3(BigDecimal paDies3Zone3) {
		this.paDies3Zone3 = paDies3Zone3;
	}

	@Column(name = "PA_DIES4_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaDies4Zone1() {
		return this.paDies4Zone1;
	}

	public void setPaDies4Zone1(BigDecimal paDies4Zone1) {
		this.paDies4Zone1 = paDies4Zone1;
	}

	@Column(name = "PA_DIES4_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaDies4Zone2() {
		return this.paDies4Zone2;
	}

	public void setPaDies4Zone2(BigDecimal paDies4Zone2) {
		this.paDies4Zone2 = paDies4Zone2;
	}

	@Column(name = "PA_DIES4_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaDies4Zone3() {
		return this.paDies4Zone3;
	}

	public void setPaDies4Zone3(BigDecimal paDies4Zone3) {
		this.paDies4Zone3 = paDies4Zone3;
	}

	@Column(name = "PA_DIES5_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPaDies5Zone1() {
		return this.paDies5Zone1;
	}

	public void setPaDies5Zone1(BigDecimal paDies5Zone1) {
		this.paDies5Zone1 = paDies5Zone1;
	}

	@Column(name = "PA_DIES5_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPaDies5Zone2() {
		return this.paDies5Zone2;
	}

	public void setPaDies5Zone2(BigDecimal paDies5Zone2) {
		this.paDies5Zone2 = paDies5Zone2;
	}

	@Column(name = "PA_DIES5_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPaDies5Zone3() {
		return this.paDies5Zone3;
	}

	public void setPaDies5Zone3(BigDecimal paDies5Zone3) {
		this.paDies5Zone3 = paDies5Zone3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif10")
	public Set getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set tarifs) {
		this.tarifs = tarifs;
	}

}
