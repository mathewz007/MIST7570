package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.UpdateQuery;
import model.Product;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(description = "controller that actually updates the product", urlPatterns = { "/updateProduct" })
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get form data 
		
		
				String sku = request.getParameter("sku");
				String producttype = request.getParameter("producttype");
				String flavor = request.getParameter("flavor");
				double cost = Double.parseDouble(request.getParameter("cost"));
				double price =Double.parseDouble(request.getParameter("price"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				
				
				
				//set product object 
				
				Product product = new Product();
				product.setSku(sku);
				product.setproducttype(producttype);
				product.setFlavor(flavor);
				product.setCost(cost);
				product.setPrice(price);
				product.setQuantity(quantity);
				
				//create update query object and update book
				UpdateQuery uq = new UpdateQuery("Grocery_Database","root","password");
				 
						uq.doUpdate(product);
						
						
				//pass control over to read servlet 
				
				String url ="/read";
						
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
				
	}

}
