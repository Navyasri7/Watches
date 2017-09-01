<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@  include file="usernavbar.jsp" %>
	<br>
	<br> 
	<%-- ${productsuser} --%>
	<br>
	<c:if test="${cartmessage!=null}">
	<div class="container">
    
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-success alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${cartmessage}. No. of items in your cart : ${customerprofile.cart.cartItems.size()}
    </div>
  </div>
  </div>
  </c:if>
	<div class="container">

		<c:forEach var="p" items="${productsuser}">
			<div class="col-sm-3" style="padding-top: 5px; padding-bottom: 5px">
				<div align="center" style="border-style: outset;">
				<c:url value="/resources/images/product/${p.productid}.jpg" var="url"></c:url>
					<img src="${url}" height="100px" width="150px" /> <br>${p.productname} <br>

					<i class="fa fa-inr" style="font-size: 15px"></i>
					${p.productsupplierprice} /- <br>Supplier : ${p.suppliername}
					<br>Stock : ${p.productsupplierstock}
					
					<c:url value="/reqAddItemToCart/${p.psid}" var="url"></c:url>
					<br>
					
					<form action="${url}">
						<select name="qty" id="qty" style="color: red">
							<option value="1" style="color: red">1</option>
							<option value="2" style="color: red">2</option>
							<option value="3" style="color: red">3</option>
							<option value="4" style="color: red">4</option>
							<option value="5" style="color: red">5</option>

						</select>
						<button type="submit" class="btn btn-warning btn-large">
							<span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
						</button>
					</form>
					<c:url value="/reqProductAllSuppliers?pid=${p.productid}" var="url"></c:url>
					<a href="${url}">All Suppliers</a>



				</div>
			</div>
		</c:forEach>


	</div>
</body>
</html>