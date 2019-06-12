/**
 * 
 */
package com.htc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.htc.bean.MyBean;
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
//		{"id":0,"address":"Address_0","name":"Name_0"}    //JSON的对象格式的字符串 ,用 { } 来表示的，
//		[{"id":0,"address":"Address_0","name":"Name_0"}]  //{ }构成的数组，用  [ { } , { } , ......  , { } ]  来表示
		
//		对象格式的JSON字符串用JSONObject处理   {}
//		数组对象的JSON字符串用JSONArray处理     [{},{},...{}]
		
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
		
		JSONArray jsonArray3 = JSONArray.fromObject(JSONstr5);
		JSONArray jsonArray4 = JSONArray.fromObject(JSONstr6);


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
	public void javaToJSON(){
		Person person = new Person();
		person.setId(1);
		person.setName("tom");
		person.setAddress("beijing");
		System.out.println("Person对象:"+person);
		//1.使用JSONObject-java对象转换成json对象，并转化为字符串
		JSONObject json = JSONObject.fromObject(person);
		String strJson = json.toString();
		
		//2.使用JSONArray-java对象列表转换为json对象数组，并转为字符串
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
		String arrayStr = "[{\"address\":\"Beijing\",\"id\":1,\"name\":\"tom\"},{\"address\":\"shanghai\",\"id\":2,\"name\":\"jack\"}]";
		
		//1.使用JSONObject-直接将JSON格式的字符串转化为java对象
		//JSONObject
		JSONObject jsonObject = JSONObject.fromObject(objectStr);
		Person person = (Person) jsonObject.toBean(jsonObject, Person.class);
		
		
		//2.使用JSONArray
		JSONArray jsonArray = JSONArray.fromObject(arrayStr);
		System.out.println(jsonArray);//[{},{}]
		
		//2.1把JSON字符串转换为JAVA对象(只获取其中的一个对象)
		Object o = jsonArray.get(1);
		JSONObject jsonObject2 = JSONObject.fromObject(o);
		Person person1 = (Person) jsonObject2.toBean(jsonObject2, Person.class);

		
		//2.2把JSON字符串转换为JAVA对象数组
		//JSONArray jsonArray = JSONArray.fromObject(arrayStr);
		List<Person> persons = (List<Person>) JSONArray.toCollection(jsonArray, Person.class);
		
		System.out.println("person:"+person);
		System.out.println("person1:"+person1);
		System.out.println("persons:"+persons);
	}
	
	/**
	 * function: listToJSON
	 * Description:list转换为JSON字符串
	 * return:void
	 */
	@Test
	public void listToJSON(){
		Person person = new Person();
		person.setId(1);
		person.setName("tom");
		person.setAddress("beijing");
		System.out.println(person);//Person [id=1, name=tom, address=beijing]
		
		List<Person> lists = new ArrayList<Person>();
		lists.add(person);
		System.out.println(lists);//[Person [id=1, name=tom, address=beijing]]
		//1.使用JSONObject
//		JSONObject listObject = JSONObject.fromObject(lists);
//		System.out.println(listObject.toString());
		
//		注意：在使用fromObject方法的时候会先进行参数类型的判断，传入的参数是一个array类型
//		net.sf.json.JSONException: 'object' is an array. Use JSONArray instead
		
		
		//2.使用JSONOArray
		JSONArray listArray = JSONArray.fromObject(lists);
		System.out.println(listArray.toString());
	}
	
	/**
	 * function: jsonToList
	 * Description:JSON字符串转换为list
	 * return:void
	 */
	@Test
	public void jsonToList(){
		String arrayStr = "[{\"address\":\"beijing\",\"id\":1,\"name\":\"tom\"}]";
		
		//1.使用JSONObject
//		JSONObject listObject = JSONObject.fromObject(lists);
//		System.out.println(listObject.toString());
		
//		注意：在使用fromObject方法的时候会先进行参数类型的判断，传入的参数是一个array类型
//		net.sf.json.JSONException: 'object' is an array. Use JSONArray instead
		
		
		//2.使用JSONOArray
		JSONArray jsonArray = JSONArray.fromObject(arrayStr);
		//转化为list
		List<Person> lists = JSONArray.toList(jsonArray, Person.class);
		for(Person li : lists){
			System.out.println(li);//Person [id=1, name=tom, address=beijing]
		}
		//转化为数组
		Person[] persons = (Person[]) JSONArray.toArray(jsonArray, Person.class);
		for(Person p : persons){
			System.out.println(p);//Person [id=1, name=tom, address=beijing]
		}
		
//		由于这里有实体类进行对应，所以在使用时指定了泛型的类型（Student.class），这样就可以得到转化后的对象。
		
	}
	
	/**
	 * function: mapToJSON
	 * Description:map转换为JSON字符串
	 * return:void
	 */
	@Test
	public void mapToJSON(){
		Person person = new Person();
		person.setId(1);
		person.setName("tom");
		person.setAddress("beijing");
		System.out.println(person);//Person [id=1, name=tom, address=beijing]
		
		Map<String, Person> map = new HashMap<String,Person>();
		map.put("first", person);
		System.out.println(map);//{first=Person [id=1, name=tom, address=beijing]}
		
		//1.使用JSONObject
		JSONObject mapObject = JSONObject.fromObject(map);
		System.out.println(mapObject.toString());//{"first":{"address":"beijing","id":1,"name":"tom"}}
		
//		注意：在使用fromObject方法的时候会先进行参数类型的判断，传入的参数是一个array类型
//		net.sf.json.JSONException: 'object' is an array. Use JSONArray instead
		
		//2.使用JSONOArray
		JSONArray mapArray = JSONArray.fromObject(map);
		System.out.println(mapArray.toString());//[{"first":{"address":"beijing","id":1,"name":"tom"}}]
	}
	
	/**
	 * function: jsonToMap
	 * Description:JSON字符串转换成map
	 * return:void
	 */
	@Test
	public void jsonToMap(){
		String strObject = "{\"first\":{\"address\":\"beijing\",\"id\":1,\"name\":\"tom\"}}";
		
		//1.使用JSONObject
		JSONObject jsonObject = JSONObject.fromObject(strObject);
		System.out.println(jsonObject.toString());
		
		Map map = new HashMap();
		map.put("first", Person.class);
		
		//toBean()方法是传入了三个参数:
		//第一个是JSONObject对象
		//第二个是MyBean.class
		//第三个是一个Map对象
//		JSONObject.toBean(JSONObject jsonObject, Class beanClass, Map classMap)
		MyBean my = (MyBean) JSONObject.toBean(jsonObject, MyBean.class, map);
		
		System.out.println(my);//com.htc.bean.MyBean@459116
		System.out.println(my.getFirst());//Person [id=1, name=tom, address=beijing]
				
	}
	
}
