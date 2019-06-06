/**
 * 
 */
package com.htc.DBUtils;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.htc.bean.Product;
import com.htc.c3p0.C3P0Utils;

/**  
* @ClassName DBUtilsQuery
* @Description:QueryRunner实现查询操作
* @author htc  
* @date 2019年6月6日下午1:25:52 
*/
public class DBUtilsQuery {
	/**
	 * function: BeanHandlerQuery
	 * Description:BeanHandler处理方式-将数据表的结果集(某一行数据),封装成JavaBean类的对象
	 * 			         构造方法:BeanHandler(Class<T> type) 
	 * return:void
	 * @throws SQLException 
	 */
	@Test
	public void BeanHandlerQuery() throws SQLException{
		//通过id查询详情，将查询结果封装到JavaBean product
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product where pid = ?";
		//3.实际参数
		Object[] params = {6};
		//4.查询并封装
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), params);
		
		System.out.println(product);
		//打印对象:
		//Product [pid=6, pname=OPPO, price=3400.0, category_id=c002]
		
		//分别打印
		System.out.println(product.getPid());
		System.out.println(product.getPname());
		System.out.println(product.getPrice());
		System.out.println(product.getCategory_id());
		System.out.println(product.getClass());
//		6
//		OPPO
//		3400.0
//		c002
//		class com.htc.bean.Product		
	}
	
	/**
	 * function: BeanListHandlerQuery
	 * Description:BeanListHandler处理方式-将数据表的每一行数据,封装成JavaBean类对象
	 * 									-->多行数据就多个JavaBean对象-->存储为List集合								
	 * return:void
	 */
	@Test
	public void BeanListHandlerQuery() throws SQLException{
		//查询所有，将每一条记录封装到一个JavaBean，然后将JavaBean添加到List中，最后返回List，BeanListHandler
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product";
		//3.实际参数
		Object[] params = {};//实际参数为空的话，query方法里的参数params可带可不带
		//4.查询并封装
		//List<Product> product = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), params);
		List<Product> product = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		
		
		System.out.println(product);
		//打印对象:
//		[Product [pid=1, pname=IBM, price=5500.0, category_id=c001], 
//		 Product [pid=2, pname=长城, price=3200.0, category_id=c001], 
//		 Product [pid=3, pname=惠普, price=5000.0, category_id=c001], 
//		 Product [pid=4, pname=华为, price=3800.0, category_id=c002], 
//		 Product [pid=5, pname=小米, price=2000.0, category_id=c002], 
//		 Product [pid=6, pname=OPPO, price=3400.0, category_id=c002], 
//		 Product [pid=7, pname=NOKIA, price=2000.0, category_id=c002], 
//		 Product [pid=8, pname=佰草集, price=800.0, category_id=c003], 
//		 Product [pid=9, pname=玉兰油, price=200.0, category_id=c003], 
//		 Product [pid=10, pname=大宝, price=5.0, category_id=c003]
//		]
		
		//打印索引为3,即第四行的数据
		System.out.println(product.get(3).getPid());
		System.out.println(product.get(3).getPname());
		System.out.println(product.get(3).getPrice());
		System.out.println(product.get(3).getCategory_id());
		System.out.println(product.getClass());	
//		4
//		华为
//		3800.0
//		c002
//		class java.util.ArrayList
		
	}
	
	/**
	 * function: ScalarHanderQuery
	 * Description:ScalarHandler处理方式-处理单值查询结果,执行的select语句后,结果集只有1个
	 * return:void
	 */
	@Test
	public void ScalarHanderQuery() throws SQLException{
		//ScalarHandler:用于处理聚合函数执行结果(一行一列)
		//查询总记录数
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select count(*) from product";
		//3.实际参数
		Object[] params = {};
		//4.查询并封装
		//long r = queryRunner.query(sql, new ScalarHandler<long>());   //这句错误(long)
		//错误代码：new ScalarHandler<long>() / new ScalarHandler<int>()
		//(1)返回的是long型，如果用int:
		//java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.Integer
		//(2)泛型必须是包装类型，而不能是基本类型（包括基本类型的数组），如果不用包装类型：
		//java报错：Syntax error, insert "Dimensions" to complete ReferenceType(语法错误，插入“维度”以完成引用类型)

		//修改为：new ScalarHandler<Long>()
		Long r = queryRunner.query(sql, new ScalarHandler<Long>());
		
		System.out.println(r);
		
		//打印索引为3,即第四行的数据
	
	}
	
	
	/**
	 * function: MapHandlerQuery
	 * Description:MapHandler处理方式-将数据表结果集的一行数据封装成Map集合
	 * 				键: 数据表中的列
	 * 				值: 这个列中的数据
	 * return:void
	 */
	@Test
	public void MapHandlerQuery() throws SQLException{
		//MapHandler:将查询到的一条记录，封装到Map中,map.key=字段名,map.value=值
		//注意与BeanHandler查询一行数据的区别
		
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product where pid = ?";
		//3.实际参数
		Object[] params = {6};
		//4.查询并封装
		Map<String, Object> map = queryRunner.query(sql, new MapHandler(), params);
		//5.打印对象
		System.out.println(map);
		//map
		//{pid=6, pname=OPPO, price=3400.0, category_id=c002}
		//product
		//Product [pid=6, pname=OPPO, price=3400.0, category_id=c002]
		
		System.out.println(map.get("pid"));
		System.out.println(map.get("pname"));
		System.out.println(map.get("price"));
		System.out.println(map.get("category_id"));
		
//		6
//		OPPO
//		3400.0
//		c002

	}
	
	/**
	 * function: MapListHandlerQuery
	 * Description:MapListHandler处理方式-将数据表的结果集的每一行封装成Map集合
	 * 				 数据表有多行数据,出现多个Map集合,存储到List集合
	 * return:void
	 */
	@Test
	public void MapListHandlerQuery() throws SQLException{
		//MapListHandler:查询所有数据，将每一条记录封装到Map中，然后将Map添加到List中，最后返回List
		
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product";
		//3.实际参数
		Object[] params = {};
		//4.查询并封装
		//Map<String, Object> map = queryRunner.query(sql, new MapHandler(), params);
		List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler());
		
		System.out.println(list);
		
