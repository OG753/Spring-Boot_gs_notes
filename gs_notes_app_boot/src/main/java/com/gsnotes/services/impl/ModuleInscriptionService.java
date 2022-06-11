package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.InscriptionModule;
import com.gsnotes.dao.IInscriptionModuleDao;
import com.gsnotes.services.IModuleInscriptionService;

@Service
@Transactional
public class ModuleInscriptionService implements IModuleInscriptionService {

	@Autowired 
	IInscriptionModuleDao service;

	@Override
	public List<InscriptionModule> findAll() {
		return service.findAll();
	}

	@Override
	public void addModule(InscriptionModule im) {
		service.save(im);
		
	}

	@Override
	public void updateModule(InscriptionModule im) {
		service.save(im);
	}
}
