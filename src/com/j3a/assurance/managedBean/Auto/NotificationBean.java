package com.j3a.assurance.managedBean.Auto;

import org.springframework.stereotype.Component;

/**
 * 
 * @author PCALekerand
 *
 */

@Component
public class NotificationBean {
	
	private Integer nombreNotification = new Integer(0);
	
	
	
	
	/***************ACCESSEUR**************/

	public Integer getNombreNotification() {
		return nombreNotification;
	}

	public void setNombreNotification(Integer nombreNotification) {
		this.nombreNotification = nombreNotification;
	}

}
