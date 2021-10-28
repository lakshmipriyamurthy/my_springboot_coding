<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<style type = "text/css">
	.table{margin:auto;
	width: 50%;}
	</style>
</head>
<body>
	<div align="center">
		<h1>Product Manager</h1>
		<div>
			<a href="new"> Create New Product</a>
		</div>


		<br /> <br />
		<table class="table table-stripped">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Name</th>
					<th>Brand</th>
					<th>Made In</th>
					<th>Price</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach var="product" items="${plist}">
				<tbody>
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.brand}</td>
						<td>${product.madein}</td>
						<td>${product.price}</td>
						<td><a href="/editProduct/${product.id }">Edit</a>
						<a href="/deleteProduct/${product.id}">Delete</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
</body>
</html>