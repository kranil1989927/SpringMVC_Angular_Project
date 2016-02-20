<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Home Page</title>

</head>
<body>
	<h1>Society Management</h1>
	<c:set var="context" value="<%=request.getContextPath()%>" />
	<div id='cssmenu'>
		<ul>
			<li class='active'><a href='#'><span>Home</span></a></li>
			<c:forEach var="topModule" items="${topModuleList}">
				<li class='has-sub'><a href='#'><span>${topModule}</span></a>
					<ul>
						<c:forEach items="${subModuleMap}" var="entry">
							<c:choose>
								<c:when test="${entry.key == topModule }">
									<c:forEach items="${entry.value}" var="mapEntry">. 
       					<li><a href='${mapEntry.moduleUrl}'><span>${mapEntry.moduleName}</span></a></li>
									</c:forEach>
								</c:when>
							</c:choose>
						</c:forEach>
					</ul></li>
			</c:forEach>
			<li class='active'><a href='<c:url value="/j_spring_security_logout"/>'><span>Log out</span></a></li>
		</ul>
	</div>
	
	<!-- Import page related CSS and Scripts -->
	<link href="<c:url value="/resources/css/styless.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/jquery-latest.js" />"></script>
	<script src="<c:url value="/resources/js/script.js"/>"></script>
</body>
</html>
