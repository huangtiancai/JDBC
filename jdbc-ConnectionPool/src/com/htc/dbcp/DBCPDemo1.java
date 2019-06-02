/**
 * 
 */
package com.htc.dbcp;
import java.sql.Connection;
import java.sql.SQLException;

//DBCP也是一个开源的连接池，是Apache Common成员之一，在企业开发中也比较常见，tomcat内置的连接池。
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

/**  
* @ClassName:DBCPDemo1
* @Description:DBCP的基本配置
* @author:htc  
* @date:2019年6月2日 下午10:48:04
*/
public class DBCPDemo1 {
	@Test
	public void demo1() throws SQLException{
		//1.获得连接池
		BasicDataSource dataSource = new BasicDataSource();
		//2.基本参数
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
		dataSource.setUsername("huangtc");
		dataSource.setPassword("huangTC@123");
		//3.其它参数
		//初始化连接池中连个的个数
		dataSource.setInitialSize(5);
		//最大活动数
		dataSource.setMaxActive(10);
		
		//4.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
	}
	
}
