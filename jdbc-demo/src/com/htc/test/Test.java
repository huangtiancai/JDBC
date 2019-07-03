/**
 * 
 */
package com.htc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.htc.bean.Owners;
import com.htc.dao.OwnersDao;
import com.htc.util.JdbcUtils;
import com.htc.util.JdbcUtils2;

/**  
* @ClassName:Test
* @Description:
* @author:htc  
* @date:2019年7月2日 上午12:51:19
*/

public class Test {
	Connection conn = null;
	Statement st = null;
	ResultSet rs =null;
	
	@org.junit.Test
	public void testJDBCMySQL(){
		try {
			Connection conn = JdbcUtils.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
		}
		
	}
	
	@org.junit.Test
	public void testJDBCOracle(){
		try {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils2.closeResource(conn, st, rs);
		}
	}
	
	@org.junit.Test
	public void testOwnersAdd(){
		Owners owners = new Owners();
		owners.setId(11L);
		owners.setName("张三丰");
		owners.setAddressid(1L);
		owners.setHousenumber("202");
		owners.setWatermeter("33448");
		owners.setAdddate(Date.valueOf("2019-07-01"));
		owners.setOwnertypeid(1L);
		
		OwnersDao dao = new OwnersDao();
		dao.add(owners);
		
		
		
	}
}
