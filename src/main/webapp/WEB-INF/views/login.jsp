<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Login</title>
</head>
<body>

	<div id="container">
		<c:if test="${not empty error}">
			<div class="error">
				${error}
			</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">
				${msg}
			</div>
		</c:if>
		<form name="loginform" action="<c:url value='j_spring_security_check'/>" method="POST">
			<label for="name">Username:</label> 
			<input type="name" name='j_username' /> 
			<label for="username">Password:</label>
			<input type="password" name='j_password'/>
			<div id="lower">
				<input type="submit" value="Login">
				<input type="reset" value="Cancel">
			</div>
		</form>
	</div>
	
	<!-- Import Login CSS -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/login.css"/>"/>
</body>
</html>