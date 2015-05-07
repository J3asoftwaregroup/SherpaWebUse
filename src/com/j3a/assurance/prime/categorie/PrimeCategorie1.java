package com.j3a.sherpawebuser.prime.categorie;

import java.math.BigDecimal;

public class PrimeCategorie1 implements PrimeCategorieInterface {

	private String energie;
	private String typeVehicule;
	private java.math.BigDecimal puissFisc = BigDecimal.ZERO;
	private java.math.BigDecimal puissReel = BigDecimal.ZERO;
	private String categorie;
	private String zone;
	private String classe;
	private String statut;
	private java.math.BigDecimal primeBase = BigDecimal.ZERO;
	private boolean remorque;
	private java.math.BigDecimal primeRemorque = BigDecimal.ZERO;
	private java.math.BigDecimal surprimes = BigDecimal.ZERO;
	private String typeTransporte;
	private short nbreTransporte;
	private java.math.BigDecimal primeRc = BigDecimal.ZERO;
	private java.math.BigDecimal defenseRecours = BigDecimal.ZERO;
	private java.math.BigDecimal defenseRecoursDommage = BigDecimal.ZERO;
	private java.math.BigDecimal immobilisation = BigDecimal.ZERO;
	private java.math.BigDecimal remboursemmentAnticipe = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRC = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRNC1 = BigDecimal.ZERO;
	private java.math.BigDecimal brisGlaceRNC2 = BigDecimal.ZERO;
	private java.math.BigDecimal valeurVenale = BigDecimal.ZERO;
	private java.math.BigDecimal valeurNeuve = BigDecimal.ZERO;
	private int dureePermis;
	private java.math.BigDecimal dommage = BigDecimal.ZERO;
	private java.math.BigDecimal collision = BigDecimal.ZERO;
	private java.math.BigDecimal volMain = BigDecimal.ZERO;
	private java.math.BigDecimal volAccessoires = BigDecimal.ZERO;
	private java.math.BigDecimal volVandalisme = BigDecimal.ZERO;
	private java.math.BigDecimal montantAccessoires = BigDecimal.ZERO;
	private java.math.BigDecimal incendie = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere1 = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere2 = BigDecimal.ZERO;
	private java.math.BigDecimal securiteRoutiere3= BigDecimal.ZERO;
	private String optionSR;
	private java.math.BigDecimal individuelChauf1 = BigDecimal.ZERO;
	private java.math.BigDecimal individuelChauf2 = BigDecimal.ZERO;
	private java.math.BigDecimal individuelChauf3 = BigDecimal.ZERO;
	private java.math.BigDecimal reduction = BigDecimal.ZERO;
	private String optionIndCh;
	private int dureeContrat;
	private int ageVehicule;
	private java.math.BigDecimal chargeUtile= BigDecimal.ZERO;
	private short nbrecarte;
	private short nbrePlaceCab;
	private short nbrePlaceHorscab;



	/*---------------determination de la prime li�e aux garanties----------------------------------*/
	
