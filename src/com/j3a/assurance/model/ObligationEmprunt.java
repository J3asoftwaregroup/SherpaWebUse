package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ObligationEmprunt generated by hbm2java
 */
@Entity
@Table(name = "obligation_emprunt", catalog = "zeusbd")
public class ObligationEmprunt implements java.io.Serializable {

	private String codeObEmp;
	private int codeexercice;
	private String nature;
	private BigDecimal montant;
	private String type;

	public ObligationEmprunt() {
	}

	public ObligationEmprunt(String codeObEmp, int codeexercice) {
		this.codeObEmp = codeObEmp;
		this.codeexercice = codeexercice;
	}

	public ObligationEmprunt(String codeObEmp, int codeexercice, String nature,
			BigDecimal montant, String type) {
		this.codeObEmp = codeObEmp;
		this.codeexercice = codeexercice;
		this.nature = nature;
		this.montant = montant;
		this.type = type;
	}

	@Id
	@Column(name = "CODE_OB_EMP", unique = true, nullable = false, length = 20)
	public String getCodeObEmp() {
		return this.codeObEmp;
	}

	public void setCodeObEmp(String codeObEmp) {
		this.codeObEmp = codeObEmp;
	}

	@Column(name = "CODEEXERCICE", nullable = false)
	public int getCodeexercice() {
		return this.codeexercice;
	}

	public void setCodeexercice(int codeexercice) {
		this.codeexercice = codeexercice;
	}

	@Column(name = "NATURE", length = 30)
	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Column(name = "MONTANT", precision = 15, scale = 3)
	public BigDecimal getMontant() {
		return this.montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	@Column(name = "TYPE", length = 30)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}