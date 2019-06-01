/**
 * 
 */
package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

/**  
* @ClassName Demo5
* @Description:JDBC API详解--结果集对象
* @author htc  
* @date 2019年6月1日下午4:42:22 
*/
public class Demo5 {
	/**
	 * Title: demo1
	 * Description: 测试结果集对象
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * ResultSet实际上就是一张二维的表格，我们可以调用其boolean next()方法指向某行记录
		 * 当第一次调用next()方法时，便指向第一行记录的位置
		 * 这时就可以使用ResultSet提供的getXXX(int col)方法(索引从1开始)来获取指定列的数据：
		 * 
		 * 
		 * 移动游标
		 * 	rs.next();  下一个
		 * 	rs.previous(); 上一个
		 * 获得指定列数据
		 * 	rs.getXxx(String) ,通过字段名称获得内容
		 * 	rs.getXxx(Integer) ,通过字段索引号获得内容
		 * 如:
		 * 	rs.getInt("cid");		  获得指定名称
		 * 	rs.getString("cname")    获得指定名称
		 * 	rs.getDouble(1)	                           获得第二列
		 * 
		 */
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","huangtc", "huangTC@123");
		Statement st = con.createStatement();
		
		String sql = "select * from category";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			
			//cid  cname
			// 1            家电
			// 2            服饰
			// 3            化妆品
			
			
			
			//getInt(int columnIndex)      int
			//getInt(String columnLabel)   int
			

			//根据索引获取数据
			
			//获取第一列的数据
			//int c1 = rs.getInt(1);
			//System.out.println("c1:"+c1);
			//c1:1
			//c1:2
			//c1:3
			//第二列数据为String类型，getInt返回的值为int类型，所以获取不到第二列的数据
			//int c2 = rs.getInt(2); 错误

			//根据索引获取数据
			int c2 = rs.getInt("cid");
			System.out.println("c2:"+c2);
			
			
			
			
			//String s1 = rs.getString(2);
			//System.out.println("s1:"+s1);
			//s1:家电
			//s1:服饰
			//s1:化妆品
			
			////获取第二列
			//String s2 = rs.getString("cname");
			//System.out.println("s2:"+s2);
			//s2:家电
			//s2:服饰
			//s2:化妆品
			
			
			
		}
		rs.close();
		st.close();
		con.close();
		
															
	}
}
