<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.GameNumber" %>

<%
  // input
  String guessStr = request.getParameter("guess");
  GameNumber guess = new GameNumber(Integer.parseInt(guessStr));
  
  String minStr = request.getParameter("minimum");
  GameNumber minimum = new GameNumber(Integer.parseInt(minStr));
  
  String maxStr = request.getParameter("maximum");
  GameNumber maximum = new GameNumber(Integer.parseInt(maxStr));
  
  String tarStr = request.getParameter("target");
  GameNumber target = new GameNumber(Integer.parseInt(tarStr));
  
  GameNumber guesses = new GameNumber(Integer.parseInt(request.getParameter("guesses")));
  
  String msg = ""; // variable to hold the message to the user
  
  //process
  
  if (guess.getValue() == target.getValue()) {
	  // the guess is correct
	  msg = "Congrats! You got the answer in " + guesses.getValue() + "guesses.";
  } else {
	  // the guess is incorrect
	  guesses.increment();
	  if (guess.getValue() < target.getValue()) {
		  // guess is too low
		  msg = "Incorrect. Please guess higher this time.";
	  } else {
		  // guess is too high
		  msg = "Incorrect. Please guess lower this time.";
	  }
  }
  
  // output
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
<%= msg %>
</p>

<%
if (guess.getValue() == target.getValue()) {
	  // correct guess
%>
     <a href="index.jsp">Play Again!</a>
<% } else {
	// incorrect guess
%>
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
<%
}
%>

</body>
</html>