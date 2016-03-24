<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.GameNumber" %>
    
<%
    // initialize the numbers for our game
      // minimum
      GameNumber minimum = new GameNumber(0);
    		
      // maximum
      GameNumber maximum = new GameNumber(1000);
    
      // target
      GameNumber target = new GameNumber();
      target.setRandom(minimum.getValue(), maximum.getValue());		
   
      // number of guesses
      GameNumber guesses = new GameNumber(1);

%>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Amazing Guessing Game (JSP Version)</title>
</head>
<body>
<h1>Amazing Guessing Game (JSP Version)</h1>

<p>
 Welcome! We hope you enjoy our guessing game!
</p>

<p>
   Please guess a number between <%= minimum.getValue() %> and <%= maximum.getValue() %>.
</p>

<form name="guessForm" action="guess.jsp" method="post" >

<label>
   Guess <%= guesses.getValue() %>:
</label>
<input type="text" name="guess" value="0" />
<br>
<input type="submit" name="guessButton" value="Go" />

<!-- using hidden textboxes to manage state -->
<!-- NOT A GOOD WAY. USE ONLY UNTIL YOU LEARN A BETTER WAY -->
<input type="hidden" name="minimum" value="<%= minimum.getValue() %>" />
<input type="hidden" name="maximum" value="<%= maximum.getValue() %>" />
<input type="hidden" name="target" value="<%= target.getValue() %>" />
<input type="hidden" name="guesses" value="<%= guesses.getValue() %>" />
</form>











</body>
</html>