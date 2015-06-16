package com.j3a.assurance.model;

// Generated 16 juin 2015 11:31:51 by Hibernate Tools 4.3.1

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
 * Tarif generated by hbm2java
 */
@Entity
@Table(name = "tarif", catalog = "zeusbd")
public class Tarif implements java.io.Serializable {

	private String codeTarif;
	private RcTarif1 rcTarif1;
	private RcTarif10 rcTarif10;
	private RcTarif12 rcTarif12;
	private RcTarif12b rcTarif12b;
	private RcTarif2 rcTarif2;
	private RcTarif3 rcTarif3;
	private RcTarif4 rcTarif4;
	private RcTarif5 rcTarif5;
	private RcTarif6 rcTarif6;
	private RcTarif7 rcTarif7;
	private RcTarif8 rcTarif8;
	private RcTarif9 rcTarif9;
	private String libelleTarif;
	private BigDecimal drDomage;
	private BigDecimal drSansDomage;
	private Float tauxDrPrimeFinale;
	private BigDecimal primeBaseDr;
	private BigDecimal immobVehicule;
	private BigDecimal graAnnuelle;
	private BigDecimal graCourt;
	private Float tauxBgOpt1;
	private Float franchBgOpt1;
	private Float tauxBgOpt2;
	private Float franchBgOpt2;
	private Float tauxBgOpt3;
	private Float francBgOpt3;
	private Float tauxPrimeDomCol;
	private Float tauxFranchDomCol;
	private Float tauxPrimeDomAcc;
	private Float tauxFranchDomAcc;
	private Float tauxPrimeVol1;
	private Float tauxPrimeVol2;
	private Float tauxPrimeVol3;
	private Float tauxFranchVol;
	private Float tauxPrimeVolAcc;
	private Float tauxFranchVolAcc;
	private BigDecimal primeVol11;
	private BigDecimal primeVol12;
	private BigDecimal primeVol13;
	private BigDecimal primeVol14;
	private BigDecimal primeVol15;
	private BigDecimal primeVol21;
	private BigDecimal primeVol22;
	private BigDecimal primeVol23;
	private BigDecimal primeVol24;
	private BigDecimal primeVol25;
	private Float tauxVandal;
	private BigDecimal primeVandal;
	private Float franchVandal;
	private Float tauxPrimeIncendie1;
	private Float tauxPrimeIncendie2;
	private Float tauxPrimeIncendie3;
	private Float tauxFranchIncendie;
	private BigDecimal primeIncendie11;
	private BigDecimal primeIncendie12;
	private BigDecimal primeIncendie13;
	private BigDecimal primeIncendie14;
	private BigDecimal primeIncendie15;
	private BigDecimal primeIncendie21;
	private BigDecimal primeIncendie22;
	private BigDecimal primeIncendie23;
	private BigDecimal primeIncendie24;
	private BigDecimal primeIncendie25;
	private Float surprimeTranspHyd;
	private BigDecimal srDeces1;
	private BigDecimal srDeces2;
	private BigDecimal srDeces3;
	private BigDecimal srIpt1;
	private BigDecimal srIpt2;
	private BigDecimal srIpt3;
	private BigDecimal srFraisTrait1;
	private BigDecimal srFraisTrait2;
	private BigDecimal srFraisTrait3;
	private BigDecimal srPrime1;
	private BigDecimal srPrime2;
	private BigDecimal srPrime3;
	private Set<RcTarif12b> rcTarif12bs = new HashSet<RcTarif12b>(0);
	private Set<RcTarif8> rcTarif8s = new HashSet<RcTarif8>(0);
	private Set<RcTarif3> rcTarif3s = new HashSet<RcTarif3>(0);
	private Set<RcTarif9> rcTarif9s = new HashSet<RcTarif9>(0);
	private Set<RcTarif7> rcTarif7s = new HashSet<RcTarif7>(0);
	private Set<RcTarif12> rcTarif12s = new HashSet<RcTarif12>(0);
	private Set<RcTarif10> rcTarif10s = new HashSet<RcTarif10>(0);
	private Set<RcTarif1> rcTarif1s = new HashSet<RcTarif1>(0);
	private Set<RcTarif2> rcTarif2s = new HashSet<RcTarif2>(0);
	private Set<RcTarif4> rcTarif4s = new HashSet<RcTarif4>(0);
	private Set<RcTarif5> rcTarif5s = new HashSet<RcTarif5>(0);
	private Set<RcTarif6> rcTarif6s = new HashSet<RcTarif6>(0);
	private Set<SousCatVehicule> sousCatVehicules = new HashSet<SousCatVehicule>(
			0);

	public Tarif() {
	}

