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
 * RcTarif2 generated by hbm2java
 */
@Entity
@Table(name = "rc_tarif2", catalog = "zeusbd")
public class RcTarif2 implements java.io.Serializable {

	private String codeRcTarif2;
	private BigDecimal pfCu1Zone1;
	private BigDecimal pfCu2Zone1;
	private BigDecimal pfCu3Zone1;
	private BigDecimal pfCu4Zone1;
	private BigDecimal pfCu5Zone1;
	private BigDecimal pfCu6Zone1;
	private BigDecimal pfCu7Zone1;
	private BigDecimal pfCu8Zone1;
	private BigDecimal pfCu9Zone1;
	private BigDecimal pfCu1Zone2;
	private BigDecimal pfCu2Zone2;
	private BigDecimal pfCu3Zone2;
	private BigDecimal pfCu4Zone2;
	private BigDecimal pfCu5Zone2;
	private BigDecimal pfCu6Zone2;
	private BigDecimal pfCu7Zone2;
	private BigDecimal pfCu8Zone2;
	private BigDecimal pfCu9Zone2;
	private BigDecimal pfCu1Zone3;
	private BigDecimal pfCu2Zone3;
	private BigDecimal pfCu3Zone3;
	private BigDecimal pfCu4Zone3;
	private BigDecimal pfCu5Zone3;
	private BigDecimal pfCu6Zone3;
	private BigDecimal pfCu7Zone3;
	private BigDecimal pfCu8Zone3;
	private BigDecimal pfCu9Zone3;
	private BigDecimal surprimePassSupHcab;
	private BigDecimal surprimeTranspElev;
	private BigDecimal surprimeTranspCam;
	private BigDecimal surpimeTranspAutocar;
	private Float tauxPassagerCland;
	private Float tauxTranspHydrocar;
	private Float tauxMajredRemorquet2;
	private Float tauxMajredPermi1t2;
	private Float tauxMajredPermis2t2;
	private Float tauxMajredStatutproat2;
	private Float tauxMajredStatutprobt2;
	private Float tauxMajredStatutproct2;
	private Float tauxMajredStatutprodt2;
	private Float tauxMajredStatutproet2;
	private Float tauxMajredStatutproautrest2;
	private Set<Tarif> tarifs = new HashSet<Tarif>(0);

	public RcTarif2() {
	}

	public RcTarif2(String codeRcTarif2) {
		this.codeRcTarif2 = codeRcTarif2;
	}

