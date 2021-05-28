package com.main.common.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

public class JsonBinder {
	
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
	
	public Map<String, Object> jsonEntity(Object param){
		
		JSONObject jsonObject = new JSONObject();
		Map<String, Object> entityMap = new HashMap<String, Object>();
		
		Integer code = new Integer((int)param);
		if(code == 1) { // 정상
			param = "0000";
		} else { // 트랜잭션 처리 실패
			param = "000A";
		}
		System.out.println("jsonBainder param" + param);
		Gson gson = new Gson();
		jsonObject.put("data", param);
		String json = gson.toJson(jsonObject);
		
		
		entityMap.put("data", json);
		System.out.println("entityMap param" + entityMap);
		return entityMap;
	}
	
}
