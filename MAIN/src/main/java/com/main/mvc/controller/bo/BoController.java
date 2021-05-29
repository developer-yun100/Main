package com.main.mvc.controller.bo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.service.sy.BoService;

@Controller
@RequestMapping(value = "/bo", produces="application/json;charset=utf-8")
public class BoController {
	
	@Resource
	BoService boService;
	
	// 채널 목록
	@RequestMapping(value = "/bo1010.yh")
	public String sy1020(Model model) {
		
		List<Bo1010Dto> channelList = boService.channelList();
		model.addAttribute("channelList", channelList);
		
		return "/bo/bo1010";
	}
}
