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
* @Description:JDBC API���--�ͷ���Դ
* @author htc  
* @date 2019��6��1�� ����10:59:42
*/
public class Demo6 {
	/**
	 * Title: demo1
	 * Description:�����ͷ���Դ
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
			//�رյ�˳�����ȵõ��ĺ�رգ���õ����ȹرա�
			//�رս����
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//�ر�ִ��ƽ̨
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//�ر�����
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
