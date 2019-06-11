/**
 * 
 */
package com.htc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.htc.bean.Person;
import com.htc.jsonlib.Jsonlib;

/**  
* @ClassName JsonService
* @Description:
* @author htc  
* @date 2019年6月10日下午6:28:08 
*/
public class JsonService {
	//JSON解析实例——使用Json-lib
	//https://www.cnblogs.com/mengdd/p/3141402.html

	public JsonService() {
		// TODO Auto-generated constructor stub
	}
	
//	id    name   address
//	001, "tom",  "Beijing"    ---第一个Person对象（一个对象具有3个属性id,name,address,属性值分别为：001,"tom","Beijing"）
//	002, "jack", "shanghai"   ---第二个Person对象
//	003, "john", "guangzhou"  ---第三个Person对象
//	每个Person对象都可以用3个属性描述他(属性:属性值  key value)
//		{"属性1":"属性值","属性1":"属性值","属性1":"属性值"}
	
//	数据在名称/值对中	  			"属性1":"属性值"
//	数据由逗号分隔	  			"属性1":"属性值","属性1":"属性值"
//	花括号保存对象(一个对象)		{"属性1":"属性值","属性1":"属性值","属性1":"属性值"}
//	方括号保存数组(多个对象)	  	[{"address":"Beijing","id":1,"name":"tom"},
//	 						 {"address":"shanghai","id":2,"name":"jack"},
//	 						 {"address":"guangzhou","id":3,"name":"john"}
//							]
	
	public Person getPerson(){
		Person person = new Person(001, "tom", "beijing");
		return person;
	}
	
//	msg = Jsonlib.createJsonString("一个Person对象", service.getPerson());
//	System.out.println(msg);
//	{"一个Person对象":
//		{"address":"beijing","id":1,"name":"tom"}
//	}
	
	public List<Person> getPersonList(){
		List<Person> personList = new ArrayList<Person>();
		
		Person person1 = new Person(001, "tom",  "Beijing");
		Person person2 = new Person(002, "jack", "shanghai");
		Person person3 = new Person(003, "john", "guangzhou");
		
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		
		return personList;	
	}
	
//	msg = Jsonlib.createJsonString("Persons", service.getPersonList());
//	System.out.println(msg);
	
//	一个List，里面有若干Person对象
//	{"Persons":
//		[{"address":"Beijing","id":1,"name":"tom"},
//		 {"address":"shanghai","id":2,"name":"jack"},
//		 {"address":"guangzhou","id":3,"name":"john"}
//		]
//	}
	
	
	public List<String> getStringList(){
		List<String> stringList = new ArrayList<String>();
		
		stringList.add("南京");
		stringList.add("杭州");
		stringList.add("苏州");
		stringList.add("无锡");
		stringList.add("上海");
		
		return stringList;
	}
	
//	一个List，里面有若干String对象
//	msg = Jsonlib.createJsonString("StringList", service.getStringList());
//	System.out.println(msg);
	
//	{"StringList":
//		["南京","杭州","苏州","无锡","上海"]
//	}
	
	public List<Map<String, Object>> getMapList(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object> >();
 		for(int i = 0;i<3;i++){
 			Map<String, Object> map = new HashMap<String,Object>();
 			
 			//map.put(String key, Object value);//key value
 			map.put("id", i);
 			map.put("name", "Name_"+i);
 			map.put("address", "Address_"+i);
 			
 			mapList.add(map);
 		}
		
		return mapList;
	}
	
//	一个List，里面有若干Map对象，每个Map对象中存储了若干个键值对
//	msg = Jsonlib.createJsonString("MapList", service.getMapList());
//	System.out.println(msg);

//	{"MapList":
//		[{"id":0,"address":"Address_0","name":"Name_0"},     i = 0  一个for循环里添加三个键值对
//		 {"id":1,"address":"Address_1","name":"Name_1"},	 i = 1
//		 {"id":2,"address":"Address_2","name":"Name_2"}		 i = 2
//		]
//	}
	
//	id   name       address
//	0,   "Name_0",  "Address_0"    ---第一个Person对象
//	1,   "Name_1",  "Address_1"    ---第二个Person对象
//	2,   "Name_2",  "Address_2"
	
	
	
}
