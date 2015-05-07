package com.j3a.assurance.objetDao;

import java.util.List;

public interface IDao {
	public void addObject(Object objet);
	
	public Object getObject(int id, String objet);
	
	public String getCodeTable(String pseudo, int taillCar, int taillChifr,
			String nomTable, String nomCOL);
	
	public Object getObject(String id, String objet);
	
	public void updateObject(Object objet);
	
	public void deleteObject(Object objet);
	
	public  List getObjects(String objet);
	
	public List<Object> getojects(Object object);
	
	public List<Object> getListGarantieByRisque(String codeRisque);

}
