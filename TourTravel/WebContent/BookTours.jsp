<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tours Booking Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript">
function bookTour(tourCode, tourName, tourPrice) {
	
	document.getElementById("div1").style.display = "none";
	document.getElementById("div2").style.display = "none";
	document.getElementById("div3").style.display = "none";
	document.getElementById("div4").style.display = "block";
	
	document.getElementById("tourCode").value = tourCode;
	document.getElementById("tourName").value = tourName;
	document.getElementById("tourPrice").value = tourPrice;
}

function total() {
	
	totalTickets = document.getElementById("totalTickets").value;
	tourPrice = document.getElementById("tourPrice").value;
	totalAmount = totalTickets * tourPrice;
	
	document.getElementById("totalAmount").value = totalAmount;
}
</script>
</head>
<body>
<div class="col-md-4">
<button class="btn btn-primary" id="button1">Buy Package</button>
<button class="btn btn-primary" id="button2">Past Bookings</button>
<button class="btn btn-primary" id="button3" style="display:none;">Add Tour</button>
</div>
<br>
<br>
<br>
<div class="col-md-12" id="div1">
<table class="table">
<tr>
<th scope="col"> tourCode </th>
<th> tourName </th>
<th> source Place</th>
<th> destination Place</th>
<th> description </th>
<th> price </th>
<th> Booking </th>
</tr>
<c:forEach var="tour" items="${ requestScope.tourList }">
	<tr>
		<td><c:out  value="${tour.tourCode}" /></td>
		<td><c:out  value="${tour.tourName}" /></td>
		<td><c:out  value="${tour.sourcePlace}" /></td>
		<td><c:out  value="${tour.destinationPlace}" /></td>
		<td><c:out  value="${tour.description}" /></td>
		<td><c:out  value="${tour.price}" /></td>
		<td><input type="Submit" onclick="bookTour(${tour.tourCode},'${tour.tourName}',${tour.price})" value="Book" class="btn btn-info"></td>
		<td></td>
	</tr>
	</c:forEach>
</table>
<br>
<form action="Filter" method="post" class="col-md-3">
<label>Source Place: </label>
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
<c:forEach var="booktour" items="${ requestScope.bookTourList }">
	<tr>
		<td><c:out  value="${booktour.userId}" /></td>
		<td><c:out  value="${booktour.tourCode}" /></td>
		<td><c:out  value="${booktour.bookingDate}" /></td>
		<td><c:out  value="${booktour.totalTickets}" /></td>
		<td><c:out  value="${booktour.totalAmount}" /></td>
		<td></td>
	</tr>
	</c:forEach>
</table>
</div>
<div class="PastBookings" id="div3" style="display:none;"></div>
<div class="col-md-3" id="div4" style="display:none;" >
<form action="Book" method="post" >
<label>TOURCODE : </label>
<input type="text" name="tourCode" id="tourCode" class="form-control"  readonly/><br>
<label>TOURNAME : </label>
<input type="text" name="tourName" id="tourName" class="form-control"  readonly/><br>
<label>TOURPRICE : </label>
<input type="text" name=tourPrice id="tourPrice" class="form-control"  readonly/><br>
<label>USERID : </label>
<input type="text" name="userId" class="form-control" value="<%= session.getAttribute("sessionId") %>" readonly/><br>
<label>BOOKING DATE : </label>
<input type="date" name="bookingDate" class="form-control" value="<%= session.getAttribute("sessionDate") %>"  readonly/><br>
<label>TOTAL TICKETS : </label>
<input type="text" name="totalTickets" id="totalTickets" class="form-control" onchange="total()"/><br>
<label>TOTAL AMOUNT : </label>
<input type="text" name="totalAmount" id="totalAmount" class="form-control" readonly/><br>
<input type="submit" value="Book" class="btn btn-primary">
</form>
</div>

</body>
<script style="text/javascript" src="scripts/script2.js"></script>
</html>