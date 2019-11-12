<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="col-md-3"> 
<form action="Registration" method="post">

<label>USERID : </label>
<input type="number" name="userId" class="form-control"/><br>

<label>PASSWORD : </label>
<input type="passWord" name="passWord"class="form-control"/><br>

<select name="userType">
		<option value="employee">EMPLOYEE</option>
		<option value="customer">CUSTOMER</option>
		</select><br><br>

<input type="submit" value="Sign Up" class="btn btn-primary">
<br><br>

<a href="login.jsp">Account Already Exist</a>
</form>
</div>
</body>
<script style="text/javascript" src="scripts/script1.js"></script>
</html>