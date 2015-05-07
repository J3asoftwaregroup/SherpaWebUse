package com.j3a.sherpawebuser.prime.categorie;

import java.math.BigDecimal;

public class PrimeCategorie8 implements PrimeCategorieInterface {
	private String energie;
	private String typeVehicule;
	private java.math.BigDecimal puissFisc = BigDecimal.ZERO;
	private String categorie;
	private String zone;
	private String classe;
	private String statut;
	private java.math.BigDecimal primeBase = BigDecimal.ZERO;
	private boolean remorque;
	private java.math.BigDecimal primeRemorque = BigDecimal.ZERO;
	private java.math.BigDecimal surprimes = BigDecimal.ZERO;
	private String typeTransporte="";
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
	private short nbreTransporte;
	private short nbrecarte;
	private short nbrePlaceCab;
	private short nbrePlaceHorscab;

	/*---------------determination de la prime li�e aux garanties----------------------------------*/

	/*------------Determine la valeur de la prime de base------------------*/
	public java.math.BigDecimal getPrimeBase() {

		 primeBase = BigDecimal.valueOf(0);
		 if(typeVehicule.equalsIgnoreCase("VEHICULE DE TOURISME")){
			 if ((energie.equals("essence") & puissFisc.intValue() >= 1 & puissFisc.intValue() <= 2)
						|| (energie.equals("diesel") & puissFisc.intValue() == 1)) {
					if (zone.equals("zone1"))
						// setprimeRc(58675);
						primeBase = BigDecimal.valueOf(106675);
					if (zone.equals("zone2"))
						// setprimeBase(55741);
						primeBase = BigDecimal.valueOf(101341);
					if (zone.equals("zone3"))
						// setprimeBase(52808);
						primeBase = BigDecimal.valueOf(96008);
				}
			

				if ((energie.equals("essence") & puissFisc.intValue() >= 3 & puissFisc.intValue() <= 6)
						|| (energie.equals("diesel") & puissFisc.intValue() >= 2 & puissFisc.intValue() <= 4)) {
					if (zone.equals("zone1"))
						// setprimeBase(66885);
						primeBase = BigDecimal.valueOf(121603);
					if (zone.equals("zone2"))
						// setprimeBase(63541);
						primeBase = BigDecimal.valueOf(115523);
					if (zone.equals("zone3"))
						// setprimeBase(60197);
						primeBase = BigDecimal.valueOf(109443);
				}

				if ((energie.equals("essence") & puissFisc.intValue() >= 7 & puissFisc.intValue() <= 9)
						|| (energie.equals("diesel") & puissFisc.intValue() >= 5 & puissFisc.intValue() <= 6)) {
					if (zone.equals("zone1"))
						// setprimeBase(73415);
						primeBase = BigDecimal.valueOf(133481);
					if (zone.equals("zone2"))
						// setprimeBase(69744);
						primeBase = BigDecimal.valueOf(126807);
					if (zone.equals("zone3"))
						// setprimeBase(66074);
						primeBase = BigDecimal.valueOf(120133);
				}
				if ((energie.equals("essence") & puissFisc.intValue() >= 10 & puissFisc.intValue() <= 11)
						|| (energie.equals("diesel") & puissFisc.intValue() >= 7 & puissFisc.intValue() <= 8)) {
					if (zone.equals("zone1"))
						// setprimeBase(114693);
						primeBase = BigDecimal.valueOf(208525);
					if (zone.equals("zone2"))
						// setprimeBase(108958);
						primeBase = BigDecimal.valueOf(198099);
					if (zone.equals("zone3"))
						// setprimeBase(103224);
						primeBase = BigDecimal.valueOf(187673);
				}
				if ((energie.equals("essence") & puissFisc.intValue() >= 12)
						|| (energie.equals("diesel") & puissFisc.intValue() >= 9)) {
					if (zone.equals("zone1"))
						// setprimeBase(129058);
						primeBase = BigDecimal.valueOf(234644);
					if (zone.equals("zone2"))
						// setprimeBase(122605);
						primeBase = BigDecimal.valueOf(222912);
					if (zone.equals("zone3"))
						// setprimeBase(116152);
						primeBase = BigDecimal.valueOf(211180);
				}
			 }
			if(typeVehicule.equalsIgnoreCase("VEHICULE DE LA CATEGORIE 2")){
				if (getChargeUtile().intValue() <= 1) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(237930);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(226034);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(214137);
				}

				if (getChargeUtile().intValue() <= 1.001 && getChargeUtile().intValue() <= 3) {
					if (zone.equals("zone1"))
						// setPrimeBase(66885);
						primeBase = BigDecimal.valueOf(310380);
					if (zone.equals("zone2"))
						// setPrimeBase(63541);
						primeBase = BigDecimal.valueOf(294861);
					if (zone.equals("zone3"))
						// setPrimeBase(60197);
						primeBase = BigDecimal.valueOf(279342);
				}

				if (getChargeUtile().intValue() <= 3.001 && getChargeUtile().intValue() <= 5) {
					if (zone.equals("zone1"))
						// setPrimeBase(73415);
						primeBase = BigDecimal.valueOf(379431);
					if (zone.equals("zone2"))
						// setPrimeBase(69744);
						primeBase = BigDecimal.valueOf(360459);
					if (zone.equals("zone3"))
						// setPrimeBase(66074);
						primeBase = BigDecimal.valueOf(341488);
				}
				if (getChargeUtile().intValue() <= 5.001 && getChargeUtile().intValue() <= 8) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(489234);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(464772) ;
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(440311);
				}
				if (getChargeUtile().intValue() <=8.001 && getChargeUtile().intValue() <= 11) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(521853);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(495760);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(469668);
				}
				if (getChargeUtile().intValue() <=11.001  && getChargeUtile().intValue() <= 13) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(546816);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(519475);
					if (zone.equals("zone3"))
						// setPrimeBase(116152);
						primeBase = BigDecimal.valueOf(492134);
				}
				
				if (getChargeUtile().intValue() <=13.001   && getChargeUtile().intValue() <= 15) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(658812);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(625871);
					if (zone.equals("zone3"))
						// setPrimeBase(116152);
						primeBase = BigDecimal.valueOf(592931);
				}
				
				if (getChargeUtile().intValue() > 15) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(862654);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(819521);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(776389);
				}
             }
			if(typeVehicule.equalsIgnoreCase("VEHICULE DE LA CATEGORIE 2 Tracteur routier")){
				
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(927850);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(881458);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(835065);
				}
			
			
			
			if(typeVehicule.equalsIgnoreCase("VEHICULE DE LA CATEGORIE 3")){
				if (getChargeUtile().intValue() <= 1) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(267000);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(253650);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(240300);
				}

				if (getChargeUtile().intValue() <= 1.001 && getChargeUtile().intValue() <= 3) {
					if (zone.equals("zone1"))
						// setPrimeBase(66885);
						primeBase = BigDecimal.valueOf(342600);
					if (zone.equals("zone2"))
						// setPrimeBase(63541);
						primeBase = BigDecimal.valueOf(325470);
					if (zone.equals("zone3"))
						// setPrimeBase(60197);
						primeBase = BigDecimal.valueOf(308340);
				}

				if (getChargeUtile().intValue() <= 3.001 && getChargeUtile().intValue() <= 5) {
					if (zone.equals("zone1"))
						// setPrimeBase(73415);
						primeBase = BigDecimal.valueOf(430000);
					if (zone.equals("zone2"))
						// setPrimeBase(69744);
						primeBase = BigDecimal.valueOf(408500);
					if (zone.equals("zone3"))
						// setPrimeBase(66074);
						primeBase = BigDecimal.valueOf(387000);
				}
				if (getChargeUtile().intValue() <= 5.001 && getChargeUtile().intValue() <= 9) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(539400);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(512340) ;
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(485460);
				}
				if (getChargeUtile().intValue() <=9.001 && getChargeUtile().intValue() <= 12) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(678800);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(644860);
					if (zone.equals("zone3"))
						primeBase = BigDecimal.valueOf(610920);
				}
				if (getChargeUtile().intValue() <=12.001  && getChargeUtile().intValue() <= 15) {
					if (zone.equals("zone1"))
						primeBase = BigDecimal.valueOf(889000);
					if (zone.equals("zone2"))
						primeBase = BigDecimal.valueOf(844550);
					if (zone.equals("zone3"))
						// setPrimeBase(116152);
						primeBase = BigDecimal.valueOf(800100);
				}
             }
			if (getChargeUtile().intValue() > 15 && getTypeVehicule().equalsIgnoreCase("tracteur routier")) {
				if (zone.equals("zone1"))
					primeBase = BigDecimal.valueOf(978000);
				if (zone.equals("zone2"))
					primeBase = BigDecimal.valueOf(929100);
				if (zone.equals("zone3"))
					primeBase = BigDecimal.valueOf(880200);
			}
		return primeBase;
	}

	/*---------------	calcul de la prime RC-------------------------------*/
	public java.math.BigDecimal getPrimeRc() {
		primeRc = getPrimeBase();

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
		remboursemmentAnticipe = BigDecimal.valueOf(15000);
		}else{
		remboursemmentAnticipe = BigDecimal.valueOf(10000);
		}
		return remboursemmentAnticipe;
	}

	/*-------------------determination de la prime en brise de glace--------------------*/
	public java.math.BigDecimal getBrisGlaceRC() {
		
		brisGlaceRC = getValeurNeuve().multiply(BigDecimal.valueOf(0.003));
		return brisGlaceRC;
	}
	
	public java.math.BigDecimal getBrisGlaceRNC1() {
		
		brisGlaceRNC1 = getValeurNeuve().multiply(BigDecimal.valueOf(0.0047));
		return brisGlaceRNC1;
	}
	public java.math.BigDecimal getBrisGlaceRNC2() {
		
		brisGlaceRNC2 = getValeurNeuve().multiply(BigDecimal.valueOf(0.004));
		return brisGlaceRNC2;
	}

	/*-------------------determination de la prime en dommage--------------------*/
	public java.math.BigDecimal getDommage() {
		dommage = getValeurNeuve().multiply(BigDecimal.valueOf(0.05));
		return dommage;
	}
	
	public java.math.BigDecimal getCollision() {
		collision = getValeurNeuve().multiply(BigDecimal.valueOf(0.075));
		
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


	@Override
	public BigDecimal getPuissReel() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setPuissReel(BigDecimal puissReel) {
		// TODO Auto-generated method stub
		
	}


	public String getTypeVehicule() {
		return typeVehicule;
	}


	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}


	@Override
	public int getDureeContrat() {
		// TODO Auto-generated method stub
		return dureeContrat;
	}


	@Override
	public void setDureeContrat(int dureeContrat) {
		// TODO Auto-generated method stub
		this.dureeContrat = dureeContrat;
	}


	@Override
	public int getAgeVehicule() {
		// TODO Auto-generated method stub
		return ageVehicule;
	}


	@Override
	public void setAgeVehicule(int ageVehicule) {
		// TODO Auto-generated method stub
		this.ageVehicule = ageVehicule;
	}


	public java.math.BigDecimal getReduction() {
		return reduction;
	}
	public void setReduction(java.math.BigDecimal reduction) {
		this.reduction = reduction;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
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

	public short getNbreTransporte() {
		return nbreTransporte;
	}

	public void setNbreTransporte(short nbreTransporte) {
		this.nbreTransporte = nbreTransporte;
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

}
