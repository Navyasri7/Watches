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
<h1>Order</h1>

<p class="lead">Order confirmation</p>
</div>
</div>
</div>
<div class="container">

<div class="row">

<xyz:form commandName="order" class="form-horizontal">

<div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">

<div class="txt-center">
<h1>Receipt</h1>
</div>
<div class="row">
<div class="col-xs-6 col-sm-6 col-md-6">
<address>
<strong>Shipping Address</strong><br/>
${order.cart.customer.shippingAddress.street}
<br/>
${order.cart.customer.shippingAddress.city}, ${order.cart.customer.shippingAddress.state}
<br/>
${order.cart.customer.shippingAddress.country}, ${order.cart.customer.shippingAddress.pincode}
</address>
</div>
<div class="col-xs-6 col-sm-6 col-md-6 text-right">
<p>Shipping Date: <fmt:formatDate type="date" value="${now}" /></p>
</div>
</div>

<div class="row">
<div class="col-xs-6 col-sm-6 col-md-6">
<address>
<strong>Billing Address</strong><br/>
${order.cart.customer.billingAddress.street}
<br/>
${order.cart.customer.billingAddress.city}, ${order.cart.customer.billingAddress.state}
<br/>
${order.cart.customer.billingAddress.country}, ${order.cart.customer.billingAddress.pincode}
</address>
</div>
</div>

<div class="row">
<table class="table table-hover">
<thead>
<tr>
<td>Product</td>
<td>Supplier</td>
<td>#</td>
<td class="text-center">Price</td>
<td class="text-center">Total</td>
</tr>
</thead>
<tbody>
<c:set var="grandTotal" value="0.0"></c:set>
<c:forEach var="cartItem" items="${order.cart.cartItems}">
<tr>
<c:url value="/resources/images/product/${cartItem.xmap_product_supplier.productid}.jpg" var="url"></c:url>
<td class="col-md-4"><img src="${url}" width="100" height="80" style="border-radius:15px"/>   </td>

<td class="col-md-5"><c:url value="/resources/images/supplier/${cartItem.xmap_product_supplier.supplierid}.jpg" var="url"></c:url>
   <img src="${url}" width="100" height="80" style="border-radius:15px"/> 
</td>
<%-- <td class="col-md-9"><em>${cartItem.xmap_product_supplier.productid}</em></td> --%>
<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
<td class="col-md-1" style="text-align: center">${cartItem.xmap_product_supplier.productsupplierprice}</td>
<td class="col-md-1" style="text-align: center">${cartItem.itemwisetotal}</td>
<c:set var="grandTotal" value="${grandTotal + cartItem.itemwisetotal }"></c:set>
</tr>
</c:forEach>

<tr>
<td></td>
<td></td>
<td class="text-right">
<h4><strong>Grand Total:</strong></h4>
</td>
<td class="text-center text-danger">
<h4><strong>Rs. ${grandTotal}</strong></h4>
</td>
</tr>

</tbody>
</table>
</div>


<input type="hidden" name="_flowExecutionKey" />

<br/><br/>

<button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>

<input type="submit" value="Submit Order" class="btn btn-default" name="_eventId_orderConfirmed" />

<button class="btn btn-default" name="_eventId_cancel">Cancel</button>
</div>
</xyz:form>
</div>
</div>
</body>
</html>