/**
 * 
 */
package com.htc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.htc.bean.Product;
import com.htc.util.JdbcUtils;


//
/**
 * 
 * 使用Junit单元测试时，要注意以下几个地方： 
	1.在测试方法上要有@Test注解 
	2.测试方法不能用static静态修饰 
	3.测试方法不能有返回值 
	4.测试方法不能有参数 
	5.如果测试类继承基础测试类，那么这个类中的所有测试方法都要符合以上四条规定
	如：这个会报错
 * @Test
	public List<Product> findAllProduct(){
	}
 */


/**  
* @ClassName MySQLProcedure
* @Description:MySqL存储过程调用
* @author htc  
* @date 2019年7月3日上午9:42:42 
*/
public class MySQLProcedure {
	Connection conn = null;
	Statement st = null;
	ResultSet rs =null;
	
	/**s
	 * function: findAll
	 * Description:通过存储过程查询数据
	 * return:void
	 */
	@Test
	public void findAll(){

		try {
			conn = JdbcUtils.getConnection();
			System.out.println("打开连接池");
			//调用存储过程
			CallableStatement cs = conn.prepareCall("{CALL findAllProduct()}");
			//执行查询操作，并获取结果集
			ResultSet rs = cs.executeQuery();
			while(rs.next()){
				int pid  = rs.getInt("pid");
				String pname = rs.getString("pname");
				String price = rs.getString("price");
				System.out.println("pid:"+pid+" pname:"+price+" price:"+price);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
			System.out.println("关闭连接池");
		}	
	}
	
}
