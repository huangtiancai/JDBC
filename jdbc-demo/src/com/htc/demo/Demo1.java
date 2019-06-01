package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


/**
 * JDBC�������ݿⲽ�裺
 * 1.���jar��  build path��
 * 2.��������
 * 3.��ȡ���Ӷ���
 * 4.��ȡ���������󣺵�һ�֣�Statement st = con.createStatement();
 * 5.ִ��sql���		
 * 		executeUpdate(sql):ִ��DML��䣨insert/update/delete��������Ϊ���Σ���ʾӰ������
 * 		executeQuery(sql):ִ��DQL���  :����ResultSet���������(��ѯ��������)
 * 6.�����صĽ��
 * 7.�ر������ԴConnection,Statement,ResultSet��
 */
	  
	/**    
	* @ClassName Demo1
	* @Description:
	* @author htc  
	* @date 2019��6��1������11:01:46
	 */
	public class Demo1 {
		/**
		 * Title: demo1
		 * Description:
		 */
		@Test
		public void demo1(){
			//��ѯ���еķ�����Ϣ
		    //ע�⣺ʹ��JDBC�淶�����ö��� java.sql���µ�����
			//ע�⣺com.mysql.jdbc.Connection ��mysql�Լ��Ľӿ�
			//java.sql.Connection ����һ�������Ľӿڰ�����mysql��֧��oracle,sqlserver �Ժܶ����ݿ�һ��������API!
			Connection con = null;
			Statement st = null;
			
			//2.ע������
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("���ݿ��������سɹ�!");
				//junit����
				//3.���������ݿ������
				//con = DriverManager.getConnection(url, user, password);
//				url: jdbc:mysql://localhost:3306/���ݿ���
				//JDBC�涨url�ĸ�ʽ����������ɣ�ÿ�������м�ʹ��ð�ŷָ�
				//��һ������jdbc�����ǹ̶��ģ�
				//�ڶ����������ݿ��������ƣ���ô����mysql���ݿ⣬�ڶ����ֵ�Ȼ��mysql��
				//���������������ݿ⳧�̹涨��,mysql�ĵ������ֱַ������ݿ��������IP��ַ��localhost�����˿ںţ�3306�����Լ�database�������
				
//				user(�û���):root
//				password(����)��huangTC@123
				//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "huangtc","huangTC@123");
				con = DriverManager.getConnection("jdbc:mysql://149.129.77.73:3306/mysql", "huangtc","huangTC@123");
				System.out.println("���ӳɹ�����ȡ���Ӷ���"+con);
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
						
	}
		
}
