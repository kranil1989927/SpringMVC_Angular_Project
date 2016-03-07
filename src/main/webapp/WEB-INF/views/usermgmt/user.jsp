<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
<script src="<c:url value="/resources/js/vendor/jquery-1.12.1.js"/>"></script>
<script	src="<c:url value="/resources/js/vendor/jquery-ui.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/usermgmt/usermgmt.css"/>"></link>
<script>
	$(document).ready(function() {
		$("#startDate, #endDate").datepicker();
	});
</script>
</head>
<body>

	<form action="" class="socuser">
		<h1>Add New User</h1>
		<fieldset class="row1">
			<legend>Personal Details </legend>
			<p>
				<label>First Name </label> <input type="text" /> 
				<label>Middle Name </label> <input type="text" /> 
				<label>Last Name </label> <input type="text" />
			</p>
			<p>
				<label>User Name </label> <input type="text" />
			</p>
			<p>
				<label>Email </label> <input type="text" /> 
				<label>PAN Number </label> <input type="text" maxlength="10" />
			</p>
			<p>
				<label>Mobile </label> <input type="text" maxlength="10" />
			</p>


		</fieldset>
		<fieldset class="row1">
			<legend>Residential Information </legend>
			<p>
				<label>Address </label>
				<textarea rows="3" cols="54"></textarea>
			</p>
			<p>
				<label>No. of Members </label> <input type="text" maxlength="2" />
			</p>
			<p>
				<label>Is Owner? </label> 
				<input type="radio" name="isOwner" value="owner" checked /> <label class="residenttype">Owner</label>
				<input type="radio" name="isOwner" value="tenant" /> <label class="residenttype">Tenant</label>
			</p>
			<p>
				<label>Start Date </label> <input type="text" id="startDate" />
			</p>
			<p>
				<label>End Date </label> <input type="text" id="endDate" />
			</p>
		</fieldset>
		<fieldset class="row1">
			<div align="center">
				<button class="button">Add User</button>
				<button class="button">Cancel</button>
			</div>
		</fieldset>
	</form>

</body>
</html>