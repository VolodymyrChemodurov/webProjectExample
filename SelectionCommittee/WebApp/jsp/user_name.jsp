<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ not empty userLastName}">
	Login as: <c:out value="${userLastName}"></c:out>
	<a href="/SelectionCommittee/logout">log out</a>
</c:if>