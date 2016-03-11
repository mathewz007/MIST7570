<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>Guessing Game - Expression Version</title>
</head>
<body>
  <h1>Guessing Game- Expression Version</h1>
  
  <p>
  <b>Please choose a number between o and 1000 </b> <span>Chose carefully!</span>
   </p>
  <p>
 <span> Message:</span> ${msg["msg"]}
  </p>
  
  <form name="guessForm" action="doGuess" method="get">
     <label>
     <span> Guess: </span> ${sessionScope.guesses.value}
     </label>
     <input type="text" name="guess" /><br />
     <input type="submit" name="submit" value="Make Guess">
     
  </form>
  <p>
<span> User-Agent:</span> ${header["user-agent"]}
</p>



<span> For test purposes target : ${target.value} </span>
</body>
</html>