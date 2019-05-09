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
            <h2 class="form-signin-heading">Thong tin tai khoan</h2>
            <input type="text" class="form-control" value="${account.username}" readonly="readonly"/>
            <input type="text" class="form-control" value="${account.fullname}" readonly="readonly"/>
            <input type="text" class="form-control" value="${account.address}" readonly="readonly"/>
            <input type="text" class="form-control" value="${account.phoneNumber}"
            	readonly="readonly"/>
            <input type="text" class="form-control" value="${account.idCard}" readonly="readonly"/>
            <a href="${contextPath}/account/update?username=${account.username}"
            	style="text-decoration: none">
	            <button class="btn btn-lg btn-primary btn-block">Cap nhat</button>
            </a>
            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
            <a href="${contextPath}/home" style="text-decoration: none">
            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
            </a>
    </div>
  </body>
</html>
