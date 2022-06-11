package com.gsnotes.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.InscriptionMatiere;


public interface ReadFileDao extends JpaRepository<InscriptionMatiere, Long> {

}