	public RcTarif2(String codeRcTarif2, BigDecimal pfCu1Zone1,
			BigDecimal pfCu2Zone1, BigDecimal pfCu3Zone1,
			BigDecimal pfCu4Zone1, BigDecimal pfCu5Zone1,
			BigDecimal pfCu6Zone1, BigDecimal pfCu7Zone1,
			BigDecimal pfCu8Zone1, BigDecimal pfCu9Zone1,
			BigDecimal pfCu1Zone2, BigDecimal pfCu2Zone2,
			BigDecimal pfCu3Zone2, BigDecimal pfCu4Zone2,
			BigDecimal pfCu5Zone2, BigDecimal pfCu6Zone2,
			BigDecimal pfCu7Zone2, BigDecimal pfCu8Zone2,
			BigDecimal pfCu9Zone2, BigDecimal pfCu1Zone3,
			BigDecimal pfCu2Zone3, BigDecimal pfCu3Zone3,
			BigDecimal pfCu4Zone3, BigDecimal pfCu5Zone3,
			BigDecimal pfCu6Zone3, BigDecimal pfCu7Zone3,
			BigDecimal pfCu8Zone3, BigDecimal pfCu9Zone3,
			BigDecimal surprimePassSupHcab, BigDecimal surprimeTranspElev,
			BigDecimal surprimeTranspCam, BigDecimal surpimeTranspAutocar,
			Float tauxPassagerCland, Float tauxTranspHydrocar,
			Float tauxMajredRemorquet2, Float tauxMajredPermi1t2,
			Float tauxMajredPermis2t2, Float tauxMajredStatutproat2,
			Float tauxMajredStatutprobt2, Float tauxMajredStatutproct2,
			Float tauxMajredStatutprodt2, Float tauxMajredStatutproet2,
			Float tauxMajredStatutproautrest2, Set<Tarif> tarifs) {
		this.codeRcTarif2 = codeRcTarif2;
		this.pfCu1Zone1 = pfCu1Zone1;
		this.pfCu2Zone1 = pfCu2Zone1;
		this.pfCu3Zone1 = pfCu3Zone1;
		this.pfCu4Zone1 = pfCu4Zone1;
		this.pfCu5Zone1 = pfCu5Zone1;
		this.pfCu6Zone1 = pfCu6Zone1;
		this.pfCu7Zone1 = pfCu7Zone1;
		this.pfCu8Zone1 = pfCu8Zone1;
		this.pfCu9Zone1 = pfCu9Zone1;
		this.pfCu1Zone2 = pfCu1Zone2;
		this.pfCu2Zone2 = pfCu2Zone2;
		this.pfCu3Zone2 = pfCu3Zone2;
		this.pfCu4Zone2 = pfCu4Zone2;
		this.pfCu5Zone2 = pfCu5Zone2;
		this.pfCu6Zone2 = pfCu6Zone2;
		this.pfCu7Zone2 = pfCu7Zone2;
		this.pfCu8Zone2 = pfCu8Zone2;
		this.pfCu9Zone2 = pfCu9Zone2;
		this.pfCu1Zone3 = pfCu1Zone3;
		this.pfCu2Zone3 = pfCu2Zone3;
		this.pfCu3Zone3 = pfCu3Zone3;
		this.pfCu4Zone3 = pfCu4Zone3;
		this.pfCu5Zone3 = pfCu5Zone3;
		this.pfCu6Zone3 = pfCu6Zone3;
		this.pfCu7Zone3 = pfCu7Zone3;
		this.pfCu8Zone3 = pfCu8Zone3;
		this.pfCu9Zone3 = pfCu9Zone3;
		this.surprimePassSupHcab = surprimePassSupHcab;
		this.surprimeTranspElev = surprimeTranspElev;
		this.surprimeTranspCam = surprimeTranspCam;
		this.surpimeTranspAutocar = surpimeTranspAutocar;
		this.tauxPassagerCland = tauxPassagerCland;
		this.tauxTranspHydrocar = tauxTranspHydrocar;
		this.tauxMajredRemorquet2 = tauxMajredRemorquet2;
		this.tauxMajredPermi1t2 = tauxMajredPermi1t2;
		this.tauxMajredPermis2t2 = tauxMajredPermis2t2;
		this.tauxMajredStatutproat2 = tauxMajredStatutproat2;
		this.tauxMajredStatutprobt2 = tauxMajredStatutprobt2;
		this.tauxMajredStatutproct2 = tauxMajredStatutproct2;
		this.tauxMajredStatutprodt2 = tauxMajredStatutprodt2;
		this.tauxMajredStatutproet2 = tauxMajredStatutproet2;
		this.tauxMajredStatutproautrest2 = tauxMajredStatutproautrest2;
		this.tarifs = tarifs;
	}

	@Id
	@Column(name = "CODE_RC_TARIF2", unique = true, nullable = false, length = 16)
	public String getCodeRcTarif2() {
		return this.codeRcTarif2;
	}

	public void setCodeRcTarif2(String codeRcTarif2) {
		this.codeRcTarif2 = codeRcTarif2;
	}

	@Column(name = "PF_CU1_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu1Zone1() {
		return this.pfCu1Zone1;
	}

	public void setPfCu1Zone1(BigDecimal pfCu1Zone1) {
		this.pfCu1Zone1 = pfCu1Zone1;
	}

	@Column(name = "PF_CU2_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu2Zone1() {
		return this.pfCu2Zone1;
	}

	public void setPfCu2Zone1(BigDecimal pfCu2Zone1) {
		this.pfCu2Zone1 = pfCu2Zone1;
	}

