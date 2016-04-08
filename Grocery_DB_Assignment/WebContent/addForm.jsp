<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Table - Add a product </title>
</head>
<body>
<h1> Product Table - Add a product</h1>

<form  name=addForm action=addproduct method=get>

<label> SKU :</label>
<input type = text name = sku value=""/>
<br/>


<label> Product Type :</label>
<input type = text name = producttype value=""/>
<br/>

<label> Flavors :</label>
<input type = text name =flavor value=""/>
<br/>

<label> Cost :</label>
<input type = text name =cost value=""/>
<br/>

<label> Price :</label>
<input type = text name =price value=""/>
<br/>

<label> Quantity :</label>
<input type = text name =quantity value=""/>
<br/>


<input type =submit name =submit value="Add a product"/>
</form>



</body>
</html>