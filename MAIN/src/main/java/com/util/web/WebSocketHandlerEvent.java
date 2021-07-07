package com.util.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Component
public class WebSocketHandlerEvent extends TextWebSocketHandler{
	
	private static final Logger log = LoggerFactory.getLogger(WebSocketHandlerEvent.class);
	
	/*
	 * WebSocket 사용
	 * socket -> session (통신 할 방 생성 )
	 * 각 세션에 req -> res 
	 * 
	 * */
	
	// session 리스트
	List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	// 통신 연결 요청
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.debug("소켓에 연결을 시도합니다. ");
		log.debug("session Id :" + session.getId());
		sessionList.add(session);
		
	}
	
	// 통신 연결 해제
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.debug("해당 session : "+ session.getId() + " 소켓 연결을 해제합니다.");
		sessionList.remove(session);
	}

	// 데이터 주고 받기 byte로 가져옴
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.debug("session : " + session.getId()  + " 에 소켓에 데이터를 전달합니다.");
		String json =  message.getPayload();
		
		for (WebSocketSession webSocketSession : sessionList) {
			webSocketSession.sendMessage(new TextMessage(json));
		}
		
	}
	
	
}
