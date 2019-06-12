/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName MyBean
* @Description:
* @author htc  
* @date 2019年6月12日下午2:51:18 
*/
public class MyBean {
	//MyBean要有一个first的属性,且其类型为Person,要和map中的键和值类型对应，即first对应键; first类型对应值的类型
	private Person first;

	public Person getFirst() {
		return first;
	}

	public void setFirst(Person first) {
		this.first = first;
	}
	
	
}
