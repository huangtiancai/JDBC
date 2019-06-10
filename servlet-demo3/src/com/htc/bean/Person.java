/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName Person
* @Description:
* @author htc  
* @date 2019年6月10日下午6:16:09 
*/
public class Person {
	private int id;
	private String name;
	private String address;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public Person(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
