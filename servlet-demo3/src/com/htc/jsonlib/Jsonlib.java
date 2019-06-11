/**
 * 
 */
package com.htc.jsonlib;

import com.htc.bean.User;

import net.sf.json.JSONObject;

/**  
* @ClassName Jsonlib
* @Description:json-lib是一个java类库，提供将Java对象，
* 			         包括beans, maps, collections, java arrays and XML等转换成JSON，或者反向转换的功能
* @author htc  
* @date 2019年6月10日下午6:10:32 
*/
public class Jsonlib {

	public Jsonlib() {
		// TODO Auto-generated constructor stub
	}
	
	//利用Json-lib生成JSON字符串
	public static String createJsonString(String key,Object value){
		String jsonString = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		
		
		jsonString = jsonObject.toString();
		
		return jsonString;
	}
}
