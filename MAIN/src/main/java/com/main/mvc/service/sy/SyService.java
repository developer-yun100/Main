package com.main.mvc.service.sy;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.main.common.api.SecurityUtil;
import com.main.common.session.UserInfoSession;
import com.main.mvc.dto.sy.Sy1010Dto;
import com.main.mvc.mapper.sy.SyMapper;

@Service
public class SyService {
	
	@Resource
	SyMapper syMapper;
	
	// test
	public List<Sy1010Dto> testService() {
		return syMapper.selectUserList();
	}
	
	// 로그인
	public int loginCheck(Sy1010Dto param) throws Exception {
		int result = 0;
		SecurityUtil su = new SecurityUtil();
		param.setPassWord(su.sha256(param.getPassWord()));
		List<Sy1010Dto> userInfo = syMapper.loginCheck(param);
		// 세션부여
		if(userInfo.size() > 0) {
			UserInfoSession.setLoginSuccess(userInfo.get(0));
			result = 1;
		}
		return result;
	}

	// 로그아웃
	public String logoutCheck() throws Exception {
		UserInfoSession.logout();
		return null;
	}
	
	// 회원가입
	@Transactional
	public int signUp(Sy1010Dto param) throws Exception {
		SecurityUtil su = new SecurityUtil();
		int result = 0;
		
		// 비밀번호 암호화 sha256
		String passSha256 = param.getPassWord();
		param.setPassWord(su.sha256(passSha256));
		
		result = syMapper.signUp(param);
		return result;
	}
	
	
}
