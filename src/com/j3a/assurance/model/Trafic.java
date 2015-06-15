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
 * Trafic generated by hbm2java
 */
@Entity
@Table(name = "trafic", catalog = "zeusbd")
public class Trafic implements java.io.Serializable {

	private String codeTrafic;
	private ListeTrafic listeTrafic;
	private Integer numeroTrafic;
	private String designationTrafic;
	private BigDecimal pleinExp;
	private BigDecimal accessoires;
	private Set aliments = new HashSet(0);

	public Trafic() {
	}

	public Trafic(String codeTrafic) {
		this.codeTrafic = codeTrafic;
	}

	public Trafic(String codeTrafic, ListeTrafic listeTrafic,
			Integer numeroTrafic, String designationTrafic,
			BigDecimal pleinExp, BigDecimal accessoires, Set aliments) {
		this.codeTrafic = codeTrafic;
		this.listeTrafic = listeTrafic;
		this.numeroTrafic = numeroTrafic;
		this.designationTrafic = designationTrafic;
		this.pleinExp = pleinExp;
		this.accessoires = accessoires;
		this.aliments = aliments;
	}

	@Id
	@Column(name = "CODE_TRAFIC", unique = true, nullable = false, length = 30)
	public String getCodeTrafic() {
		return this.codeTrafic;
	}

	public void setCodeTrafic(String codeTrafic) {
		this.codeTrafic = codeTrafic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODE_LISTE_TRAFIC")
	public ListeTrafic getListeTrafic() {
		return this.listeTrafic;
	}

	public void setListeTrafic(ListeTrafic listeTrafic) {
		this.listeTrafic = listeTrafic;
	}

	@Column(name = "NUMERO_TRAFIC")
	public Integer getNumeroTrafic() {
		return this.numeroTrafic;
	}

	public void setNumeroTrafic(Integer numeroTrafic) {
		this.numeroTrafic = numeroTrafic;
	}

	@Column(name = "DESIGNATION_TRAFIC", length = 60)
	public String getDesignationTrafic() {
		return this.designationTrafic;
	}

	public void setDesignationTrafic(String designationTrafic) {
		this.designationTrafic = designationTrafic;
	}

	@Column(name = "PLEIN_EXP", precision = 15, scale = 3)
	public BigDecimal getPleinExp() {
		return this.pleinExp;
	}

	public void setPleinExp(BigDecimal pleinExp) {
		this.pleinExp = pleinExp;
	}

	@Column(name = "ACCESSOIRES", precision = 15, scale = 3)
	public BigDecimal getAccessoires() {
		return this.accessoires;
	}

	public void setAccessoires(BigDecimal accessoires) {
		this.accessoires = accessoires;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "trafic")
	public Set getAliments() {
		return this.aliments;
	}

	public void setAliments(Set aliments) {
		this.aliments = aliments;
	}

}
