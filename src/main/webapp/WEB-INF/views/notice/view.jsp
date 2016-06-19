<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Notice</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="noticeId" value="${noticeId}" />
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>View Notice - ${noticeId}</b></span> 
			</div>
			<form class="socuser" id="noticeViewForm">
				<fieldset class="profileDetails">
					<legend>Notice Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Title </label> 
							<span class="viewName">${noticeDetails.noticeTitle}</span>
						</p>
						<p>
							<label>Description </label>
							<span class="viewName">${noticeDetails.noticeDescription} </span>
						</p>
						<p>
							<label>Notice Date </label> 
							<span class="viewName">${noticeDetails.noticeDate} </span>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateNotice"/>
						<button class="button">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>