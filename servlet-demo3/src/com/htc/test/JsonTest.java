/**
 * 
 */
package com.htc.test;

import com.htc.bean.Person;
import com.htc.jsonlib.Jsonlib;
import com.htc.service.JsonService;

/**  
* @ClassName JsonTest
* @Description:
* @author htc  
* @date 2019年6月10日下午6:27:16 
*/
public class JsonTest {
	public static void main(String[] args) {
		String msg = "";
		JsonService service = new JsonService();
		//Person person = service.getPerson();
		
		msg = Jsonlib.createJsonString("一个Person对象", service.getPerson());
		System.out.println(msg);
		
		msg = Jsonlib.createJsonString("若干个Person对象", service.getPersonList());
		System.out.println(msg);
		
		msg = Jsonlib.createJsonString("若干String对象", service.getStringList());
		System.out.println(msg);
	}
}
