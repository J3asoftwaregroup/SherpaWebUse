package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Etatc10tabaExercice generated by hbm2java
 */
@Entity
@Table(name = "etatc10taba_exercice", catalog = "zeusbd")
public class Etatc10tabaExercice implements java.io.Serializable {

	private Etatc10tabaExerciceId id;
	private Etatc10TabA etatc10TabA;
	private Exercice exercice;
	private BigDecimal reglementexo;
	private BigDecimal provisionexo;
	private BigDecimal totalsinistreexo;
	private BigDecimal primeacquiseexo;
	private BigDecimal sinistresurprimeacquisepourcenexo;
	private String libelleexo;

	public Etatc10tabaExercice() {
	}

	public Etatc10tabaExercice(Etatc10tabaExerciceId id,
			Etatc10TabA etatc10TabA, Exercice exercice) {
		this.id = id;
		this.etatc10TabA = etatc10TabA;
		this.exercice = exercice;
	}

	public Etatc10tabaExercice(Etatc10tabaExerciceId id,
			Etatc10TabA etatc10TabA, Exercice exercice,
			BigDecimal reglementexo, BigDecimal provisionexo,
			BigDecimal totalsinistreexo, BigDecimal primeacquiseexo,
			BigDecimal sinistresurprimeacquisepourcenexo, String libelleexo) {
		this.id = id;
		this.etatc10TabA = etatc10TabA;
		this.exercice = exercice;
		this.reglementexo = reglementexo;
		this.provisionexo = provisionexo;
		this.totalsinistreexo = totalsinistreexo;
		this.primeacquiseexo = primeacquiseexo;
		this.sinistresurprimeacquisepourcenexo = sinistresurprimeacquisepourcenexo;
		this.libelleexo = libelleexo;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeetatc10", column = @Column(name = "CODEETATC10", nullable = false, length = 20)),
			@AttributeOverride(name = "codeexercice", column = @Column(name = "CODEEXERCICE", nullable = false)) })
	public Etatc10tabaExerciceId getId() {
		return this.id;
	}

	public void setId(Etatc10tabaExerciceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODEETATC10", nullable = false, insertable = false, updatable = false)
	public Etatc10TabA getEtatc10TabA() {
		return this.etatc10TabA;
	}

	public void setEtatc10TabA(Etatc10TabA etatc10TabA) {
		this.etatc10TabA = etatc10TabA;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODEEXERCICE", nullable = false, insertable = false, updatable = false)
	public Exercice getExercice() {
		return this.exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Column(name = "REGLEMENTEXO", precision = 15, scale = 3)
	public BigDecimal getReglementexo() {
		return this.reglementexo;
	}

	public void setReglementexo(BigDecimal reglementexo) {
		this.reglementexo = reglementexo;
	}

	@Column(name = "PROVISIONEXO", precision = 15, scale = 3)
	public BigDecimal getProvisionexo() {
		return this.provisionexo;
	}

	public void setProvisionexo(BigDecimal provisionexo) {
		this.provisionexo = provisionexo;
	}

	@Column(name = "TOTALSINISTREEXO", precision = 15, scale = 3)
	public BigDecimal getTotalsinistreexo() {
		return this.totalsinistreexo;
	}

	public void setTotalsinistreexo(BigDecimal totalsinistreexo) {
		this.totalsinistreexo = totalsinistreexo;
	}

	@Column(name = "PRIMEACQUISEEXO", precision = 15, scale = 3)
	public BigDecimal getPrimeacquiseexo() {
		return this.primeacquiseexo;
	}

	public void setPrimeacquiseexo(BigDecimal primeacquiseexo) {
		this.primeacquiseexo = primeacquiseexo;
	}

	@Column(name = "SINISTRESURPRIMEACQUISEPOURCENEXO", precision = 15, scale = 3)
	public BigDecimal getSinistresurprimeacquisepourcenexo() {
		return this.sinistresurprimeacquisepourcenexo;
	}

	public void setSinistresurprimeacquisepourcenexo(
			BigDecimal sinistresurprimeacquisepourcenexo) {
		this.sinistresurprimeacquisepourcenexo = sinistresurprimeacquisepourcenexo;
	}

	@Column(name = "LIBELLEEXO", length = 10)
	public String getLibelleexo() {
		return this.libelleexo;
	}

	public void setLibelleexo(String libelleexo) {
		this.libelleexo = libelleexo;
	}

}
