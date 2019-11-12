<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logging In</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<% 
session.setAttribute("sessionId",""); 
%>
<div class="col-md-3">

<form action="Login" method="post" class="form-group">

<div style="color: #FF0000;">${errorMessage}</div>

<label>USERID : </label>
<input type="number" name="userId" class="form-control"/><br>

<label>PASSWORD : </label>
<input type="passWord" name="passWord" class="form-control"/><br>

<input type="submit" value="Sign In" class="btn btn-primary">
</form>
</div>
</body>
<script style="text/javascript" src="scripts/script2.js"></script>
</html>