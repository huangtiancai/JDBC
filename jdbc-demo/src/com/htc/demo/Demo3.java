/**
 * 
 */
package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**  
* @ClassName Demo3
* @Description:JDBC API详解--获取连接
* @author htc  
* @date 2019年6月1日下午3:45:08 
*/
public class Demo3 {
	/**
	 * 
	 * Title: demo1
	 * Description:测试获取连接
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * 获得连接
		 * DBC提供工具类 DriverManager(驱动管理器)
		 * getConnection() 通过设置具体参数向不同的数据库创建新的连接
		 * 
		 * DriverManager.getConnection(url, user, password);
		 * 参数1 url :数据访问路径
		 * 参数2 user: 数据库用户名
		 * 参数3 password:数据库密码
		 *   url访问路径:
		 *   格式  jdbc:mysql://ip地址:端口号/数据库名称
		 *   如：  jdbc:myql://localhost:3306/mydb  
		 *   	jdbc:mysql://149.129.77.73:3306/mysql
		 *      
		 *      jdbc固定
		 *      mysql 表示mysql数据库，一般情况会根据数据库不同而不同
		 *      localhost:3306 表示数据库具体地址，为默认值
		 *      mydb:表示数据名称 
		 * 
		 */
		Class.forName("com.mysql.jdbc.Driver");
//		DriverManager.getConnection(String url,String user,String password);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql","huangtc", "huangTC@123");
		//Connection con = DriverManager.getConnection("jdbc:mysql://149.129.77.73:3306/mysql","huangtc", "huangTC@123");
		System.out.println("连接成功，获取连接对象："+con);

		
	}
}
