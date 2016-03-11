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

<p>
The War has begun ${winner} wins the battle!
</p>

</div>


<div id ="left">
<p>
<img class ="card-image" src= "classic-cards/${player1Card}.png"/>
</p>
Cards Left: ${player1CardsLeft }
<p>

 <b> ${sessionScope.player1Name}</b>
</p>
<p>
<em> Score:</em> ${sessionScope.player1Score} 
</p>

</div>


<div id ="right">
<p>
<img class ="card-image" src= "classic-cards/${player2Card}.png">
</p>
Cards Left: ${player2CardsLeft }
<p>

 <b> ${sessionScope.player2Name}</b>
</p>

<p>
<em> Score:</em> ${sessionScope.player2Score} 
</p>

</div>



	<form  name="guessForm" action="doBattle" method="get">
	<div id = "footer">
     <p>
     <%boolean isWar=((Boolean) session.getAttribute("isWar")).booleanValue(); 
     if(isWar){ %>
    <input type="submit" name="submit" value= "Break Tie!">
    <%} else {%>
    <input type="submit" name="submit" value= "Next Deal!">
    <%} %>
     </p>
</div>
     
  </form>




</body>
</html>