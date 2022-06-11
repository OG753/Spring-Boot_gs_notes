package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsnotes.bo.Etudiant;
import com.gsnotes.dao.IEtudiantDao;
import com.gsnotes.services.IEtudiantService;

@Service
public class EtudiantServiceImpl implements IEtudiantService{
    @Autowired
    IEtudiantDao student;
	@Override
	public List<Etudiant> getEtudiant() {
	return student.findAll();
	}

}
