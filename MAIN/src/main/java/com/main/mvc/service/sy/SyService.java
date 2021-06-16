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
	
	public List<Sy1010Dto> userList(){
		return syMapper.userList();
	}
	
	// 관리자 로그인
	public int loginCheckSystem(Sy1010Dto param) {
		int result = 0;
		
		// 관리자 세션 종료
		UserInfoSession.logout();
		
		List<Sy1010Dto> userInfo = syMapper.loginCheckSystem(param);
		if(userInfo.size() > 0) {
			UserInfoSession.setLoginSuccess(userInfo.get(0));
			result = 1;
		}
		
		return result;
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
	public int logoutCheck() throws Exception {
		int result = 0;
		UserInfoSession.logout();
		if(!UserInfoSession.isLogin()) {
			result = 1;
		}
		return result;
	}
	
	// 회원가입
	@Transactional
	public int signUp(Sy1010Dto param) throws Exception {
		SecurityUtil su = new SecurityUtil();
		int result = 0;
		
		// 비밀번호 암호화 sha256
		String passSha256 = param.getPassWord();
		param.setPassWord(su.sha256(passSha256));
		
		// 아이디 // 닉네임 체크
		
		result = syMapper.signUp(param);
		return result;
	}
	
	// 아이디
	public boolean userIdCheck(Sy1010Dto param) {
		boolean isOk;
		Sy1010Dto syDto = syMapper.userIdCheck(param);
		int count = Integer.parseInt(syDto.getUserId());
		if(count > 0) {
			isOk = true;
		} else {
			isOk = false;
		}
		
		return isOk;
	}
	
	// 닉네임 체크
	public boolean nickNameCheck(Sy1010Dto param) {
		boolean isOk;
		Sy1010Dto syDto = syMapper.nickNameCheck(param);
		int count = Integer.parseInt(syDto.getNickName());
		if (count > 0) {
			isOk = true;
		} else {
			isOk = false;
		}

		return isOk;
	}
	
}
