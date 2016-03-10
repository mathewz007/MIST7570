<%@page import="model.*"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War Card Game </title>
<link rel="stylesheet" href="war.css" type ="text/css"/>

</head>
<body>

<div id="header"> 

<h1>Welcome to the War Card Game! </h1>

</div>

<div id= "center">
<p>

Congratulations ${winner} Today was a great day ! Today you won!

</p>
<p>

<em> ${player1Name }</em> ${player1Score} 

<em>${player2Name }</em> ${player2Score} 

</p>
</div>






	<form  name="guessForm" action="doBattle" method="get">
	<div id = "footer">
     <p>
     <input type="submit" name="submit" value= "Play Again!">
     </p>
</div>
     
  </form>




</body>
</html>