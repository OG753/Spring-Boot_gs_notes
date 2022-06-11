package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gsnotes.bo.Module;
import com.gsnotes.dao.IModuleDao;
import com.gsnotes.services.IModuleService;
@Service
public class moduleServiceImpl implements IModuleService{
    @Autowired
    IModuleDao mdao;
    
	@Override
	public List<com.gsnotes.bo.Module> getAll() {
		
		return mdao.findAll() ;
	}
	@Override
	public Module findBytitre(String s) {
	    Module m = null;
		List<Module> l=mdao.findAll();
		for(int i=0;i<l.size();i++) {
			if(l.get(i).getTitre().equals(s)) 
				 m=l.get(i);
		}
		return m;
	}

}
