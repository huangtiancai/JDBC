package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


/**
 * JDBC连接数据库步骤：
 * 1.添加jar包  build path下
 * 2.加载驱动
 * 3.获取连接对象
 * 4.获取处理器对象：第一种：Statement st = con.createStatement();
 * 5.执行sql语句		
 * 		executeUpdate(sql):执行DML语句（insert/update/delete）：返回为整形，表示影响行数
 * 		executeQuery(sql):执行DQL语句  :返回ResultSet结果集对象(查询所有数据)
 * 6.处理返回的结果
 * 7.关闭相关资源Connection,Statement,ResultSet等
 */
	  
	/**    
	* @ClassName Demo1
	* @Description:
	* @author htc  
	* @date 2019年6月1日上午11:01:46
	 */
	public class Demo1 {
		/**
		 * Title: demo1
		 * Description:
		 */
		@Test
		public void demo1(){
			//查询所有的分类信息
		    //注意：使用JDBC规范，采用都是 java.sql包下的内容
			//注意：com.mysql.jdbc.Connection 是mysql自己的接口
			//java.sql.Connection 这是一个公共的接口包括对mysql的支持oracle,sqlserver 对很多数据库一个公共的API!
			Connection con = null;
			Statement st = null;
			
			//2.注册驱动
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("数据库驱动加载成功!");
				//junit测试
				//3.建立与数据库的连接
				//con = DriverManager.getConnection(url, user, password);
//				url: jdbc:mysql://localhost:3306/数据库名
				//JDBC规定url的格式由三部分组成，每个部分中间使用冒号分隔
				//第一部分是jdbc，这是固定的；
				//第二部分是数据库类型名称，那么连接mysql数据库，第二部分当然是mysql了
				//第三部分是由数据库厂商规定的,mysql的第三部分分别由数据库服务器的IP地址（localhost）、端口号（3306），以及database名称组成
				
//				user(用户名):root
//				password(密码)：huangTC@123
				//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "huangtc","huangTC@123");
				con = DriverManager.getConnection("jdbc:mysql://149.129.77.73:3306/mysql", "huangtc","huangTC@123");
				System.out.println("连接成功，获取连接对象："+con);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
						
	}
		
}
