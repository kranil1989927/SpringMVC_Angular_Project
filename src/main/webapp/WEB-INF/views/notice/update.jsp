<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Notice</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<input type="hidden" id="noticeId" value="${noticeId}" />
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Update Notice - ${noticeId}</b></span> 
			</div>
			<form class="socuser" name="noticeDetail" modelAttribute="noticeDetailForm" method="POST">
				<fieldset class="profileDetails">
					<legend>Notice Details </legend>
					<div class="container">
						<div class="personalInformation">
							<p>
								<label>Title </label> 
								<input type="text" id="noticeTitle"  value ="${noticeDetails.noticeTitle}"/>
							</p>
							<p>
								<label>Description </label>
								<textarea rows="4" cols="100"  id="noticeDesc">${noticeDetails.noticeDescription}</textarea>
							</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Update" id="updateNotice"/>
						<button class="button" id="cancelUpdateNotice">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>