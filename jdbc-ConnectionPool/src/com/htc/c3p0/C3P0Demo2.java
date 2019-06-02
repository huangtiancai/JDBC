/**
 * 
 */
package com.htc.c3p0;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**  
* @ClassName C3P0Demo2
* @Description:使用c3p0-config.xml进行c3p0的配置(在程序中如何加载xml文件获得链接)
* @author htc  
* @date 2019年6月2日 下午9:26:42
*/
public class C3P0Demo2 {
	/**
	 * function: demo1
	 * Description:c3p0-config.xml进行c3p0的配置
	 * return:void
	 */
	@Test
	public void demo1(){
		
		try {
			//1.获得连接池(数据源)
			//c3p0 jar包将自动加载"c3p0-config.xml"文件，并获得具体的配置信息
			//加载命名配置
			//在配置文件中 <named-config name="名称"> ，可以通过核心类 new ComboPooledDataSource("名称")
			ComboPooledDataSource dataSource = new ComboPooledDataSource("htcconfig");
			
			//注意：如果名称为空，加载默认配置
			//ComboPooledDataSource dataSource = new ComboPooledDataSource();
			
			//2.获得连接
			Connection conn = dataSource.getConnection();
			System.out.println("获得的连接："+conn);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
