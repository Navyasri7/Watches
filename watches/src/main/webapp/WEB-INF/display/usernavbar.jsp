<nav class="container navbar navbar-inverse  navbar-fixed-top">
	<div class="container">

		<ul class="nav navbar-nav" >
			<li><li><c:url value="/resources/images/customer/${customerprofile.customerid}.jpg" var="url"></c:url>
			<img src="${url}" height="50" width="60" class="img-circle" /></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Welcome ${customerprofile.customername}<span
					class="caret"></span></a>
				<ul class="dropdown-menu" style="vertical-align: middle">
					<li><a href="#">Edit Profile</a></li>
					<li><a href="#">Change Password</a></li>
					<li><c:url value="/j_spring_security_logout" var="url"></c:url><a href="${url}">Logout</a></li>
					
					<%--<li><c:url value="/reqLogout" var="url"></c:url>
					<a href="${url}">Logout</a></li> --%>
				</ul>
			</li>
			
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> Products<span class="caret"></span></a>
				<ul class="dropdown-menu" style="vertical-align: middle">
					<li><c:url value="/reqDisplayProductsUser" var="url"></c:url><a href="${url}">Display Products</a></li>
					
				</ul>
			</li>
			
			
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Orders<span class="caret"></span></a>
				<ul class="dropdown-menu" style="vertical-align: middle">
					<c:url value="/reqDisplayOrderHistory?custid=${customerprofile.customerid}" var="url"></c:url>
					<a href="${url}">Order History</a>					
				</ul>
			</li>
			
			
			<li class="dropdown">
				<c:url value="/reqDisplayCart" var="url"></c:url>					
				<a href="${url}"  style="font-size:18px;"> 
				<span class="glyphicon glyphicon-shopping-cart"></span>
				${customerprofile.cart.cartItems.size()}</a>				
			</li>
		</ul>
	</div>
</nav>