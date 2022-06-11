package com.gsnotes.services;

import java.util.List;


import com.gsnotes.bo.InscriptionMatiere;

public interface IElementInscriptionService {
      public List<InscriptionMatiere> findAll();
  	  public void addElement(InscriptionMatiere mat);
  	  public void updateElemet(InscriptionMatiere mat);
	  
}
