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
		 * 	rs.getInt("cid");		  �����������(�����������ֶλ�ȡ)
		 * 	rs.getString("cname")    ����ַ���
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
			
			//����������ȡ��������
			
			//��ȡ��һ�е�����
			//int c1 = rs.getInt(1);
			//System.out.println(c1);
			//1
			//2
			//3
			//�ڶ�������ΪString���ͣ�getInt���ص�ֵΪint���ͣ����Ի�ȡ�����ڶ��е�����
			//int c2 = rs.getInt(2); ����

			//�����ֶλ�ȡ��������
			//int c3 = rs.getInt("cid");
			//System.out.println(c3);
			//ͬ���õ�getInt��ȡ����cname�ֶ�ֵ
					
			
			//����������ȡ�ַ���
			//��ȡ��һ��
			//String s1 = rs.getString(2);
			//System.out.println(s1);
			//�ҵ�
			//����
			//��ױƷ
			//��ȡ�ڶ���(���ص����Ϳɵ����ַ���)
			//String s2 = rs.getString(1);
			//System.out.println(s2);
			
			//����������ȡ�ַ���
			//��ȡcname�ֶ�
			//String s3 = rs.getString("cname");
			//System.out.println(s3);
			//�ҵ�
			//����
			//��ױƷ
			//��ȡcid�ֶ�
			String s4 = rs.getString("cid");
			System.out.println(s4);
			
			
			
			
			
		}
		rs.close();
		st.close();
		con.close();
		
															
	}
}
