package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Product;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new product to the DB", urlPatterns = { "/addproduct" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data
		
		String sku =request.getParameter("sku");
		String producttype =request.getParameter("producttype");
		String flavor =request.getParameter("flavor");
		Double cost =Double.parseDouble(request.getParameter("cost"));
		Double price =Double.parseDouble(request.getParameter("price"));
		int quantity =Integer.parseInt(request.getParameter("quantity"));
			
		//create the product object 
		
		Product product = new Product();
		product.setSku(sku);
		product.setproducttype(producttype);
		product.setFlavor(flavor);
		product.setCost(cost);
		product.setPrice(price);
		product.setQuantity(quantity);
	
		//set up and add query obj
		
		AddQuery aq = new AddQuery("Grocery_Database","root","password");
		
		aq.doAdd(product);
		
		
		
		//pass execution to the readservlet 
		
		String url = "/read";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}

}
