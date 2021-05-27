package com.main.mvc.dto.sy;

import lombok.Data;

public @Data class Sy1010Dto {
	
	// 계정 관련
	private String clientId;
	private String userId;
	private String passWord;
	private String nickName;
	private String email;
	private String authCode;
	private String menuType;
	private String regDate;
	private String modDate;
	private String useYn;

}
