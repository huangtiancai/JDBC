/**
 * 
 */
package com.htc.dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**  
* @ClassName:DBCPUtils
* @Description:dbcp连接池--工具类
* @author:htc  
* @date:2019年6月2日 下午11:24:25
*/
public class DBCPUtils {
	private static DataSource dataSource;
	
	static{
		try {
			//1)加载properties文件，获得Properties对象
			InputStream is = DBCPDemo2.class.getClassLoader().getResourceAsStream("dbcp-config.properties");
			Properties props = new Properties();
			props.load(is);
			//2)通过工厂，创建连接池
			dataSource = BasicDataSourceFactory.createDataSource(props);
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
