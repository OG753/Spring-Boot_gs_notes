package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;

public interface INiveauDao extends JpaRepository<Niveau,Long> {
	public List<Niveau> findAllByfiliere(Filiere filiere);
	public List<Niveau> findAll();
	public Boolean existsByalias(String alias);
}
