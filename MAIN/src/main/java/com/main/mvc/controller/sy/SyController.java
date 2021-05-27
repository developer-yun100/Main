package com.main.mvc.controller.sy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.mvc.dto.sy.Sy1010Dto;
import com.main.mvc.service.sy.SyService;

@Controller
@RequestMapping(value = "/sy")
public class SyController {
	
	@Resource
	SyService syService;
	
	@RequestMapping(value = "/sy1010.yh")
	public String sy1010(Model model) {
		System.out.println("controller 테스트 ");
		List<Sy1010Dto> list = syService.testService();
			System.out.println("쿼리 테스트 => " + list.get(0));
		return "/sy/sy1010";
	}
}
