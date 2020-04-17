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
<title>Add/Update Item</title>
</head>
<body>

	<div class="jumbotron text-center">
		<h2>Show Item</h2>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-sm-2">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="/item/">Home</a></li>
					<li><a href="/item/list">Item List</a></li>
					<li><a href="/item/new">Add Item</a></li>
				</ul>
			</div>
			
			<div class="col-sm-6">			
			<c:if test="${success != null}">
				<div class="alert alert-success alert-dismissible fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success!</strong> ${success}
				</div>
			</c:if>
			
			<c:if test="${update != null}">
				<div class="alert alert-success alert-dismissible fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Success!</strong> ${update}
				</div>
			</c:if>
			
				<div class="well well-lg">
					<label for="id">ID :</label>
					<c:out value='${item.id}' />
					<br> <label for="name">Name :</label>
					<c:out value='${item.name}' />
					<br> <label for="description">Description:</label>
					<c:out value='${item.description}' />
					<br> <label for="address">createDate:</label>
					<fmt:formatDate pattern = "yyyy-MM-dd hh:MM:ss" value = "${item.createDate}"/>
					<br> <label for="address">updateDate:</label>
					<fmt:formatDate pattern = "yyyy-MM-dd hh:MM:ss" value = "${item.updateDate}"/>
				</div>
				<a class="btn btn-warning" href="/item/edit?id=<c:out value='${item.id}' />">Edit</a>
					&nbsp; 
					<a class="btn btn-danger" href="/item/delete?id=<c:out value='${item.id}' />">Delete</a>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</div>
</body>
</html>