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
 * ��������ݿ����ӡ������������Ժ����ɾ�Ĳ����й����ж����ڣ����Է�װ������JDBCUtils���ṩ��ȡ���Ӷ���ķ������Ӷ��ﵽ������ظ����á�
 */

/**  
* @ClassName JdbcUtils
* @Description:JDBC������	
* @author htc  
* @date 2019��6��1�� ����11:20:11
*/
public class JdbcUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String user = "huangtc";
	private static String password = "huangTC@123";
	//Class.forName�����ڷ��ھ�̬�������߷�����
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
	 * Description:�������
	 * return:Connection
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException{
		//�������
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	} 
	/**
	 * function: closeResource
	 * Description:�ͷ���Դ
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