	public Tarif(String codeTarif, RcTarif1 rcTarif1, RcTarif10 rcTarif10,
			RcTarif12 rcTarif12, RcTarif12b rcTarif12b, RcTarif2 rcTarif2,
			RcTarif3 rcTarif3, RcTarif4 rcTarif4, RcTarif5 rcTarif5,
			RcTarif6 rcTarif6, RcTarif7 rcTarif7, RcTarif8 rcTarif8,
			RcTarif9 rcTarif9) {
		this.codeTarif = codeTarif;
		this.rcTarif1 = rcTarif1;
		this.rcTarif10 = rcTarif10;
		this.rcTarif12 = rcTarif12;
		this.rcTarif12b = rcTarif12b;
		this.rcTarif2 = rcTarif2;
		this.rcTarif3 = rcTarif3;
		this.rcTarif4 = rcTarif4;
		this.rcTarif5 = rcTarif5;
		this.rcTarif6 = rcTarif6;
		this.rcTarif7 = rcTarif7;
		this.rcTarif8 = rcTarif8;
		this.rcTarif9 = rcTarif9;
	}

	public Tarif(String codeTarif, RcTarif1 rcTarif1, RcTarif10 rcTarif10,
			RcTarif12 rcTarif12, RcTarif12b rcTarif12b, RcTarif2 rcTarif2,
			RcTarif3 rcTarif3, RcTarif4 rcTarif4, RcTarif5 rcTarif5,
			RcTarif6 rcTarif6, RcTarif7 rcTarif7, RcTarif8 rcTarif8,
			RcTarif9 rcTarif9, String libelleTarif, BigDecimal drDomage,
			BigDecimal drSansDomage, Float tauxDrPrimeFinale,
			BigDecimal primeBaseDr, BigDecimal immobVehicule,
			BigDecimal graAnnuelle, BigDecimal graCourt, Float tauxBgOpt1,
			Float franchBgOpt1, Float tauxBgOpt2, Float franchBgOpt2,
			Float tauxBgOpt3, Float francBgOpt3, Float tauxPrimeDomCol,
			Float tauxFranchDomCol, Float tauxPrimeDomAcc,
			Float tauxFranchDomAcc, Float tauxPrimeVol1, Float tauxPrimeVol2,
			Float tauxPrimeVol3, Float tauxFranchVol, Float tauxPrimeVolAcc,
			Float tauxFranchVolAcc, BigDecimal primeVol11,
			BigDecimal primeVol12, BigDecimal primeVol13,
			BigDecimal primeVol14, BigDecimal primeVol15,
			BigDecimal primeVol21, BigDecimal primeVol22,
			BigDecimal primeVol23, BigDecimal primeVol24,
			BigDecimal primeVol25, Float tauxVandal, BigDecimal primeVandal,
			Float franchVandal, Float tauxPrimeIncendie1,
			Float tauxPrimeIncendie2, Float tauxPrimeIncendie3,
			Float tauxFranchIncendie, BigDecimal primeIncendie11,
			BigDecimal primeIncendie12, BigDecimal primeIncendie13,
			BigDecimal primeIncendie14, BigDecimal primeIncendie15,
			BigDecimal primeIncendie21, BigDecimal primeIncendie22,
			BigDecimal primeIncendie23, BigDecimal primeIncendie24,
			BigDecimal primeIncendie25, Float surprimeTranspHyd,
			BigDecimal srDeces1, BigDecimal srDeces2, BigDecimal srDeces3,
			BigDecimal srIpt1, BigDecimal srIpt2, BigDecimal srIpt3,
			BigDecimal srFraisTrait1, BigDecimal srFraisTrait2,
			BigDecimal srFraisTrait3, BigDecimal srPrime1, BigDecimal srPrime2,
			BigDecimal srPrime3, Set<RcTarif12b> rcTarif12bs,
			Set<RcTarif8> rcTarif8s, Set<RcTarif3> rcTarif3s,
			Set<RcTarif9> rcTarif9s, Set<RcTarif7> rcTarif7s,
			Set<RcTarif12> rcTarif12s, Set<RcTarif10> rcTarif10s,
			Set<RcTarif1> rcTarif1s, Set<RcTarif2> rcTarif2s,
			Set<RcTarif4> rcTarif4s, Set<RcTarif5> rcTarif5s,
			Set<RcTarif6> rcTarif6s, Set<SousCatVehicule> sousCatVehicules) {
		this.codeTarif = codeTarif;
		this.rcTarif1 = rcTarif1;
		this.rcTarif10 = rcTarif10;
		this.rcTarif12 = rcTarif12;
		this.rcTarif12b = rcTarif12b;
		this.rcTarif2 = rcTarif2;
		this.rcTarif3 = rcTarif3;
		this.rcTarif4 = rcTarif4;
		this.rcTarif5 = rcTarif5;
		this.rcTarif6 = rcTarif6;
		this.rcTarif7 = rcTarif7;
		this.rcTarif8 = rcTarif8;
		this.rcTarif9 = rcTarif9;
		this.libelleTarif = libelleTarif;
		this.drDomage = drDomage;
		this.drSansDomage = drSansDomage;
		this.tauxDrPrimeFinale = tauxDrPrimeFinale;
		this.primeBaseDr = primeBaseDr;
		this.immobVehicule = immobVehicule;
		this.graAnnuelle = graAnnuelle;
		this.graCourt = graCourt;
		this.tauxBgOpt1 = tauxBgOpt1;
		this.franchBgOpt1 = franchBgOpt1;
		this.tauxBgOpt2 = tauxBgOpt2;
		this.franchBgOpt2 = franchBgOpt2;
		this.tauxBgOpt3 = tauxBgOpt3;
		this.francBgOpt3 = francBgOpt3;
		this.tauxPrimeDomCol = tauxPrimeDomCol;
		this.tauxFranchDomCol = tauxFranchDomCol;
		this.tauxPrimeDomAcc = tauxPrimeDomAcc;
		this.tauxFranchDomAcc = tauxFranchDomAcc;
		this.tauxPrimeVol1 = tauxPrimeVol1;
		this.tauxPrimeVol2 = tauxPrimeVol2;
		this.tauxPrimeVol3 = tauxPrimeVol3;
		this.tauxFranchVol = tauxFranchVol;
		this.tauxPrimeVolAcc = tauxPrimeVolAcc;
		this.tauxFranchVolAcc = tauxFranchVolAcc;
		this.primeVol11 = primeVol11;
		this.primeVol12 = primeVol12;
		this.primeVol13 = primeVol13;
		this.primeVol14 = primeVol14;
		this.primeVol15 = primeVol15;
		this.primeVol21 = primeVol21;
		this.primeVol22 = primeVol22;
		this.primeVol23 = primeVol23;
		this.primeVol24 = primeVol24;
		this.primeVol25 = primeVol25;
		this.tauxVandal = tauxVandal;
		this.primeVandal = primeVandal;
		this.franchVandal = franchVandal;
		this.tauxPrimeIncendie1 = tauxPrimeIncendie1;
		this.tauxPrimeIncendie2 = tauxPrimeIncendie2;
		this.tauxPrimeIncendie3 = tauxPrimeIncendie3;
		this.tauxFranchIncendie = tauxFranchIncendie;
		this.primeIncendie11 = primeIncendie11;
		this.primeIncendie12 = primeIncendie12;
		this.primeIncendie13 = primeIncendie13;
		this.primeIncendie14 = primeIncendie14;
		this.primeIncendie15 = primeIncendie15;
		this.primeIncendie21 = primeIncendie21;
		this.primeIncendie22 = primeIncendie22;
		this.primeIncendie23 = primeIncendie23;
		this.primeIncendie24 = primeIncendie24;
		this.primeIncendie25 = primeIncendie25;
		this.surprimeTranspHyd = surprimeTranspHyd;
		this.srDeces1 = srDeces1;
		this.srDeces2 = srDeces2;
		this.srDeces3 = srDeces3;
		this.srIpt1 = srIpt1;
		this.srIpt2 = srIpt2;
		this.srIpt3 = srIpt3;
		this.srFraisTrait1 = srFraisTrait1;
		this.srFraisTrait2 = srFraisTrait2;
		this.srFraisTrait3 = srFraisTrait3;
		this.srPrime1 = srPrime1;
		this.srPrime2 = srPrime2;
		this.srPrime3 = srPrime3;
		this.rcTarif12bs = rcTarif12bs;
		this.rcTarif8s = rcTarif8s;
		this.rcTarif3s = rcTarif3s;
		this.rcTarif9s = rcTarif9s;
		this.rcTarif7s = rcTarif7s;
		this.rcTarif12s = rcTarif12s;
		this.rcTarif10s = rcTarif10s;
		this.rcTarif1s = rcTarif1s;
		this.rcTarif2s = rcTarif2s;
		this.rcTarif4s = rcTarif4s;
		this.rcTarif5s = rcTarif5s;
		this.rcTarif6s = rcTarif6s;
		this.sousCatVehicules = sousCatVehicules;
	}

