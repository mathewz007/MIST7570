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
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${player1Card}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p1WarCard1}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p1WarCard2}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p1WarCard3}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p1WarCard4}.png"/>
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

<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${player2Card}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p2WarCard1}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p2WarCard2}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p2WarCard3}.png"/>
<img class ="card-image" src= "http://localhost:8080/War_Card_Game/classic-cards/${p2WarCard4}.png"/></p>
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