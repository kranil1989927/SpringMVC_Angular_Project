<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
   <title>View all Users</title>
   <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
   <link href="<c:url value="/resources/css/table.css" />" rel="stylesheet">
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
<h2>
	All Users List
</h2>

<table class="gradienttable">
<tr><td>User ID</td><td>User Name</td><td>User Password</td></tr>
<c:forEach var="listValue" items="${userDetailList}">
	<tr><td>${listValue.userId}</td><td>${listValue.userName}</td><td>${listValue.password}</td></tr>			
			</c:forEach>

</table>
</body>
</html>
