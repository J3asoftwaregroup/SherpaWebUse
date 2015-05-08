package com.j3a.assurance.objetService;

import java.util.List;

public interface ObjectService {
public void addObject(Object objet);
	
	public Object getObjectById(int id, String objet);
	
	public Object getObjectById(String id, String objet);
	
	public void updateObject(Object objet);
	
	public void deleteObject(Object objet);
	
	public  List getObjects(String objet);
	
	public List<Object> getojects(Object object);
	
	public String getCodeTable(String pseudo, int taillCar, int taillChifr,
			String nomTable, String nomCOL);
	public List<Object> getListGarantieByRisque(String codeRisque);
	
	public Object getByIdPK(Object object, String table);
}
