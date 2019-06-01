package com.htc.demo;

/**
 * 
 * 
 */

/**
 * JDBC连接数据库步骤：
 * 1.添加jar包  build path下
 * 2.加载驱动
 * 3.获取连接对象
 * 4.获取处理器对象：第一种：Statement st = con.createStatement();
 * 5.执行sql语句		
 * 		executeUpdate(sql):执行DML语句（insert/update/delete）：返回为整形，表示影响行数
 * 		executeQuery(sql):执行DQL语句  :返回ResultSet结果集对象(查询所有数据)
 * 6.处理返回的结果
 * 7.关闭相关资源Connection,Statement,ResultSet等
 */

public class Demo1 {
		
}
