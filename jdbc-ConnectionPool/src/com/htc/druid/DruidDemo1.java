/**
 * 
 */
package com.htc.druid;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;

/**  
* @ClassName:DruidDemo1
* @Description:Druid的基本配置    ----> DruidUtil
* @author:htc  
* @date:2019年6月2日 下午11:52:19
*/
public class DruidDemo1 {
	@Test
	public void demo1() throws SQLException{
		//1.获得连接池
		DruidDataSource dataSource = new DruidDataSource();
		//2.基本参数（注意：Druid的基本参数和DBCP的基本参数相同）
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("huangtc");
		dataSource.setPassword("huangTC@123");
		//3.其它参数
		//初始化连接池中连个的个数
		dataSource.setInitialSize(5);
		//最大活动数
		dataSource.setMaxActive(10);
		//超时等待时
		dataSource.setMaxWait(60000);
		//最小空闲连接
		dataSource.setMinIdle(5);
		
		//4.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
}
