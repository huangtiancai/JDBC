/**
 * 
 */
package com.htc.druid;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;


/**  
* @ClassName:TestDruid
* @Description:测试类
* @author:htc  
* @date:2019年6月3日 上午12:24:32
*/
public class TestDruid {
	/**
	 * function: demo1
	 * Description:测试DruidUtils工具类（连接池）
	 * return:void
	 */
	@Test
	public void demo1(){
		try {
			Connection conn = DruidUtils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * function: demo2
	 * Description:测试DruidUtil工具类（连接池）
	 * return:void
	 */
	@Test
	public void demo2(){
		try {
			Connection conn = DruidUtil.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
