<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
<head>

   <title>Raise Complaint</title>
   <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.js" />"></script>
    <script src="<c:url value="/resources/js/script.js" />"></script>
</head>
	<body>
		<h1>
	Society Management	
</h1>
	<div id='cssmenu'>
<ul>
 <li class='active'><a href="${pageContext.request.contextPath}/user/addUser">Add a User</a></li>
 <li><a href="${pageContext.request.contextPath}/user/getAllUsers">All User</a></li>
 <li><a href="${pageContext.request.contextPath}/complaint/raiseComplaint">Raise Complaint</a></li>
 <li><a href="${pageContext.request.contextPath}/complaint/getAllComplaints">All Complaints</a></li>
 <li><a href="${pageContext.request.contextPath}/login"> Logout here</a></li>
</ul>
</div>
		<h2 id="banner">Raise Complaint</h2> 
		
		<form:form modelAttribute="complaintDetailsFormBean" action="/maintain/complaint/raise" method="POST" >
		<table width="50%" border="1">
			<tr>
				<td>Complaint Type</td>
				<td><form:select path="complaintType">
				<form:option value="NONE" label="--- Select ---"/>
				<form:option value="Elecctric" label="ELECTRICAL"/>
				<form:option value="Plumber" label="PLUMBER"/>
				<form:option value="Painting" label="PAINTING"/>
    			<!-- <form:options items="${states}" />  --> 
				</form:select>
				</td>
			</tr>
			<tr>
				<td>Complaint Description</td>
				<td><form:textarea path="complaintDescription" rows="5" cols="30" />
				</td>
			</tr>
		<tr>
				<td>Phone No</td>
				<td><form:input path="phoneNo" />
				</td>
			</tr>
			<tr>
				<td>Available Time</td>
				<td><form:input path="availableTime" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login" />
				</td>
			</tr>
		</table>
	</form:form> 
	</body>
</html>