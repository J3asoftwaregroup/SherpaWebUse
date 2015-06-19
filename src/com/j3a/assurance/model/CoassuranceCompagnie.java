package com.j3a.assurance.model;

// Generated 18 juin 2015 16:44:49 by Hibernate Tools 4.3.1

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
 * CoassuranceCompagnie generated by hbm2java
 */
@Entity
@Table(name = "coassurance_compagnie", catalog = "zeusbd")
public class CoassuranceCompagnie implements java.io.Serializable {

	private CoassuranceCompagnieId id;
	private Coassurance coassurance;
	private Compagnie compagnie;
	private BigDecimal montantAssure;

	public CoassuranceCompagnie() {
	}

	public CoassuranceCompagnie(CoassuranceCompagnieId id,
			Coassurance coassurance, Compagnie compagnie) {
		this.id = id;
		this.coassurance = coassurance;
		this.compagnie = compagnie;
	}

	public CoassuranceCompagnie(CoassuranceCompagnieId id,
			Coassurance coassurance, Compagnie compagnie,
			BigDecimal montantAssure) {
		this.id = id;
		this.coassurance = coassurance;
		this.compagnie = compagnie;
		this.montantAssure = montantAssure;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codeCoassurance", column = @Column(name = "CODE_COASSURANCE", nullable = false, length = 16)),
			@AttributeOverride(name = "codeCompagnie", column = @Column(name = "CODE_COMPAGNIE", nullable = false, length = 10)) })
	public CoassuranceCompagnieId getId() {
		return this.id;
	}

	public void setId(CoassuranceCompagnieId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_COASSURANCE", nullable = false, insertable = false, updatable = false)
	public Coassurance getCoassurance() {
		return this.coassurance;
	}

	public void setCoassurance(Coassurance coassurance) {
		this.coassurance = coassurance;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_COMPAGNIE", nullable = false, insertable = false, updatable = false)
	public Compagnie getCompagnie() {
		return this.compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	@Column(name = "MONTANT_ASSURE", precision = 15, scale = 3)
	public BigDecimal getMontantAssure() {
		return this.montantAssure;
	}

	public void setMontantAssure(BigDecimal montantAssure) {
		this.montantAssure = montantAssure;
	}

}
