<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Save or Update Book</title>
	<!-- Reference Bootstrap files -->
	<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>

<body>
	<form:form action="saveBook" name="book" method="POST">
		<div class="container">
			<div class="jumbotron jumbotron-fluid mt-5 py-5" style="background-color: rgba(236, 209, 118, 0.726);">
			  <div class="container">
			    <h1 class="display-4">Library Management</h1>
			    <p class="lead">A program created to store and organize the names of books. </p>
			  </div>
			</div>
			
			<div class="card mt-5">
		  		<div class="card-header lead" style="background-color: rgb(204, 204, 204)">Save Book</div>
	  			<div class="card-body">
				
					<!-- Need to associate data with book id -->
					<input type="number" class="visually-hidden" name="id" value="${book.id}">

			
					<div class="input-group my-3">
					 	<span class="input-group-text" id="addon-wrapping">Book Name</span>
					    <input type="text" class="form-control" name="name" placeholder="Book Name" value="${book.name}">
					    <span class="input-group-text" id="addon-wrapping">Author</span>
					    <input type="text" class="form-control" name="author" placeholder="Author" value="${book.author}">
				  	</div>
		
		            <div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Literature</label>
						<select class="form-select" name="literature" >
						  <option selected>${book.literature}<option>
						  <option value="Turkish">Turkish</option>
						  <option value="French">French</option>
		  				  <option value="Russian">Russian</option>
						  <option value="English">English</option>
						  <option value="German">German</option>
						  <option value="Greek">Greek</option>
		  				  <option value="Latin">Latin</option>
						  <option value="American">American</option>
						  <option value="Spanish">Spanish</option>
						  <option value="Indian">Indian</option>
						  <option value="Japan">Japan</option>
						</select>
						<span class="input-group-text" id="addon-wrapping">Pub Year</span>
						<input type="text" class="form-control" name="year" placeholder="Publication Year" value="${book.year}">
						
				  	</div>
				  	<div class="form-group py-2">
				  		<button type="submit" class="btn btn-success pr-3">Save</button>
						<a href="${pageContext.request.contextPath}/book/list" class="btn btn-outline-primary mx-3" role="button">Back to List</a>
					</div>	
				</div>
				

				
			</div>
	
		</div>
	
	  
	</form:form>



</body>

<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    -->
	


</html>