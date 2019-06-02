/**
 * 
 */
package com.htc.druid;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;


/**  
* @ClassName:DruidDemo2
* @Description:使用配置文件配置druid  --->  DruidUtils
* @author:htc  
* @date:2019年6月3日 上午12:02:43
*/
public class DruidDemo2 {
	@Test
	public void demo1() throws Exception{
		//1.获得连接池
		//1.1加载properties文件，获得Properties对象
		InputStream is = DruidDemo2.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties props = new Properties();
		props.load(is);
		
		//1.2获得连接池
		DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
		
		//2.获得连接
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
