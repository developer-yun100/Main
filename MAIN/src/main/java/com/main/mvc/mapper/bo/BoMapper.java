package com.main.mvc.mapper.bo;

import java.util.List;

import com.main.mvc.dto.bo.Bo1010Dto;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoMapper")
public interface BoMapper {
	
	public List<Bo1010Dto> channelList();
	
}
