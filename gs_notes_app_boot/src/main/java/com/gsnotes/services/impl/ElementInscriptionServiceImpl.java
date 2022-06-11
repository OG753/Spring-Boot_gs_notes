package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Element;
import com.gsnotes.bo.InscriptionMatiere;
import com.gsnotes.dao.IInscriptionMatiereDao;
import com.gsnotes.services.IElementInscriptionService;

@Service
@Transactional
public class ElementInscriptionServiceImpl implements IElementInscriptionService {
    @Autowired
    IInscriptionMatiereDao serv;
	@Override
	public List<InscriptionMatiere> findAll() {
		return serv.findAll();
	}
	@Override
	public void addElement(InscriptionMatiere mat) {
		serv.save(mat);
	}
	@Override
	public void updateElemet(InscriptionMatiere mat) {
	     serv.save(mat);
		
	}
	
	
	

}
