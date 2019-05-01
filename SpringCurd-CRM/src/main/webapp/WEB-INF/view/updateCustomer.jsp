<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update CUSTOMER</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br>
		<div class="card">
			<div id="wrapper">
				<div id="header">
					&nbsp;&nbsp;
					<h1 class="text-primary">Customer Relationship Manager</h1>
				</div>
			</div>
			<hr>
			&nbsp;&nbsp;
			<h3>Update Customer</h3>

			&nbsp;&nbsp;
			<h1 style="color: red;">${status}</h1>

			<form:form action="updateProcess" modelAttribute="customer"
				method="POST" id="myform" class="form-group">

				<table>
					<tbody>
						<form:hidden path="id" />
						<tr>
							<td><label class="form-group">First name:</label></td>
							<td><form:input path="firstName" class="form-group" /></td>
						</tr>

						<tr>
							<td><label class="form-group">Last name:</label></td>
							<td><form:input path="lastName" class="form-group" /></td>
						</tr>

						<tr>
							<td><label class="form-group">Email:</label></td>
							<td><form:input path="email" class="form-group" /></td>
						</tr>

						<tr>
							<td><label class="form-group"></label></td>
							<td><input type="submit" value="Save"
								class="btn btn-primary" /></td>
						</tr>


					</tbody>
				</table>


			</form:form>


		</div>
	</div>
</body>
</html>