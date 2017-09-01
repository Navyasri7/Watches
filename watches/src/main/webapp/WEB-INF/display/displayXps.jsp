<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp" %>
<script>

$(document).ready(function(){
	var searchCondition='${searchCondition}';
	$('.table').DataTable({
		"lengthMenu" : [[5,10,15,-1],[5,10,15,"All"]],
		"oSearch":{"sSearch":searchCondition}
		
	})	
});

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<br><br> <br><c:if test="${xpsmessage!=null}">
	<div class="container">
    
    <div col-sm-3></div>
    <div col-sm-6>
     <div class="alert alert-success alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${xpsmessage}
    </div>
  </div>
  </div>
  </c:if>
<div class="container">
<table border ="0" class="table table-stripped fixed_headers" style="font-weight:bold"  >
<thead>

<tr style="background:rgba(60,60,90,1);color:yellow;table-layout: fixed;">
<th style="text-align:center">Product ID</th>
<th style="text-align:center">Supplier ID</th>
<th style="text-align:center">XPS ID</th>
<th style="text-align:center">Price</th>
<th style="text-align:center">Stock</th>
<th style="text-align:center">Is Available</th>

<th style="text-align:center">Manage</th>
</tr>
</thead>
<tbody>
<c:forEach var="xps" items="${xpsdata}">
<tr style="text-align:center;">
<td style="vertical-align: middle;font-weight:bold;"><img src="resources/images/product/${xps.productid}.jpg" height="70" width="90" /> 
<br> ${xps.productid}</td>
<td style="vertical-align: middle;font-weight:bold;"><img src="resources/images/supplier/${xps.supplierid}.jpg" height="70" width="90" />
<br>  ${xps.supplierid}</td>
<td style="vertical-align: middle;font-weight:bold;">${xps.psid}</td>
<td style="vertical-align: middle;font-weight:bold;">${xps.productsupplierprice}</td>
<td style="vertical-align: middle;font-weight:bold;">${xps.productsupplierstock}</td>
<td style="vertical-align: middle;font-weight:bold;">${xps.isproductsupplieravailable}</td>

<td style="vertical-align: middle">
<a href="reqEditXpsPage?psid=${xps.psid}" > 
<span class="glyphicon glyphicon-pencil btn btn-warning btn-large"></span>
</a> / 
<a href="reqDeleteXps?psid=${xps.psid}"> 
<span class="glyphicon glyphicon-trash btn btn-warning btn-large"></span>
</a> 
</td>

</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>