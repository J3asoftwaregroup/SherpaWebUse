package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

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
 * RcTarif1 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif1", catalog = "zeusbd")
public class RcTarif1 implements java.io.Serializable {

	private String codeRcTarif1;
	private BigDecimal pfE12d1Zone1;
	private BigDecimal pfE12d1Zone2;
	private BigDecimal pfE12d1Zone3;
	private BigDecimal pfE36d24Zone1;
	private BigDecimal pfE36d24Zone2;
	private BigDecimal pfE36d24Zone3;
	private BigDecimal pfE79d56Zone1;
	private BigDecimal pfE79d56Zone2;
	private BigDecimal pfE79d56Zone3;
	private BigDecimal pfE1011d78Zone1;
	private BigDecimal pfE1011d78Zone2;
	private BigDecimal pfE1011d78Zone3;
	private BigDecimal pfE12d9Zone1;
	private BigDecimal pfE12d9Zone2;
	private BigDecimal pfE12d9Zone3;
	private Float tauxMajredRemorque;
	private Float tauxMajredPermi1;
	private Float tauxMajredPermis2;
	private Float tauxMajredStatutproa;
	private Float tauxMajredStatutprob;
	private Float tauxMajredStatutproc;
	private Float tauxMajredStatutprod;
	private Float tauxMajredStatutproe;
	private Float tauxMajredStatutproautres;
	private Set<Tarif> tarifs = new HashSet<Tarif>(0);

	public RcTarif1() {
	}

	public RcTarif1(String codeRcTarif1) {
		this.codeRcTarif1 = codeRcTarif1;
	}

	public RcTarif1(String codeRcTarif1, BigDecimal pfE12d1Zone1,
			BigDecimal pfE12d1Zone2, BigDecimal pfE12d1Zone3,
			BigDecimal pfE36d24Zone1, BigDecimal pfE36d24Zone2,
			BigDecimal pfE36d24Zone3, BigDecimal pfE79d56Zone1,
			BigDecimal pfE79d56Zone2, BigDecimal pfE79d56Zone3,
			BigDecimal pfE1011d78Zone1, BigDecimal pfE1011d78Zone2,
			BigDecimal pfE1011d78Zone3, BigDecimal pfE12d9Zone1,
			BigDecimal pfE12d9Zone2, BigDecimal pfE12d9Zone3,
			Float tauxMajredRemorque, Float tauxMajredPermi1,
			Float tauxMajredPermis2, Float tauxMajredStatutproa,
			Float tauxMajredStatutprob, Float tauxMajredStatutproc,
			Float tauxMajredStatutprod, Float tauxMajredStatutproe,
			Float tauxMajredStatutproautres, Set<Tarif> tarifs) {
		this.codeRcTarif1 = codeRcTarif1;
		this.pfE12d1Zone1 = pfE12d1Zone1;
		this.pfE12d1Zone2 = pfE12d1Zone2;
		this.pfE12d1Zone3 = pfE12d1Zone3;
		this.pfE36d24Zone1 = pfE36d24Zone1;
		this.pfE36d24Zone2 = pfE36d24Zone2;
		this.pfE36d24Zone3 = pfE36d24Zone3;
		this.pfE79d56Zone1 = pfE79d56Zone1;
		this.pfE79d56Zone2 = pfE79d56Zone2;
		this.pfE79d56Zone3 = pfE79d56Zone3;
		this.pfE1011d78Zone1 = pfE1011d78Zone1;
		this.pfE1011d78Zone2 = pfE1011d78Zone2;
		this.pfE1011d78Zone3 = pfE1011d78Zone3;
		this.pfE12d9Zone1 = pfE12d9Zone1;
		this.pfE12d9Zone2 = pfE12d9Zone2;
		this.pfE12d9Zone3 = pfE12d9Zone3;
		this.tauxMajredRemorque = tauxMajredRemorque;
		this.tauxMajredPermi1 = tauxMajredPermi1;
		this.tauxMajredPermis2 = tauxMajredPermis2;
		this.tauxMajredStatutproa = tauxMajredStatutproa;
		this.tauxMajredStatutprob = tauxMajredStatutprob;
		this.tauxMajredStatutproc = tauxMajredStatutproc;
		this.tauxMajredStatutprod = tauxMajredStatutprod;
		this.tauxMajredStatutproe = tauxMajredStatutproe;
		this.tauxMajredStatutproautres = tauxMajredStatutproautres;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF1", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif1() {
		return this.codeRcTarif1;
	}

