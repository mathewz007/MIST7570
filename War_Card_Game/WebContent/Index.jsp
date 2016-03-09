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


<div id ="center">
<img class ="center-image" src= "https://lh5.ggpht.com/16GTM70G8BLoQONAIHBSwIEhDNr_wZFce-Y18La7xlgNve2UTsidZX2ezH8rzs_pwTg=w300"
/>

</div>

<div id = "footer">

	<form class= "bottom" name="guessForm" action="doBattle" method="get">

 <label>
     Player 1: <input type="text" name="player1" /> 
     Player 2: <input type="text" name="player2" />
     </label>
    
    <p>
     
     <input type="submit" name="submit" value= "Play War!">
     </p>
     
  </form>
</div>




</body>
</html>