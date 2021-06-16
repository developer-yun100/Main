package com.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.main.common.session.UserInfoSession;

public class Interceptor extends HandlerInterceptorAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(Interceptor.class);
	
	// URL 요청시 세션 및 권한 체크
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUrl = request.getRequestURI();
		LOG.debug("request URL : " + requestUrl);
		
		// sy20 / 관리자 화면
		
		if(!UserInfoSession.isLogin()) {
			if(requestUrl.contains("/bo") || requestUrl.contains("/us")) {
				response.sendRedirect("/sy/interceptor.yh");
				return false;
			} else if(requestUrl.contains("/sy/sy20")) {
				response.sendRedirect("/sy/index.yh");
				return false;
			}
			
		} else {
			if(requestUrl.contains("/sy/sy20")) {
				LOG.debug("system Login user check " + UserInfoSession.getUser().getUserId());
				if(!"00000AHMS".equals(UserInfoSession.getUser().getAuthCode())) {
					response.sendRedirect("/sy/interceptorSyPage.yh");
					return false;
				}
			}
			
		}
		return true;
	}
}
