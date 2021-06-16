package com.main.mvc.dto.common;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import lombok.Data;

public @Data class FileDto {
	
	private MultipartFile[] files;
	private MultipartFile file;
    private MultipartHttpServletRequest fileData;
    
    private String uploadFileName;
    private String orgFileName;
    private String newFileName;
    
    
}
