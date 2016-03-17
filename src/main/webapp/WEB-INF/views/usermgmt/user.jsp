<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" data-ng-app="socUserMgmtApp"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New User</title>
<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css"/>"></link> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.common.min.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/grid/kendo.default.min.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>"></link>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/usermgmt/usermgmt.css"/>"></link>

<script type="text/javascript" src="<c:url value="/resources/js/vendor/jquery-1.12.1.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/vendor/jquery-ui.js"/>"></script>
<script	type="text/javascript" src="<c:url value="/resources/js/vendor/kendo.all.min.js"/>"></script> 
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-route.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/vendor/angular-resource.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/app.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/controller/usermgmt_controller.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/usermgmt/service/usermgmt_service.js"/>"></script>
<script>
	$(document).ready(function() {
		$("#startDate, #endDate").datepicker();
	});
</script>
</head>
<body data-ng-controller="socUserCtrl as newCtrl">
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	
	<div ng-if="isNew">
		<div class="reportMsg"><label class="userMsg" for="message">{{message}}</label></div>
	</div>
	
	<div id="example"><div id="grid"></div>	</div>
	
	<h1>Add New User</h1>
	<form class="socuser" data-ng-submit="newCtrl.submit()" name="socUserMaintain">
		<input type="hidden" data-ng-model="newCtrl.socUser.userId" />
		<fieldset class="row1">
			<legend>Personal Details </legend>
			<p>
				<label>First Name </label> <input type="text" data-ng-model="newCtrl.socUser.firstName" id="firstName" /> 
				<label>Middle Name </label> <input type="text" data-ng-model="newCtrl.socUser.middleName" id="middleName" /> 
				<label>Last Name </label> <input type="text" data-ng-model="newCtrl.socUser.lastName" id="lastName" />
			</p>
			<p>
				<label>User Name </label> <input type="text" data-ng-model="newCtrl.socUser.userName" ng-readonly="true" id="userName"/>
			</p>
			<p>
				<label>Email </label> <input type="email"  data-ng-model="newCtrl.socUser.emailId" ng-focus="getUserName()" id="emailId"/> 
				<label>PAN Number </label> <input type="text" data-ng-model="newCtrl.socUser.panNo" id="panNo" data-ng-minlength="10"/>
			</p>
			<p>
				<label>Mobile </label> <input type="text" data-ng-minlength="10" data-ng-model="newCtrl.socUser.phoneNo" id="phoneNo" />
			</p>


		</fieldset>
		<fieldset class="row1">
			<legend>Residential Information </legend>
			<p>
				<label>Address </label>
				<textarea rows="3" cols="54" data-ng-model="newCtrl.socUser.address" id="address"></textarea>
			</p>
			<p>
				<label>No. of Members </label> <input type="text" data-ng-model="newCtrl.socUser.noOfMembers" id="noOfMembers" />
			</p>
			<p>
				<label>Is Owner? </label> 
				<input type="radio" name="isOwner" value="owner" data-ng-model="newCtrl.socUser.isOwner" ng-checked="true" /> <label class="residenttype">Owner</label>
				<input type="radio" name="isOwner" value="tenant" data-ng-model="newCtrl.socUser.isOwner" /> <label class="residenttype">Tenant</label>
			</p>
			<p>
				<label>Start Date </label> <input type="text" id="startDate" data-ng-model="newCtrl.socUser.startDate" />
				
				<span ng-show="newCtrl.socUser.isOwner == 'tenant'">
					<label>End Date </label> <input type="text" id="endDate" data-ng-model="newCtrl.socUser.endDate"/>
				</span>
			</p>
			
		</fieldset>
		<fieldset class="row1">
			<div align="center">
				<input type="submit" class="button" value="{{!newCtrl.socUser.userId ? 'Add' : 'Update'}}" />
				<button class="button">Cancel</button>
			</div>
		</fieldset>
	</form>

</body>
</html>