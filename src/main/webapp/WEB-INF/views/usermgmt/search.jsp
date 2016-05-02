<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<br/><br/>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<div ng-app="socUserMgmtApp" ng-controller="socUserCtrl as searchCtrl">
		<div id="example">
			<div id="grid"></div>
			<div style="padding-top: 15px;"><span width="100%"></span></div>
			<div>
				<button class="button" data-ng-click="searchCtrl.editUserDetails()" id="edit">Edit</button>
				<button class="button deleteButton" data-ng-click="searchCtrl.deleteUserDetails()" id="delete">Delete</button>
			</div>
		</div>
	</div>
</body>
</html>