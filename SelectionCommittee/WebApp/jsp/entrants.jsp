<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<table id="hor-minimalist-a">
		<tr>
			<th>Rate</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Status</th>
			<th>Certificate</th>
			<th>Mathematics</th>
			<th>Physics</th>
			<th>English</th>
			<th>Ukrainian</th>
			<th>AVG</th>
		</tr>
		<c:set var="count" value="1" scope="page" />
		<c:forEach var="entrant" items="${faculty.entrants}" varStatus="entrantsLoop">
		<tr>
			<td><c:out value="${count}"></c:out></td>
			<td><c:out value="${entrant.firstName}"></c:out></td>
			<td><c:out value="${entrant.lastName}"></c:out></td>
			<td><c:out value="${entrant.status}"></c:out></td>
			<td><c:out value="${entrant.marks.certificate}"></c:out></td>
			<td><c:out value="${entrant.marks.mathematics}"></c:out></td>
			<td><c:out value="${entrant.marks.physics}"></c:out></td>
			<td><c:out value="${entrant.marks.english}"></c:out></td>
			<td><c:out value="${entrant.marks.ukrainian}"></c:out></td>
			<td><c:out value="${entrant.marks.avgMark}"></c:out></td>
			<c:set var="count" value="${count + 1}" scope="page"/>
		</tr>
		</c:forEach>
	</table>