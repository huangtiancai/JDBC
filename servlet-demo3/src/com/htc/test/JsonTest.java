/**
 * 
 */
package com.htc.test;

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
		
		//一个Person对象
		msg = Jsonlib.createJsonString("一个Person对象", service.getPerson());
		System.out.println(msg);
		//一个List，里面有若干Person对象
		msg = Jsonlib.createJsonString("Persons", service.getPersonList());
		System.out.println(msg);
		//一个List，里面有若干String对象
		msg = Jsonlib.createJsonString("StringList", service.getStringList());
		System.out.println(msg);
		//一个List，里面有若干Map对象，每个Map对象中存储了若干个键值对
		msg = Jsonlib.createJsonString("MapList", service.getMapList());
		System.out.println(msg);
	}
}
