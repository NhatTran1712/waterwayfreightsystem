<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Admin Home Page</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
  <div class="container">
  	<h2 align="left">He Thong Van Chuyen Hang Hoa Duong Thuy</h2>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h6 align="right">
        	<a href="${contextPath}/account?username=${pageContext.request.userPrincipal.name}">
        		${pageContext.request.userPrincipal.name}</a> |
        		<a onclick="document.forms['logoutForm'].submit()">dang xuat</a><br/>
        </h6>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <h6 align="right">
        	<a href="${contextPath}/login">Dang nhap</a> |
        		<a href="${contextPath}/account/registration">Dang ky</a>
        </h6>
    </c:if>
    <div class="menubar" align="center">
    	<h5>
    		<a href="${contextPath}/account/registration-staff" style="color:red">Tao tai khoan</a>
    	</h5>
    </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
