/**
 * 
 */
package com.htc.demo;

import org.junit.Test;

/**  
* @ClassName Demo2
* @Description:JDBC API���--ע������
* @author htc  
* @date 2019��6��1������3:05:49 
*/
public class Demo2 {
	/**
	 * Title: demo1
	 * Description: ����ע������
	 * @throws Exception 
	 */
	@Test
	public void demo1() throws Exception{
		//1.JDBC�淶�涨�������Ҫ�������ݿ⣬�����ṩ�����ӿڵ�ʵ����
		/**
		 * 1.JDBC�淶�涨�������Ҫ�������ݿ⣬�����ṩ�����ӿڵ�ʵ����
		 *   �����ӿ�:java.sql.Driver 			      		-package java.sql;
		 *   ÿһ�����ݿ��ṩ����jar��ʵ�ָýӿ�
		 * 2.MySQL�������ṩʵ���ࣺcom.mysql.jdbc.Driver     -package com.mysql.jdbc;
		 *   Դ�룺public class Driver extends NonRegisteringDriver implements java.sql.Driver{}
		 * 3.JDBC�淶�ṩ��ע���ʵ�ַ�ʽ
		 *   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 *   ���������ѭ������䣬Java������ mysqlʵ�������(ֱ�ӹ�ϵ)��֮���л����ݿ⽫���ܽ��С�
		 *   ����ͨ����ѯcom.mysql.jdbc.DriverԴ�룬���Ƿ���Driver�ࡰ���������Լ�����ע��:
		 *   DriverManager.registerDriver(new Driver());
		 *   �ܽ᲻��:(1)Ӳ����,�����ں��ڵ�ά���͸���
    	 *		   (2)�����౻����������
    	 *	   ϣ���ṩ����ʱ��ֻҪ�л������������Ϳ����л�ʹ�����ݿ�
		 *	4.ͨ��ע������ʹ�ñ�׼д��
		 *	Class.forName("com.mysql.jdbc.Driver");
		 *	1) ʹ�÷���ķ�ʽ����ָ������
		 *	2) ������ص������ַ���(���ȫ�޶�����)����,���ݾͿ��Դ�ŵ������ļ��У�ͨ���޸������ļ������л����ݿ�
		 *	3) һ���౻���ص��ڴ棬��̬����齫ִ�У�static{ ... }	
		 *	
		 */
		//���ۣ�ע������
		Class.forName("com.mysql.jdbc.Driver");
		
		//ע������--ע������
		/**
		 * �ֶ�ע������������ע���˼��Σ�(2��)
		 * DriverManager�����࣬�ṩע�������ķ��� registerDriver()
		 * DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		 * ��һ�Σ�
		 * 		DriverManager.registerDriver(new Driver());
		 * 		new Driver() ʱ��Driver����أ���̬�����ִ�У�ע��һ��
		 * �ڶ��Σ��ֶ�ע��
		 * 
		 */
		
	}
}
