<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="/SelectionCommittee/css/style.css" type="text/css" media="screen, projection" />
</head>
<body>
	<div id="wrapper">

	<div id="header">
		<img src="/SelectionCommittee/images/Color_Globes_001.png" id="logo">
		<jsp:include page="user_name.jsp"></jsp:include>
	</div><!-- #header-->

	<div id="content">
		<form action="/SelectionCommittee/login" method="post">
			<div class="main">
				<div class="field">
					<label><c:out value="${message}"></c:out></label>
				</div>
				<div class="field">
					<label for="log">Login:</label>
					<input name="login" id="log"/>
				</div>
				<div class="field">
					<label for="pas">Password:</label>
					<input name="password" type="password" id="pas"/>
				</div>
				<div class="field">
					<input type="submit" value="Ok" id="submit"/><br/>
				</div>
				<div class="link">
					<a href="/SelectionCommittee/jsp/registration.jsp">register</a>
				</div>
			</div>
		</form>
	</div><!-- #content-->

	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->
</body>
</html>