package com.main.mvc.service.bo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.main.common.session.UserInfoSession;
import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.mapper.bo.BoMapper;

@Service
public class BoService {
	
	@Resource
	BoMapper boMapper;
	
	public List<Bo1010Dto> channelList(Bo1010Dto param){
		if(param.getRownum() == null || "".equals(param.getRownum())) {
			param.setRownum("1");
		}
		return boMapper.channelList(param);
	}
	
	// 상세
	public List<Bo1010Dto> channelDetailList(Bo1010Dto param){
		return boMapper.channelDetailList(param);
	}
	
	// 상세 페이징
	public List<Bo1010Dto> channelDetailListTwo(Bo1010Dto param){
		return boMapper.channelDetailListTwo(param);
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
	
	// 내가 쓴 글 조회
	public List<Bo1010Dto> contentMyList(Bo1010Dto param){
		return boMapper.contentMyList(param);
	}
	
	public Bo1010Dto subScrYn(Bo1010Dto param) {
		param.setUserId(UserInfoSession.getUser().getUserId());
		return boMapper.subScrYn(param);
	}
	
	public List<Bo1010Dto> scrContentList(Bo1010Dto param){
		param.setUserId(UserInfoSession.getUser().getUserId());
		return  boMapper.scrContentList(param);
	}
	
	public List<Bo1010Dto> searchPaging(Bo1010Dto param){
		List<Bo1010Dto> boDto = new ArrayList<Bo1010Dto>();
		// DB 로우 수
		Bo1010Dto rowCount = boMapper.searchPaging(param);
		int row = Integer.parseInt(rowCount.getRowCount());
		param.setStartPage("1");
		
		// 페이징 처리는 10개 당 1개
		int pagingCount = 10;
		int paging = 1;
		
		// 10개당 1페이지
		for(int i = 0; i < row; i++) {
			if(i > pagingCount) {
				pagingCount += 10;
				paging += 1;
			}
		}
		param.setLastPage(String.valueOf(paging));
		boDto.add(param);
		return boDto;
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
	
	// 채널 구독
	@Transactional
	public int subScribe(Bo1010Dto param) {
		int result = 0;
		result = boMapper.subScribe(param);
		return result;
	}
	
	// 채널 구독 취소
	@Transactional
	public int subScribeCancel(Bo1010Dto param) {
		int result = 0;
		result = boMapper.subScribeCancel(param);
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
