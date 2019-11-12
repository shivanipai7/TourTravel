<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript">
function updateTour(tourCode) {
	
	document.getElementById("div1").style.display = "none";
	document.getElementById("div2").style.display = "none";
	document.getElementById("div3").style.display = "none";
	document.getElementById("div4").style.display = "block";
	
	document.getElementById("tourCode").value = tourCode;
	
}
</script>
</head>
<body>
<div class="col-md-4">
<button class="btn btn-primary" id="button1">Update Tours Package</button>
<button class="btn btn-primary" id="button2">Customer BookTours</button>
<button class="btn btn-primary" id="button3">Add Tour</button>
</div>
<br>
<br>
<br>

<div class="col-md-12" id="div1" >
<table class="table">
<tr>
<th> tourId </th>
<th> tourName </th>
<th> source </th>
<th> destination </th>
<th> description </th>
<th> price </th>
<th> Update </th>
</tr>
<c:forEach var="tour" items="${ requestScope.tourList }">
	<tr>
		<td><c:out  value="${tour.tourCode}" /></td>
		<td><c:out  value="${tour.tourName}" /></td>
		<td><c:out  value="${tour.sourcePlace}" /></td>
		<td><c:out  value="${tour.destinationPlace}" /></td>
		<td><c:out  value="${tour.description}" /></td>
		<td><c:out  value="${tour.price}" /></td>
		<td><input type="Submit" onclick="updateTour(${tour.tourCode})" value="Update" class="btn btn-info"></td>
		<td></td>
	</tr>
	</c:forEach>
</table>
<br>
<form action="Filter1" method="post" class="col-md-3">
<label>Source Place : </label>
<input type="text" name="sourcePlace" class="form-control"/><br>
<label>Destination Place: </label>
<input type="text" name="destinationPlace"class="form-control"/><br>
<input type="Submit" value="Filter" class="btn btn-info">
</form>
</div>


<div class="col-md-12" id="div2" style="display:none;">
<table class="table">
<tr>
<th> userId </th>
<th> tourCode </th>
<th> bookingDate </th>
<th> totalTickets </th>
<th> totalAmount </th>
</tr>
<c:forEach var="booking" items="${ requestScope.bookingList }">
	<tr>
		<td><c:out  value="${booking.userId}" /></td>
		<td><c:out  value="${booking.tourCode}" /></td>
		<td><c:out  value="${booking.bookingDate}" /></td>
		<td><c:out  value="${booking.totalTickets}" /></td>
		<td><c:out  value="${booking.totalAmount}" /></td>
		<td></td>
	</tr>
	</c:forEach>
</table><br>

<form action="ByTourName" method="post" class="col-md-3">
<label>TOURNAME : </label>
<input type="text" name="tourName2"class="form-control"/><br>
<input type="Submit" value="Filter" class="btn btn-info">
</form>

</div>


<div class="AddTour" id="div3" style="display:none;">
<form action="AddTour" method="post" class="col-md-3">
<label>TOURCODE : </label>
<input type="text" name="tourCode" class="form-control"/><br>
<label>TOURNAME : </label>
<input type="text" name="tourName"class="form-control"/><br>
<label> SOURCE PLACE: </label>
<input type="text" name="sourcePlace" class="form-control"/><br>
<label>DESTINATION PLACE : </label>
<input type="text" name="destinationPlace"class="form-control"/><br>
<label>START DATE : </label>
<input type="date" name="startDate"class="form-control"/><br>
<label>END DATE : </label>
<input type="date" name="endDate"class="form-control"/><br>
<label>PRICE : </label>
<input type="text" name="price"class="form-control"/><br>
<input type="submit" value="AddTour" class="btn btn-primary">
<input type="reset" value="Reset" id="btn1" class="btn btn-danger" id="resetBtn">
</form>
</div>


<div class="UpdateTour" id="div4" style="display:none;">
<form action="UpdateTour" method="post" class="col-md-3">
<label>TOURCODE : </label>
<input type="text" name="tourCode" id="tourCode" class="form-control" readonly/><br>
<label>TOURNAME : </label>
<input type="text" name="tourName"class="form-control"/><br>
<label> SOURCE PLACE : </label>
<input type="text" name="sourcePlace" class="form-control"/><br>
<label>DESTINATION PLACE: </label>
<input type="text" name="destinationPlace"class="form-control"/><br>
<label>START DATE:</label>
<input type="date" name="startDate"class="form-control"/><br>
<label>END DATE : </label>
<input type="date" name="endDate"class="form-control"/><br>
<label>PRICE : </label>
<input type="number" name="price"class="form-control"/><br>
<input type="submit" value="UpdateTour" class="btn btn-primary">
<input type="reset" value="Reset"  class="btn btn-danger" id="resetBtn">
</form>
</div>


</body>
<script style="text/javascript" src="scripts/script2.js"></script>
</html>