/**
 * 
 */
package com.htc.dbcp;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

/**  
* @ClassName:DBCPDemo2
* @Description:使用配置文件配置dbcp
* @author:htc  
* @date:2019年6月2日 下午11:01:10
*/
public class DBCPDemo2 {
	@Test
	public void demo1() throws Exception{
		//1.获得连接池
		//1.1加载properties文件，获得Properties对象
		InputStream is = DBCPDemo2.class.getClassLoader().getResourceAsStream("dbcp.properties");
		Properties props = new Properties();
		props.load(is);
		
		//1.2获得连接池
		DataSource dataSource = BasicDataSourceFactory.createDataSource(props);
		
		//2.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
		
		
	}
}