	public void setCodeRcTarif1(String codeRcTarif1) {
		this.codeRcTarif1 = codeRcTarif1;
	}

	@Column(name = "PF_E12D1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfE12d1Zone1() {
		return this.pfE12d1Zone1;
	}

	public void setPfE12d1Zone1(BigDecimal pfE12d1Zone1) {
		this.pfE12d1Zone1 = pfE12d1Zone1;
	}

	@Column(name = "PF_E12D1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfE12d1Zone2() {
		return this.pfE12d1Zone2;
	}

	public void setPfE12d1Zone2(BigDecimal pfE12d1Zone2) {
		this.pfE12d1Zone2 = pfE12d1Zone2;
	}

	@Column(name = "PF_E12D1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfE12d1Zone3() {
		return this.pfE12d1Zone3;
	}

	public void setPfE12d1Zone3(BigDecimal pfE12d1Zone3) {
		this.pfE12d1Zone3 = pfE12d1Zone3;
	}

	@Column(name = "PF_E36D24_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfE36d24Zone1() {
		return this.pfE36d24Zone1;
	}

	public void setPfE36d24Zone1(BigDecimal pfE36d24Zone1) {
		this.pfE36d24Zone1 = pfE36d24Zone1;
	}

	@Column(name = "PF_E36D24_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfE36d24Zone2() {
		return this.pfE36d24Zone2;
	}

	public void setPfE36d24Zone2(BigDecimal pfE36d24Zone2) {
		this.pfE36d24Zone2 = pfE36d24Zone2;
	}

	@Column(name = "PF_E36D24_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfE36d24Zone3() {
		return this.pfE36d24Zone3;
	}

	public void setPfE36d24Zone3(BigDecimal pfE36d24Zone3) {
		this.pfE36d24Zone3 = pfE36d24Zone3;
	}

	@Column(name = "PF_E79D56_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfE79d56Zone1() {
		return this.pfE79d56Zone1;
	}

	public void setPfE79d56Zone1(BigDecimal pfE79d56Zone1) {
		this.pfE79d56Zone1 = pfE79d56Zone1;
	}

	@Column(name = "PF_E79D56_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfE79d56Zone2() {
		return this.pfE79d56Zone2;
	}

	public void setPfE79d56Zone2(BigDecimal pfE79d56Zone2) {
		this.pfE79d56Zone2 = pfE79d56Zone2;
	}

	@Column(name = "PF_E79D56_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfE79d56Zone3() {
		return this.pfE79d56Zone3;
	}

	public void setPfE79d56Zone3(BigDecimal pfE79d56Zone3) {
		this.pfE79d56Zone3 = pfE79d56Zone3;
	}

	@Column(name = "PF_E1011D78_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfE1011d78Zone1() {
		return this.pfE1011d78Zone1;
	}

	public void setPfE1011d78Zone1(BigDecimal pfE1011d78Zone1) {
		this.pfE1011d78Zone1 = pfE1011d78Zone1;
	}

	@Column(name = "PF_E1011D78_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfE1011d78Zone2() {
		return this.pfE1011d78Zone2;
	}

	public void setPfE1011d78Zone2(BigDecimal pfE1011d78Zone2) {
		this.pfE1011d78Zone2 = pfE1011d78Zone2;
	}

	@Column(name = "PF_E1011D78_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfE1011d78Zone3() {
		return this.pfE1011d78Zone3;
	}

