package com.gsnotes.services;

import java.util.List;
import com.gsnotes.bo.Module;
public interface IModuleService {

	public List<Module> getAll();
	public Module findBytitre(String s);
}
