package com.gsnotes.services;

import java.util.List;

import com.gsnotes.bo.Filiere;
import com.gsnotes.bo.Niveau;

public interface NavBarNoteService {
    public List<Filiere> getAllFiliere();
    public Filiere getFiliereById(Long id);
    public List<Niveau> getAllNiveau();
    public Boolean getByalias(String name);
}
