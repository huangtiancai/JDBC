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
* @ClassName PrepareDemo3
* @Description:使用PreparedStatement对象解决SQL注入问题
* @author htc  
* @date 2019年6月2日下午4:51:05 
*/
public class PrepareDemo3 {
	/**
	 * function: demo1
	 * Description:模拟用户登录
	 * return:void
	 */
	@Test
	public void demo1(){
		String username = "jack";//username和password存储动态传入的字符串
		String password = "1234";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//1.获得连接
			conn = JdbcUtils.getConnection();
			//2.准备sql语句
			String sql = "select * from user where username = ? and password = ?";
			//3.获得预处理对象
			psmt = conn.prepareStatement(sql);
			//4.设置实际参数
			psmt.setString(1, username);
			psmt.setString(2, password);
			//5.执行sql语句（注意没有sql语句）
			rs = psmt.executeQuery();
			//6.判断
			if(rs.next()){
				System.out.println("登录成功！");
			}else{
				System.out.println("用户名或者密码错误！");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtils.closeResource(conn, psmt, rs);
		}
		
		
		
	}
}
