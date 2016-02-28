/**
 * 
 */
package model;

/**
 * @author mathewalexander
 *
 */
public class Loan{
	// declare variables 
	
	private double principalAmount;
	private double loanRate;
	private int loanTerm;
	
	
// Constructors
	
   public Loan() {
		principalAmount =0;
		loanRate = 0;
		loanTerm = 0;
		
	}

   public Loan(double principalAmount, double loanRate, int loanTerm) {
	this.principalAmount = principalAmount;
	this.loanRate = loanRate;
	this.loanTerm = loanTerm;
	
}
   // getters and setters 
   
public double getprincipalAmount() {
	return principalAmount;
}

public void setprincipalAmount(double principalAmount) {
	this.principalAmount = principalAmount;
}

public double getloanRate() {
	return loanRate;
}

public void setloanRate(double loanRate) {
	this.loanRate = loanRate;
}

public int getloanTerm() {
	return loanTerm;
}

public void setloanTerm(int loanTerm) {
	this.loanTerm = loanTerm;
}

// custom Methods 

public double getmonthlyPayment(){
	double monthlyPayment = (this.getprincipalAmount() * this.getmonthlyLoanRate()/ (1 - (Math.pow( (1 + this.getmonthlyLoanRate()), (-1*this.gettotalTerm())) )));
   			 return monthlyPayment;
}
public double getmonthlyLoanRate(){
	 double monthlyLoanRate=(this.loanRate/100)/12; 
	 return monthlyLoanRate;
 }

public int gettotalTerm(){
	int totalTerm=this.loanTerm*12;
			return totalTerm;
}

}

	