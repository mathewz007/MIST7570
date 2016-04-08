/**
 * 
 */
package dbHelpers;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;


import model.Product;

/**
 * @author mathewalexander
 *
 */
public class ReadQuery {
	
	
	private Connection connection;
	private ResultSet results;
	
	
public ReadQuery(String dbName, String uname, String pwd){
	 String url ="jdbc:mysql://localhost:3306/"+ dbName;
	 
	 // set up driver 
	 
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		this.connection = (Connection) DriverManager.getConnection(url,uname,pwd);
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void doRead(){
	String query ="select * from products";
	try {
		PreparedStatement ps = this.connection.prepareStatement(query);
		this.results=ps.executeQuery();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public String getHTMLTable(){
String table ="";
table +="<table border=1>";

try {
	while (this.results.next()){
	Product product = new Product();
	
		product.setSku(this.results.getString("SKU"));
		product.setproducttype(this.results.getString("Product Type"));
		product.setFlavor(this.results.getString("flavor"));
		product.setCost(this.results.getInt("cost"));
		product.setPrice(this.results.getInt("price"));
		product.setQuantity(this.results.getInt("quantity"));
		
		
		
		
		table+= "<tr>";
		table+= "<td>";		
		table+=	product.getSku();
		table+= "</td>";
		table+= "<td>";	
		table+=	product.getproducttype();
		table+= "</td>";
		table+= "<td>";	
		table+=	product.getFlavor();
		table+= "</td>";
		table+= "<td>";	
		table+=	product.getCost();
		table+= "</td>";
		table+= "<td>";	
		table+=	product.getPrice();
		table+= "</td>";
		table+= "<td>";	
		table+=	product.getQuantity();
		table+= "</td>";
			
				
			
				table+= "<td>";	
				table+= "<a href=update?SKU=" + product.getSku() + ">update</a> <a href = delete?SKU="+ product.getSku() + "> delete</a> ";
				table+="</tr>";
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

table+="</table>";
return table;
}
}






