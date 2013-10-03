<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Marks Page</title>
<link rel="stylesheet" href="/SelectionCommittee/css/style.css" type="text/css" media="screen, projection" />
<body>

	<div id="wrapper">

	<div id="header">
		<img src="/SelectionCommittee/images/Color_Globes_001.png" id="logo">
		<jsp:include page="user_name.jsp"></jsp:include>
	</div><!-- #header-->

	<div id="content">
	
		<form action="/SelectionCommittee/process_marks" method="post">
			<div class="main">
				<div class="field">
					<label><c:out value="${message}"></c:out></label>
				</div>
				<div class="field">
					<label for="cer">Certificate:</label>
					<input name="certificate" id="cer" value="<c:out value="${marks.certificate}"></c:out>"/>
				</div>
				<div class="field">
					<label for="mat">Mathematics:</label>
					<input name="mathematics" id="mat" value="<c:out value="${marks.mathematics}"></c:out>"/>
				</div>
				<div class="field">
					<label for="phy">Physics:</label>
					<input name="physics" id="phy" value="<c:out value="${marks.physics}"></c:out>"/>
				</div>
				<div class="field">
					<label for="en">English:</label>
					<input name="english" id="en" value="<c:out value="${marks.english}"></c:out>"/>
				</div>
				<div class="field">
					<label for="ua">Ukrainian:</label>
					<input name="ukrainian" id="ua" value="<c:out value="${marks.ukrainian}"></c:out>"/>
				</div>
				
				<div class="field">
					<input type="submit" value="Ok" id="submit"/><br/>
					<a href="/SelectionCommittee/faculties" class="back"><img src="/SelectionCommittee/images/back.png" title="go back"></img></a>
				</div>
			</div>
		</form>
		
	</div><!-- #content-->

	</div><!-- #wrapper -->

	<div id="footer">
	</div><!-- #footer -->
	
</body>
</html>