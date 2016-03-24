<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Function Tag</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>
<h1>Function Tag testing with Trim Contains & Length</h1>

<c:set var="value1" value="          HelloWorld"/>
<c:set var="value2" value="HelloWorldNew"/>



<h2> Trim function</h2>
<p>
${fn:trim(value1)}
</p>

<h2> length function</h2>
<p>
Length of Value1 is: ${fn:length(value1)}<br>
Length of Value2 is: ${fn:length(value2)}<br>

</p>

<h2> Contains function</h2>
<p>
<c:if test="${fn:contains(HellowWorld, HelloWorldNew )}">
 <c:out value="New Password should not contain any old password as substring"/>
</c:if>
</p>


 <p>
    <a href=index.html>HOME</a>
    </p>


</body>
</html>