//		[{pid=1, pname=IBM, price=5500.0, category_id=c001}, 
//		 {pid=2, pname=长城, price=3200.0, category_id=c001}, 
//		 {pid=3, pname=惠普, price=5000.0, category_id=c001}, 
//		 {pid=4, pname=华为, price=3800.0, category_id=c002}, 
//		 {pid=5, pname=小米, price=2000.0, category_id=c002}, 
//		 pid=6, pname=OPPO, price=3400.0, category_id=c002}, 
//		 {pid=7, pname=NOKIA, price=2000.0, category_id=c002}, 
//		 {pid=8, pname=佰草集, price=800.0, category_id=c003}, 
//		 {pid=9, pname=玉兰油, price=200.0, category_id=c003}, 
//		 {pid=10, pname=大宝, price=5.0, category_id=c003}
//		]
		
		
		//5.打印对象
		for(Map<String, Object> map : list){
			System.out.println(map);
		}
		
//		{pid=1, pname=IBM, price=5500.0, category_id=c001}
//		{pid=2, pname=长城, price=3200.0, category_id=c001}
//		{pid=3, pname=惠普, price=5000.0, category_id=c001}
//		{pid=4, pname=华为, price=3800.0, category_id=c002}
//		{pid=5, pname=小米, price=2000.0, category_id=c002}
//		{pid=6, pname=OPPO, price=3400.0, category_id=c002}
//		{pid=7, pname=NOKIA, price=2000.0, category_id=c002}
//		{pid=8, pname=佰草集, price=800.0, category_id=c003}
//		{pid=9, pname=玉兰油, price=200.0, category_id=c003}
//		{pid=10, pname=大宝, price=5.0, category_id=c003}
		
		//打印出pname字段的值
		for(Map<String, Object> map : list){
			Object pnames = map.get("pname");
			System.out.println(pnames);
		}

	}
	
	/**
	 * function: ArrayHandlerQuery
	 * Description:ArrayHandler处理方式-将数据表中的一行数据,存储到对象数组Object[]中
	 * 				注意:获取查询后的一行数据,如果查询不到结果集,返回的对象数组的length=0
	 * return:void
	 */
	@Test
	public void ArrayHandlerQuery() throws SQLException{
		//ArrayHandler:查询一条记录，将数据封装到数组中
		
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product where pid = ?";
		//3.实际参数
		Object[] params = {6};
		//4.查询并封装
		Object[] arr = queryRunner.query(sql, new ArrayHandler(), params);
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));//[6, OPPO, 3400.0, c002]
	}	
	
	/**
	 * function: ArrayListHandlerQuery
	 * Description: ArrayListHandler处理方式-将数据表中的每一行数据,存储到一个对象数组Object[]中
	 * 									       而数据表中会有多行数据,产生多个对象数组, 存储到List集合中
	 * return:void
	 */
	@Test
	public void ArrayListHandlerQuery() throws SQLException{
		// ArrayListHandler:查询所有，将每一行记录封装到数组中，然后添加到List，最后返回list
		
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select * from product";
		//3.实际参数
		Object[] params = {};
		//4.查询并封装
		List<Object[]> list = queryRunner.query(sql, new ArrayListHandler());
		
		System.out.println(list);
		
//		[
//		  [Ljava.lang.Object;@c677a7, 
//		  [Ljava.lang.Object;@1d9a9a7, 
//		  [Ljava.lang.Object;@1114c4f, 
//		  [Ljava.lang.Object;@a8f4d4, 
//		  [Ljava.lang.Object;@61c207, 
//		  [Ljava.lang.Object;@97eb1, 
//		  [Ljava.lang.Object;@15c9b9c, 
//		  [Ljava.lang.Object;@ec5af6, 
//		  [Ljava.lang.Object;@147d62e, 
//		  [Ljava.lang.Object;@13e94d3
//		]
		
		for(Object[] arr:list){
			System.out.println(Arrays.toString(arr));
		}
		
//		[1, IBM, 5500.0, c001]
//		[2, 长城, 3200.0, c001]
//		[3, 惠普, 5000.0, c001]
//		[4, 华为, 3800.0, c002]
//		[5, 小米, 2000.0, c002]
//		[6, OPPO, 3400.0, c002]
//		[7, NOKIA, 2000.0, c002]
//		[8, 佰草集, 800.0, c003]
//		[9, 玉兰油, 200.0, c003]
//		[10, 大宝, 5.0, c003]
	}
	
	//KeyedHandler
	//ColumnListHandler
	
	
	
	
}
