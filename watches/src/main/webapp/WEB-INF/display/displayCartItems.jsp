<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],["Five","Ten","Fifteen","All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});

</script>
</head>
<body>

	<%@ include file="usernavbar.jsp"%>
	<br><br><br>
	<div class="container">

		<div class="col-md-2"
			style="background-color: transparent; border: none">
			<c:url value="/reqClearCart/${customerprofile.customerid}" var="url"></c:url>
			<a href="${url}" style="color: yellow;"
				class="btn btn-warning btn-large">Clear Cart</a>
		</div>
		<div class="col-md-6"
			style="background-color: transparent; border: none"></div>

		<div class="col-md-4" align="right"
			style="background-color: transparent; border: none">

			<c:if test="${customerprofile.cart.cartItems.size()==0}">
  				Cart is Empty
  			</c:if>
			<c:if test="${customerprofile.cart.cartItems.size()>=1}">
				<b>Order Total : ${customerprofile.cart.totalbill}</b>
				<c:url value="/order/${customerprofile.cart.cartid}" var="url"></c:url>
				<a href="${url}" style="color: yellow"
					class="btn btn-warning btn-large">Check Out</a>
			</c:if>
		</div>
	</div>
	<br>
	<div class="container">

		<table border="0" class="table table-stripped fixed_headers" style="font-weight: bold">
			<thead>
				<tr style="background: rgba(60, 60, 90, 1); color: yellow; table-layout: fixed;">
					<th style="text-align: center">Product</th>
					<th style="text-align: center">Supplier</th>
					<th style="text-align: center">Quantity</th>
					<th style="text-align: center">Price</th>
					<th style="text-align: center">Item wise Total</th>
					<th style="text-align: center">Option</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="cartitem" items="${cartitems}">
					<tr style="text-align: center">

						<td style="vertical-align: middle; font-weight: bold;">
							<c:url value="/resources/images/product/${cartitem.xmap_product_supplier.productid}.jpg" var="url"></c:url>
							<img style="border-radius: 15px" src="${url}" height="120px" width="150px" />
						</td>

						<td style="vertical-align: middle; font-weight: bold;">
							<c:url value="/resources/images/supplier/${cartitem.xmap_product_supplier.supplierid}.jpg" var="url"></c:url>
							<img style="border-radius: 15px" src="${url}" height="120" width="150" />
						</td>

						<td
							style="vertical-align: middle; font-weight: bold;">${cartitem.quantity}</td>
						<td
							style="vertical-align: middle; font-weight: bold;">${cartitem.xmap_product_supplier.productsupplierprice}</td>
						<td
							style="vertical-align: middle; font-weight: bold;">${cartitem.itemwisetotal}</td>
						<td style="vertical-align: middle;">
						<c:url value="/reqDeleteCartItem/${cartitem.cartitemid}" var="url"></c:url>
							<a href="${url}" style="color: yellow; font-weight: bold" class="btn btn-warning btn-large">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>


		</table>



	</div>

</body>
</html>