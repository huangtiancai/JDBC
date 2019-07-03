/**
 * 
 */
package com.htc.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.htc.bean.Product;
import com.htc.util.JdbcUtils;

/**  
* @ClassName FindProduct
* @Description:
* @author htc  
* @date 2019年7月3日上午11:15:50 
*/
public class FindProduct {
	Connection conn = null;
	Statement st = null;
	ResultSet rs =null;
	
	/**
	 * function: findAllProduct
	 * Description:通过存储过程查询数据(Product)
	 * return:List<Product>
	 */
	public List<Product> findAllProduct(){
		List<Product> list = new ArrayList<Product>();
		try {
			conn = JdbcUtils.getConnection();
			System.out.println("打开连接池");
			//调用存储过程
			CallableStatement cs = conn.prepareCall("{CALL findAllProduct()}");
			//执行查询操作，并获取结果集
			ResultSet rs = cs.executeQuery();
			while(rs.next()){
				//实例化Product对象
				Product product = new Product();
				
				product.setPid(rs.getString("pid"));
				product.setPname(rs.getString("pname"));
				product.setPrice(rs.getDouble("price"));
				
				list.add(product);				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, st, rs);
			System.out.println("关闭连接池");
		}
		return list;	
	}
	
	/**
	 * function: main
	 * Description:主函数 调用存储过程(测试使用)
	 * return:void
	 */
	public static void main(String[] args) {
		FindProduct fp = new FindProduct();
		List<Product> products = fp.findAllProduct();
		for(Product product:products){
			System.out.println(product.getPid()+" "+product.getPname()+" "+product.getPrice());
		}
	}

}
