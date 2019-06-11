/**
 * 
 */
package com.htc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.htc.bean.Person;
import com.htc.jsonlib.Jsonlib;
import com.htc.service.JsonService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**  
* @ClassName JsonTest
* @Description:
* @author htc  
* @date 2019年6月10日下午6:27:16 
*/
public class JsonTest {
	//利用Json-lib生成JSON字符串
	@Test
	public void testcreateJsonString() {
		
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
	
	/**
	 * function: testArrayToJSON
	 * Description:一般数组转换成JSON
	 * return:void
	 */
	@Test
	public void testArrayToJSON(){
		int[] arr = new int[]{12,23,34,45};
		boolean[] bollArray = new boolean[]{true,false,true};
		
		JSONArray jsonArray = JSONArray.fromObject(arr);
		JSONArray jsonArray1 = JSONArray.fromObject(bollArray);
		//java中打印输出数组
		System.out.println("arr:"+Arrays.toString(arr));
		System.out.println("jsonArray:"+jsonArray);
		System.out.println("jsonArray1:"+jsonArray1);
	}
	
	/**
	 * function: testListToJSON
	 * Description:Collection对象转换成JSON
	 * return:void
	 */
	@Test
	public void testListToJSON(){
		List<String> list = new ArrayList<String>();
		list.add("first");
		list.add("second");
		list.add("third");
		JSONArray jsonArray = JSONArray.fromObject(list);
		
		System.out.println("list:"+list);
		System.out.println("jsonArray:"+jsonArray);
		
//		list:[first, second, third]
//		jsonArray:["first","second","third"]
	}
	
	/**
	 * function: tsetJSONstrToJSON
	 * Description:JSON字符串转换成JSON对象，根据情况使用JSONArray或JSONObject
	 * 				注意JSON字符串与JSON对象的区别
	 * return:void
	 */
	@Test
	public void testJSONstrToJSON(){
		//JSONArray jsonArray = JSONArray.fromObject("["first","second","third"]");//会报错
//		JSON可以有两种格式，一种是对象格式的，另一种是数组对象
//		{"id":0,"address":"Address_0","name":"Name_0"}    //JSONObject-JSON的对象格式的字符串 ,用 { } 来表示的，
//		[{"id":0,"address":"Address_0","name":"Name_0"}]  //JSONArray-由JSONObject构成的数组，用  [ { } , { } , ......  , { } ]  来表示
//		后端返回json格式的字符串，前台使用js中的JSON.parse()方法把JSON字符串解析为json对象，然后进行遍历，供前端使用
		
//		JSONArray jsonArray = JSONArray.fromObject(Object object);
		String JSONstr1 = "['南京','杭州','苏州','无锡','上海']";
		String JSONstr2 = "[\"南京\",\"杭州\",\"苏州\",\"无锡\",\"上海\"]";
		
		String JSONstr3 = "{\"address\":\"Beijing\",\"id\":1,\"name\":\"tom\"}";
		String JSONstr4 = "{'address':'Beijing','id':1,'name':'tom'}";
		
		String JSONstr5 = "[{\"address\":\"Beijing\",\"id\":1,\"name\":\"tom\"}]";
		String JSONstr6 = "[{'address':'Beijing','id':1,'name':'tom'}]";
		
		JSONArray jsonArray1 = JSONArray.fromObject(JSONstr1);
		JSONArray jsonArray2 = JSONArray.fromObject(JSONstr2);
		
		JSONObject jsonObject1 = JSONObject.fromObject(JSONstr3);
		JSONObject jsonObject2 = JSONObject.fromObject(JSONstr4);
		
		JSONObject jsonArray3 = JSONObject.fromObject(JSONstr5);
		JSONObject jsonArray4 = JSONObject.fromObject(JSONstr6);


		System.out.println(jsonArray1);
		System.out.println(jsonArray2);
		System.out.println(jsonObject1);
		System.out.println(jsonObject2);
		System.out.println(jsonArray3);
		System.out.println(jsonArray4);

	}
	
	/**
	 * function: convertObject
	 * Description:java对象转化为JSON字符串(两种格式的JSON字符串)
	 * return:void
	 */
	@Test
	public void convertObject(){
		Person person = new Person();
		person.setId(1);
		person.setName("tom");
		person.setAddress("beijing");
		System.out.println("Person对象:"+person);
		//1.使用JSONObject
		//JSONObject
		JSONObject json = JSONObject.fromObject(person);
		String strJson = json.toString();
		
		//2.使用JSONArray
		JSONArray arry = JSONArray.fromObject(person);
		String strArray = arry.toString();
		
		System.out.println("json:"+json);
		System.out.println("arry:"+arry);
		//System.out.println("strArray:"+strJson);
		//System.out.println("strArray:"+strArray);
	}
	
	/**
	 * function: jsonStrToJava
	 * Description:把JSON字符串格式转化为java对象(两种格式的JSON字符串转化为java对象)
	 * return:void
	 */
	@Test
	public void jsonStrToJava(){
		//定义两种不同格式的字符串
		String objectStr = "{\"address\":\"beijing\",\"id\":1,\"name\":\"tom\"}"; 
		

		//1.使用JSONObject
		//JSONObject
		JSONObject jsonObject = JSONObject.fromObject(objectStr);
		Person person = (Person) jsonObject.toBean(jsonObject, Person.class);
		System.out.println("person:"+person);
		
		//2.使用JSONArray
		//JSONArray arry = JSONArray.fromObject(person);

	}
	
	
	
	
}
