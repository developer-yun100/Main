package com.main.mvc.service.bo;

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
	
	public List<Bo1010Dto> channelList(Bo1010Dto param){
		return boMapper.channelList(param);
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
	
	// 채널 개설
	@Transactional
	public int channelInsert(Bo1010Dto param) {
		int result = 0;
		Bo1010Dto channelCount = boMapper.channelCount(param);
		param.setChannelCount(channelCount.getChannelCount());
		result = boMapper.channelInsert(param);
		return result;
	}
	
	// 게시글 작성
	@Transactional
	public int contentInsert(Bo1010Dto param) throws Exception {
		int result = 0;
		Bo1010Dto contentConut = boMapper.contentConut(param);
		param.setChNo(contentConut.getContentCount());
		result = boMapper.contentInsert(param);
		return result;
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
	
	// 조회수 체크
	@Transactional
	public int contentIncheck(Bo1010Dto param) throws Exception {
		int result = 0;
		result = boMapper.contentIncheck(param);
		return result;
	}
	
}
