<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="main.java.com.epam.model.user.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Entrant Page</title>
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

	<jsp:include page="faculties.jsp"></jsp:include>

	</div><!-- #content-->

	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->
	
</body>
</html>