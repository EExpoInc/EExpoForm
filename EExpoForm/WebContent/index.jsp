<%@page import="eexpoform.FormBase"%>
<%@page import="eexpoforms.test.Main"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <%@taglib prefix="ex" uri="http://eexponews.com/eexpoform"%> --%>
<%@taglib prefix="ex" tagdir="/WEB-INF/tags"%>

<%
Object entity = request.getAttribute("entity");

if(entity == null){
	entity = Main.genEntity();	
}%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<title>Test Form</title>
</head>
<body> 

	<div class="container">
		<div class="row">
			<h3>Crud Filter</h3>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<ex:formBase bean="<%=entity%>" readOnly="<%=true%>" action="~/Teste"/>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<ex:formBase bean="<%=entity%>"  action="~/Teste"/>
			</div>
		</div>
	</div>
</body>
</html>