	@Column(name = "PF_CU3_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu3Zone1() {
		return this.pfCu3Zone1;
	}

	public void setPfCu3Zone1(BigDecimal pfCu3Zone1) {
		this.pfCu3Zone1 = pfCu3Zone1;
	}

	@Column(name = "PF_CU4_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu4Zone1() {
		return this.pfCu4Zone1;
	}

	public void setPfCu4Zone1(BigDecimal pfCu4Zone1) {
		this.pfCu4Zone1 = pfCu4Zone1;
	}

	@Column(name = "PF_CU5_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu5Zone1() {
		return this.pfCu5Zone1;
	}

	public void setPfCu5Zone1(BigDecimal pfCu5Zone1) {
		this.pfCu5Zone1 = pfCu5Zone1;
	}

	@Column(name = "PF_CU6_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu6Zone1() {
		return this.pfCu6Zone1;
	}

	public void setPfCu6Zone1(BigDecimal pfCu6Zone1) {
		this.pfCu6Zone1 = pfCu6Zone1;
	}

	@Column(name = "PF_CU7_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu7Zone1() {
		return this.pfCu7Zone1;
	}

	public void setPfCu7Zone1(BigDecimal pfCu7Zone1) {
		this.pfCu7Zone1 = pfCu7Zone1;
	}

	@Column(name = "PF_CU8_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu8Zone1() {
		return this.pfCu8Zone1;
	}

	public void setPfCu8Zone1(BigDecimal pfCu8Zone1) {
		this.pfCu8Zone1 = pfCu8Zone1;
	}

	@Column(name = "PF_CU9_ZONE1", precision = 15, scale = 3)
	public BigDecimal getPfCu9Zone1() {
		return this.pfCu9Zone1;
	}

	public void setPfCu9Zone1(BigDecimal pfCu9Zone1) {
		this.pfCu9Zone1 = pfCu9Zone1;
	}

	@Column(name = "PF_CU1_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu1Zone2() {
		return this.pfCu1Zone2;
	}

	public void setPfCu1Zone2(BigDecimal pfCu1Zone2) {
		this.pfCu1Zone2 = pfCu1Zone2;
	}

	@Column(name = "PF_CU2_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu2Zone2() {
		return this.pfCu2Zone2;
	}

	public void setPfCu2Zone2(BigDecimal pfCu2Zone2) {
		this.pfCu2Zone2 = pfCu2Zone2;
	}

	@Column(name = "PF_CU3_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu3Zone2() {
		return this.pfCu3Zone2;
	}

	public void setPfCu3Zone2(BigDecimal pfCu3Zone2) {
		this.pfCu3Zone2 = pfCu3Zone2;
	}

	@Column(name = "PF_CU4_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu4Zone2() {
		return this.pfCu4Zone2;
	}

	public void setPfCu4Zone2(BigDecimal pfCu4Zone2) {
		this.pfCu4Zone2 = pfCu4Zone2;
	}

	@Column(name = "PF_CU5_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu5Zone2() {
		return this.pfCu5Zone2;
	}

	public void setPfCu5Zone2(BigDecimal pfCu5Zone2) {
		this.pfCu5Zone2 = pfCu5Zone2;
	}

	@Column(name = "PF_CU6_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu6Zone2() {
		return this.pfCu6Zone2;
	}

	public void setPfCu6Zone2(BigDecimal pfCu6Zone2) {
		this.pfCu6Zone2 = pfCu6Zone2;
	}

	@Column(name = "PF_CU7_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu7Zone2() {
		return this.pfCu7Zone2;
	}

	public void setPfCu7Zone2(BigDecimal pfCu7Zone2) {
		this.pfCu7Zone2 = pfCu7Zone2;
	}

	@Column(name = "PF_CU8_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu8Zone2() {
		return this.pfCu8Zone2;
	}

	public void setPfCu8Zone2(BigDecimal pfCu8Zone2) {
		this.pfCu8Zone2 = pfCu8Zone2;
	}

	@Column(name = "PF_CU9_ZONE2", precision = 15, scale = 3)
	public BigDecimal getPfCu9Zone2() {
		return this.pfCu9Zone2;
	}

