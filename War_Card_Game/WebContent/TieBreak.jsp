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
TIE BREAKER
</p>

</div>


<div id ="left">
<p>
<img class ="card-image" src= "classic-cards/${player1Card}.png"/>
<%
Deck p1WarDeck = (Deck) session.getAttribute("p1WarDeck");
for(int i=0;i<p1WarDeck.getCardsLeft();i++)
{
%>
<img class ="card-image" src= "classic-cards/<%=p1WarDeck.getCard(i).toString() %>.png"/>
<%} %>
</p>

<p>

 <b> ${sessionScope.player1Name}</b>
</p>
<p>
<em> Score:</em> ${sessionScope.player1Score} 
</p>

</div>


<div id ="right">
<p>

<img class ="card-image" src= "classic-cards/${player2Card}.png"/>
<%
Deck p2WarDeck = (Deck) session.getAttribute("p2WarDeck");
for(int i=0;i<p2WarDeck.getCardsLeft();i++)
{
%>
<img class ="card-image" src= "classic-cards/<%=p2WarDeck.getCard(i).toString() %>.png"/>
<%} %>
</p>
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
     <input type="submit" name="submit" value= "NextDeal!">
     </p>
</div>
     
  </form>




</body>
</html>