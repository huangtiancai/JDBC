/**
 * 
 */
package com.htc.DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.htc.c3p0.C3P0Utils;

/**  
* @ClassName DBUtilsDemo1
* @Description:QueryRunner（核心工具类 提供了对数据库的操作）实现添加、更新、删除操作
* @author htc  
* @date 2019年6月6日上午11:21:32 
*/
public class DBUtilsDemo1 {
	/**
	 * function: insert
	 * Description:添加
	 * return:void
	 * @throws SQLException 
	 */
	@Test
	public void insert() throws SQLException{
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.准备sql语句
		String sql = "insert into product(pid,pname,price,category_id)values(?,?,?,?)";		
		Object[] params = {11,"测试","100","c009"};
		//3.执行update方法
		int r = queryRunner.update(sql, params);
		
		System.out.println(r);	
	}
	
	/**
	 * function: update
	 * Description:更新
	 * return:void
	 */
	@Test
	public void update() throws SQLException{
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.准备sql语句
		//String sql = "insert into product(pid,pname,price,category_id)values(?,?,?,?)";
		String sql = "update product set pname = ?,price = ?,category_id = ? where pid = ?";
		Object[] params = {"测试更新","200","c010",11};
		//3.执行update方法
		int r = queryRunner.update(sql, params);
		
		System.out.println(r);	
	}
	/**
	 * function: delete
	 * Description:删除
	 * return:void
	 */
	@Test
	public void delete() throws SQLException{
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.准备sql语句
		//String sql = "update product set pname = ?,price = ?,category_id = ? where pid = ?";
		String sql = "delete from product where pid = ?";
		Object[] params = {11};
		//3.执行update方法
		int r = queryRunner.update(sql, params);
		
		System.out.println(r);	
	}
	
}
