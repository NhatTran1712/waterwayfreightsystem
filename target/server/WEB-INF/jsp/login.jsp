<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in</title>
      <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Dang nhap</h2>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span style="color:red">${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Dang nhap</button>
            <h4 class="text-center"><a href="${contextPath}/account/registration">Dang ky</a></h4>
            <h4 class="text-center"><a href="${contextPath}/home">Trang chu</a></h4>
        </div>
      </form>
    </div>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>" >
    </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </body>
</html>
