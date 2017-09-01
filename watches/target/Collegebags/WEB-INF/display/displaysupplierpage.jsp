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
<br><br><br>
<div class="container">
<table  class="table table-stripped fixed_headers">
<thead>
<tr>
<th>Supplier ID</th>
<th>Image</th>
<th>Supplier Name</th>
<th>Supplier Desc</th>
<th>Supplier Available</th>
<th>Options</th>
</tr>

</thead>

<tbody>
<c:forEach var="s" items="${suppliers}">
<tr>
<td>${s.supplierid}</td>
<td><img src="resources/images/supplier/${s.supplierid}.jpg" height="100px" width="150px"/></td>
<td>${s.suppliername}</td>
<td>${s.supplierdesc}</td>
<td>${s.issupplieravailable}</td>
<td>
<a href="reqEditSupplier?sid=${s.supplierid}">Edit</a> 
/
 <a href="reqDeleteSupplier?sid=${s.supplierid}">Delete</a>
 </td>
</tr>
</c:forEach>


</tbody>
</table>
</div>

</body>
</html>