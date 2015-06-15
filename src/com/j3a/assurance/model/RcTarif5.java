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
 * RcTarif5 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif5", catalog = "zeusbd")
public class RcTarif5 implements java.io.Serializable {

	private String codeRcTarif5;
	private Tarif tarif;
	private BigDecimal cyl1Zone1;
	private BigDecimal cyl1Zone2;
	private BigDecimal cyl1Zone3;
	private BigDecimal cyl2Zone1;
	private BigDecimal cyl2Zone2;
	private BigDecimal cyl2Zone3;
	private BigDecimal cyl3Zone1;
	private BigDecimal cyl3Zone2;
	private BigDecimal cyl3Zone3;
	private BigDecimal cyl4Zone1;
	private BigDecimal cyl4Zone2;
	private BigDecimal cyl4Zone3;
	private BigDecimal cyl5Zone1;
	private BigDecimal cyl5Zone2;
	private BigDecimal cyl5Zone3;
	private BigDecimal tandems1Zone1;
	private BigDecimal tandems1Zone2;
	private BigDecimal tandems1Zone3;
	private BigDecimal tandems2Zone1;
	private BigDecimal tandems2Zone2;
	private BigDecimal tandems2Zone3;
	private Set tarifs = new HashSet(0);

	public RcTarif5() {
	}

	public RcTarif5(String codeRcTarif5) {
		this.codeRcTarif5 = codeRcTarif5;
	}

	public RcTarif5(String codeRcTarif5, Tarif tarif, BigDecimal cyl1Zone1,
			BigDecimal cyl1Zone2, BigDecimal cyl1Zone3, BigDecimal cyl2Zone1,
			BigDecimal cyl2Zone2, BigDecimal cyl2Zone3, BigDecimal cyl3Zone1,
			BigDecimal cyl3Zone2, BigDecimal cyl3Zone3, BigDecimal cyl4Zone1,
			BigDecimal cyl4Zone2, BigDecimal cyl4Zone3, BigDecimal cyl5Zone1,
			BigDecimal cyl5Zone2, BigDecimal cyl5Zone3,
			BigDecimal tandems1Zone1, BigDecimal tandems1Zone2,
			BigDecimal tandems1Zone3, BigDecimal tandems2Zone1,
			BigDecimal tandems2Zone2, BigDecimal tandems2Zone3, Set tarifs) {
		this.codeRcTarif5 = codeRcTarif5;
		this.tarif = tarif;
		this.cyl1Zone1 = cyl1Zone1;
		this.cyl1Zone2 = cyl1Zone2;
		this.cyl1Zone3 = cyl1Zone3;
		this.cyl2Zone1 = cyl2Zone1;
		this.cyl2Zone2 = cyl2Zone2;
		this.cyl2Zone3 = cyl2Zone3;
		this.cyl3Zone1 = cyl3Zone1;
		this.cyl3Zone2 = cyl3Zone2;
		this.cyl3Zone3 = cyl3Zone3;
		this.cyl4Zone1 = cyl4Zone1;
		this.cyl4Zone2 = cyl4Zone2;
		this.cyl4Zone3 = cyl4Zone3;
		this.cyl5Zone1 = cyl5Zone1;
		this.cyl5Zone2 = cyl5Zone2;
		this.cyl5Zone3 = cyl5Zone3;
		this.tandems1Zone1 = tandems1Zone1;
		this.tandems1Zone2 = tandems1Zone2;
		this.tandems1Zone3 = tandems1Zone3;
		this.tandems2Zone1 = tandems2Zone1;
		this.tandems2Zone2 = tandems2Zone2;
		this.tandems2Zone3 = tandems2Zone3;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF5", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif5() {
		return this.codeRcTarif5;
	}

