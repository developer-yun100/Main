package com.main.mvc.dto.common;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public @Data class FileDto {
	
	private MultipartFile[] file;
    private MultipartFile fileData;
    
    private String uploadFileName;
    private String orgFileName;
    private String newFileName;
    
    
}
