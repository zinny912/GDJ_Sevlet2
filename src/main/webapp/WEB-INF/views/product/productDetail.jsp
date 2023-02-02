<%@page import="com.iu.home.product.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Detail Page</h1>
	<%
	
	ProductDTO productDTO = (ProductDTO)request.getAttribute("detail"); 
	
	%>
	<h2>ProductDetail</h2>
	<h4><%= productDTO.getProductName() %></h4>
	<h6><%= productDTO.getProductJumsu() %></h6>
	<h3><%= productDTO.getProductDetail()  %></h3>
	
	
</body>
</html>