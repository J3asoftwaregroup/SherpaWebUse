package com.j3a.assurance.managedBean.Auto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.j3a.assurance.model.Contrat;
import com.j3a.assurance.model.Etre;
import com.j3a.assurance.model.Morale;
import com.j3a.assurance.model.Personne;
import com.j3a.assurance.model.Physique;
import com.j3a.assurance.model.TypePersonne;

@Component
public class ClientMB implements Serializable{
private Physique monPhysique = new Physique();
private TypePersonne typePersonne = new TypePersonne();
private Contrat monContrat = new Contrat();
private String situationMatrimoniale;
private String tittre;
private String profession;
private String typePiece;
private Etre etreType = new Etre();
private Personne personne = new Personne();
private Physique physique = new Physique();
private Morale morale = new Morale();


	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void editerClient() {
		
		
	}

}
