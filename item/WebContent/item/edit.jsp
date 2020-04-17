<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Edit Item</title>
</head>
<body>

<div class="jumbotron text-center">
		<h2>Edit Item</h2>

	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">		
					<ul class="nav nav-pills nav-stacked">
						<li><a href="/item/">Home</a></li>
						<li><a href="/item/list">Item List</a></li>
						<li><a href="/item/new">Add Item </a></li>		
					</ul>

			</div>
			<div class="col-sm-4">				
				
				<form class="form-outline" action="/item/update" method="post">
					<input type="hidden" id="id" name="id" value="${item.id}">
					<label for="name">Name:</label> 
					<input class="form-control" type="text" id="name" name="name" value="${item.name}">
					<label for="description">Description:</label>
					<textarea class="form-control" rows="5" id="description" name="description">${item.description}</textarea><br>
					
					<input type="submit" value="Submit" class="btn btn-warning">
				</form>

			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>

	
</body>
</html>