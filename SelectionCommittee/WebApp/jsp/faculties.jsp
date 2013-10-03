<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<table id="hor-minimalist-a">
		<tr>
			<th>Faculty</th>
			<th>Seats</th>
			<th>Applications</th>
			<th>Reception</th>
		</tr>
		<c:forEach var="faculty" items="${faculties}" varStatus="facultyLoop">
		<tr>
			<td>
				<a href="/SelectionCommittee/faculty?faculty=<c:out value="${faculty.id}"></c:out>">
					<c:out value="${faculty.name}"></c:out>
				</a>
			</td>
			<td><c:out value="${faculty.seatsCount}"></c:out></td>
			<td><c:out value="${fn:length(faculty.entrants)}"></c:out></td>
			<td><c:out value="${faculty.reception}"></c:out></td>
		</tr>
		</c:forEach>
	</table>