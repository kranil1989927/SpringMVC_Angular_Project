<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>

<html>
<head>

<title>Home Page</title>
<!--  CSS -->
<link href="<c:url value="/resources/css/styles.css" />"rel="stylesheet">
<link href="<c:url value="/resources/css/dateselector.min.css" />"rel="stylesheet">
<link href="<c:url value="/resources/css/jquerysctipttop.css" />"rel="stylesheet">
<link href="<c:url value="/resources/css/dateselector.css" />"rel="stylesheet">


<!-- Scripts -->
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>
<script src="<c:url value="/resources/js/jquery-1.11.2.min.js" />"></script>
<script src="<c:url value="/resources/js/dateselector.min.js" />"></script>
<script src="<c:url value="/resources/js/dateselector.js" />"></script>
<%-- <script src="<c:url value="/resources/js/hideandshow.js" />"></script> --%>
<script src="<c:url value="http://code.jquery.com/jquery.min.js" />"></script>


<script>
			$(document).ready(function() {
				$('#test').dateSelector();
				$('#test2').dateSelector();
			});
		</script> 
		
		<script type="text/javascript">
		$(document).ready(function(){
    $('input[type="radio"]').click(function(){
        if($(this).attr("value")=="Y"){
        	$("#tenent_section").show();
        }
        if($(this).attr("value")=="N"){
        	$("#tenent_section").hide();
        }
     
    });
});
		
		</script>

		<style type="text/css">
			#demo {
				margin: 150px auto;
				padding: 2em;
				width: 70%;
			}
			#tenent_section{
			display: none; 
			}
		</style>
		<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</head>
<body>
	<h1>Society Management</h1>
	
	<form:form modelAttribute="socUserFormBean"
		action="/maintain/user/add" method="POST">
		<table >
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
				<td>Middle Name :</td>
				<td><form:input path="middleName" /></td>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Email ID :</td>
				<td><form:input path="emailId" /></td>
				<td>Phone No :</td>
				<td><form:input path="phoneNo" /></td>
				<td>Pan Number</td>
				<td><form:input path="panNo" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>No.Of Family Member</td>
				<td><form:input path="noOfMembers"/></td>
				<td>Is Owner</td>
				<td><form:radiobutton path="isOwner"  value="Y"  />Yes 
				<form:radiobutton path="isOwner"  name="owner" value="N"/>No 
				</td>
			</tr>
			
			<tr>
				<td>Start Date</td>
				<td><form:input id="test" path="startDate"/></td>
				<td>End Date</td>
				<td><form:input id="test2" path="endDate"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
		<div id="tenent_section">
		dgbhhbdgfh
	<input type="submit" value="Login" />
	</div>
	</form:form>
	
</body>
</html>