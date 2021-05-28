package com.main.mvc.controller.sy;

import java.util.HashMap;
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
import com.main.mvc.dto.sy.Sy1010Dto;
import com.main.mvc.service.sy.SyService;

@Controller
@RequestMapping(value = "/sy", produces="application/json;charset=utf-8")
public class SyController {
	
	@Resource
	SyService syService;
	
	// 회원가입 팝업
	@RequestMapping(value = "/sy1010pop.yh")
	public String sy1010(Model model) {
		return "/sy/sy1010pop";
	}
	
	@RequestMapping(value = "/signUp.act")
	@ResponseBody
	public Map<String, Object> signUp(@RequestBody ParamDto params, Model model) {
		// form data
		Sy1010Dto form = params.getForm(Sy1010Dto.class);
		JsonBinder entity = new JsonBinder();
		
		return entity.jsonEntity(syService.signUp(form));
	}
	
	
}
