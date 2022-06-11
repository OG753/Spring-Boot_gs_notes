package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.InscriptionModule;

public interface IInscriptionModuleDao extends JpaRepository<InscriptionModule,Long>{
      public List<InscriptionModule> findAll();
//      public void addElement(InscriptionModule  mod);
//      public void updateElemet(InscriptionModule mod);
}
