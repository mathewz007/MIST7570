package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;
import model.Amortization;
/**
 * Servlet implementation class AmortizationServlet
 */
@WebServlet("/Amortization")
public class AmortizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmortizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//get input and convert values 

		double loanamount = Double.parseDouble(request.getParameter("LoanAmount"));
	    double loanrate =Double.parseDouble(request.getParameter("LoanRate"));
	    int loanterm =Integer.parseInt(request.getParameter("LoanTerm"));
		   
	   Loan loan = new Loan (loanamount, loanrate,loanterm);
		
		
		
	// send response and output 
		response.setContentType("text/html");
	     PrintWriter out = response.getWriter();
	     
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
	    out.println("<html>");
	    out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		out.println("<link rel='stylesheet' type='text/css' href='stylesheet.css' />");
		out.println("<title>Amortization Schedule</title>");

		out.println("</head>");
		out.println("<body>");
		out.println("<h2> Here are the results for your loan:</h2>");
	
		out.println("<p>");
		out.println("Loan Principal : $" +" "+ loan.getprincipalAmount());
		out.println("<br>");
		out.println("Loan Term :" + " "+ loan.gettotalTerm() + " " +"Months");
		out.println("<br>");
		out.println("Loan Rate :" +" "+  loan.getmonthlyLoanRate() +"%"+ " "+  "(Monthly rate)");
		out.println("</p>");
		
		  out.println(new Amortization(new Loan(loanamount,loanrate,loanterm)).doAmortization());

			out.println("<p>");
			out.println("<a href ='index.jsp'> Try Another!</a>");
			out.println("</p>");
		  
	
	  out.println("</body>");
	 out.println("</html>");
		
		
		
		
		
		
		
	}

}
