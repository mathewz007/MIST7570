package model;

import java.text.NumberFormat;

public class Amortization {

	private Loan loan;
	private double  monthlyPaymentToInterest;
	private double monthlyPaymentToBalance;
	private double currentBalance;
	
	
	
	// constructors

	public Amortization() {
		super();
		this.loan = new Loan ();
	}

	public Amortization(Loan loan) {
		this.loan = loan;
		this.setNewBalance(loan.getprincipalAmount());
	}

	
	
	
	// getters and setters 
	
	public Loan  getloan(){
		return loan;
	}
	
	public void setLoan(Loan loan){
		this.loan =loan;
	}
		

	public double getMonthlyPaymentToInterest() {
		return monthlyPaymentToInterest;
	}
	
	public void setMonthlyPaymentToInterest(double monthlyPaymentToInterest) {
		this.monthlyPaymentToInterest = monthlyPaymentToInterest;
	}
	
	public double getMonthlyPaymentToBalance() {
		return monthlyPaymentToBalance;
	}

	public void setMonthlyPaymentToBalance(double monthlyPaymentToBalance) {
		this.monthlyPaymentToBalance = monthlyPaymentToBalance;
	}
		
	public double getNewBalance() {
		return currentBalance;
	}

	public void setNewBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	// custom method 
	public String doAmortization(){
		String createTable;
		int count =0;
		NumberFormat nf= NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		
		
 createTable = "<table><tr><th>Month</th> <th> Payment</th> <th>Interest Paid</th> <th>Principal Paid</th> <th>Ending Balance</th></tr>";
		  while (count++ < loan.gettotalTerm() ){ 
			   
		  createTable += "<tr><td>" +count+"</td>"; 
		  createTable += "<td>"+"$" + nf.format(this.loan.getmonthlyPayment() )+ "</td>";
		  createTable += "<td>"+"$" + nf.format (this.calcmonthlyPaymentToInterest() )+"</td>";
		  createTable += "<td>" + "$" + nf.format(this.calcmonthlyPaymentToBalance() )+ "</td>" ;
	     this.setNewBalance(this.getNewBalance()-this.calcmonthlyPaymentToBalance() );
	     createTable  += "<td>" + "$" +nf.format (this.calccurrentBalanceAfterPayment() )+ "</td>";
	 
	}
		  createTable += "</table>";
		  return createTable ;
	}
		  
	
public double calcmonthlyPaymentToInterest(){
	return this.loan.getmonthlyLoanRate()*(this.getNewBalance());
}

public double calcmonthlyPaymentToBalance(){
	return this.loan.getmonthlyPayment() -this.calcmonthlyPaymentToInterest();
}

public double calccurrentBalanceAfterPayment(){
	return this.getNewBalance()-this.getMonthlyPaymentToBalance();
	
}
	}


	
	
	

