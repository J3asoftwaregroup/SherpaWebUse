package com.j3a.assurance.model;

// Generated 5 mai 2015 11:21:10 by Hibernate Tools 4.3.1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Emission generated by hbm2java
 */
@Entity
@Table(name = "emission", catalog = "zeusbd")
public class Emission implements java.io.Serializable {

	private String codeObEmp;
	private ObligationEmprunt obligationEmprunt;
	private String nature;
	private BigDecimal montantEmis;

	public Emission() {
	}

	public Emission(ObligationEmprunt obligationEmprunt) {
		this.obligationEmprunt = obligationEmprunt;
	}

	public Emission(ObligationEmprunt obligationEmprunt, String nature,
			BigDecimal montantEmis) {
		this.obligationEmprunt = obligationEmprunt;
		this.nature = nature;
		this.montantEmis = montantEmis;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "obligationEmprunt"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CODE_OB_EMP", unique = true, nullable = false, length = 20)
	public String getCodeObEmp() {
		return this.codeObEmp;
	}

	public void setCodeObEmp(String codeObEmp) {
		this.codeObEmp = codeObEmp;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public ObligationEmprunt getObligationEmprunt() {
		return this.obligationEmprunt;
	}

	public void setObligationEmprunt(ObligationEmprunt obligationEmprunt) {
		this.obligationEmprunt = obligationEmprunt;
	}

	@Column(name = "NATURE", length = 30)
	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Column(name = "MONTANT_EMIS", precision = 15, scale = 3)
	public BigDecimal getMontantEmis() {
		return this.montantEmis;
	}

	public void setMontantEmis(BigDecimal montantEmis) {
		this.montantEmis = montantEmis;
	}

}
