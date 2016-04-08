package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadRecord;

import model.Product;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "will get a product adn use the the data to fill inthe product table", urlPatterns = { "/update" })
public class UpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFormServlet() {
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
		//get product SKU 
		
				String sku = request.getParameter("sku");
				
				
				//create readRecord class
				ReadRecord rr =new ReadRecord ("Grocery_Database","root","password","sku" ) ;
				
				
				
				//useReadRecord to get product
				rr.doRead();
				Product product =rr.getproduct();
				
				
				//pass book and control to the update form.jsp
				
				request.setAttribute("product", product);
				String url="/updateForm.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				

}
}