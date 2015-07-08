package com.j3a.assurance.managedBean.Auto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Avenant;
import com.j3a.assurance.objetService.ObjectService;

/**
 * 
 * @author PCALekerand
 *
 */

@Component
public class NotificationBean {

	@Autowired
    ObjectService objectService;
	private Integer nombreNotification = new Integer(0);
	private Date dateduJour = Calendar.getInstance().getTime();
	List<Avenant> listAffairesNouvelles = new ArrayList<Avenant>();
	
	@PostConstruct
	public List<Avenant> afficherListContrat(){
		return listAffairesNouvelles = getObjectService().AvenantAFNPeriode("AFFAIRE NOUVELLE", dateduJour, dateduJour);
	}
	
	
	/***************ACCESSEUR**************/

	public Integer getNombreNotification() {
		return nombreNotification;
	}

	public void setNombreNotification(Integer nombreNotification) {
		this.nombreNotification = nombreNotification;
	}
	
	public ObjectService getObjectService() {
		return objectService;
	}

	public void setObjectService(ObjectService objectService) {
		this.objectService = objectService;
	}




	public List<Avenant> getListAffairesNouvelles() {
		return listAffairesNouvelles;
	}




	public void setListAffairesNouvelles(List<Avenant> listAffairesNouvelles) {
		this.listAffairesNouvelles = listAffairesNouvelles;
	}

}
