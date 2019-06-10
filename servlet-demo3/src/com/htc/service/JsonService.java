/**
 * 
 */
package com.htc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.htc.bean.Person;

/**  
* @ClassName JsonService
* @Description:
* @author htc  
* @date 2019年6月10日下午6:28:08 
*/
public class JsonService {

	public JsonService() {
		// TODO Auto-generated constructor stub
	}
	
	public Person getPerson(){
		Person person = new Person(001, "tom", "beijing");
		return person;
	}
	
//	{"address":"beijing","id":1,"name":"tom"}
	
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
	
//	[{"address":"Beijing","id":1,"name":"tom"},
//	 {"address":"shanghai","id":2,"name":"jack"},
//	 {"address":"guangzhou","id":3,"name":"john"}
//	]
	
	
	public List<String> getStringList(){
		List<String> stringList = new ArrayList<String>();
		
		stringList.add("南京");
		stringList.add("杭州");
		stringList.add("苏州");
		stringList.add("无锡");
		stringList.add("上海");
		
		return stringList;
	}
	
//	["南京","杭州","苏州","无锡","上海"]
	
	public List<Map<String, Object>> getMapList(){
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object> >();
 		
		
		return null;
	}
	
//	[{"id":0,"address":"Address_0","name":"Name_0"},
//	 {"id":1,"address":"Address_1","name":"Name_1"},
//	 {"id":2,"address":"Address_2","name":"Name_2"}]
	
	
	
	
	
}
