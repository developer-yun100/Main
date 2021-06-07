package com.main.mvc.controller.bo;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.main.common.api.JsonBinder;
import com.main.common.api.ParamDto;
import com.main.common.file.FileManager;
import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.service.bo.BoService;

@Controller
@RequestMapping(value = "/bo", produces="application/json;charset=utf-8")
public class BoController {
	
	@Resource
	BoService boService;
	
	// 게시글 작성
	@RequestMapping(value = "/bo1013.yh")
	public String bo1013(Bo1010Dto bo1010Dto, Model model) {
		Bo1010Dto channelHeader = boService.channelHeader(bo1010Dto);
		model.addAttribute("channelHeader", channelHeader);
		return "/bo/bo1013";
	}
	
	// 채널 목록 조회
	@RequestMapping(value = "/bo1010.yh")
	public String bo1010(Bo1010Dto bo1010Dto, Model model) {
		List<Bo1010Dto> channelList = boService.channelList(bo1010Dto);
		model.addAttribute("channelList", channelList);
		return "/bo/bo1010";
	}
	
	// 채널 목록 검색 조회
	@RequestMapping(value = "/searchTitle.act")
	@ResponseBody
	public Map<String, Object> searchTitle(@RequestBody ParamDto params, Model model) throws Exception {
		Bo1010Dto form = params.getForm(Bo1010Dto.class);
		JsonBinder entity = new JsonBinder();
		List<Bo1010Dto> channelList = boService.channelList(form);
		return entity.jsonEntityList(channelList);
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
	
	// 채널생성 팝업
	@RequestMapping(value = "/bo1014pop.yh")
	public String bo1014(Bo1010Dto bo1010Dto, Model model) throws Exception {
		return "/bo/bo1014pop";
	}
	
	
	// 채널 생성
	@RequestMapping(value = "/channelInsert.act")
	@ResponseBody
	public Map<String, Object> insertChannel(@RequestBody ParamDto params, Model model) throws Exception {
		Bo1010Dto form = params.getForm(Bo1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(boService.channelInsert(form));
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
		// InetAddress.getLocalHost().getHostAddress();
		String ip = "localhost";
				
		int port = req.getServerPort();
		
		FileManager fm = new FileManager();
		String fileName = fm.fileUpload(params, port);
		PrintWriter pw;
		String ipPort;
		
		if(port == 80) {
			ipPort = "http://yh.developeryun.kr";
		} else {
			ipPort = "http://" + ip + ":" + String.valueOf(port);
		}
		
		String path = "/images/boardFiles/";
		
        String filePathName = ipPort + path + fileName;
        String callback = req.getParameter("CKEditorFuncNum");
        res.setCharacterEncoding("utf-8");
        res.setContentType("text/html; charset=utf-8");
        pw = res.getWriter();
        
        // 파일 생성 텀 주기 (파일 생성 이 후 -> URL 전달)
        Thread.sleep(2000);
        
        pw.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
               + callback
               + ",'"
               + filePathName
               + "','upload success'"
               + ")</script>");

        pw.flush();
        
        
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
