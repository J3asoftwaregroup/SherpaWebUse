package com.j3a.assurance.utilitaires.hybride;

import java.util.ArrayList;
import java.util.List;

import com.j3a.assurance.managedBean.admin.AvenantByPointVenteRow;

public class MouvementRow {
	private String mouvement;
	List<AvenantByPointVenteRow> ListAvenantRow = new ArrayList<AvenantByPointVenteRow>();

	public MouvementRow() {

	}

	public String getMouvement() {
		return mouvement;
	}

	public void setMouvement(String mouvement) {
		this.mouvement = mouvement;
	}

	public List<AvenantByPointVenteRow> getListAvenantRow() {
		return ListAvenantRow;
	}

	public void setListAvenantRow(List<AvenantByPointVenteRow> listAvenantRow) {
		ListAvenantRow = listAvenantRow;
	}

}
