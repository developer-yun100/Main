package com.main.mvc.service.sy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.mapper.bo.BoMapper;

@Service
public class BoService {
	
	@Resource
	BoMapper boMapper;
	
	public List<Bo1010Dto> channelList(){
		return boMapper.channelList();
	}
}
