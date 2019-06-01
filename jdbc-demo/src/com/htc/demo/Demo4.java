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
* @Description:JDBC API���--������ִ����
* @author htc  
* @date 2019��6��1������4:04:24 
*/
public class Demo4 {
	/**
	 * Title: demo1
	 * Description: ���Ի�����ִ����
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * ������ִ��ƽ̨
		 * ͨ��Connection�Ϳ��Ի����Բ�ͬ���ݿ�sql����ִ�ж��󣬳���  createStatement()
		 * ͨ��Statement�������ִ�������SQL���
		 * int executeUpdate(String sql);
			 * -st.executeUpdate(sql) 
			 * -ִ��DML���(��ɾ�� insert��delete��update) ������Ϊ���ͣ���ʾӰ������ 
		 * ResultSet executeQuery(String sql); 
			 * -st.executeQuery(sql)  
			 * -ִ��DQL���(��ѯ select) ������ResultSet���������(��ѯ��������)
		 * Boolean execute(String sql);
			 * -st.execute(sql)
			 * -ִ������sql��䡣����Ϊboolean
				 * true����ʾִ��DQL��䣬��Ҫͨ��ts.getResultSet() ��ò�ѯ���
				 * false����ʾDML��䣬��Ҫͨ�� ts.getUpdateCount() ���Ӱ��������
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
