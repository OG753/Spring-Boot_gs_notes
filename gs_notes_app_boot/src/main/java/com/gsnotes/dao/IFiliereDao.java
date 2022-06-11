package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Filiere;

public interface IFiliereDao extends JpaRepository<Filiere,Long> {
    public List<Filiere> findAll();
    public Filiere getById(Long id);
   
}
