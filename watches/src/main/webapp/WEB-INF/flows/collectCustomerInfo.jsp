<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file ="../display/links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="../display/usernavbar.jsp" %>
<br>
<div class="container-wrapper">
<div class="container">
<div class="page-header">
<h1>Cutomer</h1>
<p class="lead">Customer Details:</p>
</div>

<xyz:form commandName="order" class="form-horizontal">

<h3>Basic Info:</h3>

<div class="form-group">
	<b>First Name</b>
	<xyz:input path="cart.customer.customername" class="form-Control" />
</div>
 

<div class="form-group">
	<b>Email</b>
	<xyz:input path="cart.customer.mailid" class="form-Control" />
</div>

<div class="form-group">
	<b>Phone</b>
	<xyz:input path="cart.customer.mobileno" id="mobileno" class="form-Control" />
</div>

<br>
<h3>Billing Address:</h3>

<div class="form-group">
	<b>Street Name</b>
	<xyz:input path="cart.customer.billingAddress.street" class="form-Control" />
</div>

<div class="form-group">
	<b>House No.</b>
	<xyz:input path="cart.customer.billingAddress.houseno" class="form-Control" />
</div>

<div class="form-group">
	<b>Area</b>
	<xyz:input path="cart.customer.billingAddress.area" class="form-Control" />
</div>

<div class="form-group">
	<b>City</b>
	<xyz:input path="cart.customer.billingAddress.city" class="form-Control" />
</div>

<div class="form-group">
	<b>State</b>
	<xyz:input path="cart.customer.billingAddress.state" class="form-Control" />
</div>

<div class="form-group">
	<b>Country</b>
	<xyz:input path="cart.customer.billingAddress.country" class="form-Control" />
</div>

<div class="form-group">
	<b>Pin code</b>
	<xyz:input path="cart.customer.billingAddress.pincode" class="form-Control" />
</div>

<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<input type="submit" value="Next" class="btn btn-default" name="_eventId_customerInfoCollected" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>

</xyz:form>
</div>
</div>

</body>
</html>