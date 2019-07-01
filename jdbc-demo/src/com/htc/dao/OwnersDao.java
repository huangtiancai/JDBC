/**
 * 
 */
package com.htc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.htc.bean.Owners;
import com.htc.util.JdbcUtils2;

/**  
* @ClassName:OwnersDao
* @Description:业主数据访问类
* @author:htc  
* @date:2019年7月2日 上午1:06:35
*/
public class OwnersDao {
	/**
	 * function: add
	 * Description:新增业主
	 * return:void
	 */
	public void add(Owners owners){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils2.getConnection();
			String sql = "insert into T_OWNERS values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setLong(1, owners.getId());
			psmt.setString(2, owners.getName());
			psmt.setLong(3, owners.getAddressid());
			psmt.setString(4, owners.getHousenumber());
			psmt.setString(5, owners.getWatermeter());
			psmt.setDate(6, owners.getAdddate());
			psmt.setLong(7, owners.getOwnertypeid());
			
			psmt.execute();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils2.closeResource(conn, psmt, rs);
		}
		
	}
}
