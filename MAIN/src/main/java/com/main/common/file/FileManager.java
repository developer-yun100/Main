package com.main.common.file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.main.mvc.dto.common.FileDto;

public class FileManager {
	private static final Logger log = LoggerFactory.getLogger(FileManager.class.getName());
	
	// 서버에 파일 저장
	public String fileUpload(MultipartHttpServletRequest req, int port) throws Exception{
		
		MultipartFile mf = req.getFile("upload");
		
		byte[] bytes = mf.getBytes();
		String oriFileName = mf.getOriginalFilename();
		log.debug("fileName : " + oriFileName);
		log.debug("request port : " + port);
		// 새로운 파일 이름
		String newFileName = null;
		
		// 파일 경로
		String path;
		// 로컬 경로
		String localPath = "C:\\testWar\\boardImages";
		// 운영 경로
		String realPath = "C:\\tomcat\\boardImages";
		
		// 임시 조치
		if(port == 10076) {
			path = realPath;
		} else {
			path = localPath;
		}
		
		// 받은 파일이 없으면
		if(bytes == null) {
			return null;
		}
		
		String fileExt = oriFileName.substring(oriFileName.lastIndexOf("."));
		
        if(fileExt == null || fileExt.equals("")) {
        	return null;
        }
        
        // 서버에 저장할 새로운 파일명 생성
        newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", 
        Calendar.getInstance());
		newFileName += System.nanoTime();
		newFileName += fileExt;
		log.debug("server save => newFileName : " + newFileName);
		
		File dir = new File(path);
		// 업로드할 경로가 없으면 폴더 생성
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String pathName = path + File.separator + newFileName;
		log.debug("pathName : " + pathName);
		
		FileOutputStream fos = new FileOutputStream(new File(pathName));
		fos.write(bytes); // 파일 생성
		fos.close();
		
		// 파일 생성 체크
		//File file = new File(pathName);
		
		/*while(!file.exists()) {
			if(file.exists()) {
				log.debug("File Create true");
				break;
			}
		}*/
        
        return newFileName;
	}
	
	// 프로필 저장 proFileIamge
	public String proFileUpload(FileDto param, int port) throws Exception {
		
		// 파일 경로 / 파일 이름
		String path;
		String newFileName;
		
		// 파일 req
		MultipartFile mf = param.getFile();
		byte[] bytes = mf.getBytes();
		
		// 파일이 없으면..
		if(bytes == null) {
			return null;
		}
		
		String oriFileName = mf.getOriginalFilename();
		log.debug("oriFileName : " + oriFileName);
		
		
		String fileExt = oriFileName.substring(oriFileName.lastIndexOf("."));
		
		// 이름이 없으면
		 if(fileExt == null || fileExt.equals("")) {
	        	return null;
	     }
		
		// 임시 조치
		if (port == 10076 || port == 80) {
			path = "C:\\tomcat\\boardImages\\profileImages";
		} else {
			path = "C:\\testWar\\boardImages\\profileImages";
		}
		
		// saveFileName
		newFileName = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", Calendar.getInstance());
		
		newFileName += System.nanoTime();
		newFileName += fileExt;
		log.debug("server save => newFileName : " + newFileName);
		
		File dir = new File(path);
		// 업로드할 경로가 없으면 폴더 생성
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		String pathName = path + File.separator + newFileName;
		log.debug("pathName : " + pathName);
		
		FileOutputStream fos = new FileOutputStream(new File(pathName));
		fos.write(bytes); // 파일 생성
		fos.close();
		
		return newFileName;
	}
	
}
