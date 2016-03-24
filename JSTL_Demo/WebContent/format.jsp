
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Format Date</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>

<h2> Fomat Number </h2>
    <c:set var="amount" value="100.23456" />
<p>Formatted Number: <fmt:formatNumber value="${amount}" 
         maxIntegerDigits="2"   type="percent"/></p>
            
 <h2> SetLocale</h2>           
    <p>Currency in USA :
<fmt:setLocale value="en_US"/>
<fmt:formatNumber value="${amount}" type="currency"/></p>        
 
  <h2> Number Format:</h2>
  
<c:set var="date" value= "<%=new java.util.Date()%>"/>
<p>Formatted Date(time): <fmt:formatDate type="time" 
            value="${date}" /></p>
<p>Formatted Date(date): <fmt:formatDate type="date" 
            value="${date}" /></p>   


            
     
     
      <p>
    <a href=index.html>HOME</a>
    </p>
     
     
</body>
</html>