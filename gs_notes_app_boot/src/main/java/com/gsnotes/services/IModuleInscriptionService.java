package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.InscriptionModule;

public interface IModuleInscriptionService{
 public List<InscriptionModule> findAll();
 public void addModule(InscriptionModule im);
 public void updateModule(InscriptionModule im);
}
