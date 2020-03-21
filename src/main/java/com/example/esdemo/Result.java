package com.example.esdemo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 作为部分请求的响应
 */
@SuppressWarnings({"rawtypes", "serial"})
public class Result implements Serializable{

	public static Map rst(int state,String msg,Object data){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
	public static Map rst(Object data){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("data", data);
		return map;
	}
	public static Map rst(int state,String msg){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("msg", msg);
		return map;
	}
	public static Map rst(int state,Object data){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", state);
		map.put("data", data);
		return map;
	}

	public static Map error(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", "404");
		map.put("msg", "错误");
		return map;
	}

	public static Map success(Object data){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", "200");
		map.put("data", data);
		return map;
	}

	public static Map success(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("state", "200");
		map.put("msg", "成功");
		return map;
	}
}
