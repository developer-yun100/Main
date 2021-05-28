package com.main.common.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

/**
 * ParamDto
 *
 *
 * @Author : 주오윤
 * @File : com.main.common.api.ParamDto.java
 * @Version : 1.0,
 * @Date : 2021. 05. 28.
 * @Commnad: RequestBody formJsonData
 *
 **/

public @Data class ParamDto {
	
	private static final Logger log = LoggerFactory.getLogger(ParamDto.class.getName());
	
	// map type
	private Map<String, Object> form;
    private Map<String, Object> form1;
    private Map<String, Object> form2;
    private Map<String, Object> form3;
    private Map<String, Object> form4;
    private Map<String, Object> form5;
    
    // list<Map> type
	private List<Map<String, Object>> data;
	private List<Map<String, Object>> data1;
	private List<Map<String, Object>> data2;
	private List<Map<String, Object>> data3;
	private List<Map<String, Object>> data4;
	private List<Map<String, Object>> data5;
	
	// json type
	private String dataJson;
	private String data1Json;
	private String data2Json;
	private String data3Json;
	private String data4Json;
	private String data5Json;
	
	// jsonArray type
	private String[] dataArrJson;
	
	// formjsonArray type
	private String formJson;
	
    public <T> List<T> getDataList(Class<T> clz) {
		List<T> list = new ArrayList<>();
		if(data == null){
            log.error("paramDto.data ::::  null");
	        return list;
		}
		try {
			for (Map<String, Object> paramsData : data) {
				T t = clz.getConstructor().newInstance();
				BeanUtils.populate(t, paramsData);
				list.add(t);
			}
		} catch (Exception e) {
            log.error("e : " + e);
		}
		return list;
	}
    
	/**
	 * type =["Data","Data1","Data2","Data3","Data4","Data5"]
	 * @param clz
	 * @param type
	 * @return
	 */
	public <T> List<T> getDataList(Class<T> clz , String type) {
        List<T> list = new ArrayList<>();
        if(getTypeOfDataList(type) == null){
            log.error("paramDto.getTypeOfDataList ::::  null");
            return list;
        }
        try {
            for (Map<String, Object> paramsData : getTypeOfDataList(type)) {
                T t = clz.getConstructor().newInstance();
                BeanUtils.populate(t, paramsData);
                list.add(t);
            }
        } catch (Exception e) {
        }
        return list;
    }
	
    private List<Map<String, Object>> getTypeOfDataList(String type) {
        // TODO Auto-generated method stub
        if(StringUtils.isEquals(type, "Data")){
            return getData();
        }else if(StringUtils.isEquals(type, "Data1")){
            return getData1();
        }else if(StringUtils.isEquals(type, "Data2")){
            return getData2();
        }else if(StringUtils.isEquals(type, "Data3")){
            return getData3();
        }else if(StringUtils.isEquals(type, "Data4")){
            return getData4();
        }else if(StringUtils.isEquals(type, "Data5")){
            return getData5();
        }else if(StringUtils.isEquals(type, "DataJson")){
            return getDataJson(type);
        }else if(StringUtils.isEquals(type, "Data1Json")){
            return getDataJson(type);
        }else if(StringUtils.isEquals(type, "Data2Json")){
            return getDataJson(type);
        }else if(StringUtils.isEquals(type, "Data3Json")){
            return getDataJson(type);
        }else if(StringUtils.isEquals(type, "Data4Json")){
            return getDataJson(type);
        }else if(StringUtils.isEquals(type, "Data5Json")){
            return getDataJson(type);
        }
        
        return null;
    }
    
    public List<Map<String, Object>> getDataJson(String type){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String paramJson = "";
            
            if(StringUtils.isEquals(type, "DataJson")){
                paramJson = this.getDataJson();
            }
            if(StringUtils.isEquals(type, "Data1Json")){
                paramJson = this.getData1Json();            
            }
            if(StringUtils.isEquals(type, "Data2Json")){
                paramJson = this.getData2Json();
            }
            if(StringUtils.isEquals(type, "Data3Json")){
                paramJson = this.getData3Json();
            }
            if(StringUtils.isEquals(type, "Data4Json")){
                paramJson = this.getData4Json();
            }
            if(StringUtils.isEquals(type, "Data5Json")){
                paramJson = this.getData5Json();
            }
            if(!StringUtils.isEquals("[]", paramJson)){
                if(paramJson != null){
                    list =objectMapper.readValue(paramJson, new TypeReference<List<Map<String,Object>>>(){});
                }
            }
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    /**
	 * use only one row parameter.
     * @return 
 	*/
    public <T>  T getObject(Class<T> clz){
        T t = null;
        if(data == null){
            log.error("data ::::  null");
            return t;
        }
        try {
            t = clz.getConstructor().newInstance();
            for (Map<String, Object> paramsData : data) {
                BeanUtils.populate(t, paramsData);
            }
        } catch (Exception e) {
            throw new RuntimeException("객체 생성시 오류");
        }
        return t;
    }
    /**
     * use only one row parameter.
     * @return 
    */
    public <T>  T getForm(Class<T> clz){
        T t = null;        
        if(form == null){
            log.error("form ::::  null");
            return t;
        }
        try {
            t = clz.getConstructor().newInstance();
            BeanUtils.populate(t, form);
        } catch (Exception e) {
            throw new RuntimeException("객체 생성시 오류(getForm)");
        }
        return t;
    }
    /**
     * use only one row parameter.
     * @return 
    */
    public <T>  T getForm(Class<T> clz, String type){
        T t = null;
        if(getTypeOfForm(type) == null){
            log.error("getTypeOfForm(type) ::::  null");
            return t;
        }
        try {
            t = clz.getConstructor().newInstance();
            BeanUtils.populate(t, getTypeOfForm(type));
        } catch (Exception e) {
            throw new RuntimeException("객체 생성시 오류(getForm)");
        }
        return t;
    }
    private Map<String, Object> getTypeOfForm(String type) {
        // TODO Auto-generated method stub
        ObjectMapper objectMapper = new ObjectMapper();
        if(StringUtils.isEquals(type, "Form")){
            return getForm();
        }else if(StringUtils.isEquals(type, "Form1")){
            return getForm1();
        }else if(StringUtils.isEquals(type, "Form2")){
            return getForm2();
        }else if(StringUtils.isEquals(type, "Form3")){
            return getForm3();
        }else if(StringUtils.isEquals(type, "Form4")){
            return getForm4();
        }else if(StringUtils.isEquals(type, "Form5")){
            return getForm5();
        }else if(StringUtils.isEquals(type, "FormJson")){
            Map<String, Object> map = new HashMap<String, Object>();
            if(this.getFormJson() == null){
                return null;
            }
            try {
                map = objectMapper.readValue(this.getFormJson(), new TypeReference<Map<String,Object>>(){});
            } catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return map;
        }
        return null;
    }

}
