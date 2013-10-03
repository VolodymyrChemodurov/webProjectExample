<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Page</title>
<link rel="stylesheet" href="/SelectionCommittee/css/style.css" type="text/css" media="screen, projection" />
<link rel="stylesheet" href="/SelectionCommittee/css/table_style.css" type="text/css" media="screen, projection" />
</head>
<body>

	<div id="wrapper">

	<div id="header">
		<img src="/SelectionCommittee/images/Color_Globes_001.png" id="logo">
		<jsp:include page="user_name.jsp"></jsp:include>
	</div><!-- #header-->

	<div id="content">
	
		<label id="tableHeader"><c:out value="${faculty.name}"></c:out></label>
		<jsp:include page="entrants.jsp"></jsp:include>
		
		<c:if test="${admin}">
			<a href="/SelectionCommittee/entrants" class="back"><img src="/SelectionCommittee/images/back.png" title="go back"></img></a><br/>
			<c:if test="${faculty.reception == 'YES'}">
				<form action="close_faculty?fac_id=<c:out value="${faculty.id}"></c:out>" method="post">
					<input type="submit" value="Close list" id="submit">
				</form>	
			</c:if>
		</c:if>
	
		<c:if test="${user}">
			<a href="/SelectionCommittee/faculties" class="back"><img src="/SelectionCommittee/images/back.png" title="go back"></img></a><br/>
			<c:if test="${faculty.reception == 'YES'}">
				<c:if test="${!allreadyRegistred}">
					<form action="jsp/marks_form.jsp" method="post">
						<input type="submit" value="Register on" id="submit">
					</form>
				</c:if>
			</c:if>
		</c:if>
	
	</div><!-- #content-->

	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->

</body>
</html>