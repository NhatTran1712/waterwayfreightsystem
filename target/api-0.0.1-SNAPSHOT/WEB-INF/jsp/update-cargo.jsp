<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>Update a cargo</title>
      	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
	    <script src="<c:url
	    	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
	    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	</head>
  	<body>
	    <div class="container">
	    	<h2 class="form-signin-heading" align="center">Cap nhat thong tin hang</h2><br/>
	        <form method="POST" action="${contextPath}/cargo/update" class="form-signin">
	            <label for="idCargo">ID:</label>
	            <input type="text" id="idCargo" name="idCargo" class="form-control"
	            	value="${cargo.idCargo}" readonly="readonly"/>
	            <label for="idOwner">Nguoi so huu:</label>&nbsp;&nbsp;&nbsp;&nbsp;
        		<select name="idOwner" id="idOwner" autofocus="autofocus">
        			<c:forEach items="${accounts}" var="account">
					    <c:if test="${account.idUser == cargo.idOwner}">
						    <option value="${account.idUser}" selected>${account.fullname}</option>
					    </c:if>
					    <c:if test="${account.idUser != cargo.idOwner}">
					    	<option value="${account.idUser}">${account.fullname}</option>
					    </c:if>
				    </c:forEach>
				</select>
				<br/>
				<br/>
	            <label for="cargoWeight">Trong luong (kg):</label>
	            <input type="text" id="cargoWeight" name="cargoWeight" class="form-control"
	            	placeholder="Trong luong (kg)" value="${cargo.cargoWeight}" required="required"/>
	            <label for="describe">Mo ta:</label>
	            <input type="text" id="describe" name="describe" class="form-control"
	            	placeholder="Mo ta" value="${cargo.describe}" required="required"/>
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Cap nhat</button>
	            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
	            <a href="${contextPath}/home-manager" style="text-decoration: none">
	            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
	            </a>
	        </form>
	    </div>
	</body>
</html>
