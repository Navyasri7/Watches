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
		<div class="col-sm-3" style="background-color:skyblue;border-radius:15px; padding-bottom:10px"">
			<div align="center" style="color: blue; font-size: 30px">
<b>Login sucessfull</b>
</div><form name="loginForm" action="<c:url value="/j_spring_security_check"></c:url>" method="POST">

	<div class="form-group">
	<b> User ID </b> <br><input type="text" name="j_username" /> <br> </div>

	<div class="form-group">
	<b>Password</b> <br><input type="password" name="j_password" /> <br> </div>

	Forgot Password?<a href=""> Click Here</a>
	<div align="right">
		<input type="submit" value="Login" />
	</div>
</form>


</div>
<div class="col-sm-9">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/images/carousel/bering.jpg" alt="Bering" style="width:50%;">
      </div>

      <div class="item">
        <img src="resources/images/carousel/fastrack2.jpg" alt="Fastrack" style="width:50%;">
      </div>
    
      <div class="item">
        <img src="resources/images/carousel/giordino8.jpg" alt="Giordino" style="width:50%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>
</body>
</html>