<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="links.jsp" %>
<title>Insert title here</title>
</head>
<body>

	<%@ include file="adminnavbar.jsp"%>
<br><br>
	<div class="container" style="padding-top: 20px">
		<div class="col-sm-6"
			style="background-color: #0db9f2; border-radius: 30px; padding-bottom: 15px; padding-top: 5px;">


			<div align="center" style="font-size: 30px; color: green">
				<b>Edit XPS Page </b>
			</div>
        <xyz:form commandName="xps" action="reqEditXpsToDB">
				<xyz:hidden path="psid" />

				<div class="form-group">
					<b> ProductID </b> <br>
					<xyz:input class="form-control" path="productid" readonly="true" />
					${pname}
				</div>


				<div class="form-group">
					<b> Supplier ID</b> <br>
					<xyz:input class="form-control" path="supplierid" readonly="true" />
					${supname}
				</div>

				<div class="form-group">
					<b> Price</b> <br>
					<xyz:input class="form-control" path="productsupplierprice" />
				</div>

				<div class="form-group">
					<b> Stock</b> <br>
					<xyz:input class="form-control" path="productsupplierstock" />
				</div>

				<div class="form-group">
					<b>XPS Available</b> <br>
					True <xyz:radiobutton path="isproductsupplieravailable" value="true"/>  
 					False <xyz:radiobutton path="isproductsupplieravailable" value="false"/> 
				</div>

				<div align="right">
					<xyz:button class="btn btn-primary">Update XPS</xyz:button>
				</div>
			</xyz:form>
		</div>
	</div>

</body>
</html>