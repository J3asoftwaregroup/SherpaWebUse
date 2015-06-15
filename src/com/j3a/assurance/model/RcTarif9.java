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
 * RcTarif9 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif9", catalog = "zeusbd")
public class RcTarif9 implements java.io.Serializable {

	private String codeRcTarif9;
	private Tarif tarif;
	private BigDecimal vhlSrZone1;
	private BigDecimal vhlSrZone2;
	private BigDecimal vhlSrZone3;
	private BigDecimal vhlRemorqueZone1;
	private BigDecimal vhlRemorqueZone2;
	private BigDecimal vhlRemorqueZone3;
	private Set tarifs = new HashSet(0);

	public RcTarif9() {
	}

	public RcTarif9(String codeRcTarif9) {
		this.codeRcTarif9 = codeRcTarif9;
	}

	public RcTarif9(String codeRcTarif9, Tarif tarif, BigDecimal vhlSrZone1,
			BigDecimal vhlSrZone2, BigDecimal vhlSrZone3,
			BigDecimal vhlRemorqueZone1, BigDecimal vhlRemorqueZone2,
			BigDecimal vhlRemorqueZone3, Set tarifs) {
		this.codeRcTarif9 = codeRcTarif9;
		this.tarif = tarif;
		this.vhlSrZone1 = vhlSrZone1;
		this.vhlSrZone2 = vhlSrZone2;
		this.vhlSrZone3 = vhlSrZone3;
		this.vhlRemorqueZone1 = vhlRemorqueZone1;
		this.vhlRemorqueZone2 = vhlRemorqueZone2;
		this.vhlRemorqueZone3 = vhlRemorqueZone3;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF9", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif9() {
		return this.codeRcTarif9;
	}

	public void setCodeRcTarif9(String codeRcTarif9) {
		this.codeRcTarif9 = codeRcTarif9;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_TARIF")
	public Tarif getTarif() {
		return this.tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	@Column(name = "VHL_SR_ZONE1", precision = 16, scale = 3)
	public BigDecimal getVhlSrZone1() {
		return this.vhlSrZone1;
	}

	public void setVhlSrZone1(BigDecimal vhlSrZone1) {
		this.vhlSrZone1 = vhlSrZone1;
	}

	@Column(name = "VHL_SR_ZONE2", precision = 16, scale = 3)
	public BigDecimal getVhlSrZone2() {
		return this.vhlSrZone2;
	}

	public void setVhlSrZone2(BigDecimal vhlSrZone2) {
		this.vhlSrZone2 = vhlSrZone2;
	}

	@Column(name = "VHL_SR_ZONE3", precision = 16, scale = 3)
	public BigDecimal getVhlSrZone3() {
		return this.vhlSrZone3;
	}

	public void setVhlSrZone3(BigDecimal vhlSrZone3) {
		this.vhlSrZone3 = vhlSrZone3;
	}

	@Column(name = "VHL_REMORQUE_ZONE1", precision = 16, scale = 3)
	public BigDecimal getVhlRemorqueZone1() {
		return this.vhlRemorqueZone1;
	}

	public void setVhlRemorqueZone1(BigDecimal vhlRemorqueZone1) {
		this.vhlRemorqueZone1 = vhlRemorqueZone1;
	}

	@Column(name = "VHL_REMORQUE_ZONE2", precision = 16, scale = 3)
	public BigDecimal getVhlRemorqueZone2() {
		return this.vhlRemorqueZone2;
	}

	public void setVhlRemorqueZone2(BigDecimal vhlRemorqueZone2) {
		this.vhlRemorqueZone2 = vhlRemorqueZone2;
	}

	@Column(name = "VHL_REMORQUE_ZONE3", precision = 16, scale = 3)
	public BigDecimal getVhlRemorqueZone3() {
		return this.vhlRemorqueZone3;
	}

	public void setVhlRemorqueZone3(BigDecimal vhlRemorqueZone3) {
		this.vhlRemorqueZone3 = vhlRemorqueZone3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif9")
	public Set getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set tarifs) {
		this.tarifs = tarifs;
	}

}