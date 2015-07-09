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

import com.j3a.assurance.model.PointVente;
import com.j3a.assurance.objetService.ObjectService;

@Component
public class PtdeVenteCvtr implements Converter{
	
	public PtdeVenteCvtr() {
		// TODO Auto-generated constructor stub
	}

	
	//Spring Apporteur Service is injected...
	@Autowired
	 ObjectService objectService;
	 
	 public List<PointVente> pointVenteList=new ArrayList<PointVente>();
	 
	 Logger logs=Logger.getLogger(PtdeVenteCvtr.class);
	 
	 
	 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) { 
		 System.out.println("la methode getAsObject................");
	        if (submittedValue.trim().equals("")) {  
	            return null;  
	        } else {  
	            try {  
	            	//String X = submittedValue;  
	  
	                for (PointVente c : getPointVenteList()) {  
	                	//if (c.getLibellePointVente().equalsIgnoreCase(X)) {
	                    if (c.getCodePointVente().equalsIgnoreCase(submittedValue)) {  
	                        return c;  
	                    }  
	                }  
	  
	            } catch(Exception exception) {  
	            	logs.info(">>>>/ "+exception.getMessage());
	                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid SousCategorie Vehicule"));  
	            }  
	            return null; 
	        }  
	        //System.out.println("testneenenenenenenennanana");
	         
	    }  
	  
	   public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
	        if (value == null || value.equals("")) {  
	            return "";  
	        } else {  
	            return ((PointVente) value).getCodePointVente();  
	        }  
	    }

	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}

	

	

	public List<PointVente> getPointVenteList() {
			pointVenteList.clear();
			for (Object c : getObjectService().getObjects("PointVente")) {  
				pointVenteList.add((PointVente) c);  
	            } 
		
		return pointVenteList;
	}

	public void setPointVenteList(List<PointVente> pointVenteList) {
		this.pointVenteList = pointVenteList;
	}
	
	

}
