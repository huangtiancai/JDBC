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
* @Description:JDBC增删改查操作
* @author htc  
* @date 2019年6月1日 下午11:44:09
*/
public class CRUDDemo {
	/**
	 * function: demo1
	 * Description:获得连接 
	 * return:void
	 */
	@Test
	public void demo1(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//获得连接
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
	}
	/**
	 * function: demo2
	 * Description:新增操作
	 * return:void
	 */
	@Test
	public void demo2(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.获得连接
			conn = JdbcUtils.getConnection();
			//2.获得语句执行者
			st = conn.createStatement();
			//3.执行sql语句
			int r = st.executeUpdate("insert into category (cname) values ('测试')");
			//4.打印结果
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo3
	 * Description:修改操作
	 * return:void
	 */
	@Test
	public void demo3(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.获得连接
			conn = JdbcUtils.getConnection();
			//2.获得语句执行者
			st = conn.createStatement();
			//3.执行sql语句
			int r = st.executeUpdate("update category set cname = '测试2' where cid = 4");
			//4.打印结果
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo4
	 * Description:删除操作
	 * return:void
	 */
	@Test
	public void demo4(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.获得连接
			conn = JdbcUtils.getConnection();
			//2.获得语句执行者
			st = conn.createStatement();
			//3.执行sql语句
			int r = st.executeUpdate("delete from category where cid in(5,6)");
			//4.打印结果
			System.out.println(r);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
	
	/**
	 * function: demo5
	 * Description:根据id查询详情 	
	 * return:void
	 */
	@Test
	public void demo5(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs =null;
		
		try {
			//1.获得连接
			conn = JdbcUtils.getConnection();
			//2.获得语句执行者
			st = conn.createStatement();
			//3.执行sql语句
			rs = st.executeQuery("select * from category where cid =2");
			//4.处理结果
			if(rs.next()){
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"@"+cname);
			}else{
				System.out.println("没有查到数据！");
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.释放资源
			JdbcUtils.closeResource(conn, st, rs);
		}
		
		
	}
}
