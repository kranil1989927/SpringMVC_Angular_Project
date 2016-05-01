<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>View User Details</title>
<link rel="shortcut icon" type="image/x-icon" href="/images/favicon.ico" />
</head>
<body>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<jsp:include page="../header.jsp" />
	<input type="hidden" id="userId" value="${userId}">
	
	<fieldset class="row1">
		<div align="right">
			<button class="button">Edit</button>
		</div>
	</fieldset>
	<fieldset class="profileDetails">
		<legend>Personal Details </legend>
		<div class="container">
			<div class="personalInformation">
				<p>
					<label>First Name </label> <span>${socUserDetails.firstName}</span> 
					<label>Middle Name </label> <span>${socUserDetails.middleName}</span> 
					<label>Last Name </label> <span>${socUserDetails.lastName}</span>
				</p>
				<p>
					<label>User Name </label> <span>${socUserDetails.userName}</span>
				</p>
				<p>
					<label>Email </label> <span>${socUserDetails.emailId}</span>
				</p>
				<p>
					<label>PAN Number </label> <span>${socUserDetails.panNo}</span>
				</p>
				<p>
					<label>Mobile </label> <span>${socUserDetails.phoneNo}</span>
				</p>
			</div>
			<div class="uploadImage">
				<img  src="data:image/jpeg;base64,${socUserDetails.profileImage}" height="120px" width="120px"/>
			</div>
		</div>
	</fieldset>

	<fieldset class="row1">
		<legend>Residential Information </legend>
		<p>
			<label>Address </label> <span>${socUserDetails.address}</span>
		</p>
		<p>
			<label>No. of Members </label> <span>${socUserDetails.noOfMembers}</span>
		</p>
		<p>
			<label>Resident Type </label> <span>${socUserDetails.isOwner}</span>
		</p>
		<p>
			<label>Start Date </label> <span>${socUserDetails.startDate}</span> 
			<label>End Date </label> <span>${socUserDetails.endDate}</span>
		</p>

	</fieldset>
</body>
</html>