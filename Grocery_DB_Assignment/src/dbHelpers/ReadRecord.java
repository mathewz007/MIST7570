/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Product;

/**
 * @author mathewalexander
 *
 */
public class ReadRecord {

	private Connection connection;
	private ResultSet  results;
	
	
	private Product product = new Product();
	private String sku;
	
	public ReadRecord(String dbName, String uname, String pwd, String sku){
		 String url ="jdbc:mysql://localhost:3306/"+ dbName;
		 this.sku =sku;


		//  set up driver 
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection= DriverManager.getConnection(url,uname,pwd);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
		public void doRead(){
			String query = "select * from products where `SKU`=?";
			
		 try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1,this.sku);
			this.results=ps.executeQuery();
			
			this.results.next();
			
		product.setSku(this.results.getString("SKU"));
		product.setproducttype(this.results.getString("Product Type"));
		product.setFlavor(this.results.getString("Flavor"));
		product.setCost(this.results.getDouble("Cost"));
		product.setPrice(this.results.getDouble("Price"));
		product.setQuantity(this.results.getInt("Quantity"));
			
	
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}
		
		public Product getproduct(){
			return this.product;
			}
			}
	
