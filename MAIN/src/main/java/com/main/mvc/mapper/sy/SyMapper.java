package com.main.mvc.mapper.sy;

import java.util.List;

import com.main.mvc.dto.sy.Sy1010Dto;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("SyMapper")
public interface SyMapper {
	
	// test
	public List<Sy1010Dto> selectUserList();
	
	// 로그인
	public List<Sy1010Dto> loginCheck(Sy1010Dto param);
	
	public List<Sy1010Dto> userList();
	
	// 관리자 로그인
	public List<Sy1010Dto> loginCheckSystem(Sy1010Dto param);
	
	// 회원가입
	public int signUp(Sy1010Dto param);
	
	// 로그인 체크
	public Sy1010Dto userIdCheck(Sy1010Dto param);
	
	public Sy1010Dto nickNameCheck(Sy1010Dto param);
	
}
