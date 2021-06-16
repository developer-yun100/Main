package com.main.mvc.mapper.us;

import com.main.mvc.dto.us.UsDto;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("UsMapper")
public interface UsMapper {
	
	public UsDto userInfoDto(UsDto param);
	
	public int proFileChange(UsDto param);

}
