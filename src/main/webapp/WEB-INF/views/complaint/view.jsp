<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Complaint</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div>
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Raise Complaint</b></span> 
			</div>
			<form class="socuser" name="socUserMaintain">
				<fieldset class="profileDetails">
					<legend>Complaint Details </legend>
					<div class="container">
						<div class="personalInformation">
						<p>
							<label>Complaint No. </label> <input type="text"  id="firstName" /> 
						</p>
						<p>
							<label>Type </label> <input type="text"  id="userName"/>
						</p>
						<p>
							<label>Description </label>
							<textarea rows="3" cols="100"  id="address"></textarea>
						</p>
						<p>
							<label>Mobile </label> <input type="text" id="phoneNo" />
						</p>
						<p>
							<label>Status </label> <input type="text"  id="panNo" />
						</p>
						<p>
							<label>Available Time </label> <input type="text"  id="panNo" />
						</p>
						<p>
							<label>Complaint Log </label>
							<textarea rows="3" cols="100"  id="address"></textarea>
						</p>
						</div>
					</div>
				</fieldset>
				
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="Add" />
						<button class="button">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>