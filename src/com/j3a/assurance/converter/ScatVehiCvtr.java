package com.j3a.assurance.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Categorie;
import com.j3a.assurance.model.RcTarif1;
import com.j3a.assurance.model.SousCatVehicule;
import com.j3a.assurance.model.Tarif;
import com.j3a.assurance.objetService.ObjectService;


@Component
public class ScatVehiCvtr implements Converter {

	public ScatVehiCvtr() {
		// TODO Auto-generated constructor stub
	}
	//Spring Apporteur Service is injected...
	@Autowired
	 ObjectService objectService;
	 
	 public List<SousCatVehicule> CatVehiList=new ArrayList<SousCatVehicule>(); 
	 
	 Logger logs=Logger.getLogger(ScatVehiCvtr.class);
	

	public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
		/*System.out.print("Avant lapel");
		getCatVehiList();
		System.out.print("Apres lapel");*/
	        if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {
	            	String X = submittedValue;
	                for (SousCatVehicule c : getCatVehiList()) {  
	                    if (c.getLibelleSousCatVehicule().equalsIgnoreCase(X)) {  
	                        return c;  
	                    }  
	                }  
	            } catch(Exception exception) {  
	            	logs.info(">>>>/ "+exception.getMessage());
	            	exception.printStackTrace();
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid SousCategorie Vehicule"));  
	            }  
	        }  
	  
	        return null;  
	    }  
	  
	   public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
	        if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return ((SousCatVehicule) value).getLibelleSousCatVehicule();  
	        }  
	    }   
	 
	 
	 
	public ObjectService getObjectService() {
		return objectService;
	}
	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}
	/*public List<SousCatVehicule> getsCatVehiList() {
		List<SousCatVehicule> A = new ArrayList<SousCatVehicule>();
		for (Object c : getObjectService().getObjects("SousCatVehicule")) {  
			A.add((SousCatVehicule) c);  
            } 
		
		return A;
	}
	public void setsCatVehiList(List<SousCatVehicule> sCatVehiList) {
		this.sCatVehiList = sCatVehiList;
	}
*/
	 public List<SousCatVehicule> getCatVehiList() {
			if(CatVehiList.isEmpty()){
				Tarif tarif1  = new Tarif();
				tarif1.setCodeTarif("Tarif1");
				RcTarif1 rc1  = new RcTarif1();
				tarif1.setRcTarif1(rc1);
				rc1.setCodeRcTarif1("RcTarif1");
				SousCatVehicule A = new SousCatVehicule("SCAT1");
				A.setLibelleSousCatVehicule("Vehicule de Tourisme");
				Categorie catA = new Categorie();
				catA.setCodeCategorie("1");
				catA.setLibelleCategorie("Promenade et Affaires");
				A.setCategorie(catA);
				A.setTarif_1("TARIF1");
				A.setTarif(tarif1);
				CatVehiList.add(A);
				
				
				SousCatVehicule B = new SousCatVehicule("SCAT12");
				B.setLibelleSousCatVehicule("Vehicule Professionnel");
				B.setCategorie(catA);
				B.setTarif_1("TARIF12");
				CatVehiList.add(B);
				
				SousCatVehicule C = new SousCatVehicule("SCAT2");
				C.setLibelleSousCatVehicule("Transport pour propre compte");
				Categorie catC = new Categorie();
				catC.setCodeCategorie("2");
				catC.setLibelleCategorie("Transport pour propre compte");
				C.setCategorie(catC);
				C.setTarif_1("TARIF2");
				CatVehiList.add(C);
				
				SousCatVehicule D = new SousCatVehicule("SCAT3");
				D.setLibelleSousCatVehicule("Transport Public de Marchandises");
				Categorie catD = new Categorie();
				catD.setCodeCategorie("3");
				catD.setLibelleCategorie("Transport Public de Marchandises");
				D.setCategorie(catD);
				D.setTarif_1("TARIF3");
				CatVehiList.add(D);
				
				/*SousCatVehicule E = new SousCatVehicule("SCAT4");
				E.setLibelleSousCatVehicule("Transport Public de Voyageurs");
				Categorie catE = new Categorie();
				catE.setId("4");
				catE.setLibelleCategorie("Transport Public de Voyageurs");
				E.setCodeCategorie(catE);
				E.setTarif("TARIF4");
				CatVehiList.add(E);*/
				
				SousCatVehicule F = new SousCatVehicule("SCAT5");
				F.setLibelleSousCatVehicule("Vehicules Motorises 2 OU 3 Roues");
				Categorie catF = new Categorie();
				catF.setCodeCategorie("5");
				catF.setLibelleCategorie("Vehicules Motorises 2 OU 3 Roues");
				F.setCategorie(catF);
				F.setTarif_1("TARIF5");
				CatVehiList.add(F);
				
				SousCatVehicule G = new SousCatVehicule("SCAT6");
				G.setLibelleSousCatVehicule("Garagistes");
				Categorie catG = new Categorie();
				catG.setCodeCategorie("6");
				catG.setLibelleCategorie("Garagistes");
				G.setCategorie(catG);
				G.setTarif_1("TARIF6");
				CatVehiList.add(G);
				
				SousCatVehicule H = new SousCatVehicule("SCAT7");
				H.setLibelleSousCatVehicule("Auto Ecole");
				Categorie catH = new Categorie();
				catH.setCodeCategorie("7");
				catH.setLibelleCategorie("Auto Ecole");
				H.setCategorie(catH);
				H.setTarif_1("TARIF7");
				CatVehiList.add(H);
				
				SousCatVehicule I = new SousCatVehicule("SCAT8");
				I.setLibelleSousCatVehicule("Véhicule de Location");
				Categorie catI = new Categorie();
				catI.setCodeCategorie("8");
				catI.setLibelleCategorie("Véhicule de Location");
				I.setCategorie(catI);
				I.setTarif_1("TARIF8");
				CatVehiList.add(I);
				
				SousCatVehicule J = new SousCatVehicule("SCAT9");
				J.setLibelleSousCatVehicule("Engins de Chantier");
				Categorie catJ = new Categorie();
				catJ.setCodeCategorie("9");
				catJ.setLibelleCategorie("Engins de Chantier");
				J.setCategorie(catJ);
				J.setTarif_1("TARIF9");
				CatVehiList.add(J);
				
				SousCatVehicule K = new SousCatVehicule("SCAT10");
				K.setLibelleSousCatVehicule("Véhicule spéciaux");
				Categorie catK = new Categorie();
				catK.setCodeCategorie("10");
				catK.setLibelleCategorie("Véhicule spéciaux");
				K.setCategorie(catK);
				K.setTarif_1("TARIF10");
				CatVehiList.add(K);
			}
			return CatVehiList;
			}

		public void setCatVehiList(List<SousCatVehicule> catVehiList) {
			CatVehiList = catVehiList;
		}
	 
	 
}
