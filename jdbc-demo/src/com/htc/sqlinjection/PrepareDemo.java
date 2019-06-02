/**
 * 
 */
package com.htc.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import com.htc.util.JdbcUtils;

/**
 * SQL注入：用户输入的内容作为了SQL语句语法的一部分，改变了原有SQL真正的意义。
 * 解决：使用PreparedStatement来解决对应的问题
 */

/**  
* @ClassName PrepareDemo
* @Description:JDBC 预处理对象--SQL注入问题
* @author htc  
* @date 2019年6月2日下午2:51:03 
*/
public class PrepareDemo {
	/** 
	 * function: demo1
	 * Description:SQL语句语句拼接+模拟用户登录
	 * return:void
	 */
	@Test
	public void demo1(){
		String username = "jack";//username和password存储动态传入的字符串
		String password = "1234";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			//拼接SQL语句时，对单引号的处理:
			//String sql = "select * from user where username = 'username' and password = '1234'";
			//不需要动态传参数的时候，语句为:select * from user where username = 'jack' and password = '1234';
			//拼接SQL语句的步骤：
			//1.select * from user where username = '' and password = '';			去除具体参数
			//2.select * from user where username = '""' and password = '""';		在' ' 中添加 " "
			//3.select * from user where username = '"++"' and password = '"++"';	在 " " 中添加 + + ,两个+号
			//4.select * from user where username = '"+username+"' and password = '"+password+"';	在 ++ 中添加要动态传入的字符串
			//5.最后把语句 复制到 String sql = " "; 中的双引号中
			//即:String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
		
			rs = st.executeQuery("select * from user where username = '"+username+"' and password = '"+password+"'");
			if(rs.next()){
				System.out.println("用户登录！");
			}else{
				System.out.println("用户不能登录！");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			JdbcUtils.closeResource(conn, st, rs);
		}
	
	}
	
	/**
	 * function: demo2
	 * Description:演示sql注入
	 * return:void
	 */
	@Test
	public void demo2(){
		//模拟用户输入用户输入用户名和密码:
		//用户名: ' or 1=1 --  
		//密     码:   
		String username = "'or 1=1 --  ";
		String password = " ";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			//如若没有做特殊处理,而只是一条带条件的查询语句如:
			String sql = "select * from user where username = '"+username+"' and password = '"+password+"'";
			rs = st.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("用户登录！");
			}else{
				System.out.println("用户不能登录！");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally{
			JdbcUtils.closeResource(conn, st, rs);
		}
	
	}
	
	
	
	
	
	
	
}
