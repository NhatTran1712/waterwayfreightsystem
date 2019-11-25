<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin Home Page</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    	rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center">
	  	<h2 align="left">He Thong Van Chuyen Hang Hoa Duong Thuy</h2>
	    <c:if test="${pageContext.request.userPrincipal.name != null}">
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
	        <h5 align="right">
	        	<a href=
	        		"${contextPath}/account/show?username=${pageContext.request.userPrincipal.name}">
	       			${pageContext.request.userPrincipal.name}</a> | <a href=
	       			"${contextPath}/account/update?username=${pageContext.request.userPrincipal.name}"
	       			style="color:black">cap nhat</a> |
	       			<a onclick="document.forms['logoutForm'].submit()" style="color:black">
	       				dang xuat</a><br/>
	        </h5>
	    </c:if>
	    <div class="menubar">
		    <nav class="navbar navbar-default">
		        <div class="container-fluid">
			        <div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
							data-target="#navbar" aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Quan tri</a>
			        </div>
					<div id="navbar" class="navbar-collapse collapse center-block" aria-expanded="false"
						style="height: 1px;">
						<ul class="nav navbar-nav">
							<li class="active"><a href="${contextPath}/home-admin">Trang chu</a></li>
<!-- 							<li><a href="#">Example</a></li> -->
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"
									role="button" aria-haspopup="true" aria-expanded="false">
									Tai khoan<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="${contextPath}/account/registration-staff">
										Tao tai khoan</a></li>
									<li><a href="${contextPath}/account">Danh sach tai khoan</a></li>
<!-- 									<li role="separator" class="divider"></li>
									<li class="dropdown-header">Nav header</li>
									<li><a href="#">Separated link</a></li> -->
								</ul>
							</li>
						</ul>
					</div><!--/.nav-collapse -->
		        </div><!--/.container-fluid -->
		      </nav>
		</div>
		<img alt="home-pic" src="${contextPath}/resources/logistic-picture.jpg">
	</div>
</body>
</html>
