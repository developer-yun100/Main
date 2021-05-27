package com.main.mvc.mapper.sy;

import java.util.List;

import com.main.mvc.dto.sy.Sy1010Dto;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("SyMapper")
public interface SyMapper {
	
	// user info select
	List<Sy1010Dto> selectUserList();
	
}
