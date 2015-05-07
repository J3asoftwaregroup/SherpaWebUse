package com.j3a.assurance.objetService;

import java.util.List;

public interface IService {
public void saveObject(Object objet);
	
	public Object getObject(int id, String objet);
	
	public Object getObject(String id, String objet);
	
	public void updateObject(Object objet);
	
	public void deleteObject(Object objet);
	
	public  List getObjects(String objet);
	
	public List<Object> getojects(Object object);

}
