<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.fa.spring.util.SortUtils" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>List Books</title>
	
	<!-- Reference Bootstrap files -->
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</body>
</html>

</head>

<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid mt-5 py-5" style="background-color: rgba(236, 209, 118, 0.726);">
		  <div class="container">
		    <h1 class="display-4">Library Management </h1>
		    <p class="lead">A program created to store and organize the names of books. </p>
		  </div>
		</div>
	
		<div class="card mt-5">
			<div class="card-header lead" style="background-color: rgb(204, 204, 204)">Books</div>
			<div class="card-body">
		  	
	            <!--  add a search box -->
	            <form:form action="searchBook" method="GET">
	                <div class="row">
		                <div class="col-md-3">	      
			                <input class="form-control mb-3 col-md-6" type="text" name="searchName" placeholder="Search" aria-label="Search">
		                </div>
		                <div class="col-md-6">	 
			                <input type="submit" value="Search" class="btn btn-warning mb-3" />
		                </div>
	                </div>
	            </form:form>
		  	
		    	<table class="table table-bordered mytable" >
		            <thead class="thead-light" >
		            
    			<!-- setup header links for sorting -->

				<!-- create a sort link for ID of the books -->
				<c:url var="sortLinkId" value="/book/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.ID) %>" />
				</c:url>					
				
				<c:url var="sortLinkName" value="/book/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.NAME) %>" />
				</c:url>					

				<!-- create a sort link for author -->
				<c:url var="sortLinkAuthor" value="/book/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.AUTHOR) %>" />
				</c:url>					

				<!-- create a sort link for literature -->
				<c:url var="sortLinkLiterature" value="/book/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LITERATURE) %>" />
				</c:url>
				
				<!-- create a sort link for year -->
				<c:url var="sortLinkYear" value="/book/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.YEAR) %>" />
				</c:url>
		            
		              <tr class="text-center" style="background-color: rgb(204, 230, 255)">
					      <th scope="col"><a href="${sortLinkId}">ID</a></th>
					      <th scope="col"><a href="${sortLinkName}">Book Name</a></th>
					      <th scope="col"><a href="${sortLinkAuthor}">Author</a></th>
					      <th scope="col"><a href="${sortLinkLiterature}">Literature</a></th>
					      <th scope="col"><a href="${sortLinkYear}">Publication Year</a></th>
					      <th scope="col">Action</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var = "book" items="${bookList}">
				  	
				  		<!-- create updateLink with book id -->
				  		<c:url var = "updateLink" value="/book/updateBook">
				  			<c:param name="bookId" value="${book.id}"/>
				  		</c:url>
				  		
				  		<!-- create deleteLink with book id -->
				  		<c:url var = "deleteLink" value="/book/deleteBook">
				  			<c:param name="bookId" value="${book.id}"/>
				  		</c:url>
				  		
				    	<tr class="text-center align-middle">
					      <td>${book.id}</td>
					      <td>${book.name}</td>
					      <td>${book.author}</td>
					      <td>${book.literature}</td>
					      <td>${book.year}</td>
					      
					      <!-- display edit text -->
					      <td>
					      	<a href = "${updateLink}" class="btn btn-outline-danger" role="button">Edit</a>
					      	<a href = "${deleteLink}" class="btn btn-outline-success" role="button"
					      	onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
					      	
					      </td>
					    </tr>
				  	</c:forEach>
				  </tbody>
				</table>
		    
		    
		    <a href="addBook" class="btn btn-primary">Add Book</a>
		  </div>
		</div>
	</div>
	
	<!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
    -->
    
</body>

</html>