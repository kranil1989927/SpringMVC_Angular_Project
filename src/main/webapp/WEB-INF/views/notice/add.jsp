<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Notice</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Add Notice</b></span> 
			</div>
			<form class="socuser" name="noticeDetail" modelAttribute="noticeDetailForm" method="POST">
				<fieldset class="profileDetails">
					<legend>Notice Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Title </label> 
							<input type="text"  id="noticeTitle" />
						</p>
						<p>
							<label>Description </label>
							<textarea rows="4" cols="100"  id="noticeDesc"></textarea>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Add" id="addNotice"/>
						<button class="button">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>