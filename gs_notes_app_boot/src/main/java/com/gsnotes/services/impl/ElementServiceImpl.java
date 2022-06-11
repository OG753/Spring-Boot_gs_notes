package com.gsnotes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.bo.Element;
import com.gsnotes.dao.IElementDao;
import com.gsnotes.services.IElementService;

@Service
@Transactional
public class ElementServiceImpl implements IElementService {
	@Autowired
	IElementDao eldao;

	@Override
	public List<Element> getAll() {
		return eldao.findAll();
	}

	@Override
	public Element getBynom(String name) {
		Element e = null;
		List<Element> el=eldao.findAll();
		for(int i=0;i<el.size();i++) {
			if(el.get(i).getNom().equals(name))
				e=el.get(i);
			}
		return e;
		}

}