	public void setPfE1011d78Zone3(BigDecimal pfE1011d78Zone3) {
		this.pfE1011d78Zone3 = pfE1011d78Zone3;
	}

	@Column(name = "PF_E12D9_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfE12d9Zone1() {
		return this.pfE12d9Zone1;
	}

	public void setPfE12d9Zone1(BigDecimal pfE12d9Zone1) {
		this.pfE12d9Zone1 = pfE12d9Zone1;
	}

	@Column(name = "PF_E12D9_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfE12d9Zone2() {
		return this.pfE12d9Zone2;
	}

	public void setPfE12d9Zone2(BigDecimal pfE12d9Zone2) {
		this.pfE12d9Zone2 = pfE12d9Zone2;
	}

	@Column(name = "PF_E12D9_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfE12d9Zone3() {
		return this.pfE12d9Zone3;
	}

	public void setPfE12d9Zone3(BigDecimal pfE12d9Zone3) {
		this.pfE12d9Zone3 = pfE12d9Zone3;
	}

	@Column(name = "TAUX_MAJRED_REMORQUE", precision = 12, scale = 0)
	public Float getTauxMajredRemorque() {
		return this.tauxMajredRemorque;
	}

	public void setTauxMajredRemorque(Float tauxMajredRemorque) {
		this.tauxMajredRemorque = tauxMajredRemorque;
	}

	@Column(name = "TAUX_MAJRED_PERMI1", precision = 12, scale = 0)
	public Float getTauxMajredPermi1() {
		return this.tauxMajredPermi1;
	}

	public void setTauxMajredPermi1(Float tauxMajredPermi1) {
		this.tauxMajredPermi1 = tauxMajredPermi1;
	}

	@Column(name = "TAUX_MAJRED_PERMIS2", precision = 12, scale = 0)
	public Float getTauxMajredPermis2() {
		return this.tauxMajredPermis2;
	}

	public void setTauxMajredPermis2(Float tauxMajredPermis2) {
		this.tauxMajredPermis2 = tauxMajredPermis2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROA", precision = 12, scale = 0)
	public Float getTauxMajredStatutproa() {
		return this.tauxMajredStatutproa;
	}

	public void setTauxMajredStatutproa(Float tauxMajredStatutproa) {
		this.tauxMajredStatutproa = tauxMajredStatutproa;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROB", precision = 12, scale = 0)
	public Float getTauxMajredStatutprob() {
		return this.tauxMajredStatutprob;
	}

	public void setTauxMajredStatutprob(Float tauxMajredStatutprob) {
		this.tauxMajredStatutprob = tauxMajredStatutprob;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROC", precision = 12, scale = 0)
	public Float getTauxMajredStatutproc() {
		return this.tauxMajredStatutproc;
	}

	public void setTauxMajredStatutproc(Float tauxMajredStatutproc) {
		this.tauxMajredStatutproc = tauxMajredStatutproc;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROD", precision = 12, scale = 0)
	public Float getTauxMajredStatutprod() {
		return this.tauxMajredStatutprod;
	}

	public void setTauxMajredStatutprod(Float tauxMajredStatutprod) {
		this.tauxMajredStatutprod = tauxMajredStatutprod;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROE", precision = 12, scale = 0)
	public Float getTauxMajredStatutproe() {
		return this.tauxMajredStatutproe;
	}

	public void setTauxMajredStatutproe(Float tauxMajredStatutproe) {
		this.tauxMajredStatutproe = tauxMajredStatutproe;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROAUTRES", precision = 12, scale = 0)
	public Float getTauxMajredStatutproautres() {
		return this.tauxMajredStatutproautres;
	}

	public void setTauxMajredStatutproautres(Float tauxMajredStatutproautres) {
		this.tauxMajredStatutproautres = tauxMajredStatutproautres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif1")
	public Set<Tarif> getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

}
