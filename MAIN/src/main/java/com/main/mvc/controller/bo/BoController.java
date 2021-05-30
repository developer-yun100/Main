package com.main.mvc.controller.bo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.common.api.JsonBinder;
import com.main.common.api.ParamDto;
import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.service.sy.BoService;

@Controller
@RequestMapping(value = "/bo", produces="application/json;charset=utf-8")
public class BoController {
	
	@Resource
	BoService boService;
	
	@RequestMapping(value = "/bo1013.yh")
	public String bo1013(Model model) {
		return "/bo/bo1013";
	}
	
	// 채널 목록
	@RequestMapping(value = "/bo1010.yh")
	public String bo1010(Model model) {
		List<Bo1010Dto> channelList = boService.channelList();
		model.addAttribute("channelList", channelList);
		return "/bo/bo1010";
	}
	
	// 채널상세
	@RequestMapping(value = "/bo1011.yh")
	public String bo1011(Bo1010Dto bo1010Dto, Model model) {
		
		List<Bo1010Dto> channelDetailList = boService.channelDetailList(bo1010Dto);
		model.addAttribute("channelDetailList", channelDetailList);
		
		Bo1010Dto channelHeader = boService.channelHeader(bo1010Dto);
		model.addAttribute("channelHeader", channelHeader);
		
		return "/bo/bo1011";
	}
	
	// 게시글 상세
	@RequestMapping(value = "/bo1012.yh")
	public String bo1012(Bo1010Dto bo1010Dto, Model model) {
		List<Bo1010Dto> commentList = boService.commentList(bo1010Dto);
		model.addAttribute("commentList", commentList);
		Bo1010Dto channelDetatilData = boService.channelDetatilData(bo1010Dto);
		model.addAttribute("channelDetatilData", channelDetatilData);
		return "/bo/bo1012";
	}
	
	// 댓글입력
	@RequestMapping(value = "/commentInsert.act")
	@ResponseBody
	public Map<String, Object> commentInsert(@RequestBody ParamDto params, Model model) throws Exception {
		Bo1010Dto form = params.getForm(Bo1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(boService.commentInsert(form));
	}
	
	
}
