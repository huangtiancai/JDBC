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
* @Description:JDBC API���--���������
* @author htc  
* @date 2019��6��1������4:42:22 
*/
public class Demo5 {
	/**
	 * Title: demo1
	 * Description: ���Խ��������
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * ResultSetʵ���Ͼ���һ�Ŷ�ά�ı�����ǿ��Ե�����boolean next()����ָ��ĳ�м�¼
		 * ����һ�ε���next()����ʱ����ָ���һ�м�¼��λ��
		 * ��ʱ�Ϳ���ʹ��ResultSet�ṩ��getXXX(int col)����(������1��ʼ)����ȡָ���е����ݣ�
		 * 
		 * 
		 * �ƶ��α�
		 * 	rs.next();  ��һ��
		 * 	rs.previous(); ��һ��
		 * ���ָ��������
		 * 	rs.getXxx(String) ,ͨ���ֶ����ƻ������
		 * 	rs.getXxx(Integer) ,ͨ���ֶ������Ż������
		 * ��:
		 * 	rs.getInt("cid");		  ���ָ������
		 * 	rs.getString("cname")    ���ָ������
		 * 	rs.getDouble(1)	                           ��õڶ���
		 * 
		 */
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","huangtc", "huangTC@123");
		Statement st = con.createStatement();
		
		String sql = "select * from category";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()){
			
			//cid  cname
			// 1            �ҵ�
			// 2            ����
			// 3            ��ױƷ
			
			
			
			//getInt(int columnIndex)      int
			//getInt(String columnLabel)   int
			

			//����������ȡ����
			
			//��ȡ��һ�е�����
			//int c1 = rs.getInt(1);
			//System.out.println("c1:"+c1);
			//c1:1
			//c1:2
			//c1:3
			//�ڶ�������ΪString���ͣ�getInt���ص�ֵΪint���ͣ����Ի�ȡ�����ڶ��е�����
			//int c2 = rs.getInt(2); ����

			//����������ȡ����
			int c2 = rs.getInt("cid");
			System.out.println("c2:"+c2);
			
			
			
			
			//String s1 = rs.getString(2);
			//System.out.println("s1:"+s1);
			//s1:�ҵ�
			//s1:����
			//s1:��ױƷ
			
			////��ȡ�ڶ���
			//String s2 = rs.getString("cname");
			//System.out.println("s2:"+s2);
			//s2:�ҵ�
			//s2:����
			//s2:��ױƷ
			
			
			
		}
		rs.close();
		st.close();
		con.close();
		
															
	}
}
