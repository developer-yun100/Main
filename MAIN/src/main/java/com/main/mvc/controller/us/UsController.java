package com.main.mvc.controller.us;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.common.api.JsonBinder;
import com.main.common.api.ParamDto;
import com.main.common.session.UserInfoSession;
import com.main.mvc.dto.bo.Bo1010Dto;
import com.main.mvc.dto.common.FileDto;
import com.main.mvc.dto.us.UsDto;
import com.main.mvc.service.us.UsService;

@Controller
@RequestMapping(value = "/us", produces="application/json;charset=utf-8")
public class UsController {
	
	@Resource
	UsService usService;
	
	// 계정 관리
	@RequestMapping(value = "/us1010.yh")
	public String us1010(UsDto usDtoParam, HttpServletRequest req, Model model) {
		UsDto usDto = usService.userInfoDto(usDtoParam);
		model.addAttribute("usDto", usDto);
		return "/us/us1010";
	}
	
	// 쪽지 목록
	@RequestMapping(value = "/us1011.yh")
	public String us1011(Model model) {
		return "/us/us1011pop";
	}
	
	// 친구 목록
	@RequestMapping(value = "/us1012.yh")
	public String us1012(Model model) {
		return "/us/us1012pop";
	}
	
	// 채팅
	@RequestMapping(value = "/us1013pop.yh")
	public String us1013(Model model) {
		return "/us/us1013pop";
	}
	
	// 친구 쪽지 관리
	@RequestMapping(value = "/us1020.yh")
	public String us1020(Model model) {
		return "/us/us1020";
	}
	
	// 이벤트 관리
	@RequestMapping(value = "/us1030.yh")
	public String us1030(Model model) {
		return "/us/us1030";
	}
	
	
	// 프로필 변경
	@RequestMapping(value = "/proFileChange.act")
	@ResponseBody
	public Map<String, Object> contentInsert(FileDto fileDto, UsDto usDto,
			HttpServletRequest req, HttpServletResponse res, Model model) throws Exception {
		JsonBinder entity = new JsonBinder();
		int port = req.getServerPort();
		return entity.jsonEntity(usService.proFileChange(usDto, fileDto, port));
	}
	
	
	// 이메일 변경
	
	// 비밀번호 변경
	
	
}
