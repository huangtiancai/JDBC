/**
 * 
 */
package com.htc.demo;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**  
* @ClassName Demo3
* @Description:JDBC API���--��ȡ����
* @author htc  
* @date 2019��6��1������3:45:08 
*/
public class Demo3 {
	/**
	 * 
	 * Title: demo1
	 * Description:���Ի�ȡ����
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		/**
		 * �������
		 * DBC�ṩ������ DriverManager(����������)
		 * getConnection() ͨ�����þ��������ͬ�����ݿⴴ���µ�����
		 * 
		 * DriverManager.getConnection(url, user, password);
		 * ����1 url :���ݷ���·��
		 * ����2 user: ���ݿ��û���
		 * ����3 password:���ݿ�����
		 *   url����·��:
		 *   ��ʽ  jdbc:mysql://ip��ַ:�˿ں�/���ݿ�����
		 *   �磺  jdbc:myql://localhost:3306/mydb  
		 *   	jdbc:mysql://149.129.77.73:3306/mysql
		 *      
		 *      jdbc�̶�
		 *      mysql ��ʾmysql���ݿ⣬һ�������������ݿⲻͬ����ͬ
		 *      localhost:3306 ��ʾ���ݿ�����ַ��ΪĬ��ֵ
		 *      mydb:��ʾ�������� 
		 * 
		 */
		Class.forName("com.mysql.jdbc.Driver");
//		DriverManager.getConnection(String url,String user,String password);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mysql","huangtc", "huangTC@123");
		//Connection con = DriverManager.getConnection("jdbc:mysql://149.129.77.73:3306/mysql","huangtc", "huangTC@123");
		System.out.println("���ӳɹ�����ȡ���Ӷ���"+con);

		
	}
}