	public java.math.BigDecimal getPrimeBase() {
		 primeBase = BigDecimal.ZERO;
		 if ((energie.equals("essence") & puissFisc.intValue() >= 1 & puissFisc.intValue() <= 2)
					|| (energie.equals("diesel") & puissFisc.intValue() == 1)) {
				if (zone.equals("zone1"))
					// setprimeRc(58675);
					primeBase = BigDecimal.valueOf(58675);
				if (zone.equals("zone2"))
					// setprimeBase(55741);
					primeBase = BigDecimal.valueOf(55741);
				if (zone.equals("zone3"))
					// setprimeBase(52808);
					primeBase = BigDecimal.valueOf(52808);
			}

			if ((energie.equals("essence") & puissFisc.intValue() >= 3 & puissFisc.intValue() <= 6)
					|| (energie.equals("diesel") & puissFisc.intValue() >= 2 & puissFisc.intValue() <= 4)) {
				if (zone.equals("zone1"))
					// setprimeBase(66885);
					primeBase = BigDecimal.valueOf(66885);
				if (zone.equals("zone2"))
					// setprimeBase(63541);
					primeBase = BigDecimal.valueOf(63541);
				if (zone.equals("zone3"))
					// setprimeBase(60197);
					primeBase = BigDecimal.valueOf(60197);
			}

			if ((energie.equals("essence") & puissFisc.intValue() >= 7 & puissFisc.intValue() <= 9)
					|| (energie.equals("diesel") & puissFisc.intValue() >= 5 & puissFisc.intValue() <= 6)) {
				if (zone.equals("zone1"))
					// setprimeBase(73415);
					primeBase = BigDecimal.valueOf(73415);
				if (zone.equals("zone2"))
					// setprimeBase(69744);
					primeBase = BigDecimal.valueOf(69744);
				if (zone.equals("zone3"))
					// setprimeBase(66074);
					primeBase = BigDecimal.valueOf(66074);
			}
			if ((energie.equals("essence") & puissFisc.intValue() >= 10 & puissFisc.intValue() <= 11)
					|| (energie.equals("diesel") & puissFisc.intValue() >= 7 & puissFisc.intValue() <= 8)) {
				if (zone.equals("zone1"))
					// setprimeBase(114693);
					primeBase = BigDecimal.valueOf(114693);
				if (zone.equals("zone2"))
					// setprimeBase(108958);
					primeBase = BigDecimal.valueOf(108958);
				if (zone.equals("zone3"))
					// setprimeBase(103224);
					primeBase = BigDecimal.valueOf(103224);
			}
			if ((energie.equals("essence") & puissFisc.intValue() >= 12)
					|| (energie.equals("diesel") & puissFisc.intValue() >= 9)) {
				if (zone.equals("zone1"))
					// setprimeBase(129058);
					primeBase = BigDecimal.valueOf(129058);
				if (zone.equals("zone2"))
					// setprimeBase(122605);
					primeBase = BigDecimal.valueOf(122605);
				if (zone.equals("zone3"))
					// setprimeBase(116152);
					primeBase = BigDecimal.valueOf(116152);
			}

		 System.out.println("Prime de Base=========="+primeBase);
		return primeBase;
	}
	
	
	/*---------------	calcul de la prime RC-------------------------------*/
	public java.math.BigDecimal getPrimeRc() {
		java.math.BigDecimal red = BigDecimal.ZERO;
		getPrimeBase();
		 primeRc = primeBase;
		 if (dureePermis <= 2) {
			classe = "classe1";
		}
		if (dureePermis > 2) {
			classe = "classe2";
		}

		if (classe.equals("classe2")) {
			
			//primeRc = primeRc.multiply(BigDecimal.valueOf(0.95));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)));
		}

		if (statut.equals("a") || statut.equals("b") || statut.equals("c")) {
			//primeRc = primeRc.multiply(BigDecimal.valueOf(0.95));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.05)));
		}

		if (statut.equals("d") || statut.equals("e")) {
			//primeRc = primeRc.multiply(BigDecimal.valueOf(0.90));
			red = red.add(primeBase.multiply(BigDecimal.valueOf(0.1)));
		}

		if (remorque == true) {
			//primeRc = primeRc.multiply(BigDecimal.valueOf(1.2));
			primeRemorque = primeRemorque.add(primeBase.multiply(BigDecimal.valueOf(0.1)));
		
		}
		
		reduction = red;
		primeRc = primeRc.add(primeRemorque).subtract(reduction);
		//calcul des surprimes pour la RC
		//if(get)
		
		return primeRc;
	}

	/*------------determination de la prime en defense recours--------------------------------*/
	public java.math.BigDecimal getDefenseRecours() {
		defenseRecours = BigDecimal.valueOf(7950);
		return defenseRecours;
	}

	public java.math.BigDecimal getDefenseRecoursDommage() {
		defenseRecoursDommage = BigDecimal.valueOf(4240);
		return defenseRecoursDommage;
	}

	/*-------------------determination de la prime en immobilisation--------------------*/
	public java.math.BigDecimal getImmobilisation() {
		immobilisation = BigDecimal.valueOf(17000);
		return immobilisation;
	}

