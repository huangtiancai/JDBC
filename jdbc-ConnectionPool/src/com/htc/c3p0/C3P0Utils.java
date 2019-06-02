/**
 * 
 */
package com.htc.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
* @ClassName:C3P0Util
* @Description:c3p0连接池--工具类(等效 jdbc-demo中的JdbcUtils，用于提供获得连接工具类)
* @author:htc  
* @date:2019年6月2日 下午10:06:37
*/
public class C3P0Utils {
	//C3P0提供核心工具类：ComboPooledDataSource，如果要使用连接池，必须创建该类的实例对象
	//new ComboPooledDataSource(“名称”); 使用配置文件“命名配置”  <named-config name="htcconfig">
	//new ComboPooledDataSource(); 使用配置文件“默认配置”       <default-config>
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("htcconfig");
	
	/**
	 * function: getDataSource
	 * Description:获得数据源（连接池）  数据源=连接池
	 * return:DataSource
	 */
	public static DataSource getDataSource(){
		return dataSource;
	}
	/**
	 * function: getConnection
	 * Description:获得连接
	 * return:Connection
	 */
	public static Connection getConnection() throws SQLException{
		//将从连接池中获得连接
		return dataSource.getConnection();
	}
	
	
	
	
	
}
