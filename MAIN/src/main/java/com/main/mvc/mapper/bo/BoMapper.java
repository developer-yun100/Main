package com.main.mvc.mapper.bo;

import java.util.List;

import com.main.mvc.dto.bo.Bo1010Dto;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoMapper")
public interface BoMapper {
	
	// jsp data info
	public List<Bo1010Dto> channelList(Bo1010Dto param);
	public List<Bo1010Dto> channelDetailList(Bo1010Dto param);
	public Bo1010Dto channelHeader(Bo1010Dto param);
	public Bo1010Dto channelDetatilData(Bo1010Dto param);
	public List<Bo1010Dto> commentList(Bo1010Dto param);
	
	public List<Bo1010Dto> contentMyList(Bo1010Dto param);
	
	// 게시글 댓글 등록
	public int commentInsert(Bo1010Dto param);
	
	// 게시글 댓글 카운트
	public Bo1010Dto commentConut(Bo1010Dto param);
	
	// 게시글 등록
	public int contentInsert(Bo1010Dto param);
	
	// 게시글 카운트
	public Bo1010Dto contentConut(Bo1010Dto param);
	
	// 조회수 업데이트
	public int contentIncheck(Bo1010Dto param);
	
	// 채널 추가
	public int channelInsert(Bo1010Dto param);
	
	// 채널 카운트
	public Bo1010Dto channelCount(Bo1010Dto param);
	
	// 채널 구독
	public int subScribe(Bo1010Dto param);
	public Bo1010Dto subScrYn(Bo1010Dto param);
	
	public List<Bo1010Dto> scrContentList(Bo1010Dto param);
	
}
