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

Message: ${msg["msg"]}

</p>

<p>
${guesses.value <= est ? "Your score was better than average":"Needs some work, your score was
 higher than average"}
 
</p>



<p>
<a href=guess.jsp> Play Again</a>
</p>


<p> 
User-Agent: ${header["user-agent"]}
</p>
</body>
</html>