<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}		
	})	
});

</script>

<title>Insert title here</title>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<br><br><br>
<div class="container">
<table  class="table table-stripped fixed_headers">
<thead>
<tr>
<th>Product ID</th>
<th>Image</th>
<th>Product Name</th>
<th>Product Desc</th>
<th>Product Available</th>
<th>Options</th>
</tr>

</thead>

<tbody>
<c:forEach var="p" items="${products}">
<tr>
<td>${p.productid}</td>
<td><img src="resources/images/product/${p.productid}.jpg" height="100px" width="150px"/></td>
<td>${p.productname}</td>
<td>${p.productdesc}</td>
<td>${p.isproductavailable}</td>
<td>
<a href="reqEditProduct?pid=${p.productid}">   Edit  </a> 
/ 
<a href="reqDeleteProduct?pid=${p.productid}">   Delete  </a>
</td>
</tr>
</c:forEach>


</tbody>
</table>
</div>
</body>
</html>