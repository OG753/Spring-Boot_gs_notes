package com.gsnotes.web.controllers;



import com.gsnotes.services.NavBarNoteService;
import com.gsnotes.web.models.InfoFileModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin") 
public class NoteNavBarController {
	@Autowired 
	private NavBarNoteService FilList;
	
	@GetMapping("FilierList")
	public String getListFiliere(Model model){
		InfoFileModel inf=new InfoFileModel();
		model.addAttribute("info",inf);
		model.addAttribute("flist",FilList.getAllFiliere());
		model.addAttribute("niv",FilList.getAllNiveau());
		return "admin/ChooseFile";
	}
	
	@GetMapping("/GotoUpload")
	public String redirect() {
		return "admin/UploadFile";
	}

}
