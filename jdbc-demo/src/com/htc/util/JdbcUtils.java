/**
 * 
 */
package com.htc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * “获得数据库连接”操作，将在以后的增删改查所有功能中都存在，可以封装工具类JDBCUtils。提供获取连接对象的方法，从而达到代码的重复利用。
 */

/**  
* @ClassName JdbcUtils
* @Description:JDBC工具类	
* @author htc  
* @date 2019年6月1日 下午11:20:11
*/
public class JdbcUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String user = "huangtc";
	private static String password = "huangTC@123";
	//Class.forName必须在放在静态代码块或者方法中
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * function: getConnection
	 * Description:获得连接
	 * return:Connection
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		//获得链接
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	} 
	/**
	 * function: closeResource
	 * Description:释放资源
	 * return:void
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeResource(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
