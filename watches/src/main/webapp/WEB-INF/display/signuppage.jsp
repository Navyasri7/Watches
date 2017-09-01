<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="xyz" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
<%@ include file="commonnavbar.jsp" %>
<div class="container">
		<div class="col-sm-4" style="background-color: lightgreen; border-radius:15px; padding-bottom:10px">
		<div align="center" style="color: blue; font-size: 30px">
             <b>SignUp Page</b>
             </div>
<xyz:form commandName="userObject" action="reqSendSignupdata" enctype="multipart/form-data">
<div class="form-group">
<b> User Name</b><br>
 <xyz:input path="username" class="form-control" placeholder="Enter User Name"/>
 </div>
 <div class="form-group">
<b> Password </b><br>
 <xyz:password path="password" class="form-control" placeholder="Enter password"/>
 </div>
 <div class="form-group">
<b> EmailID</b><br>
 <xyz:input path="emailid" class="form-control" placeholder="Enter emailid"/>
 </div>
 <div class="form-group">
<b> Mobile</b> <br>
 <xyz:input path="mobile" class="form-control" placeholder="Enter mobileno"/>
 </div>
 <div class="form-group">
<b> Address </b> <br>
<xyz:input path="address" class="form-control" placeholder="Enter address"/>
</div>
<div class="form-group"> 
<b>Browse Image</b> <br> 
<xyz:input type="file" path="userImage" class="form-control"/>
</div>

<br><xyz:button>
Signup
</xyz:button>
</xyz:form>
</div>
</div>


</body>
</html>