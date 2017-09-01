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
<%@include file="adminnavbar.jsp" %>
<br><br><br>
<div class="container">
		<div class="col-sm-4" style="background-color: #39c6c6; border-radius:15px; padding-bottom:10px">
		<div align="center" style="color: blue; font-size: 30px">
             <b>Product Page</b>
             </div>
<xyz:form commandName="productobject" action="reqsendproductdata" enctype="multipart/form-data">
<div class="form-group">
<b>product name</b> <br>
<xyz:input path="productname" class="form-control" placeholder="Enter product name"/>
</div>
<div class="form-group">
<b>product desc</b> <br>
 <xyz:input path="productdesc" class="form-control" placeholder="Enter product desc"/>
 </div>
<div class="form-group">
<b>Browse profile picture</b><br>
 <xyz:input type="file" path="productimage" class="form-control"/>
 </div>
<xyz:button>AddProduct</xyz:button>
</xyz:form>
</div>
</div>

</body>
</html>