<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Notice</title>
<link href='<c:url value="/resources/css/bootstrap.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/css/notice/notice.css"/>' rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<br/>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<div>
		<span id="searchTitle" > <b>Notice Board</b></span> 
	</div>
	<br/>

	<div id ="content">
		<c:forEach items="${noticeDetailList}" var="noticeDetail">
			<div class="noticePanel panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title"><a href= '<c:url value="/notice/view/${noticeDetail.noticeId}"/>'>${noticeDetail.noticeTitle}</a>
						<span id="noticeDate">${noticeDetail.noticeDate}</span> 
					</h3>
				</div>
				<div class="panel-body">${noticeDetail.noticeDesc}</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>