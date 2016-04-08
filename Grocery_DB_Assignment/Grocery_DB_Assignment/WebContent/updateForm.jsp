<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.Product"  %>
    <% Product product = (Product)request.getAttribute("product"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Grocery Database - update product table </title>
</head>
<body>

<h1>Grocery Database - update product table </h1>

<form  name=updateForm action=updateProduct method=get>


<label> SKU :</label>
<input type = text name = sku value="<%=product.getSku()%>"/>
<br/>

<label> Product Type :</label>
<input type = text name = producttype value="<%=product.getproducttype()%>"/>
<br/>

<label> Flavors :</label>
<input type = text name =flavor value="<%=product.getFlavor()%>"/>
<br/>

<label> Cost :</label>
<input type = text name =cost value="<%=product.getCost()%>"/>
<br/>

<label> Price :</label>
<input type = text name =price value="<%=product.getPrice()%>"/>
<br/>

<label> Quantity :</label>
<input type = text name =quantity value="<%=product.getQuantity()%>"/>
<br/>

<input type =submit name =submit value=" Update Products"/>
</form>



</body>
</html>