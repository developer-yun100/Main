package com.main.mvc.mapper.bo;

import java.util.List;

import com.main.mvc.dto.bo.Bo1010Dto;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoMapper")
public interface BoMapper {
	
	public List<Bo1010Dto> channelList();
	
	public List<Bo1010Dto> channelDetailList(Bo1010Dto param);
	
	public Bo1010Dto channelHeader(Bo1010Dto param);
	
	public Bo1010Dto channelDetatilData(Bo1010Dto param);
	public List<Bo1010Dto> commentList(Bo1010Dto param);
	
	public int commentInsert(Bo1010Dto param);
	
	public Bo1010Dto commentConut(Bo1010Dto param);
	
}
