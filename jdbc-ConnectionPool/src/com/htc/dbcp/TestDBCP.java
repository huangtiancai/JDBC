/**
 * 
 */
package com.htc.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**  
* @ClassName:TestDBCP
* @Description:测试类
* @author:htc  
* @date:2019年6月2日 下午11:34:04
*/
public class TestDBCP {
	@Test
	public void demo1(){
		try {
			Connection conn = DBCPUtils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
