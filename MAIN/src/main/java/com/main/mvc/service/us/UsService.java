package com.main.mvc.service.us;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.main.common.file.FileManager;
import com.main.common.session.UserInfoSession;
import com.main.mvc.dto.common.FileDto;
import com.main.mvc.dto.us.UsDto;
import com.main.mvc.mapper.us.UsMapper;

@Service
public class UsService {
	
	@Resource
	UsMapper usMapper;
	
	// 계정 정보
	public UsDto userInfoDto(UsDto param) {
		param.setUserId(UserInfoSession.getUser().getUserId());
		return usMapper.userInfoDto(param);
	}
	
	
	// 프로필 변경
	@Transactional
	public int proFileChange(UsDto param, FileDto fileDto, int port) throws Exception {
		int result = 0;
		FileManager fm = new FileManager();
		String fileName = fm.proFileUpload(fileDto, port);
		if(fileName == null) {
			return result;
		}
		fileName = "/boardImages/profileImages/"+fileName;
		param.setUserId(UserInfoSession.getUser().getUserId());
		param.setProFileImgUrl(fileName);
		// url
		result = usMapper.proFileChange(param);
		return result;
	}
	

}
