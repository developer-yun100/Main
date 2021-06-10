package com.main.mvc.controller.us;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.mvc.service.us.UsService;

@Controller
@RequestMapping(value = "/us", produces="application/json;charset=utf-8")
public class UsController {
	
	@Resource
	UsService usService;
	
	@RequestMapping(value = "/us1010.yh")
	public String us1010() {
		return "/us/us1010";
	}
	
}
