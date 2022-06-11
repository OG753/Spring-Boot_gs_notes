package com.gsnotes.services;

import org.springframework.web.multipart.MultipartFile;

public interface ReadFileService {
	public void uploadFile(MultipartFile file);
}
