/**
 * 
 */
package com.htc.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
* @ClassName C3P0Demo12
* @Description:C3P0的基本配置
* @author htc  
* @date 2019年6月2日 下午9:00:32
*/
public class C3P0Demo1 {
	/**
	 * function: demo1
	 * Description:
	 * return:void
	 */
	@Test
	public void demo1(){
		
		try {
			//1.获得连接池（数据源）-创建连接池对象
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			//2.为了让链接池和数据库链接   必须设置4大参数
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
			dataSource.setUser("huangtc");
			dataSource.setPassword("huangTC@123");
			//3.设置其它项
			//初始化连接池中连接的个数
			dataSource.setInitialPoolSize(5);
			//最小连接数
			dataSource.setMinPoolSize(2);
			//最大连接数
			dataSource.setMaxPoolSize(50);
			//最大空闲数
			dataSource.setMaxIdleTime(10);
			//每次增长个数
			dataSource.setAcquireIncrement(2);
			//4.获得连接
			Connection conn = dataSource.getConnection();
			System.out.println("获得的连接："+conn);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
