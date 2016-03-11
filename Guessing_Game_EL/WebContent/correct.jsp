<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guessing Game - Expression Version</title>
</head>
<body>
<H1>Guessing Game - Expression Version</h1>

<p>

<span>Message:</span> ${msg["msg"]}

</p>
Guesses: ${est["10"]}
<p>
<span> EST:</span> ${guesses.value <= est["10"] ? "Your score was better than average":"Needs some work, your score was
 higher than average"}
 
 
</p>



<p>
<a href=guess.jsp >  Play Again</a>
</p>


<p> 
<span> User-Agent:</span> ${header["user-agent"]}
</p>
</body>
</html>