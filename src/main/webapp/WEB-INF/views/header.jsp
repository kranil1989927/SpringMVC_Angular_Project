<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js"/>"></script> 
<script src="<c:url value="/resources/js/functions.js"/>"></script>
<div id="wrapper">
	<h1 id="logo">
		<a href="#">Society</a>
	</h1>
	<header class="header">
		<nav id="navigation">
			<ul>
				<li><a href='<c:url value="/home"/>'>Home</a></li>
				<li><a href="#">Manage User<span></span></a>
					<ul>
						<li><a href='<c:url value="/user/add"/>'>Add User</a></li>
						<li><a href='<c:url value="/user/search"/>'>View All</a></li>
					</ul></li>
				<li><a href="#">Manage Complaints<span></span></a>
					<ul>
						<li><a href='<c:url value="/complaint/add"/>'>Add Complaint</a></li>
						<li><a href='<c:url value="/complaint/search"/>'>View All</a></li>
					</ul></li>
				<li><a href="#">Manage Amenities<span></span></a>
					<ul>
						<li><a href="#">Request Amenities</a></li>
						<li><a href="#">View Users</a></li>
					</ul></li>
				<li><a href="#">Notice Board<span></span></a>
					<ul>
						<li><a href='<c:url value="/notice/add"/>'>Add Notice</a></li>
						<li><a href='<c:url value="/notice/search"/>'>View All</a></li>
					</ul></li>
				<li><a href='<c:url value="/j_spring_security_logout"/>'>Logout</a></li>
			</ul>
		</nav>
		<div class="cl">&nbsp;</div>
	</header>
</div>

<!-- Import all the required CSS and JS files -->
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.common.min.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.default.min.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/usermgmt/usermgmt.css"/>"></link>

<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/kendo.all.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-route.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-resource.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/fileUpload.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/service/usermgmt_service.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/controller/usermgmt_controller.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/directive/usermgmt_directive.js"/>"></script>