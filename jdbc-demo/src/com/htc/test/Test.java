/**
 * 
 */
package com.htc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import com.htc.bean.Owners;
import com.htc.dao.OwnersDao;
import com.htc.util.JdbcUtils2;

/**  
* @ClassName:Test
* @Description:
* @author:htc  
* @date:2019年7月2日 上午12:51:19
*/

public class Test {
	@org.junit.Test
	public void testJDBCOracle(){
		try {
			Connection conn = JdbcUtils2.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