	/*-------------------determination de la prime en remboursement anticipe--------------------*/
	public java.math.BigDecimal getRemboursemmentAnticipe() {
		if(dureeContrat<12){
		remboursemmentAnticipe = remboursemmentAnticipe.add(BigDecimal.valueOf(15000));
		}else{
		remboursemmentAnticipe = remboursemmentAnticipe.add(BigDecimal.valueOf(10000));
		}
		return remboursemmentAnticipe;
	}

	/*-------------------determination de la prime en brise de glace--------------------*/
	public java.math.BigDecimal getBrisGlaceRC() {
		
		brisGlaceRC = brisGlaceRC.add(getValeurNeuve().multiply(BigDecimal.valueOf(0.003)));
		return brisGlaceRC;
	}
	
	public java.math.BigDecimal getBrisGlaceRNC1() {
		
		brisGlaceRNC1 = brisGlaceRNC1.add(getValeurNeuve().multiply(BigDecimal.valueOf(0.0047)));
		return brisGlaceRNC1;
	}
	public java.math.BigDecimal getBrisGlaceRNC2() {
		
		brisGlaceRNC2 = brisGlaceRNC2.add(getValeurNeuve().multiply(BigDecimal.valueOf(0.004)));
		return brisGlaceRNC2;
	}

	/*-------------------determination de la prime en dommage--------------------*/
	public java.math.BigDecimal getDommage() {
		dommage = dommage.add(getValeurNeuve().multiply(BigDecimal.valueOf(0.05)));
		return dommage;
	}
	
	public java.math.BigDecimal getCollision() {
		collision = collision.add(getValeurNeuve().multiply(BigDecimal.valueOf(0.075)));
		
		return collision;
	}

	/*-------------------determination de la prime en vol � main arm�e--------------------*/

