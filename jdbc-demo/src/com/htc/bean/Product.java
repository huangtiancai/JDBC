/**
 * 
 */
package com.htc.bean;

/**  
* @ClassName Product
* @Description:Product-JavaBean就是一个类，在开发中常用语封装数据
* @author htc  
* @date 2019年6月6日下午1:12:33 
*/
public class Product {
	private String pid;
	private String pname;
	private Double price;
	private String category_id;

	//alt+/   生成无参构造器
	public Product() {
		// 
	}

	/**
	 * @param pid
	 * @param pname
	 * @param price
	 * @param category_id
	 */
	//alt+shift+s+o 生成带参构造
	public Product(String pid, String pname, Double price, String category_id) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.category_id = category_id;
	}
	
	//alt+shift+s+r  tab+enter  快速生成get set方法
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	//alt+shift+s
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", category_id=" + category_id + "]";
	}
	


	
}
