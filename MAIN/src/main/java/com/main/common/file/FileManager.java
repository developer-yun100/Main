package com.main.common.file;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileManager {
	private static final Logger log = LoggerFactory.getLogger(FileManager.class.getName());
	
	// 서버에 파일 저장
	public String fileUpload(MultipartHttpServletRequest req, int port) throws Exception{
		
		MultipartFile mf = req.getFile("upload");
		
		byte[] bytes = mf.getBytes();
		String oriFileName = mf.getOriginalFilename();
		log.debug("fileName : " + oriFileName);
		
		// 새로운 파일 이름
		String newFileName = null;
		
		// 파일 경로
		String path;
		// 로컬 경로
		String localPath = "C:\\Users\\beyon\\git\\Main\\MAIN\\src\\main\\webapp\\images\\boardFiles";
		// 운영 경로
		String realPath = "C:\\testWar\\Tomcat 8.5\\webapps\\MAIN\\images\\boardFiles";
		
		if(port == 80) {
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
}
