<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Core Demo</title>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
</head>
<body>

<h2> Test with if, choose, out ,forEach, otherwise</h2>

<c:forEach var="number" begin="0" end="4">

      <c:out value="${number}"/> :
      <c:choose>
   <c:when test="${number == 0}">
          That's Zero!</br>
  </c:when>
  <c:when test="${number == 1}">
          That'sOne!</br>
  </c:when>
  <c:when test="${number == 4}">
          That'sFour!</br>
  </c:when>
  <c:when test="${number== 3}">
         That's Three!</br>
  </c:when>
  <c:otherwise>
         What Happened</br>
  </c:otherwise>
      </c:choose>
    </c:forEach>
    
<h2> Testing Import </h2>
   <c:import var="data" url="/index.html"/>
<c:out value="${data}"/>
</body>
    
      <h2> Testing forToken </h2>
   
    <c:forTokens items="1,2,3,4,5" delims="," var="let">
 <c:out value="${let}"/> <p>
    </c:forTokens>

  
   
    <p>
    To learn about Format Tags <a href=format.jsp>click here </a>
   </p>
    
      <p>
    To learn about Function Tags <a href=function.jsp>click here </a> 
   </p>
   
    
    <p>
    <a href=index.html>HOME</a>
    </p>
    
  </body>
</html>




