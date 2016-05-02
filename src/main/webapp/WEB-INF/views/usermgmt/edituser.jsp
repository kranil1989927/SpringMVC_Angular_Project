<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
	<input type="hidden" id="context" value="<%=request.getContextPath()%>" />
	<jsp:include page="../header.jsp" />
	
	<h1>Update User Details</h1>
	<div id="container" style="padding-left: 34px;">
		<form class="socuser" id="updateUserForm">
			<input type="hidden" id="userId" value="${userId}">
			<fieldset class="profileDetails">
				<legend>Personal Details </legend>
				<div class="container">
					<div class="personalInformation">
					<p>
						<label>First Name </label> 
						<input type="text" value="${socUserDetails.firstName}" disabled id="firstName" /> 
						<label>Middle Name </label> 
						<input type="text" value="${socUserDetails.middleName}" disabled id="middleName" /> 
						<label>Last Name </label> 
						<input type="text" value="${socUserDetails.lastName}" disabled id="lastName"/>
					</p>
					<p>
						<label>User Name </label> 
						<input type="text" value="${socUserDetails.userName}" disabled id="userName"/>
					</p>
					<p>
						<label>Email </label> 
						<input type="email"  value="${socUserDetails.emailId}" id="emailId" />
					</p>
					<p>
						<label>PAN Number </label> 
						<input type="text" value="${socUserDetails.panNo}" id="panNo" data-ng-minlength="10"/>
					</p>
					<p>
						<label>Mobile </label> 
						<input type="text" data-ng-minlength="10" value="${socUserDetails.phoneNo}" id="phoneNo"/>
					</p>
					</div>
					<div class="uploadImage">
						<img id ="profileImage" src="data:image/jpeg;base64,${socUserDetails.profileImage}" class="imgDiv" /><br />
						<input type="file" accept=".jpg,.jpeg,.png" onchange="loadFile(event)">
					</div>
				</div>
			</fieldset>
			
			<fieldset class="row1">
				<legend>Residential Information </legend>
				<p>
					<label>Address </label>
					<textarea rows="3" cols="54" id="address">${socUserDetails.address}</textarea>
				</p>
				<p>
					<label>No. of Members </label> 
					<input type="text" value="${socUserDetails.noOfMembers}" id="noOfMembers"/>
				</p>
				<p>
					<label>Is Owner? </label> 
					<input type="radio" name="isOwner" value="owner" value="${socUserDetails.isOwner}" checked='true' />
					<label class="residenttype">Owner</label>
					<input type="radio" name="isOwner" value="tenant" value="${socUserDetails.isOwner}" /> 
					<label class="residenttype">Tenant</label>
				</p>
				<p>
					<label>Start Date </label> 
					<input type="text" id="startDate" value="${socUserDetails.startDate}" />
					
					<span>
						<label>End Date </label> 
						<input type="text" id="endDate" value="${socUserDetails.endDate}" />
					</span>
				</p>
				
			</fieldset>
			<fieldset class="row1">
				<div align="center" class="button-left">
					<input type="submit" class="button" value="Update" id="updateRecord" />
					<button class="button" id="cancel">Cancel</button>
				</div>
			</fieldset>
		</form>
	</div>
	<script language="javascript" type="text/javascript">
		$( document ).ready(function() {
			$('#updateRecord').click(function(){
				alert("Are you realy want to update the record ? ");
				return false;
				/* $('#updateUserForm').submit(function(){
		    		 alert("Are you realy want to update the record ? ");
		    	 	 return false;
		    	}); */
			});
			$('#cancel').click(function(){
				location.href = $('#context').val() +"/user/search";
		    	return false;
			});
	    	
		});
		var loadFile = function(event) {
			var reader = new FileReader();
			reader.onload = function(){
				var output = document.getElementById('profileImage');
				output.src = reader.result;
			  };
			  reader.readAsDataURL(event.target.files[0]);
			};
	</script>
</body>
</html>