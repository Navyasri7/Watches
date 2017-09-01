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
<%@ include file="adminnavbar.jsp" %>
<br><br><br>
<div class="container">
		<div class="col-sm-4" style="background-color: #39c6c6; border-radius:15px; padding-bottom:10px">
		<div align="center" style="color: blue; font-size: 30px">
             <b>Supplier Page</b>
             </div>
<xyz:form commandName="supplierobject" action="reqsendsupplierdata" enctype="multipart/form-data">
<div class="form-group">
<b>supplier name</b><br>
 <xyz:input path="suppliername" class="form-control" placeholder="Enter supplier name"/>
 </div>
<div class="form-group">
<b>supplier desc</b><br>
 <xyz:input path="supplierdesc" class="form-control" placeholder="Enter supplierdesc"/>
</div>
<div class="form-group">
<b>Browse profile picture</b><br>
 <xyz:input type="file" path="supplierimage" class="form-control"/>
 </div>
<xyz:button>SupplierProduct</xyz:button>
</xyz:form>
</div>
</div>

</body>
</html>