package com.main.common.session;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.main.mvc.dto.sy.Sy1010Dto;

public class UserInfoSession {
		// 세션 키 (유저 타입)
		public static final String LOGIN_USER = "S_USERINFO";
		private static final Logger LOG = LoggerFactory.getLogger(UserInfoSession.class);
		
		// 세션 객체 생성
		public static HttpSession getSession() {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			return attr.getRequest().getSession();
		}

		// 로그인 정보 주기
		public static Sy1010Dto getUser() {
			if(isLogin()) {
				return (Sy1010Dto)getSession().getAttribute(LOGIN_USER);
			} else {
				return null;
			}
		}
		
		// 로그인 세션 정보부여
		public static Boolean setLoginSuccess(Sy1010Dto param) {
			try {
				LOG.debug("Login Info : "+ param.toString());
				getSession().setAttribute(LOGIN_USER, param);
				getSession().setMaxInactiveInterval(3000);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		// 로그아웃
		public static void logout() {
			getSession().invalidate();
		}
		
		// 세션 체크
		public static Boolean isLogin() {
			if(getSession().getAttribute(LOGIN_USER) == null) {
				return false;
			} else {
				return true;
			}
		}
}
