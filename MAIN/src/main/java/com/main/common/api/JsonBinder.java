package com.main.common.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.util.web.Interceptor;

public class JsonBinder {
	
	private static final Logger LOG = LoggerFactory.getLogger(JsonBinder.class);
	
	// response json - String
	public String resJson(Object param){
		JSONObject jsonObj = new JSONObject();
		List<Object> list = new ArrayList<Object>();
		
		list.add(param);
		jsonObj.put("data", list);
		
		Gson gson = new Gson();
		String json = gson.toJson(jsonObj);
		
		return json;
	}
	
	//service transaction
	public Map<String, Object> jsonEntity(Object param){
		LOG.debug("JSON Map Binding Code => " + param);
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> entityMap = new HashMap<String, Object>();
		
		Integer code = new Integer((int)param);
		if(code == 1) { // 정상
			param = "0000";
		} else { // 트랜잭션 처리 실패
			param = "000A";
		}
		LOG.debug("JSON Result Code => " + param);
		Gson gson = new Gson();
		jsonObject.put("data", param);
		String json = gson.toJson(jsonObject);
		
		entityMap.put("data", json);
		return entityMap;
	}
	
	// service List
	public Map<String, Object> jsonEntityList(Object param) {
		LOG.debug("JSON List Binding Code => " + param);
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> entityMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		jsonObject.put("data", param);
		String json = gson.toJson(jsonObject);
		entityMap.put("data", json);
		LOG.debug("JSON entityMap => " + entityMap);
		return entityMap;
	}
	
	
	// return JSON ( 0000, 000A, 000B, 000C )
	public Map<String, Object> returnJSON(String code){
		LOG.debug("JSON Map Binding Code => " + code);
		Map<String, Object> entity = new HashMap<String, Object>();
		JSONObject jsonObject = new JSONObject();
		Gson gson = new Gson();
		jsonObject.put("data", code);
		String json = gson.toJson(jsonObject);
		entity.put("data", json);
		return entity;
	}
	
}
