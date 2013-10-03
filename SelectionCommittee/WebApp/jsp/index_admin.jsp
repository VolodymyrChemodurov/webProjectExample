<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/SelectionCommittee/css/style.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="/SelectionCommittee/css/table_style.css" type="text/css" media="screen, projection" />
<title>Admin page</title>
</head>
<body>

	<div id="wrapper">

	<div id="header">
		<img src="/SelectionCommittee/images/Color_Globes_001.png" id="logo">
		<jsp:include page="user_name.jsp"></jsp:include>
	</div><!-- #header-->

	<div id="content">
		<c:choose>
			<c:when test="${fn:length(entrants) gt 0}">
				<hr>
				<label id="tableHeader">New entrants:</label>
				<form action="/SelectionCommittee/submit_roll" method="post">
				<table id="hor-minimalist-a">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Certificate</th>
						<th>Mathematics</th>
						<th>Physics</th>
						<th>English</th>
						<th>Ukrainian</th>
						<th>Mark</th>
					</tr>
					<c:forEach var="entrant" items="${entrants}" varStatus="entrantsLoop">
					<tr>
						<td><c:out value="${entrant.firstName}"></c:out></td>
						<td><c:out value="${entrant.lastName}"></c:out></td>
						<td><c:out value="${entrant.marks.certificate}"></c:out></td>
						<td><c:out value="${entrant.marks.mathematics}"></c:out></td>
						<td><c:out value="${entrant.marks.physics}"></c:out></td>
						<td><c:out value="${entrant.marks.english}"></c:out></td>
						<td><c:out value="${entrant.marks.ukrainian}"></c:out></td>
						<td>
							<input type="checkbox" name="checkedRows" value="<c:out value="${entrant.id}"/>"></input>
						</td>
					</tr>
					</c:forEach>
				</table>
					<input type="submit" value="Confirm" id="submit"/><br/>
				</form>
			</c:when>
			<c:otherwise>
				<label id="tableHeader">No new Entrants.</label>
			</c:otherwise>
		</c:choose>
		<hr>
		<label id="tableHeader">Faculties:</label>
		<jsp:include page="faculties.jsp"></jsp:include>

	</div><!-- #content-->
		
	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->

</body>
</html>