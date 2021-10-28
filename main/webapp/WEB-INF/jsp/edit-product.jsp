<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<div align="center">
		<h1>Update Product</h1>
		</br>
		<c: var = "action" value = "/edit" />
		<form:form action="${ action }" method="post" modelAttribute="editForm"
			novalidate="novalidate">
			<table>
			<tr>
			<td> Product Id</td>
			<td><form:input path= "id" readOnly= "readOnly" /></td>
			</tr>
				<tr>
					<td>Product Name</td>
					<td><form:input type="text" path="name" /></td>
				</tr>

				<tr>
					<td>Brand</td>
					<td><form:input path="brand" /></td>
				</tr>

				<tr>
					<td>Made-in</td>
					<td><form:input path="madein" /></td>
				</tr>

				<tr>
					<td>Price</td>
					<td><form:input type= text path="price" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update Product" /></td>
					<td><input type="reset" value="Cancel" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>