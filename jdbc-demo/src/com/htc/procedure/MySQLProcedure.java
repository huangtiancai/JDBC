/**
 * 
 */
package com.htc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
	
	/**
	 * function: avgScore
	 * Description:根据学生编号查询姓名
	 * return:void
	 */
	@Test
	public void findScoreById(){

		try {
			//1.获取连接对象
			conn = JdbcUtils.getConnection();
			System.out.println("打开连接池");
			//2.获取操作存储过程的对象                                               
			CallableStatement cs = conn.prepareCall("{call Proc_Student(?,?)}");//不管是输入还是输出，都可以用 ? 来代替这个参数
			/**
			 * 设置输入参数：第一个参数是位置下标
			 * 设置输出参数：第二个参数是存储过程中，那个输出参数的类型
			 * 		此方法就是注册输出参数的类型:因为是注册输出参数的是mysql中的操作，注册的输出参数也必须是mysql中的数据类型
			 * 通过 java.sql.Types.XXX：就可以获得其中的sql的类型
			 */
			//3.注入输入参数
			cs.setString(1, "101");
			//4.注册输出参数
			cs.registerOutParameter(2, java.sql.Types.VARCHAR); //out参数是varchar
			
			//发送参数：结果并不在resultSet中
			//这里并不需要rs结果集：因为我们是带返回参数的存储过程，并没有查询结果集
			//5.执行语句
			cs.execute();
			
			//结果在输出参数中，我们应该在"输出参数"中查看结果
			//通过getXXX方法；但是这里的getXXX方法，和resultSet中的getXXX方法不同
			//这里的getXXX方法是callableStatement提供的，专门针对存储过程的out参数的, 而resultSet中的getXXX方法是获取列的值的
			//6.获取结果
			String sname =  cs.getString(2);
			System.out.println(sname);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
			System.out.println("关闭连接池");
		}	
	}
	
	/**
	 * function: findAll
	 * Description:通过存储过程查询数据
	 * return:void
	 */
	@Test
	public void findAllProduct(){

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
	
	@Test
	public void findAllProductById(){

		try {
			conn = JdbcUtils.getConnection();
			System.out.println("打开连接池");

			CallableStatement cs = conn.prepareCall("{CALL findAllProductById(?,?)}");
			cs.setInt(1, 5);
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);;
			cs.execute();
			System.out.println(cs.getString(2));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
			System.out.println("关闭连接池");
		}	
	}
	
	
	
}
