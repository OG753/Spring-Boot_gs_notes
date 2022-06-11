package com.gsnotes.services.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gsnotes.dao.IInscriptionMatiereDao;
import com.gsnotes.dao.IInscriptionModuleDao;
import com.gsnotes.services.ReadFileService;
import com.gsnotes.utils.export.FileManagerHelper;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;



@Service
@Transactional
public class ReadFileServiceImpl implements ReadFileService {
	 @Autowired
	 IInscriptionMatiereDao matiereDao;
	 @Autowired
	 IInscriptionModuleDao moduleDao;
	 
	  public void save(MultipartFile file) {
	  
	  }

	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;
	public void uploadFile(MultipartFile file) {
		 try {
	            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
	            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
	                + ". Please try again!");
	        }
		
	}
	}

