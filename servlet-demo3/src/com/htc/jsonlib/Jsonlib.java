/**
 * 
 */
package com.htc.jsonlib;

import com.htc.bean.User;

import net.sf.json.JSONObject;

/**  
* @ClassName Jsonlib
* @Description:
* @author htc  
* @date 2019年6月10日下午6:10:32 
*/
public class Jsonlib {

	public Jsonlib() {
		// TODO Auto-generated constructor stub
	}
	
	public static String createJsonString(String key,Object value){
		String jsonString = null;
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		
		jsonString = jsonObject.toString();
		
		return jsonString;
	}
}
