/**
 * 
 */
package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**  
* @ClassName Demo4
* @Description:JDBC API详解--获得语句执行者
* @author htc  
* @date 2019年6月1日下午4:04:24 
*/
public class Demo4 {
	/**
	 * Title: demo1
	 * Description: 测试获得语句执行者
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * 获得语句执行平台
		 * 通过Connection就可以获得针对不同数据库sql语句的执行对象，常用  createStatement()
		 * 通过Statement对象可以执行任意的SQL语句
		 * int executeUpdate(String sql);
			 * -st.executeUpdate(sql) 
			 * -执行DML语句(增删改 insert、delete、update) ，返回为整型，表示影响行数 
		 * ResultSet executeQuery(String sql); 
			 * -st.executeQuery(sql)  
			 * -执行DQL语句(查询 select) ，返回ResultSet结果集对象(查询所有数据)
		 * Boolean execute(String sql);
			 * -st.execute(sql)
			 * -执行任意sql语句。返回为boolean
				 * true，表示执行DQL语句，需要通过ts.getResultSet() 获得查询结果
				 * false，表示DML语句，需要通过 ts.getUpdateCount() 获得影响行数。
		 */
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","huangtc", "huangTC@123");
		Statement st = con.createStatement();
		
		//ResultSet rs = st.executeQuery("select * from category");
		//System.out.println("rs:"+rs);
		
		//int num = st.executeUpdate("upadte category set cname = 1 where cid = 2");
		//System.out.println("num");
		
		Boolean r = st.execute("select * from category");
		System.out.println("t:"+r);
		
		
		
	}
}
