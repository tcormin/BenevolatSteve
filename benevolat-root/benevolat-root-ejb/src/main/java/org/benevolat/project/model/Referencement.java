package org.benevolat.project.model;

public class Referencement {

	private Benevole benevole;
	private Association association;
	private Mission mission;
	private String lettre;
	
	public Benevole getBenevole() {
		return benevole;
	}
	public void setBenevole(Benevole benevole) {
		this.benevole = benevole;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public String getLettre() {
		return lettre;
	}
	public void setLettre(String lettre) {
		this.lettre = lettre;
	}
	
	
}
