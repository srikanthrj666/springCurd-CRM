<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Customers</title>
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
		<div id="wrapper">
			<div id="header">
				<br>
				<h1 class="text-primary" align="center">Customer Relationship
					Manager</h1>
			</div>
		</div>


		<h3 style="color: red;">${status}</h3>
		<div id="content">
			<hr>




			<!-- put new button: Add Customer -->

			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="btn btn-primary" /> <br> <br>


			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>


					</tr>
				</thead>
				<tbody>
					<!-- loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}">

						<!-- construct an "update" link with customer id -->
						<c:url var="updateLink" value="/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>


							<td>
								<!-- display the update link --> <a href="${updateLink}">Update</a>

								&nbsp;<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</td>


						</tr>

					</c:forEach>
				</tbody>

			</table>

		</div>
		<br> <a href="logout" class="btn btn-danger"
			style="float: right;">logout</a><br> <br> <br> <br>
	</div>
</body>
</html>