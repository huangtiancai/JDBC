/**
 * 
 */
package com.htc.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.htc.util.JdbcUtils;

/**  
* @ClassName PrepareDemo1
* @Description:使用PreparedStatement对象完成数据库的增删改查
* @author htc  
* @date 2019年6月2日下午4:12:04 
*/
public class PrepareDemo1 {
	/**
	 * function: demo1
	 * Description:向分类表中添加数据
	 * return:void
	 */
	@Test
	public void demo1(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得链接
			conn  = JdbcUtils.getConnection();
			//2.sql语句
			String sql = "insert into category cname values (?)";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.设置实际参数
			//void setXxx(int index, Xxx xx) 将指定参数设置指定类型的值
			//参数1：index 实际参数序列号，从1开始
			//参数2：xxx 实际参数值，XXX表示具体的类型
			//如void setString(int parameterIndex, String x);
			psmt.setString(1,"预处理");//把SQL语句中第1个位置的占位符?替换成实际参数 "预处理"
			//5.执行
			int r = psmt.executeUpdate();
			System.out.println(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//6.释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
			
	}
	/**
	 * function: demo2
	 * Description:修改操作
	 * return:void
	 */
	@Test
	public void demo2(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得链接
			conn  = JdbcUtils.getConnection();
			//2.sql语句
			String sql = "update category set cname = ? where cid = ? ";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.设置实际参数
			//void setXxx(int index, Xxx xx) 将指定参数设置指定类型的值
			//参数1：index 实际参数序列号，从1开始
			//参数2：xxx 实际参数值，XXX表示具体的类型
			//如void setString(int parameterIndex, String x);
			psmt.setString(1,"测试1");//把SQL语句中第1个位置的占位符?替换成实际参数 "预处理"
			psmt.setInt(2, 5);
			//5.执行
			int r = psmt.executeUpdate();
			System.out.println(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//6.释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
			
	}
	
	/**
	 * function: demo3
	 * Description:删除操作
	 * return:void
	 */
	@Test
	public void demo3(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得链接
			conn  = JdbcUtils.getConnection();
			//2.sql语句
			String sql = "delete from category where cid = ? ";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.设置实际参数
			//void setXxx(int index, Xxx xx) 将指定参数设置指定类型的值
			//参数1：index 实际参数序列号，从1开始
			//参数2：xxx 实际参数值，XXX表示具体的类型
			//如void setString(int parameterIndex, String x);
			psmt.setInt(1, 5);//把SQL语句中第1个位置的占位符?替换成实际参数 "预处理"
			//5.执行
			int r = psmt.executeUpdate();
			System.out.println(r);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//6.释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
			
	}
	
	/**
	 * function: demo4
	 * Description:查询所有数据
	 * return:void
	 */
	@Test
	public void demo4(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得链接
			conn  = JdbcUtils.getConnection();
			//2.sql语句
			String sql = "select * from category";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.执行
			rs = psmt.executeQuery();
			while(rs.next()){
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"@"+cname);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//5.释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
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
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得链接
			conn  = JdbcUtils.getConnection();
			//2.sql语句
			String sql = "select * from category where cid = ? ";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.设置实际参数
			psmt.setInt(1, 3);
			//5.执行
			rs = psmt.executeQuery();
			if(rs.next()){
				System.out.println("查询到的数据如下：");
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"@"+cname);
			}else{
				System.out.println("未查询到数据");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//6.释放资源
			JdbcUtils.closeResource(conn, psmt, rs);
		}
			
	}
	
}
