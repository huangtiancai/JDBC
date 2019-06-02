/**
 * 
 */
package com.htc.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

/**  
* @ClassName:TestC3P0
* @Description:测试类
* @author:htc  
* @date:2019年6月2日 下午11:38:19
*/
public class TestC3P0 {
	@Test
	public void demo1(){
		try {
			Connection conn = C3P0Utils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
