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
		
		<div id="container">
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
						<button class="button" id="cancelNotice">Cancel</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<script language="javascript" type="text/javascript">
		debugger;
		$(document).ready(function() {
			
			$("#addNotice").click(function(){
				addNoticeDetails();
				return false;
			});
			
			$("#cancelNotice").click(function(){
				window.location.href = $('#context').val() + "/notice/search";
				return false;
			});
			
			function addNoticeDetails(){
				debugger;
				var addNoticeUrl = $('#context').val() + "/notice/save";
				var noticeForm = {};
				noticeForm.noticeTitle = $('#noticeTitle').val();
				noticeForm.noticeDesc = $('#noticeDesc').val();
				//noticeForm.noticeDate = $('#phoneNo').val();
				
				$.ajax({
					  type: "POST",
					  url: addNoticeUrl,
					  data: JSON.stringify(noticeForm),
					  dataType: "json",
					  contentType : "application/json",
					  success: function(data){
						  window.location.href = $('#context').val() + "/notice/search";
						  return false;
					  },
					  error: function(data){
						  window.alert("Notice Added failed");
						  return false;
					  }
				});
				return false;
			};
		});
	</script>
</body>
</html>