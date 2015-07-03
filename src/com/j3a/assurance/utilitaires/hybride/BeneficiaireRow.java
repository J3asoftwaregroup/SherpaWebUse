package com.j3a.assurance.utilitaires.hybride;

import com.j3a.assurance.model.Beneficiaire;


public class BeneficiaireRow {
	private Beneficiaire beneficiaire = new Beneficiaire();
	private int nOrdr;
	
	private Boolean statutBeneficiaireBD;
	public BeneficiaireRow() {
		beneficiaire.setPartBeneficiaire(0);
	}
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	public int getnOrdr() {
		return nOrdr;
	}
	public void setnOrdr(int nOrdr) {
		this.nOrdr = nOrdr;
	}
	public Boolean getStatutBeneficiaireBD() {
		return statutBeneficiaireBD;
	}
	public void setStatutBeneficiaireBD(Boolean statutBeneficiaireBD) {
		this.statutBeneficiaireBD = statutBeneficiaireBD;
	}

}
