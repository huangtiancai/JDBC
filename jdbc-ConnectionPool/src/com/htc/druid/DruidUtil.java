/**
 * 
 */
package com.htc.druid;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

/**  
* @ClassName:DruidUtil
* @Description:DruidUtil连接池--工具类
* @author:htc  
* @date:2019年6月3日 上午12:33:34
*/
public class DruidUtil {
	//模式同DruidDemo1
	//1.获得连接池
	private static DruidDataSource dataSource = new DruidDataSource();
	
	//2.设置参数
	static{
		try {
			//Properties props = new Properties();
			//InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");	
			//props.load(is);
			
			Properties props = new Properties();
			Reader reader = new FileReader(new File("src/druid.properties"));
			props.load(reader);
			
			//为数据源的属性设置参数
			//设置驱动字符串
			dataSource.setDriverClassName(props.getProperty("driverClassName"));
			//设置连接字符串
			dataSource.setUrl(props.getProperty("url"));
			//设置用户名
			dataSource.setUsername(props.getProperty("username"));
			//设置密码
			dataSource.setPassword(props.getProperty("password"));
			dataSource.setMaxActive(Integer.parseInt(props.getProperty("maxActive")));
			dataSource.setInitialSize(Integer.parseInt(props.getProperty("initialSize")));
			dataSource.setMaxWait(Long.parseLong(props.getProperty("maxWait")));
			dataSource.setMinIdle(Integer.parseInt(props.getProperty("minIdle")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//获得数据源(连接池)
	public static DruidDataSource getDruidDataSource(){
		return dataSource;	
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException{
		//将从连接池中获得连接
		return dataSource.getConnection();
	}
	
	
	
	
	
}
