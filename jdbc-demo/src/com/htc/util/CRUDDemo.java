/**
 * 
 */
package com.htc.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**  
* @ClassName CRUDDemo
* @Description:JDBC��ɾ�Ĳ����
* @author htc  
* @date 2019��6��1�� ����11:44:09
*/
public class CRUDDemo {
	/**
	 * function: demo1
	 * Description:������� 
	 * return:void
	 */
	@Test
	public void demo1(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//�������
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	/**
	 * function: demo2
	 * Description:��������
	 * return:void
	 */
	@Test
	public void demo2(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.�������
			conn = JdbcUtils.getConnection();
			//2.������ִ����
			st = conn.createStatement();
			//3.ִ��sql���
			int r = st.executeUpdate("insert into category (cname) values ('����')");
			//4.��ӡ���
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo3
	 * Description:�޸Ĳ���
	 * return:void
	 */
	@Test
	public void demo3(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.�������
			conn = JdbcUtils.getConnection();
			//2.������ִ����
			st = conn.createStatement();
			//3.ִ��sql���
			int r = st.executeUpdate("update category set cname = '����2' where cid = 4");
			//4.��ӡ���
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo4
	 * Description:ɾ������
	 * return:void
	 */
	@Test
	public void demo4(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.�������
			conn = JdbcUtils.getConnection();
			//2.������ִ����
			st = conn.createStatement();
			//3.ִ��sql���
			int r = st.executeUpdate("delete from category where cid in(5,6)");
			//4.��ӡ���
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo5
	 * Description:����id��ѯ���� 	
	 * return:void
	 */
	@Test
	public void demo5(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.�������
			conn = JdbcUtils.getConnection();
			//2.������ִ����
			st = conn.createStatement();
			//3.ִ��sql���
			rs = st.executeQuery("select * from category where cid =2");
			//4.������
			if(rs.next()){
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"@"+cname);
			}else{
				System.out.println("û�в鵽���ݣ�");
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.�ͷ���Դ
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
}
