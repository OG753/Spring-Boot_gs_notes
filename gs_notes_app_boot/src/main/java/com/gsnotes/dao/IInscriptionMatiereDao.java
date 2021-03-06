package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.InscriptionMatiere;

public interface IInscriptionMatiereDao extends JpaRepository<InscriptionMatiere,Long> {
    public List<InscriptionMatiere> findAll();
}