	@Id
	@Column(name = "CODE_TARIF", unique = true, nullable = false, length = 16)
	public String getCodeTarif() {
		return this.codeTarif;
	}

	public void setCodeTarif(String codeTarif) {
		this.codeTarif = codeTarif;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF1", nullable = false)
	public RcTarif1 getRcTarif1() {
		return this.rcTarif1;
	}

	public void setRcTarif1(RcTarif1 rcTarif1) {
		this.rcTarif1 = rcTarif1;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF10", nullable = false)
	public RcTarif10 getRcTarif10() {
		return this.rcTarif10;
	}

	public void setRcTarif10(RcTarif10 rcTarif10) {
		this.rcTarif10 = rcTarif10;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF12", nullable = false)
	public RcTarif12 getRcTarif12() {
		return this.rcTarif12;
	}

	public void setRcTarif12(RcTarif12 rcTarif12) {
		this.rcTarif12 = rcTarif12;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF12B", nullable = false)
	public RcTarif12b getRcTarif12b() {
		return this.rcTarif12b;
	}

	public void setRcTarif12b(RcTarif12b rcTarif12b) {
		this.rcTarif12b = rcTarif12b;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF2", nullable = false)
	public RcTarif2 getRcTarif2() {
		return this.rcTarif2;
	}

	public void setRcTarif2(RcTarif2 rcTarif2) {
		this.rcTarif2 = rcTarif2;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF3", nullable = false)
	public RcTarif3 getRcTarif3() {
		return this.rcTarif3;
	}

	public void setRcTarif3(RcTarif3 rcTarif3) {
		this.rcTarif3 = rcTarif3;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF4", nullable = false)
	public RcTarif4 getRcTarif4() {
		return this.rcTarif4;
	}

	public void setRcTarif4(RcTarif4 rcTarif4) {
		this.rcTarif4 = rcTarif4;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF5", nullable = false)
	public RcTarif5 getRcTarif5() {
		return this.rcTarif5;
	}

	public void setRcTarif5(RcTarif5 rcTarif5) {
		this.rcTarif5 = rcTarif5;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF6", nullable = false)
	public RcTarif6 getRcTarif6() {
		return this.rcTarif6;
	}

	public void setRcTarif6(RcTarif6 rcTarif6) {
		this.rcTarif6 = rcTarif6;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF7", nullable = false)
	public RcTarif7 getRcTarif7() {
		return this.rcTarif7;
	}

	public void setRcTarif7(RcTarif7 rcTarif7) {
		this.rcTarif7 = rcTarif7;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF8", nullable = false)
	public RcTarif8 getRcTarif8() {
		return this.rcTarif8;
	}

	public void setRcTarif8(RcTarif8 rcTarif8) {
		this.rcTarif8 = rcTarif8;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_RC_TARIF9", nullable = false)
	public RcTarif9 getRcTarif9() {
		return this.rcTarif9;
	}

	public void setRcTarif9(RcTarif9 rcTarif9) {
		this.rcTarif9 = rcTarif9;
	}

	@Column(name = "LIBELLE_TARIF", length = 100)
	public String getLibelleTarif() {
		return this.libelleTarif;
	}

	public void setLibelleTarif(String libelleTarif) {
		this.libelleTarif = libelleTarif;
	}

	@Column(name = "DR_DOMAGE", precision = 15, scale = 3)
	public BigDecimal getDrDomage() {
		return this.drDomage;
	}

	public void setDrDomage(BigDecimal drDomage) {
		this.drDomage = drDomage;
	}

	@Column(name = "DR_SANS_DOMAGE", precision = 15, scale = 3)
	public BigDecimal getDrSansDomage() {
		return this.drSansDomage;
	}

	public void setDrSansDomage(BigDecimal drSansDomage) {
		this.drSansDomage = drSansDomage;
	}

	@Column(name = "TAUX_DR_PRIME_FINALE", precision = 12, scale = 0)
	public Float getTauxDrPrimeFinale() {
		return this.tauxDrPrimeFinale;
	}

	public void setTauxDrPrimeFinale(Float tauxDrPrimeFinale) {
		this.tauxDrPrimeFinale = tauxDrPrimeFinale;
	}

	@Column(name = "PRIME_BASE_DR", precision = 15, scale = 3)
	public BigDecimal getPrimeBaseDr() {
		return this.primeBaseDr;
	}

	public void setPrimeBaseDr(BigDecimal primeBaseDr) {
		this.primeBaseDr = primeBaseDr;
	}

	@Column(name = "IMMOB_VEHICULE", precision = 15, scale = 3)
	public BigDecimal getImmobVehicule() {
		return this.immobVehicule;
	}

	public void setImmobVehicule(BigDecimal immobVehicule) {
		this.immobVehicule = immobVehicule;
	}

	@Column(name = "GRA_ANNUELLE", precision = 15, scale = 3)
	public BigDecimal getGraAnnuelle() {
		return this.graAnnuelle;
	}

	public void setGraAnnuelle(BigDecimal graAnnuelle) {
		this.graAnnuelle = graAnnuelle;
	}

	@Column(name = "GRA_COURT", precision = 15, scale = 3)
	public BigDecimal getGraCourt() {
		return this.graCourt;
	}

	public void setGraCourt(BigDecimal graCourt) {
		this.graCourt = graCourt;
	}

	@Column(name = "TAUX_BG_OPT1", precision = 12, scale = 0)
	public Float getTauxBgOpt1() {
		return this.tauxBgOpt1;
	}

	public void setTauxBgOpt1(Float tauxBgOpt1) {
		this.tauxBgOpt1 = tauxBgOpt1;
	}

	@Column(name = "FRANCH_BG_OPT1", precision = 12, scale = 0)
	public Float getFranchBgOpt1() {
		return this.franchBgOpt1;
	}

	public void setFranchBgOpt1(Float franchBgOpt1) {
		this.franchBgOpt1 = franchBgOpt1;
	}

	@Column(name = "TAUX_BG_OPT2", precision = 12, scale = 0)
	public Float getTauxBgOpt2() {
		return this.tauxBgOpt2;
	}

	public void setTauxBgOpt2(Float tauxBgOpt2) {
		this.tauxBgOpt2 = tauxBgOpt2;
	}

	@Column(name = "FRANCH_BG_OPT2", precision = 12, scale = 0)
	public Float getFranchBgOpt2() {
		return this.franchBgOpt2;
	}

	public void setFranchBgOpt2(Float franchBgOpt2) {
		this.franchBgOpt2 = franchBgOpt2;
	}

	@Column(name = "TAUX_BG_OPT3", precision = 12, scale = 0)
	public Float getTauxBgOpt3() {
		return this.tauxBgOpt3;
	}

	public void setTauxBgOpt3(Float tauxBgOpt3) {
		this.tauxBgOpt3 = tauxBgOpt3;
	}

	@Column(name = "FRANC_BG_OPT3", precision = 12, scale = 0)
	public Float getFrancBgOpt3() {
		return this.francBgOpt3;
	}

	public void setFrancBgOpt3(Float francBgOpt3) {
		this.francBgOpt3 = francBgOpt3;
	}

	@Column(name = "TAUX_PRIME_DOM_COL", precision = 12, scale = 0)
	public Float getTauxPrimeDomCol() {
		return this.tauxPrimeDomCol;
	}

	public void setTauxPrimeDomCol(Float tauxPrimeDomCol) {
		this.tauxPrimeDomCol = tauxPrimeDomCol;
	}

	@Column(name = "TAUX_FRANCH_DOM_COL", precision = 12, scale = 0)
	public Float getTauxFranchDomCol() {
		return this.tauxFranchDomCol;
	}

	public void setTauxFranchDomCol(Float tauxFranchDomCol) {
		this.tauxFranchDomCol = tauxFranchDomCol;
	}

	@Column(name = "TAUX_PRIME_DOM_ACC", precision = 12, scale = 0)
	public Float getTauxPrimeDomAcc() {
		return this.tauxPrimeDomAcc;
	}

	public void setTauxPrimeDomAcc(Float tauxPrimeDomAcc) {
		this.tauxPrimeDomAcc = tauxPrimeDomAcc;
	}

	@Column(name = "TAUX_FRANCH_DOM_ACC", precision = 12, scale = 0)
	public Float getTauxFranchDomAcc() {
		return this.tauxFranchDomAcc;
	}

	public void setTauxFranchDomAcc(Float tauxFranchDomAcc) {
		this.tauxFranchDomAcc = tauxFranchDomAcc;
	}

	@Column(name = "TAUX_PRIME_VOL1", precision = 12, scale = 0)
	public Float getTauxPrimeVol1() {
		return this.tauxPrimeVol1;
	}

	public void setTauxPrimeVol1(Float tauxPrimeVol1) {
		this.tauxPrimeVol1 = tauxPrimeVol1;
	}

	@Column(name = "TAUX_PRIME_VOL2", precision = 12, scale = 0)
	public Float getTauxPrimeVol2() {
		return this.tauxPrimeVol2;
	}

	public void setTauxPrimeVol2(Float tauxPrimeVol2) {
		this.tauxPrimeVol2 = tauxPrimeVol2;
	}

	@Column(name = "TAUX_PRIME_VOL3", precision = 12, scale = 0)
	public Float getTauxPrimeVol3() {
		return this.tauxPrimeVol3;
	}

	public void setTauxPrimeVol3(Float tauxPrimeVol3) {
		this.tauxPrimeVol3 = tauxPrimeVol3;
	}

	@Column(name = "TAUX_FRANCH_VOL", precision = 12, scale = 0)
	public Float getTauxFranchVol() {
		return this.tauxFranchVol;
	}

	public void setTauxFranchVol(Float tauxFranchVol) {
		this.tauxFranchVol = tauxFranchVol;
	}

	@Column(name = "TAUX_PRIME_VOL_ACC", precision = 12, scale = 0)
	public Float getTauxPrimeVolAcc() {
		return this.tauxPrimeVolAcc;
	}

	public void setTauxPrimeVolAcc(Float tauxPrimeVolAcc) {
		this.tauxPrimeVolAcc = tauxPrimeVolAcc;
	}

	@Column(name = "TAUX_FRANCH_VOL_ACC", precision = 12, scale = 0)
	public Float getTauxFranchVolAcc() {
		return this.tauxFranchVolAcc;
	}

	public void setTauxFranchVolAcc(Float tauxFranchVolAcc) {
		this.tauxFranchVolAcc = tauxFranchVolAcc;
	}

	@Column(name = "PRIME_VOL11", precision = 15, scale = 3)
	public BigDecimal getPrimeVol11() {
		return this.primeVol11;
	}

	public void setPrimeVol11(BigDecimal primeVol11) {
		this.primeVol11 = primeVol11;
	}

	@Column(name = "PRIME_VOL12", precision = 15, scale = 3)
	public BigDecimal getPrimeVol12() {
		return this.primeVol12;
	}

	public void setPrimeVol12(BigDecimal primeVol12) {
		this.primeVol12 = primeVol12;
	}

	@Column(name = "PRIME_VOL13", precision = 15, scale = 3)
	public BigDecimal getPrimeVol13() {
		return this.primeVol13;
	}

	public void setPrimeVol13(BigDecimal primeVol13) {
		this.primeVol13 = primeVol13;
	}

	@Column(name = "PRIME_VOL14", precision = 15, scale = 3)
	public BigDecimal getPrimeVol14() {
		return this.primeVol14;
	}

	public void setPrimeVol14(BigDecimal primeVol14) {
		this.primeVol14 = primeVol14;
	}

	@Column(name = "PRIME_VOL15", precision = 15, scale = 3)
	public BigDecimal getPrimeVol15() {
		return this.primeVol15;
	}

	public void setPrimeVol15(BigDecimal primeVol15) {
		this.primeVol15 = primeVol15;
	}

	@Column(name = "PRIME_VOL21", precision = 15, scale = 3)
	public BigDecimal getPrimeVol21() {
		return this.primeVol21;
	}

	public void setPrimeVol21(BigDecimal primeVol21) {
		this.primeVol21 = primeVol21;
	}

	@Column(name = "PRIME_VOL22", precision = 15, scale = 3)
	public BigDecimal getPrimeVol22() {
		return this.primeVol22;
	}

	public void setPrimeVol22(BigDecimal primeVol22) {
		this.primeVol22 = primeVol22;
	}

	@Column(name = "PRIME_VOL23", precision = 15, scale = 3)
	public BigDecimal getPrimeVol23() {
		return this.primeVol23;
	}

	public void setPrimeVol23(BigDecimal primeVol23) {
		this.primeVol23 = primeVol23;
	}

	@Column(name = "PRIME_VOL24", precision = 15, scale = 3)
	public BigDecimal getPrimeVol24() {
		return this.primeVol24;
	}

	public void setPrimeVol24(BigDecimal primeVol24) {
		this.primeVol24 = primeVol24;
	}

	@Column(name = "PRIME_VOL25", precision = 15, scale = 3)
	public BigDecimal getPrimeVol25() {
		return this.primeVol25;
	}

	public void setPrimeVol25(BigDecimal primeVol25) {
		this.primeVol25 = primeVol25;
	}

	@Column(name = "TAUX_VANDAL", precision = 12, scale = 0)
	public Float getTauxVandal() {
		return this.tauxVandal;
	}

	public void setTauxVandal(Float tauxVandal) {
		this.tauxVandal = tauxVandal;
	}

	@Column(name = "PRIME_VANDAL", precision = 15, scale = 3)
	public BigDecimal getPrimeVandal() {
		return this.primeVandal;
	}

	public void setPrimeVandal(BigDecimal primeVandal) {
		this.primeVandal = primeVandal;
	}

	@Column(name = "FRANCH_VANDAL", precision = 12, scale = 0)
	public Float getFranchVandal() {
		return this.franchVandal;
	}

	public void setFranchVandal(Float franchVandal) {
		this.franchVandal = franchVandal;
	}

	@Column(name = "TAUX_PRIME_INCENDIE1", precision = 12, scale = 0)
	public Float getTauxPrimeIncendie1() {
		return this.tauxPrimeIncendie1;
	}

	public void setTauxPrimeIncendie1(Float tauxPrimeIncendie1) {
		this.tauxPrimeIncendie1 = tauxPrimeIncendie1;
	}

	@Column(name = "TAUX_PRIME_INCENDIE2", precision = 12, scale = 0)
	public Float getTauxPrimeIncendie2() {
		return this.tauxPrimeIncendie2;
	}

	public void setTauxPrimeIncendie2(Float tauxPrimeIncendie2) {
		this.tauxPrimeIncendie2 = tauxPrimeIncendie2;
	}

	@Column(name = "TAUX_PRIME_INCENDIE3", precision = 12, scale = 0)
	public Float getTauxPrimeIncendie3() {
		return this.tauxPrimeIncendie3;
	}

	public void setTauxPrimeIncendie3(Float tauxPrimeIncendie3) {
		this.tauxPrimeIncendie3 = tauxPrimeIncendie3;
	}

	@Column(name = "TAUX_FRANCH_INCENDIE", precision = 12, scale = 0)
	public Float getTauxFranchIncendie() {
		return this.tauxFranchIncendie;
	}

	public void setTauxFranchIncendie(Float tauxFranchIncendie) {
		this.tauxFranchIncendie = tauxFranchIncendie;
	}

	@Column(name = "PRIME_INCENDIE11", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie11() {
		return this.primeIncendie11;
	}

	public void setPrimeIncendie11(BigDecimal primeIncendie11) {
		this.primeIncendie11 = primeIncendie11;
	}

	@Column(name = "PRIME_INCENDIE12", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie12() {
		return this.primeIncendie12;
	}

	public void setPrimeIncendie12(BigDecimal primeIncendie12) {
		this.primeIncendie12 = primeIncendie12;
	}

	@Column(name = "PRIME_INCENDIE13", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie13() {
		return this.primeIncendie13;
	}

	public void setPrimeIncendie13(BigDecimal primeIncendie13) {
		this.primeIncendie13 = primeIncendie13;
	}

	@Column(name = "PRIME_INCENDIE14", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie14() {
		return this.primeIncendie14;
	}

	public void setPrimeIncendie14(BigDecimal primeIncendie14) {
		this.primeIncendie14 = primeIncendie14;
	}

	@Column(name = "PRIME_INCENDIE15", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie15() {
		return this.primeIncendie15;
	}

	public void setPrimeIncendie15(BigDecimal primeIncendie15) {
		this.primeIncendie15 = primeIncendie15;
	}

	@Column(name = "PRIME_INCENDIE21", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie21() {
		return this.primeIncendie21;
	}

	public void setPrimeIncendie21(BigDecimal primeIncendie21) {
		this.primeIncendie21 = primeIncendie21;
	}

	@Column(name = "PRIME_INCENDIE22", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie22() {
		return this.primeIncendie22;
	}

	public void setPrimeIncendie22(BigDecimal primeIncendie22) {
		this.primeIncendie22 = primeIncendie22;
	}

	@Column(name = "PRIME_INCENDIE23", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie23() {
		return this.primeIncendie23;
	}

	public void setPrimeIncendie23(BigDecimal primeIncendie23) {
		this.primeIncendie23 = primeIncendie23;
	}

	@Column(name = "PRIME_INCENDIE24", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie24() {
		return this.primeIncendie24;
	}

	public void setPrimeIncendie24(BigDecimal primeIncendie24) {
		this.primeIncendie24 = primeIncendie24;
	}

	@Column(name = "PRIME_INCENDIE25", precision = 15, scale = 3)
	public BigDecimal getPrimeIncendie25() {
		return this.primeIncendie25;
	}

	public void setPrimeIncendie25(BigDecimal primeIncendie25) {
		this.primeIncendie25 = primeIncendie25;
	}

	@Column(name = "SURPRIME_TRANSP_HYD", precision = 12, scale = 0)
	public Float getSurprimeTranspHyd() {
		return this.surprimeTranspHyd;
	}

	public void setSurprimeTranspHyd(Float surprimeTranspHyd) {
		this.surprimeTranspHyd = surprimeTranspHyd;
	}

	@Column(name = "SR_DECES1", precision = 15, scale = 3)
	public BigDecimal getSrDeces1() {
		return this.srDeces1;
	}

	public void setSrDeces1(BigDecimal srDeces1) {
		this.srDeces1 = srDeces1;
	}

	@Column(name = "SR_DECES2", precision = 15, scale = 3)
	public BigDecimal getSrDeces2() {
		return this.srDeces2;
	}

	public void setSrDeces2(BigDecimal srDeces2) {
		this.srDeces2 = srDeces2;
	}

	@Column(name = "SR_DECES3", precision = 15, scale = 3)
	public BigDecimal getSrDeces3() {
		return this.srDeces3;
	}

	public void setSrDeces3(BigDecimal srDeces3) {
		this.srDeces3 = srDeces3;
	}

	@Column(name = "SR_IPT1", precision = 15, scale = 3)
	public BigDecimal getSrIpt1() {
		return this.srIpt1;
	}

	public void setSrIpt1(BigDecimal srIpt1) {
		this.srIpt1 = srIpt1;
	}

	@Column(name = "SR_IPT2", precision = 15, scale = 3)
	public BigDecimal getSrIpt2() {
		return this.srIpt2;
	}

	public void setSrIpt2(BigDecimal srIpt2) {
		this.srIpt2 = srIpt2;
	}

	@Column(name = "SR_IPT3", precision = 15, scale = 3)
	public BigDecimal getSrIpt3() {
		return this.srIpt3;
	}

	public void setSrIpt3(BigDecimal srIpt3) {
		this.srIpt3 = srIpt3;
	}

	@Column(name = "SR_FRAIS_TRAIT1", precision = 15, scale = 3)
	public BigDecimal getSrFraisTrait1() {
		return this.srFraisTrait1;
	}

	public void setSrFraisTrait1(BigDecimal srFraisTrait1) {
		this.srFraisTrait1 = srFraisTrait1;
	}

	@Column(name = "SR_FRAIS_TRAIT2", precision = 15, scale = 3)
	public BigDecimal getSrFraisTrait2() {
		return this.srFraisTrait2;
	}

	public void setSrFraisTrait2(BigDecimal srFraisTrait2) {
		this.srFraisTrait2 = srFraisTrait2;
	}

	@Column(name = "SR_FRAIS_TRAIT3", precision = 15, scale = 3)
	public BigDecimal getSrFraisTrait3() {
		return this.srFraisTrait3;
	}

	public void setSrFraisTrait3(BigDecimal srFraisTrait3) {
		this.srFraisTrait3 = srFraisTrait3;
	}

	@Column(name = "SR_PRIME1", precision = 15, scale = 3)
	public BigDecimal getSrPrime1() {
		return this.srPrime1;
	}

	public void setSrPrime1(BigDecimal srPrime1) {
		this.srPrime1 = srPrime1;
	}

	@Column(name = "SR_PRIME2", precision = 15, scale = 3)
	public BigDecimal getSrPrime2() {
		return this.srPrime2;
	}

	public void setSrPrime2(BigDecimal srPrime2) {
		this.srPrime2 = srPrime2;
	}

	@Column(name = "SR_PRIME3", precision = 15, scale = 3)
	public BigDecimal getSrPrime3() {
		return this.srPrime3;
	}

	public void setSrPrime3(BigDecimal srPrime3) {
		this.srPrime3 = srPrime3;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif12b> getRcTarif12bs() {
		return this.rcTarif12bs;
	}

	public void setRcTarif12bs(Set<RcTarif12b> rcTarif12bs) {
		this.rcTarif12bs = rcTarif12bs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif8> getRcTarif8s() {
		return this.rcTarif8s;
	}

	public void setRcTarif8s(Set<RcTarif8> rcTarif8s) {
		this.rcTarif8s = rcTarif8s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif3> getRcTarif3s() {
		return this.rcTarif3s;
	}

	public void setRcTarif3s(Set<RcTarif3> rcTarif3s) {
		this.rcTarif3s = rcTarif3s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif9> getRcTarif9s() {
		return this.rcTarif9s;
	}

	public void setRcTarif9s(Set<RcTarif9> rcTarif9s) {
		this.rcTarif9s = rcTarif9s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif7> getRcTarif7s() {
		return this.rcTarif7s;
	}

	public void setRcTarif7s(Set<RcTarif7> rcTarif7s) {
		this.rcTarif7s = rcTarif7s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif12> getRcTarif12s() {
		return this.rcTarif12s;
	}

	public void setRcTarif12s(Set<RcTarif12> rcTarif12s) {
		this.rcTarif12s = rcTarif12s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif10> getRcTarif10s() {
		return this.rcTarif10s;
	}

	public void setRcTarif10s(Set<RcTarif10> rcTarif10s) {
		this.rcTarif10s = rcTarif10s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif1> getRcTarif1s() {
		return this.rcTarif1s;
	}

	public void setRcTarif1s(Set<RcTarif1> rcTarif1s) {
		this.rcTarif1s = rcTarif1s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif2> getRcTarif2s() {
		return this.rcTarif2s;
	}

	public void setRcTarif2s(Set<RcTarif2> rcTarif2s) {
		this.rcTarif2s = rcTarif2s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif4> getRcTarif4s() {
		return this.rcTarif4s;
	}

	public void setRcTarif4s(Set<RcTarif4> rcTarif4s) {
		this.rcTarif4s = rcTarif4s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif5> getRcTarif5s() {
		return this.rcTarif5s;
	}

	public void setRcTarif5s(Set<RcTarif5> rcTarif5s) {
		this.rcTarif5s = rcTarif5s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<RcTarif6> getRcTarif6s() {
		return this.rcTarif6s;
	}

	public void setRcTarif6s(Set<RcTarif6> rcTarif6s) {
		this.rcTarif6s = rcTarif6s;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tarif")
	public Set<SousCatVehicule> getSousCatVehicules() {
		return this.sousCatVehicules;
	}

	public void setSousCatVehicules(Set<SousCatVehicule> sousCatVehicules) {
		this.sousCatVehicules = sousCatVehicules;
	}

}
