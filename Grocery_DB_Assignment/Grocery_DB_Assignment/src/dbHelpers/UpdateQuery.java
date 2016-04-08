/**
 * 
 */
package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Product;

/**
 * @author mathewalexander
 *
 */
public class UpdateQuery {
	
private Connection connection;
	
	public UpdateQuery(String dbName, String uname, String pwd){
		 String url ="jdbc:mysql://localhost:3306/"+ dbName;

		 try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection =  DriverManager.getConnection(url,uname,pwd);
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		 public void doUpdate(Product product){
				String query ="update products set `SKU` =? ,`Product Type`= ?,`Flavor` = ?,`Cost` =?,`Price`= ?,`Quantity`= ? where SKU =?";
		
				try {
					
					PreparedStatement ps= connection.prepareStatement(query);
					ps.setString(1, product.getSku());
					ps.setString(2, product.getproducttype());
					ps.setString(3, product.getFlavor());
					ps.setDouble(4, product.getCost());
					ps.setDouble(5, product.getPrice());
					ps.setInt(6, product.getQuantity());
					
					ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
}
}
