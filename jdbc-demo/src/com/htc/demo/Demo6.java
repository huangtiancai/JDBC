/**
 * 
 */
package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**  
* @ClassName Demo6
* @Description:JDBC API详解--释放资源
* @author htc  
* @date 2019年6月1日 下午10:59:42
*/
public class Demo6 {
	/**
	 * Title: demo1
	 * Description:测试释放资源
	 */
	@Test
	public void demo1(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "huangtc", "huangTC@123");
			st=conn.createStatement();
			rs = st.executeQuery("select * from category");
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//关闭的顺序是先得到的后关闭，后得到的先关闭。
			//关闭结果集
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//关闭执行平台
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//关闭连接
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
		
	}
}
