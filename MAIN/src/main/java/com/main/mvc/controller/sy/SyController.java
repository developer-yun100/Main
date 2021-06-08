package com.main.mvc.controller.sy;

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
	
	// 인터셉터 2 시스템 관리 URL 접속 차단
	@RequestMapping(value = "/interceptorSyPage.yh")
	public String interceptorSyPage(Model model) {
		return "/interceptor/interceptorSyPage";
	}
	
	// 준비중인 화면
	@RequestMapping(value = "/construct.yh")
	public String construct(Model model) {
		return "/interceptor/construct";
	}
	
	// 홈 화면으로
	@RequestMapping(value = "/index.yh")
	public String index(Model model) {
		return "redirect:/";
	}
	
	// 시스템 관리 화면
	@RequestMapping(value = "/sy2010.yh")
	public String sy2010(Model model) {
		List<Sy1010Dto> userList = syService.userList();
		model.addAttribute("userList", userList);
		return "/sy/sy2010";
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
	
	// 관리자 로그인
	@RequestMapping(value = "/loginCheckSystem.act")
	@ResponseBody
	public Map<String, Object> loginCheckSystem(@RequestBody ParamDto params, Model model) throws Exception {
		// form data
		Sy1010Dto form = params.getForm(Sy1010Dto.class);
		JsonBinder entity = new JsonBinder();
		return entity.jsonEntity(syService.loginCheckSystem(form));
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
