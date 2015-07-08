package com.j3a.assurance.model;

// Generated 6 juil. 2015 11:25:44 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * EffectifPersonnel generated by hbm2java
 */
@Entity
@Table(name = "effectif_personnel", catalog = "zeusbd")
public class EffectifPersonnel implements java.io.Serializable {

	private String codeEffectifPersonnel;
	private Integer personnelDirection;
	private Integer agentMaitrise;
	private Integer agentExecution;
	private Integer autreProdSalPays;
	private Integer totalPersSalarie;
	private Integer agentGeneroPays;
	private Integer coutiers;
	private Integer totalPersNonSalarie;
	private Set<EtatCima> etatCimas = new HashSet<EtatCima>(0);

	public EffectifPersonnel() {
	}

	public EffectifPersonnel(String codeEffectifPersonnel) {
		this.codeEffectifPersonnel = codeEffectifPersonnel;
	}

	public EffectifPersonnel(String codeEffectifPersonnel,
			Integer personnelDirection, Integer agentMaitrise,
			Integer agentExecution, Integer autreProdSalPays,
			Integer totalPersSalarie, Integer agentGeneroPays,
			Integer coutiers, Integer totalPersNonSalarie,
			Set<EtatCima> etatCimas) {
		this.codeEffectifPersonnel = codeEffectifPersonnel;
		this.personnelDirection = personnelDirection;
		this.agentMaitrise = agentMaitrise;
		this.agentExecution = agentExecution;
		this.autreProdSalPays = autreProdSalPays;
		this.totalPersSalarie = totalPersSalarie;
		this.agentGeneroPays = agentGeneroPays;
		this.coutiers = coutiers;
		this.totalPersNonSalarie = totalPersNonSalarie;
		this.etatCimas = etatCimas;
	}

	@Id
	@Column(name = "CODE_EFFECTIF_PERSONNEL", unique = true, nullable = false, length = 20)
	public String getCodeEffectifPersonnel() {
		return this.codeEffectifPersonnel;
	}

	public void setCodeEffectifPersonnel(String codeEffectifPersonnel) {
		this.codeEffectifPersonnel = codeEffectifPersonnel;
	}

	@Column(name = "PERSONNEL_DIRECTION")
	public Integer getPersonnelDirection() {
		return this.personnelDirection;
	}

	public void setPersonnelDirection(Integer personnelDirection) {
		this.personnelDirection = personnelDirection;
	}

	@Column(name = "AGENT_MAITRISE")
	public Integer getAgentMaitrise() {
		return this.agentMaitrise;
	}

	public void setAgentMaitrise(Integer agentMaitrise) {
		this.agentMaitrise = agentMaitrise;
	}

	@Column(name = "AGENT_EXECUTION")
	public Integer getAgentExecution() {
		return this.agentExecution;
	}

	public void setAgentExecution(Integer agentExecution) {
		this.agentExecution = agentExecution;
	}

	@Column(name = "AUTRE_PROD_SAL_PAYS")
	public Integer getAutreProdSalPays() {
		return this.autreProdSalPays;
	}

	public void setAutreProdSalPays(Integer autreProdSalPays) {
		this.autreProdSalPays = autreProdSalPays;
	}

	@Column(name = "TOTAL_PERS_SALARIE")
	public Integer getTotalPersSalarie() {
		return this.totalPersSalarie;
	}

	public void setTotalPersSalarie(Integer totalPersSalarie) {
		this.totalPersSalarie = totalPersSalarie;
	}

	@Column(name = "AGENT_GENERO_PAYS")
	public Integer getAgentGeneroPays() {
		return this.agentGeneroPays;
	}

	public void setAgentGeneroPays(Integer agentGeneroPays) {
		this.agentGeneroPays = agentGeneroPays;
	}

	@Column(name = "COUTIERS")
	public Integer getCoutiers() {
		return this.coutiers;
	}

	public void setCoutiers(Integer coutiers) {
		this.coutiers = coutiers;
	}

	@Column(name = "TOTAL_PERS_NON_SALARIE")
	public Integer getTotalPersNonSalarie() {
		return this.totalPersNonSalarie;
	}

	public void setTotalPersNonSalarie(Integer totalPersNonSalarie) {
		this.totalPersNonSalarie = totalPersNonSalarie;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "effectif_perso_etat_cima", catalog = "zeusbd", joinColumns = { @JoinColumn(name = "CODE_EFFECTIF_PERSONNEL", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "CODE_ETAT_CIMA", nullable = false, updatable = false) })
	public Set<EtatCima> getEtatCimas() {
		return this.etatCimas;
	}

	public void setEtatCimas(Set<EtatCima> etatCimas) {
		this.etatCimas = etatCimas;
	}

}
