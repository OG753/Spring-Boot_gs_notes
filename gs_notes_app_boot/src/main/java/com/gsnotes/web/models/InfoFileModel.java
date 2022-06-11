package com.gsnotes.web.models;


public class InfoFileModel {
   private String NomFiliere;
   private String NomModule;
   private String NomEnseignant;
   private String Niv;
   private int date;
   private Long ID;
   private String CNE;
   private String NOMetudiant;
   private String PRENOMetudiant;
   private String Element1;
   private String Element2;
   private double Moyenne;
   private String Validation;
   
   public InfoFileModel() {}
   public InfoFileModel(String nomFiliere, String nomModule, String nomEnseignant, String niv, int date, Long iD,
		String cNE, String nOMetudiant, String pRENOMetudiant, String element1, String element2, double moyenne,
		String validation) {
	super();
	NomFiliere = nomFiliere;
	NomModule = nomModule;
	NomEnseignant = nomEnseignant;
	Niv = niv;
	this.date = date;
	ID = iD;
	CNE = cNE;
	NOMetudiant = nOMetudiant;
	PRENOMetudiant = pRENOMetudiant;
	Element1 = element1;
	Element2 = element2;
	Moyenne = moyenne;
	Validation = validation;
}

   
//public InfoFileModel() {
//	
//} 
public Long getID() {
	return ID;
}
public void setID(Long iD) {
	ID = iD;
}
public String getCNE() {
	return CNE;
}
public void setCNE(String cNE) {
	CNE = cNE;
}
public String getNOMetudiant() {
	return NOMetudiant;
}
public void setNOMetudiant(String nOMetudiant) {
	NOMetudiant = nOMetudiant;
}
public String getPRENOMetudiant() {
	return PRENOMetudiant;
}
public void setPRENOMetudiant(String pRENOMetudiant) {
	PRENOMetudiant = pRENOMetudiant;
}
public int getDate() {
	return date;
}
public void setDate(int date) {
	this.date = date;
}
public String getElement1() {
	return Element1;
}
public void setElement1(String element1) {
	this.Element1 = element1;
}
public String getElement2() {
	return Element2;
}
public void setElement2(String element2) {
	this.Element2 = element2;
}
public String getValidation() {
	return Validation;
}
public void setValidation(String validation) {
	this.Validation = validation;
}
public double getMoyenne() {
	return Moyenne;
}
public void setMoyenne(double moyenne) {
	this.Moyenne = moyenne;
}
public String getNomFiliere() {
	return NomFiliere;
}
public void setNomFiliere(String nomFiliere) {
	NomFiliere = nomFiliere;
}
public String getNomModule() {
	return NomModule;
}
public void setNomModule(String nomModule) {
	NomModule = nomModule;
}
public String getNomEnseignant() {
	return NomEnseignant;
}
public void setNomEnseignant(String nomEnseignant) {
	NomEnseignant = nomEnseignant;
}
public String getNiv() {
	return Niv;
}
public void setNiv(String niv) {
	Niv = niv;
}
}
