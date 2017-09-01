<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="commonnavbar.jsp" %>
<c:if test="${signupmsg!=null}">
		<div class="container">
			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-success alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${signupmsg}
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${errormessage!=null}">
		<div class="container">
			<div col-sm-3></div>
			<div col-sm-6>
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
					${errormessage}
				</div>
			</div>
		</div>
	</c:if>

	<div class="container">
		<div class="col-sm-4" style="background-color:lightpink;border-radius:15px; padding-bottom:10px"">
			<div align="center" style="color: blue; font-size: 30px">
<b>Login sucessfull</b>
</div>
<xyz:form commandName="userObject" action="reqSendLoginData">
<div class="form-group">
<b>User ID</b><br>
 <xyz:input path="userid" class="form-control" place-holder="enter userid"/>
 </div>
 <div class="form-group">
<b>Password</b><br>
 <xyz:password path="password" class="form-control" place-holder="enter password"/>
 </div>
<br>
<xyz:button>Login</xyz:button>
</xyz:form>
</div>
</div>

</body>
</html>