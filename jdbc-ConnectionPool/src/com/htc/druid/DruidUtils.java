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

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**  
* @ClassName:DruidUtils
* @Description:DruidUtils连接池--工具类
* @author:htc  
* @date:2019年6月3日 上午12:13:13
*/
public class DruidUtils {
	private static DataSource dataSource;
	
	static{
		try {
			//Properties props = new Properties();
			//InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
			//props.load(is);
			
			Properties props = new Properties();
			Reader reader = new FileReader(new File("src/druid.properties"));
			props.load(reader);
			
			dataSource = DruidDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获得数据源(连接池)
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	//获得连接
	public static Connection getConnection() throws SQLException{
		//将从连接池中获得连接
		return dataSource.getConnection();
	}
	
	
}
