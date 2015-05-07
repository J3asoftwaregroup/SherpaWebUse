package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Vente generated by hbm2java
 */
@Entity
@Table(name = "vente", catalog = "zeusbd")
public class Vente implements java.io.Serializable {

	private String codePortefeilles;
	private Exercice exercice;
	private Portefeuilles portefeuilles;
	private String natureVente;
	private String acquereurVente;
	private BigDecimal montantVente;

	public Vente() {
	}

	public Vente(Portefeuilles portefeuilles) {
		this.portefeuilles = portefeuilles;
	}

	public Vente(Exercice exercice, Portefeuilles portefeuilles,
			String natureVente, String acquereurVente, BigDecimal montantVente) {
		this.exercice = exercice;
		this.portefeuilles = portefeuilles;
		this.natureVente = natureVente;
		this.acquereurVente = acquereurVente;
		this.montantVente = montantVente;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "portefeuilles"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CODE_PORTEFEILLES", unique = true, nullable = false, length = 20)
	public String getCodePortefeilles() {
		return this.codePortefeilles;
	}

	public void setCodePortefeilles(String codePortefeilles) {
		this.codePortefeilles = codePortefeilles;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODEEXERCICE")
	public Exercice getExercice() {
		return this.exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Portefeuilles getPortefeuilles() {
		return this.portefeuilles;
	}

	public void setPortefeuilles(Portefeuilles portefeuilles) {
		this.portefeuilles = portefeuilles;
	}

	@Column(name = "NATURE_VENTE", length = 20)
	public String getNatureVente() {
		return this.natureVente;
	}

	public void setNatureVente(String natureVente) {
		this.natureVente = natureVente;
	}

	@Column(name = "ACQUEREUR_VENTE", length = 20)
	public String getAcquereurVente() {
		return this.acquereurVente;
	}

	public void setAcquereurVente(String acquereurVente) {
		this.acquereurVente = acquereurVente;
	}

	@Column(name = "MONTANT_VENTE", precision = 15, scale = 3)
	public BigDecimal getMontantVente() {
		return this.montantVente;
	}

	public void setMontantVente(BigDecimal montantVente) {
		this.montantVente = montantVente;
	}

}
