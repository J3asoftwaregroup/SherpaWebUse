package com.j3a.assurance.managedBean.admin;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.j3a.assurance.utilitaires.hybride.AssureRow;
import com.j3a.assurance.utilitaires.hybride.ManagedSinistreIA;



@Component 
@Scope("session")
public class AssurRwCvtr implements Converter {

	public AssurRwCvtr() {
		// TODO Auto-generated constructor stub
	}

	
	
	//Spring Apporteur Service is injected...
		@Autowired
		ManagedSinistreIA managedSinistreIA;
		 
		 public List<AssureRow> AssurRwList =new ArrayList<AssureRow>(); 
		 
		 Logger logs=Logger.getLogger(AssurRwCvtr.class);
		 
		 public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
		        if (submittedValue.trim().equals("")) {  
		            return null;  
		        } else {  
		        	System.out.println("INSIDE CONVERTER submittedValue.trim()!=rien");
		            try {  
		            	String X = submittedValue;  
		            	for (AssureRow c : getAssurRwList()) {  
		                    if (c.getAssure().getNumIdentification().equalsIgnoreCase(X)) {  
		                        return c;  
		                    }  
		                }  
		  
		            } catch(Exception exception) {
		            	exception.printStackTrace();
		            	logs.info(">>>>/ "+exception.getMessage());
		                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid SousCategorie Vehicule"));  
		            }  
		        }  
		  
		        return null;  
		    }  
		  
		   public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
			   System.out.println("INSIDE CONVERTER getAsString(F  VAlue de Object"+ value.toString());
		        if (value == null || value.equals("")) {  
		            return "";  
		        } else {  
		        	return ((AssureRow) value).getAssure().getNumIdentification();  
		        }  
		       
		    }







		public ManagedSinistreIA getManagedSinistreIA() {
			return managedSinistreIA;
		}

		public void setManagedSinistreIA(ManagedSinistreIA managedSinistreIA) {
			this.managedSinistreIA = managedSinistreIA;
		}

		
		
		
		
		public List<AssureRow> getAssurRwList() {
			if(AssurRwList.isEmpty()){
				AssurRwList.addAll(getManagedSinistreIA().getAssurRwList());
				return AssurRwList;
			}
			return AssurRwList;
		}

		public void setAssurRwList(List<AssureRow> assurRwList) {
			AssurRwList = assurRwList;
		}



		
		   
}
