<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Page 1-1</a></li>
      <li><a href="#">Page 1-2</a></li>
      <li><a href="#">Page 1-3</a></li>
    </ul>
   
    
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

 <table  class="table table-striped">
    	<tr> 
    		<td>NUM</td> <td>TITLE</td> <td>WRITER</td> <td>CONTENTS</td> <td>REGDATE</td> <td>HIT</td>
    			
    	</tr>
    	
    	<c:forEach items="${list}" var="dto">  	
    		<tr>
    			<td>${dto.num}</td>
    			<td>${dto.title}</td>
    			<td>${dto.writer}</td>
    			<td>${dto.contents}</td>
    			<td>${dto.regdate}</td>
    			<td>${dto.hit}</td>
    		</tr>
    	</c:forEach>
    </table>
    
    <form action="./boardWrite.board">
    	<button type="submit" class="btn btn-default">WRITE</button>
    </form>
   
</body>
</html>