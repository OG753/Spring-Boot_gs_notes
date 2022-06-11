package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Element;

public interface IElementService {
  public List<Element> getAll();
  public Element getBynom(String name);
}