	public void setPfCu9Zone2(BigDecimal pfCu9Zone2) {
		this.pfCu9Zone2 = pfCu9Zone2;
	}

	@Column(name = "PF_CU1_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu1Zone3() {
		return this.pfCu1Zone3;
	}

	public void setPfCu1Zone3(BigDecimal pfCu1Zone3) {
		this.pfCu1Zone3 = pfCu1Zone3;
	}

	@Column(name = "PF_CU2_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu2Zone3() {
		return this.pfCu2Zone3;
	}

	public void setPfCu2Zone3(BigDecimal pfCu2Zone3) {
		this.pfCu2Zone3 = pfCu2Zone3;
	}

	@Column(name = "PF_CU3_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu3Zone3() {
		return this.pfCu3Zone3;
	}

	public void setPfCu3Zone3(BigDecimal pfCu3Zone3) {
		this.pfCu3Zone3 = pfCu3Zone3;
	}

	@Column(name = "PF_CU4_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu4Zone3() {
		return this.pfCu4Zone3;
	}

	public void setPfCu4Zone3(BigDecimal pfCu4Zone3) {
		this.pfCu4Zone3 = pfCu4Zone3;
	}

	@Column(name = "PF_CU5_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu5Zone3() {
		return this.pfCu5Zone3;
	}

	public void setPfCu5Zone3(BigDecimal pfCu5Zone3) {
		this.pfCu5Zone3 = pfCu5Zone3;
	}

	@Column(name = "PF_CU6_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu6Zone3() {
		return this.pfCu6Zone3;
	}

	public void setPfCu6Zone3(BigDecimal pfCu6Zone3) {
		this.pfCu6Zone3 = pfCu6Zone3;
	}

	@Column(name = "PF_CU7_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu7Zone3() {
		return this.pfCu7Zone3;
	}

	public void setPfCu7Zone3(BigDecimal pfCu7Zone3) {
		this.pfCu7Zone3 = pfCu7Zone3;
	}

	@Column(name = "PF_CU8_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu8Zone3() {
		return this.pfCu8Zone3;
	}

	public void setPfCu8Zone3(BigDecimal pfCu8Zone3) {
		this.pfCu8Zone3 = pfCu8Zone3;
	}

	@Column(name = "PF_CU9_ZONE3", precision = 15, scale = 3)
	public BigDecimal getPfCu9Zone3() {
		return this.pfCu9Zone3;
	}

	public void setPfCu9Zone3(BigDecimal pfCu9Zone3) {
		this.pfCu9Zone3 = pfCu9Zone3;
	}

	@Column(name = "SURPRIME_PASS_SUP_HCAB", precision = 15, scale = 3)
	public BigDecimal getSurprimePassSupHcab() {
		return this.surprimePassSupHcab;
	}

	public void setSurprimePassSupHcab(BigDecimal surprimePassSupHcab) {
		this.surprimePassSupHcab = surprimePassSupHcab;
	}

	@Column(name = "SURPRIME_TRANSP_ELEV", precision = 15, scale = 3)
	public BigDecimal getSurprimeTranspElev() {
		return this.surprimeTranspElev;
	}

	public void setSurprimeTranspElev(BigDecimal surprimeTranspElev) {
		this.surprimeTranspElev = surprimeTranspElev;
	}

	@Column(name = "SURPRIME_TRANSP_CAM", precision = 15, scale = 3)
	public BigDecimal getSurprimeTranspCam() {
		return this.surprimeTranspCam;
	}

	public void setSurprimeTranspCam(BigDecimal surprimeTranspCam) {
		this.surprimeTranspCam = surprimeTranspCam;
	}

	@Column(name = "SURPIME_TRANSP_AUTOCAR", precision = 15, scale = 3)
	public BigDecimal getSurpimeTranspAutocar() {
		return this.surpimeTranspAutocar;
	}

	public void setSurpimeTranspAutocar(BigDecimal surpimeTranspAutocar) {
		this.surpimeTranspAutocar = surpimeTranspAutocar;
	}

