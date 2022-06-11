package com.gsnotes.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class InscriptionMatiere {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long idInscriptionMatiere;

	private double noteSN;
	private double noteSR;
	private double noteFinale;
	private String validation;
	private String plusInfos;

	/** Coefficient */
	private double coefficient;

	@ManyToOne
	@JoinColumn(name = "idMatiere")
	private Element matiere;

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	@ManyToOne
	@JoinColumn(name = "idInscription")
	private InscriptionAnnuelle inscriptionAnnuelle;

	@ManyToOne
	@JoinColumn(name = "idEnseighant")
	private Enseignant enseignant;

	public String getEnseignantNom() {
		return enseignant.getNom();
	}
	public String getEnseignantPrenom() {
		return enseignant.getPrenom();
	}
	public String getEnseignantFullName() {
		return enseignant.getNom()+" "+enseignant.getPrenom();
	}
	public void setEnseignantFullName(String s) {
		enseignant.setNom(s.split(" ")[0]);
		enseignant.setPrenom(s.split(" ")[1]);
	}
	public InscriptionMatiere() {
	}

	public Long getIdInscriptionMatiere() {
		return idInscriptionMatiere;
	}

	public void setIdInscriptionMatiere(Long idInscriptionMatiere) {
		this.idInscriptionMatiere = idInscriptionMatiere;
	}

	public double getNoteSN() {
		return noteSN;
	}

	public void setNoteSN(double noteSN) {
		this.noteSN = noteSN;
	}

	public double getNoteSR() {
		return noteSR;
	}

	public void setNoteSR(double noteSR) {
		this.noteSR = noteSR;
	}

	public double getNoteFinale() {
		return noteFinale;
	}

	public void setNoteFinale(double noteFinale) {
		this.noteFinale = noteFinale;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getPlusInfos() {
		return plusInfos;
	}

	public void setPlusInfos(String plusInfos) {
		this.plusInfos = plusInfos;
	}

	public Element getMatiere() {
		return matiere;
	}

	public void setMatiere(Element matiere) {
		this.matiere = matiere;
	}

	public InscriptionAnnuelle getInscriptionAnnuelle() {
		return inscriptionAnnuelle;
	}

	public void setInscriptionAnnuelle(InscriptionAnnuelle inscriptionAnnuelle) {
		this.inscriptionAnnuelle = inscriptionAnnuelle;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

}
