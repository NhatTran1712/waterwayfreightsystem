<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Account Information</title>
      <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
      <script src="<c:url
      	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
      <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </head>
  <body>
    <div class="container">
    	<div class="form-signin">
	        <h2 class="form-signin-heading">Thong tin tai khoan</h2><br>
	        <label for="username">Username:</label>
	        <input type="text" id="username" class="form-control" value="${account.username}" 
	        	readonly="readonly"/>
	        <label for="accountType">Loai tai khoan:</label>
	        <input type="text" id="accountType" class="form-control" value="${account.accountType}"
	        	readonly="readonly"/>
	        <label for="fullname">Ho ten:</label>
	        <input type="text" id="fullname" class="form-control" value="${account.fullname}"
	        	readonly="readonly"/>
	        <label for="address">Dia chi:</label>
	        <input type="text" id="address" class="form-control" value="${account.address}"
	        	readonly="readonly"/>
	        <label for="phoneNumber">So dien thoai:</label>
	        <input type="text" id="phoneNumber" class="form-control" value="${account.phoneNumber}"
	        	readonly="readonly"/>
	        <label for="idCard">CMND:</label>
	        <input type="text" id="idCard" class="form-control" value="${account.idCard}"
	        	readonly="readonly"/>
	        <a href="${contextPath}/account/update?username=${account.username}"
	        	style="text-decoration: none"><button class="btn btn-lg btn-primary btn-block">
	        	Cap nhat</button>
	        </a>
	        <c:if test="${account.username != pageContext.request.userPrincipal.name}">
	        	<a href="${contextPath}/home-admin" style="text-decoration: none">
		        	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
		        </a>
	        </c:if>
	        <c:if test="${account.username == pageContext.request.userPrincipal.name}">
		        <c:if test="${account.accountType.toString() == 'ADMIN'}">
			        <a href="${contextPath}/home-admin" style="text-decoration: none">
			        	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
			        </a>
		        </c:if>
		        <c:if test="${account.accountType.toString() != 'ADMIN'}">
			        <a href="${contextPath}/home" style="text-decoration: none">
			        	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
			        </a>
		        </c:if>
		    </c:if>
    	</div>
    </div>
  </body>
</html>
