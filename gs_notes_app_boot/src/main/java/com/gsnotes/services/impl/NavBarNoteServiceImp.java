package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;
import com.gsnotes.dao.IElementDao;
import com.gsnotes.dao.IFiliereDao;
import com.gsnotes.dao.IModuleDao;
import com.gsnotes.dao.INiveauDao;
import com.gsnotes.services.NavBarNoteService;

@Service
public class NavBarNoteServiceImp implements NavBarNoteService{
  @Autowired 
  private IFiliereDao Fil;
  
  @Autowired 
  private INiveauDao Niv;
  
  @Autowired 
  private IModuleDao Mod;
  
  @Autowired 
  private IElementDao Ele;
  
  public List<Filiere> getAllFiliere(){
	  return Fil.findAll();  
  }


@Override
public Filiere getFiliereById(Long id) {
	return Fil.getById(id);
}

@Override
public List<Niveau> getAllNiveau() {

	return Niv.findAll();
}


@Override
public Boolean getByalias(String name) {
	return Niv.existsByalias(name);
}


  
}
