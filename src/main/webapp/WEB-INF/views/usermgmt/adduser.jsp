<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" data-ng-app="socUserMgmtApp"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div data-ng-controller="socUserCtrl as newCtrl">
		<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
		
		<div id="container" style="padding-left: 34px;">
			<div>
				<span id="headerTitle"><b>Add User</b></span> 
			</div>
			<form class="socuser" data-ng-submit="newCtrl.submit()" name="socUserMaintain">
				<input type="hidden" data-ng-model="newCtrl.socUser.userId" />
				<fieldset class="profileDetails">
					<legend>Personal Details </legend>
					<div class="container">
						<div class="personalInformation">
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
						</p>
						<p>
							<label>PAN Number </label> <input type="text" data-ng-model="newCtrl.socUser.panNo" id="panNo" data-ng-minlength="10"/>
						</p>
						<p>
							<label>Mobile </label> <input type="text" data-ng-minlength="10" data-ng-model="newCtrl.socUser.phoneNo" id="phoneNo" />
						</p>
						</div>
						<div class="uploadImage">
							<img ng-src="{{imageSrc}}" class="imgDiv" /><br />
							<input type="file"  accept=".jpg,.jpeg,.png" ng-file-select="onFileSelect($files)" data-ng-model="newCtrl.socUser.profileImage"/>
							<br/>
							<b>Progress:</b><br/>
							<progress value="{{progress}}"></progress>
						</div>
					</div>
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
						<label>Start Date </label> <input type="text" id="startDate" data-ng-model="newCtrl.socUser.startDate" ng-change="calAgreementEndDate()" />
						
						<span ng-show="newCtrl.socUser.isOwner == 'tenant'">
							<label>End Date </label> <input type="text" id="endDate" data-ng-model="newCtrl.socUser.endDate" ng-readonly="true" />
						</span>
					</p>
					
				</fieldset>
				<fieldset class="row1">
					<div align="center" class="button-left">
						<input type="submit" class="button" value="{{!newCtrl.socUser.userId ? 'Add' : 'Update'}}" />
						<button class="button deleteButton" id="cancelUser" >Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$(document).ready(function() {
			$("#startDate, #endDate").datepicker();
			
		    $('#cancelUser').click(function(){
		    	 location.href = $('#context').val() +"/user/search";
		    	 return false;
		    });
		});
	</script>
</body>
</html>