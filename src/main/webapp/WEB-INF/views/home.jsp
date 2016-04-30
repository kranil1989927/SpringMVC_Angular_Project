<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>Home</title>
		<link rel="shortcut icon" type="image/x-icon" href= "/images/favicon.ico" />
	</head>
	<body>
		<c:set var="context" value="<%=request.getContextPath()%>" />
		<jsp:include page="header.jsp" />  
	</body>
</html>