	@Column(name = "TAUX_PASSAGER_CLAND", precision = 12, scale = 0)
	public Float getTauxPassagerCland() {
		return this.tauxPassagerCland;
	}

	public void setTauxPassagerCland(Float tauxPassagerCland) {
		this.tauxPassagerCland = tauxPassagerCland;
	}

	@Column(name = "TAUX_TRANSP_HYDROCAR", precision = 12, scale = 0)
	public Float getTauxTranspHydrocar() {
		return this.tauxTranspHydrocar;
	}

	public void setTauxTranspHydrocar(Float tauxTranspHydrocar) {
		this.tauxTranspHydrocar = tauxTranspHydrocar;
	}

	@Column(name = "TAUX_MAJRED_REMORQUET2", precision = 12, scale = 0)
	public Float getTauxMajredRemorquet2() {
		return this.tauxMajredRemorquet2;
	}

	public void setTauxMajredRemorquet2(Float tauxMajredRemorquet2) {
		this.tauxMajredRemorquet2 = tauxMajredRemorquet2;
	}

	@Column(name = "TAUX_MAJRED_PERMI1T2", precision = 12, scale = 0)
	public Float getTauxMajredPermi1t2() {
		return this.tauxMajredPermi1t2;
	}

	public void setTauxMajredPermi1t2(Float tauxMajredPermi1t2) {
		this.tauxMajredPermi1t2 = tauxMajredPermi1t2;
	}

	@Column(name = "TAUX_MAJRED_PERMIS2T2", precision = 12, scale = 0)
	public Float getTauxMajredPermis2t2() {
		return this.tauxMajredPermis2t2;
	}

	public void setTauxMajredPermis2t2(Float tauxMajredPermis2t2) {
		this.tauxMajredPermis2t2 = tauxMajredPermis2t2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROAT2", precision = 12, scale = 0)
	public Float getTauxMajredStatutproat2() {
		return this.tauxMajredStatutproat2;
	}

	public void setTauxMajredStatutproat2(Float tauxMajredStatutproat2) {
		this.tauxMajredStatutproat2 = tauxMajredStatutproat2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROBT2", precision = 12, scale = 0)
	public Float getTauxMajredStatutprobt2() {
		return this.tauxMajredStatutprobt2;
	}

	public void setTauxMajredStatutprobt2(Float tauxMajredStatutprobt2) {
		this.tauxMajredStatutprobt2 = tauxMajredStatutprobt2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROCT2", precision = 12, scale = 0)
	public Float getTauxMajredStatutproct2() {
		return this.tauxMajredStatutproct2;
	}

	public void setTauxMajredStatutproct2(Float tauxMajredStatutproct2) {
		this.tauxMajredStatutproct2 = tauxMajredStatutproct2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPRODT2", precision = 12, scale = 0)
	public Float getTauxMajredStatutprodt2() {
		return this.tauxMajredStatutprodt2;
	}

	public void setTauxMajredStatutprodt2(Float tauxMajredStatutprodt2) {
		this.tauxMajredStatutprodt2 = tauxMajredStatutprodt2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROET2", precision = 12, scale = 0)
	public Float getTauxMajredStatutproet2() {
		return this.tauxMajredStatutproet2;
	}

	public void setTauxMajredStatutproet2(Float tauxMajredStatutproet2) {
		this.tauxMajredStatutproet2 = tauxMajredStatutproet2;
	}

	@Column(name = "TAUX_MAJRED_STATUTPROAUTREST2", precision = 12, scale = 0)
	public Float getTauxMajredStatutproautrest2() {
		return this.tauxMajredStatutproautrest2;
	}

	public void setTauxMajredStatutproautrest2(Float tauxMajredStatutproautrest2) {
		this.tauxMajredStatutproautrest2 = tauxMajredStatutproautrest2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcTarif2")
	public Set<Tarif> getTarifs() {
		return this.tarifs;
	}

	public void setTarifs(Set<Tarif> tarifs) {
		this.tarifs = tarifs;
	}

}
