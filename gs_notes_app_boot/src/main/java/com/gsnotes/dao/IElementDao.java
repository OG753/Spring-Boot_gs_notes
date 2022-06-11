package com.gsnotes.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsnotes.bo.Element;

public interface IElementDao extends JpaRepository<Element,Long>{
	  public List<Element> findAll();
}
