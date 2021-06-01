package com.main.mvc.controller.bo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.common.api.JsonBinder;
import com.main.common.api.ParamDto;
import com.main.common.file.FileManager;
import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.dto.common.FileDto;
import com.main.mvc.service.bo.BoService;

@Controller
@RequestMapping(value = "/bo", produces="application/json;charset=utf-8")
public class BoController {
	
	@Resource
	BoService boService;
	
	@RequestMapping(value = "/bo1013.yh")
	public String bo1013(Bo1010Dto bo1010Dto, Model model) {
		Bo1010Dto channelHeader = boService.channelHeader(bo1010Dto);
		model.addAttribute("channelHeader", channelHeader);
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
	public String bo1012(Bo1010Dto bo1010Dto, Model model) throws Exception {
		List<Bo1010Dto> commentList = boService.commentList(bo1010Dto);
		model.addAttribute("commentList", commentList);
		Bo1010Dto channelDetatilData = boService.channelDetatilData(bo1010Dto);
		model.addAttribute("channelDetatilData", channelDetatilData);
		boService.contentIncheck(bo1010Dto);
		
		return "/bo/bo1012";
	}
	
	// 게시글 입력
	@RequestMapping(value = "/contentInsert.act")
	@ResponseBody
	public Map<String, Object> contentInsert(@RequestBody ParamDto params, Model model) throws Exception {
		Bo1010Dto form = params.getForm(Bo1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(boService.contentInsert(form));
	}
	
	// 파일 첨부
	@RequestMapping(value = "/fileUpload.act")
	public void fileUpload(MultipartHttpServletRequest params, HttpServletRequest req, HttpServletResponse res) throws Exception{
		FileManager fm = new FileManager();
		String fileName = fm.fileUpload(params);
		
		String ip = InetAddress.getLocalHost().getHostAddress();
		int port = req.getServerPort();
		String ipPort = "http://" + ip + ":" + String.valueOf(port);
		
		String path = "/images/boardFiles/";
		
        String filePathName = ipPort + path + fileName;
        
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("uploaded", "1");
        map.put("filename", fileName);
        map.put("url", filePathName);
        
        ObjectMapper ob = new ObjectMapper();
        ob.writeValue(res.getWriter(), map);
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
