package com.main.mvc.controller.sy;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.common.api.JsonBinder;
import com.main.common.api.ParamDto;
import com.main.mvc.dto.sy.Sy1010Dto;
import com.main.mvc.service.sy.SyService;

@Controller
@RequestMapping(value = "/sy", produces="application/json;charset=utf-8")
public class SyController {
	
	@Resource
	SyService syService;
	
	// 인터셉터
	@RequestMapping(value = "/interceptor.yh")
	public String interceptorPage(Model model) {
		return "/interceptor/interceptorPage";
	}
	
	// 시스템 관리 화면
	@RequestMapping(value = "/sy1010.yh")
	public String sy1020(Model model) {
		return "/sy/sy1010";
	}

	// 회원가입 팝업
	@RequestMapping(value = "/sy1010pop.yh")
	public String sy1010(Model model) {
		return "/sy/sy1010pop";
	}
	
	// 로그인 팝업
	@RequestMapping(value = "/sy1011pop.yh")
	public String sy1011(Model model) {
		return "/sy/sy1011pop";
	}
	
	// 로그인
	@RequestMapping(value = "/loginCheck.act")
	@ResponseBody
	public Map<String, Object> loginCheck(@RequestBody ParamDto params, Model model) throws Exception {
		// form data
		Sy1010Dto form = params.getForm(Sy1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(syService.loginCheck(form));
	}
	
	// 로그아웃
	@RequestMapping(value = "/logoutCheck.act")
	@ResponseBody
	public Map<String, Object> logoutCheck(@RequestBody ParamDto params, Model model) throws Exception {
		// form data
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(syService.logoutCheck());
	}
	
	// 회원가입
	@RequestMapping(value = "/signUp.act")
	@ResponseBody
	public Map<String, Object> signUp(@RequestBody ParamDto params, Model model) throws Exception {
		// form data
		Sy1010Dto form = params.getForm(Sy1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(syService.signUp(form));
	}
	
	
}
