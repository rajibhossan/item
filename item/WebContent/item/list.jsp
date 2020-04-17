<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>List of Item</title>

</head>
<body>

	<div class="jumbotron text-center">
		<h2>Item List</h2>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-2">				
				<ul class="nav nav-pills nav-stacked">
					<li><a href="/item/">Home</a></li>	
					<li><a href="/item/list">Items List</a></li>
					<li><a href="/item/new">Add Items</a></li>
				</ul>

			</div>
			<div class="col-sm-9">
				<c:if test="${delete != null}">
					<div class="alert alert-danger alert-dismissible fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>Success!</strong> ${delete}
					</div>
				</c:if>
				<table class="table table-bordered table-responsive">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Description</th>
							<th>Create Date</th>
							<th>Update Date</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${listItems}">
							<tr>
								<td><c:out value="${item.id}" /></td>
								<td><c:out value="${item.name}" /></td>
								<td><c:out value="${item.description}" /></td>
								<td><fmt:formatDate pattern = "yyyy-MM-dd hh:MM:ss" value = "${item.createDate}" /></td>
								<td><fmt:formatDate pattern = "yyyy-MM-dd hh:MM:ss" value = "${item.updateDate}" /></td>
								<td>
								<a class="btn btn-primary btn-sm" href="/item/show?id=<c:out value='${item.id}' />">show</a>
									&nbsp; 
								<a class="btn btn-warning btn-sm" href="/item/edit?id=<c:out value='${item.id}' />">edit</a>
									&nbsp; 
									<a class="btn btn-danger btn-sm"	href="/item/delete?id=<c:out value='${item.id}' />">delete</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	
			</div>
			<div class="col-sm-1"></div>
		</div>
	</div>
</body>
</html>