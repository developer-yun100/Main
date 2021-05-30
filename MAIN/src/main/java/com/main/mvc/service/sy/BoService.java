package com.main.mvc.service.sy;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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
	
	// 상세
	public List<Bo1010Dto> channelDetailList(Bo1010Dto param){
		return boMapper.channelDetailList(param);
	}
	
	// 상세
	public Bo1010Dto channelHeader(Bo1010Dto param){
		return boMapper.channelHeader(param);
	}
	
	public Bo1010Dto channelDetatilData(Bo1010Dto param){
		return boMapper.channelDetatilData(param);
	}
	
	public List<Bo1010Dto> commentList(Bo1010Dto param){
		return boMapper.commentList(param);
	}
	
	// 댓글 입력
	@Transactional
	public int commentInsert(Bo1010Dto param) throws Exception {
		int result = 0;
		Bo1010Dto commentConut = boMapper.commentConut(param);
		param.setCommentLine(commentConut.getCommentCount());
		result = boMapper.commentInsert(param);
		return result;
	}
	
}
