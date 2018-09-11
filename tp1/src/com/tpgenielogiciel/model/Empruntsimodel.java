package com.tpgenielogiciel.model;

public class Empruntsimodel {
	
	int id;
	String nonAdherent;
	String prenomAdherent;
	String titreliv;
	String datesortie;
	String dateretour;
	String etatemp;
	String nomAut;
	
	public void setNomAut(String nomAut) {
		this.nomAut = nomAut;
	}
	public String getNomAut() {
		return nomAut;
	}
	public int getId() {
		return id;
	}
	public String getNonAdherent() {
		return nonAdherent;
	}
	public String getPrenomAdherent() {
		return prenomAdherent;
	}
	public String getTitreliv() {
		return titreliv;
	}
	public String getDatesortie() {
		return datesortie;
	}
	public String getDateretour() {
		return dateretour;
	}
	public String getEtatemp() {
		return etatemp;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNonAdherent(String nonAdherent) {
		this.nonAdherent = nonAdherent;
	}
	public void setPrenomAdherent(String prenomAdherent) {
		this.prenomAdherent = prenomAdherent;
	}
	public void setTitreliv(String titreliv) {
		this.titreliv = titreliv;
	}
	public void setDatesortie(String datesortie) {
		this.datesortie = datesortie;
	}
	public void setDateretour(String dateretour) {
		this.dateretour = dateretour;
	}
	public void setEtatemp(String etatemp) {
		this.etatemp = etatemp;
	}
	
	public Empruntsimodel() {
		super();
	}
	public Empruntsimodel(String nonAdherent, String prenomAdherent, String titreliv, String datesortie,
			String dateretour, String etatemp,String nomAut) {
		super();
		this.nonAdherent = nonAdherent;		
		this.prenomAdherent = prenomAdherent;
		this.titreliv = titreliv;
		this.datesortie = datesortie;
		this.dateretour = dateretour;
		this.etatemp = etatemp;
		this.nomAut = nomAut;
	}
	
	
	
	

}
