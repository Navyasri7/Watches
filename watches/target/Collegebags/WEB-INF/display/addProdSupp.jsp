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
<xyz:form commandName="prodsuppObject" action="reqAddProdSuppDataToDb">

Products 
<xyz:select path="productid">
<c:forEach var="prd" items="${products}">
<option value="${prd.productid}"> ${prd.productname}</option>
</c:forEach>
</xyz:select>

Supplier 
<xyz:select path="supplierid">
<c:forEach var="sup" items="${suppliers}">
<option value="${sup.supplierid}"> ${sup.suppliername}</option>
</c:forEach>
</xyz:select>

Price <xyz:input path="productsupplierprice"/>
Stock <xyz:input path="productsupplierstock"/>

IsAvailable   
True <xyz:radiobutton path="isproductsupplieravailable" value="true"/>
False <xyz:radiobutton path="isproductsupplieravailable" value="false"/>

<xyz:button>Add Record</xyz:button>
</xyz:form>
</div>
</body>
</html>