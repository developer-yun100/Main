package com.main.mvc.service.sy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.mvc.dto.sy.Sy1010Dto;
import com.main.mvc.mapper.sy.SyMapper;

@Service
public class SyService {
	
	@Resource
	SyMapper syMapper;
	
	public List<Sy1010Dto> testService() {
		System.out.println("service 테스트");
		return syMapper.selectUserList();
	}
	
	public int signUp(Sy1010Dto param) {
		System.out.println("서비스 작동");
		int result = 0;
		result = syMapper.signUp(param);
		return result;
	}
	
	
}
