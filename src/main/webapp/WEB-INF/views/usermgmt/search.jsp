<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html lang="en" ng-app="socUserMgmtApp"> -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Search</title>
<!-- Import all the required CSS and JS files -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.common.min.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.default.min.css"/>"></link>

<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.1.js"/>"></script>
<script	type="text/javascript" src="<c:url value="/resources/js/vendor/kendo.all.min.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-route.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-resource.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/controller/usermgmt_controller.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/service/usermgmt_service.js"/>"></script>
</head>
<body>
<input type="hidden" id="context" value="<%=request.getContextPath()%>" />

<!-- <div ng-controller="socUserCtrl"> -->
<div >

	<!-- <div id="example">
    	<div id="grid"></div>
	</div> -->
	<ul>
		Hello friends
		<!-- <li ng-repeat="socUser in socusers">		
	    	<p>{{socUser.firstName}}</p>
	        <p>{{socUser.lastName}}</p>
	 	</li> -->
 	</ul>
</div>

</body>
</html>