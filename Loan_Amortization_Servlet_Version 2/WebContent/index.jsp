<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Loan"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Loan Amortization Application</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css" />
</head>

<h1>Your Loan Amortization Application  </h1>

<body style="font-family:verdana;font-size:10pt;">

	<p>Welcome to your loan application!</p>
	<p>
		Please enter the below fields to get started
	</p>

	<form name="loanApp" action ="Amortization" method="post">


		<label> Loan Amount : </label>
		<input	type="text" name="LoanAmount" value="20000" />

		<br>
		<label> Loan Term (in years) :</label>
		<input type ="text" name="LoanTerm" value="30"/>
		
 		<br>
		<label> Loan Rate:</label>
		<input type="text" name="LoanRate" value="6"/>
		
		<br>
       <input type ="submit" name ="calculate" value="Submit"/> 
       
	</form>

 

</body>
</html>