<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selection Committee</title>
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
		
		<div id="textColumnLeft">
			<label id="boldHeader">Welcome To Selection Committee</label><br/>
			Lviv Polytechnic National University is the largest scientific university in Lviv.
			Since its foundation in 1844, it was one of the most important centres of science 
			and technological development in Central Europe. In the interbellum period,
			the Polytechnic was one of the most important technical colleges in Poland, 
			together with the Warsaw Polytechnic. 
			Today the University is also the National Defense University (Military Institution).<br/>
			For admission you must <a href="jsp/login.jsp">login</a>
		</div>
		<jsp:include page="/jsp/faculties.jsp"></jsp:include>

	</div><!-- #content-->

	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->
	
</body>
</html>