/**
 * 
 */
package com.htc.demo;

import org.junit.Test;

/**  
* @ClassName Demo2
* @Description:JDBC API详解--注解驱动
* @author htc  
* @date 2019年6月1日下午3:05:49 
*/
public class Demo2 {
	/**
	 * Title: demo1
	 * Description: 测试注解驱动
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		//1.JDBC规范规定，如果需要连接数据库，必须提供驱动接口的实现类
		/**
		 * 1.JDBC规范规定，如果需要连接数据库，必须提供驱动接口的实现类
		 *   驱动接口:java.sql.Driver 			      		-package java.sql;
		 *   每一个数据库提供驱动jar都实现该接口
		 * 2.MySQL驱动包提供实现类：com.mysql.jdbc.Driver     -package com.mysql.jdbc;
		 *   源码：public class Driver extends NonRegisteringDriver implements java.sql.Driver{}
		 * 3.JDBC规范提供了注册的实现方式
		 *   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 *   但，如果遵循上面语句，Java代码与 mysql实现类耦合(直接关系)，之后切换数据库将不能进行。
		 *   另外通过查询com.mysql.jdbc.Driver源码，我们发现Driver类“主动”将自己进行注册:
		 *   DriverManager.registerDriver(new Driver());
		 *   总结不足:(1)硬编码,不利于后期的维护和更换
    	 *		   (2)驱动类被加载了两次
    	 *	   希望提供方案时，只要切换数据驱动，就可以切换使用数据库
		 *	4.通常注册驱动使用标准写法
		 *	Class.forName("com.mysql.jdbc.Driver");
		 *	1) 使用反射的方式加载指定的类
		 *	2) 具体加载的类以字符串(类的全限定名称)体现,内容就可以存放到配置文件中，通过修改配置文件方便切换数据库
		 *	3) 一个类被加载到内存，静态代码块将执行，static{ ... }	
		 *	
		 */
		//结论：注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		
		//注册驱动--注意事项
		/**
		 * 手动注册驱动，驱动注册了几次？(2次)
		 * DriverManager工具类，提供注册驱动的方法 registerDriver()
		 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 * 第一次：
		 * 		DriverManager.registerDriver(new Driver());
		 * 		new Driver() 时，Driver类加载，静态代码块执行，注册一次
		 * 第二次：手动注册
		 * 
		 */
		
	}
}
