<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Cargo Information</title>
      <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
      <script src="<c:url
      	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
      <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </head>
  <body>
    <div class="container">
    	<div class="form-signin">
	        <h2 class="form-signin-heading">Thong tin hang</h2><br>
	        <label for="idCargo">ID:</label>
	        <input type="text" id="idCargo" class="form-control" value="${cargo.idCargo}" 
	        	readonly="readonly"/>
	        <label for="idOwner">Nguoi so huu:</label>&nbsp;&nbsp;&nbsp;&nbsp;
	        <c:forEach items="${accounts}" var="account">
		        <c:if test="${account.idUser == cargo.idOwner}">
			        <input type="text" id="idOwner" class="form-control" value="${account.fullname}"
			        	readonly="readonly"/>&nbsp;&nbsp;&nbsp;&nbsp;
		    		<a href="${contextPath}/account/show?username=${account.fullname}">+Xem thong tin</a>
			    </c:if>
		    </c:forEach>
		    <br/>
	        <label for="cargoWeight">Trong luong:</label>
	        <input type="text" id="cargoWeight" class="form-control" value="${cargo.cargoWeight}"
	        	readonly="readonly"/>
	        <a href="${contextPath}/cargo/update?id=${cargo.idCargo}"
	        	style="text-decoration: none"><button class="btn btn-lg btn-primary btn-block">
	        	Cap nhat</button>
	        </a>
	        <a href="${contextPath}/cargo" style="text-decoration: none">
	        	<button class="btn btn-lg btn-primary btn-block">Danh sach</button>
	        </a>
	        <a href="${contextPath}/home-manager" style="text-decoration: none">
	        	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
	        </a>
    	</div>
    </div>
  </body>
</html>
