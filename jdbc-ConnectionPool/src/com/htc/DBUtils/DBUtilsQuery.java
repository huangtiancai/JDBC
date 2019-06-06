/**
 * 
 */
package com.htc.DBUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
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
		//通过id查询详情，将查询结果封装到JavaBean product
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "select count(*) from product";
		//3.实际参数
		Object[] params = {};
		//4.查询并封装
		//int r = queryRunner.query(sql, new ScalarHandler<int>());   //这句错误(int) 
		//错误代码：new ScalarHandler<int>()
		//java报错：Syntax error, insert "Dimensions" to complete ReferenceType(语法错误，插入“维度”以完成引用类型)
		//原因：泛型必须是包装类类型，而不能是基本类型（包括基本类型的数组）
		//修改为：new ScalarHandler<int>()
		Integer r = queryRunner.query(sql, new ScalarHandler<Integer>());
		
		System.out.println(r);
		
		//打印索引为3,即第四行的数据
	
	}
	
	
	
}
