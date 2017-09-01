<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="xyz"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="links.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PhoneCases - Signup</title>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 100%;
      margin: auto;
      height:400px;
  }
   .carousel-control.left, .carousel-control.right {
  background-image: none;opacity=0.4;
}
  </style>
</head>
<body>
	<%@ include file="commonnavbar.jsp"%>


	<div class="container">
		<div class="col-sm-6"
			style="background-color: #0db9f2; border-radius: 30px; padding-bottom: 15px;padding-top: 5px;">


			<div align="center" style="font-size: 30px; color: green">
				<b>SignUp Form</b>
			</div>




			<xyz:form commandName="customer" action="reqSendSignupData"
				enctype="multipart/form-data">

				<div class="form-group">
					<b> Enter Customer Name </b> <br>
					<xyz:input class="form-control" placeholder="Enter Customer Name"
						path="customername" />
				</div>
				
				<div class="form-group">
					<b> Enter Customer E-Mail ID </b> <br>
					<xyz:input class="form-control" placeholder="Enter Customer E-Mail ID"
						path="mailid" />
				</div>
				
				<div class="form-group">
					<b> Enter Customer Mobile No. </b> <br>
					<xyz:input class="form-control" placeholder="Enter Customer Mobile No."
						path="mobileno" />
				</div>

				<div class="form-group">
					<b>Browse Image</b> <br>
					<xyz:input class="form-control" type="file" path="customerimage" />
				</div>
				
				<div class="form-group">
					<b> Enter password </b> <br>
					<xyz:password class="form-control" placeholder="Enter Password"
						path="userDetails.password" />
				</div>

				<div class="form-group">
					<b>House No. </b> <br>
					<xyz:input class="form-control" placeholder="Enter House No."
						path="shippingAddress.houseno" />
				</div>
				
				<div class="form-group">
					<b>Street</b> <br>
					<xyz:input class="form-control" placeholder="Enter Street"
						path="shippingAddress.street" />
				</div>	
						
				<div class="form-group">
					<b>Area</b> <br>
					<xyz:input class="form-control" placeholder="Enter Area"
						path="shippingAddress.area" />
				</div>
					
				<div class="form-group">
					<b>City</b> <br>
					<xyz:input class="form-control" placeholder="Enter City"
						path="shippingAddress.city" />
				</div>	
				
				<div class="form-group">
					<b>State</b> <br>
					<xyz:input class="form-control" placeholder="Enter State"
						path="shippingAddress.state" />
				</div>	
				
				<div class="form-group">
					<b>Country</b> <br>
					<xyz:input class="form-control" placeholder="Enter Country"
						path="shippingAddress.country" />
				</div>
				
				<div class="form-group">
					<b>Pincode</b> <br>
					<xyz:input class="form-control" placeholder="Enter Pincode"
						path="shippingAddress.pincode" />
				</div>
																	
				<div align="right">
					<xyz:button class="btn btn-primary">SignUp</xyz:button>
				</div>
			</xyz:form>

		</div>

		<div class="col-sm-6">

			
			

		</div>
	</div>

</body>
</html>