	public java.math.BigDecimal getVolMain() {
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 10000000) {
			volMain = getValeurVenale().multiply(BigDecimal.valueOf(0.015));
		}
		if (getValeurVenale().intValue() > 10000001 & getValeurVenale().intValue() <= 20000000) {
			volMain = getValeurVenale().multiply(BigDecimal.valueOf(0.025));
		}
		if (getValeurVenale().intValue() > 20000001) {
			volMain = getValeurVenale().multiply(BigDecimal.valueOf(0.035));
		}
		return volMain;
	}

	/*-------------------determination de la prime en vol accessoires--------------------*/
	public java.math.BigDecimal getVolAccessoires() {
		volAccessoires = getMontantAccessoires().multiply(BigDecimal.valueOf(0.08));
		return volAccessoires;
	}
	/*-------------------determination de la prime en vol vandalisme--------------------*/
	public java.math.BigDecimal getVolVandalisme() {
		volVandalisme = BigDecimal.valueOf(12000);
		return volVandalisme;
	}

	/*-------------------determination de la prime en incendie--------------------*/

	public java.math.BigDecimal getIncendie() {
		if (getValeurVenale().intValue() > 0 & getValeurVenale().intValue() <= 10000000) {
			incendie = getValeurVenale().multiply(BigDecimal.valueOf(0.007));
		}
		if (getValeurVenale().intValue() > 10000001 & getValeurVenale().intValue() <= 20000000) {
			incendie = getValeurVenale().multiply(BigDecimal.valueOf(0.5));
		}
		if (getValeurVenale().intValue() > 20000001) {
			incendie = getValeurVenale().multiply(BigDecimal.valueOf(0.3));
		}
		return incendie;
	}

	/*-------------------determination de la prime en securit�--------------------*/
	public java.math.BigDecimal getSecuriteRoutiere1() {
		securiteRoutiere1 = BigDecimal.valueOf(9650);
		return securiteRoutiere1;
	}
	
	public java.math.BigDecimal getSecuriteRoutiere2() {
		securiteRoutiere2 = BigDecimal.valueOf(16420);
		return securiteRoutiere2;
	}
	public java.math.BigDecimal getSecuriteRoutiere3() {
		securiteRoutiere3 = BigDecimal.valueOf(19120);
		return securiteRoutiere3;
	}
	
	public java.math.BigDecimal getIndividuelChauf1(){
		return individuelChauf1;
	}
	
	public java.math.BigDecimal getIndividuelChauf2(){
		return individuelChauf2;
	}
	
	public java.math.BigDecimal getIndividuelChauf3(){
		return individuelChauf3;
	}

	/*----------les Setters --------------------------------------------------------------*/

	public void setPrimeRc(java.math.BigDecimal primeRc) {
		this.primeRc = primeRc;
	}


	/*--------------autres Getter and setter------------------------------*/
	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

	public java.math.BigDecimal getPuissFisc() {
		return puissFisc;
	}

	public void setPuissFisc(java.math.BigDecimal puissFisc) {
		this.puissFisc = puissFisc;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public boolean isRemorque() {
		return remorque;
	}
	public void setRemorque(boolean remorque) {
		this.remorque = remorque;
	}

	public int getDureePermis() {
		return dureePermis;
	}

	public void setDureePermis(int dureePermis) {
		this.dureePermis = dureePermis;
	}

	public void setValeurNeuve(java.math.BigDecimal valeurNeuve) {
		this.valeurNeuve = valeurNeuve;
	}

	public java.math.BigDecimal getMontantAccessoires() {
		return montantAccessoires;
	}

	public void setMontantAccessoires(java.math.BigDecimal montantAccessoires) {
		this.montantAccessoires = montantAccessoires;
	}

	public String getOptionSR() {
		return optionSR;
	}

	public void setOptionSR(String optionSR) {
		this.optionSR = optionSR;
	}

	public java.math.BigDecimal getValeurVenale() {
		return valeurVenale;
	}

	public void setValeurVenale(java.math.BigDecimal valeurVenale) {
		this.valeurVenale = valeurVenale;
	}

	public java.math.BigDecimal getValeurNeuve() {
		return valeurNeuve;
	}

	public void setPrimeBase(java.math.BigDecimal primeBase) {
		this.primeBase = primeBase;
	}


	public String getOptionIndCh() {
		return optionIndCh;
	}

	public void setOptionIndCh(String optionIndCh) {
		this.optionIndCh = optionIndCh;
	}


	public String getTypeVehicule() {
		return typeVehicule;
	}


	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}


	

	public java.math.BigDecimal getReduction() {
		return reduction;
	}
	public void setReduction(java.math.BigDecimal reduction) {
		this.reduction = reduction;
	}

	public java.math.BigDecimal getPrimeRemorque() {
		return primeRemorque;
	}


	public void setPrimeRemorque(java.math.BigDecimal primeRemorque) {
		this.primeRemorque = primeRemorque;
	}


	public java.math.BigDecimal getChargeUtile() {
		return chargeUtile;
	}

	public void setChargeUtile(java.math.BigDecimal chargeUtile) {
		this.chargeUtile = chargeUtile;
	}


	public java.math.BigDecimal getSurprimes() {
		return surprimes;
	}
	public void setSurprimes(java.math.BigDecimal surprimes) {
		this.surprimes = surprimes;
	}

	public String getTypeTransporte() {
		return typeTransporte;
	}

	public void setTypeTransporte(String typeTransporte) {
		this.typeTransporte = typeTransporte;
	}


	public java.math.BigDecimal getPuissReel() {
		return puissReel;
	}


	public void setPuissReel(java.math.BigDecimal puissReel) {
		this.puissReel = puissReel;
	}


	public short getNbreTransporte() {
		return nbreTransporte;
	}


	public void setNbreTransporte(short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
	}


	public int getDureeContrat() {
		return dureeContrat;
	}


	public void setDureeContrat(int dureeContrat) {
		this.dureeContrat = dureeContrat;
	}


	public int getAgeVehicule() {
		return ageVehicule;
	}


	public void setAgeVehicule(int ageVehicule) {
		this.ageVehicule = ageVehicule;
	}


	public short getNbrecarte() {
		return nbrecarte;
	}


	public void setNbrecarte(short nbrecarte) {
		this.nbrecarte = nbrecarte;
	}


	public short getNbrePlaceCab() {
		return nbrePlaceCab;
	}


	public void setNbrePlaceCab(short nbrePlaceCab) {
		this.nbrePlaceCab = nbrePlaceCab;
	}


	public short getNbrePlaceHorscab() {
		return nbrePlaceHorscab;
	}


	public void setNbrePlaceHorscab(short nbrePlaceHorscab) {
		this.nbrePlaceHorscab = nbrePlaceHorscab;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	
}
