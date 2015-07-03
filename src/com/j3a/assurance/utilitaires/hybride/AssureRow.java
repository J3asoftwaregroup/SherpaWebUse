package com.j3a.assurance.utilitaires.hybride;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.j3a.assurance.model.Apporteur;
import com.j3a.assurance.model.AssureIa;
import com.j3a.assurance.model.Beneficiaire;
import com.j3a.assurance.model.ClasseIa;
import com.j3a.assurance.model.GarantieChoisieIa;
import com.j3a.assurance.model.GarantieGarantieChoisieIa;
import com.j3a.assurance.utilitaire.Garanties;



public class AssureRow {
private AssureIa assure = new AssureIa();
private ClasseIa classeIa = new ClasseIa();
private List<Garanties> listegarantiesIa =new ArrayList<Garanties>();
private List<AssureIa> listAssures = new ArrayList<AssureIa>();
private List<BeneficiaireRow> listBeneficiaireRow = new ArrayList<BeneficiaireRow>();
private List<Beneficiaire> listBeneficiaires=new ArrayList<Beneficiaire>();
private GarantieChoisieIa gcIa = new GarantieChoisieIa();
private List<GarantieGarantieChoisieIa> gGcIa =  new ArrayList<GarantieGarantieChoisieIa>();
private java.math.BigDecimal accessoireAssure = BigDecimal.ZERO;
private java.math.BigDecimal prime= BigDecimal.ZERO;
private boolean statutAssureBD = false;
private int nOrdr;
private java.math.BigDecimal commissionApporteur = BigDecimal.ZERO;
private java.math.BigDecimal tauxCommissionApporteur = BigDecimal.ZERO;
private java.math.BigDecimal primeNette = BigDecimal.ZERO;
private Apporteur apporteur = new Apporteur();

	public AssureRow() {
		// TODO Auto-generated constructor stub
	}

	public AssureIa getAssure() {
		return assure;
	}

	public void setAssure(AssureIa assure) {
		this.assure = assure;
	}

	public java.math.BigDecimal getCommissionApporteur() {
		return commissionApporteur;
	}

	public void setCommissionApporteur(java.math.BigDecimal commissionApporteur) {
		this.commissionApporteur = commissionApporteur;
	}

	public java.math.BigDecimal getPrimeNette() {
		return primeNette;
	}

	public void setPrimeNette(java.math.BigDecimal primeNette) {
		this.primeNette = primeNette;
	}

	public Apporteur getApporteur() {
		return apporteur;
	}

	public void setApporteur(Apporteur apporteur) {
		this.apporteur = apporteur;
	}

	public ClasseIa getClasseIa() {
		return classeIa;
	}

	public void setClasseIa(ClasseIa classeIa) {
		this.classeIa = classeIa;
	}

	public List<Garanties> getListegarantiesIa() {
		return listegarantiesIa;
	}

	public void setListegarantiesIa(List<Garanties> listegarantiesIa) {
		this.listegarantiesIa = listegarantiesIa;
	}

	public java.math.BigDecimal getPrime() {
		return prime;
	}

	public void setPrime(java.math.BigDecimal prime) {
		this.prime = prime;
	}

	public boolean isStatutAssureBD() {
		return statutAssureBD;
	}

	public void setStatutAssureBD(boolean statutAssureBD) {
		this.statutAssureBD = statutAssureBD;
	}

	public int getnOrdr() {
		return nOrdr;
	}

	public void setnOrdr(int nOrdr) {
		this.nOrdr = nOrdr;
	}

	public List<AssureIa> getListAssures() {
		return listAssures;
	}

	public void setListAssures(List<AssureIa> listAssures) {
		this.listAssures = listAssures;
	}

	public List<BeneficiaireRow> getListBeneficiaireRow() {
		return listBeneficiaireRow;
	}

	public void setListBeneficiaireRow(List<BeneficiaireRow> listBeneficiaireRow) {
		this.listBeneficiaireRow = listBeneficiaireRow;
	}

	public GarantieChoisieIa getGcIa() {
		return gcIa;
	}

	public void setGcIa(GarantieChoisieIa gcIa) {
		this.gcIa = gcIa;
	}

	public java.math.BigDecimal getAccessoireAssure() {
		return accessoireAssure;
	}

	public void setAccessoireAssure(java.math.BigDecimal accessoireAssure) {
		this.accessoireAssure = accessoireAssure;
	}

	public List<GarantieGarantieChoisieIa> getgGcIa() {
		return gGcIa;
	}

	public void setgGcIa(List<GarantieGarantieChoisieIa> gGcIa) {
		this.gGcIa = gGcIa;
	}

	public List<Beneficiaire> getListBeneficiaires() {
		System.out.println("TEST BEFOREEEE");
		if(listBeneficiaires.isEmpty())
			System.out.println("ListBenef"+listBeneficiaires);
			listBeneficiaires=new ArrayList<Beneficiaire>(assure.getBeneficiaires()) ;
		return listBeneficiaires;
	}

	public void setListBeneficiaires(List<Beneficiaire> listBeneficiaires) {
		this.listBeneficiaires = listBeneficiaires;
	}

	public java.math.BigDecimal getTauxCommissionApporteur() {
		return tauxCommissionApporteur;
	}

	public void setTauxCommissionApporteur(java.math.BigDecimal tauxCommissionApporteur) {
		this.tauxCommissionApporteur = tauxCommissionApporteur;
	}

	
	
}
