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
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<div ng-app="socUserMgmtApp" ng-controller="socUserCtrl">
		<div id="example">
			<div id="grid"></div>
		</div>
	</div>
</body>
</html>