	public void setCodeRcTarif5(String codeRcTarif5) {
		this.codeRcTarif5 = codeRcTarif5;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_TARIF")
	public Tarif getTarif() {
		return this.tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	@Column(name = "CYL1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getCyl1Zone1() {
		return this.cyl1Zone1;
	}

	public void setCyl1Zone1(BigDecimal cyl1Zone1) {
		this.cyl1Zone1 = cyl1Zone1;
	}

	@Column(name = "CYL1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getCyl1Zone2() {
		return this.cyl1Zone2;
	}

	public void setCyl1Zone2(BigDecimal cyl1Zone2) {
		this.cyl1Zone2 = cyl1Zone2;
	}

	@Column(name = "CYL1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getCyl1Zone3() {
		return this.cyl1Zone3;
	}

	public void setCyl1Zone3(BigDecimal cyl1Zone3) {
		this.cyl1Zone3 = cyl1Zone3;
	}

	@Column(name = "CYL2_ZONE1", precision = 15, scale = 3)
	public BigDecimal getCyl2Zone1() {
		return this.cyl2Zone1;
	}

	public void setCyl2Zone1(BigDecimal cyl2Zone1) {
		this.cyl2Zone1 = cyl2Zone1;
	}

	@Column(name = "CYL2_ZONE2", precision = 15, scale = 3)
	public BigDecimal getCyl2Zone2() {
		return this.cyl2Zone2;
	}

	public void setCyl2Zone2(BigDecimal cyl2Zone2) {
		this.cyl2Zone2 = cyl2Zone2;
	}

	@Column(name = "CYL2_ZONE3", precision = 15, scale = 3)
	public BigDecimal getCyl2Zone3() {
		return this.cyl2Zone3;
	}

	public void setCyl2Zone3(BigDecimal cyl2Zone3) {
		this.cyl2Zone3 = cyl2Zone3;
	}

	@Column(name = "CYL3_ZONE1", precision = 15, scale = 3)
	public BigDecimal getCyl3Zone1() {
		return this.cyl3Zone1;
	}

	public void setCyl3Zone1(BigDecimal cyl3Zone1) {
		this.cyl3Zone1 = cyl3Zone1;
	}

	@Column(name = "CYL3_ZONE2", precision = 15, scale = 3)
	public BigDecimal getCyl3Zone2() {
		return this.cyl3Zone2;
	}

	public void setCyl3Zone2(BigDecimal cyl3Zone2) {
		this.cyl3Zone2 = cyl3Zone2;
	}

	@Column(name = "CYL3_ZONE3", precision = 15, scale = 3)
	public BigDecimal getCyl3Zone3() {
		return this.cyl3Zone3;
	}

	public void setCyl3Zone3(BigDecimal cyl3Zone3) {
		this.cyl3Zone3 = cyl3Zone3;
	}

	@Column(name = "CYL4_ZONE1", precision = 15, scale = 3)
	public BigDecimal getCyl4Zone1() {
		return this.cyl4Zone1;
	}

	public void setCyl4Zone1(BigDecimal cyl4Zone1) {
		this.cyl4Zone1 = cyl4Zone1;
	}

	@Column(name = "CYL4_ZONE2", precision = 15, scale = 3)
	public BigDecimal getCyl4Zone2() {
		return this.cyl4Zone2;
	}

	public void setCyl4Zone2(BigDecimal cyl4Zone2) {
		this.cyl4Zone2 = cyl4Zone2;
	}

	@Column(name = "CYL4_ZONE3", precision = 15, scale = 3)
	public BigDecimal getCyl4Zone3() {
		return this.cyl4Zone3;
	}

	public void setCyl4Zone3(BigDecimal cyl4Zone3) {
		this.cyl4Zone3 = cyl4Zone3;
	}

	@Column(name = "CYL5_ZONE1", precision = 15, scale = 3)
	public BigDecimal getCyl5Zone1() {
		return this.cyl5Zone1;
	}

	public void setCyl5Zone1(BigDecimal cyl5Zone1) {
		this.cyl5Zone1 = cyl5Zone1;
	}

	@Column(name = "CYL5_ZONE2", precision = 15, scale = 3)
	public BigDecimal getCyl5Zone2() {
		return this.cyl5Zone2;
	}

	public void setCyl5Zone2(BigDecimal cyl5Zone2) {
		this.cyl5Zone2 = cyl5Zone2;
	}

	@Column(name = "CYL5_ZONE3", precision = 15, scale = 3)
	public BigDecimal getCyl5Zone3() {
		return this.cyl5Zone3;
	}

	public void setCyl5Zone3(BigDecimal cyl5Zone3) {
		this.cyl5Zone3 = cyl5Zone3;
	}

	@Column(name = "TANDEMS1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getTandems1Zone1() {
		return this.tandems1Zone1;
	}

	public void setTandems1Zone1(BigDecimal tandems1Zone1) {
		this.tandems1Zone1 = tandems1Zone1;
	}

	@Column(name = "TANDEMS1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getTandems1Zone2() {
		return this.tandems1Zone2;
	}

	public void setTandems1Zone2(BigDecimal tandems1Zone2) {
		this.tandems1Zone2 = tandems1Zone2;
	}

	@Column(name = "TANDEMS1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getTandems1Zone3() {
		return this.tandems1Zone3;
	}

	public void setTandems1Zone3(BigDecimal tandems1Zone3) {
		this.tandems1Zone3 = tandems1Zone3;
	}

	@Column(name = "TANDEMS2_ZONE1", precision = 15, scale = 3)
	public BigDecimal getTandems2Zone1() {
		return this.tandems2Zone1;
	}

	public void setTandems2Zone1(BigDecimal tandems2Zone1) {
		this.tandems2Zone1 = tandems2Zone1;
	}

	@Column(name = "TANDEMS2_ZONE2", precision = 15, scale = 3)
	public BigDecimal getTandems2Zone2() {
		return this.tandems2Zone2;
	}

	public void setTandems2Zone2(BigDecimal tandems2Zone2) {
		this.tandems2Zone2 = tandems2Zone2;
	}

	@Column(name = "TANDEMS2_ZONE3", precision = 15, scale = 3)
	public BigDecimal getTandems2Zone3() {
		return this.tandems2Zone3;
	}

	public void setTandems2Zone3(BigDecimal tandems2Zone3) {
		this.tandems2Zone3 = tandems2Zone3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif5")
	public Set getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set tarifs) {
		this.tarifs = tarifs;
	}

}
