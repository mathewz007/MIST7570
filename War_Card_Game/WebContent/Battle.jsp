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
<h1>War Card Game- Deal </h1>
<p>
 The war has begun ${Parm.player} wins the battle!
</p>
</div>
<div id ="left" >
<p>
<img class="card-image" src="http://a1.mzstatic.com/us/r30/Purple69/v4/b8/46/0e/b8460e7d-575d-5dcc-4726-4cb8581ec11a/icon175x175.png"/>

</p>


<p>
Player : ${parm.player1} 
</p>

<p>
Score:
</p>
</div>


<div id = "footer">

<form name="guessForm" action="doBattle" method="get">  
    <p>
     
     <input type="submit" name="submit" value= "Next Deal!">
     </p>
     
  </form>
</div>




</body>
</html>