<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<title>Item Add</title>
</head>
<body>


	<div class="jumbotron text-center">
		<h2>Add Item</h2>

	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="/item/">Home</a></li>
					<li><a href="/item/list">Item List</a></li>					
				</ul>
				
			</div>
			<div class="col-sm-4">							
				<form class="form-outline" action="/item/insert" method="post">
					<label for="name">Name:</label>
					 <input class="form-control" type="text" id="name" name="name">
					<label for="description">Description:</label>
					<textarea class="form-control" rows="5" id="description" name="description"></textarea><br>
					<input type="submit" value="Submit" class="btn btn-success">
				</form>

			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>