<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create an account</title>
      <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
  </head>
  <body>
    <div class="container">
        <form:form method="POST" modelAttribute="userForm" class="form-signin">
            <h2 class="form-signin-heading">Tao tai khoan</h2>
            <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="username" class="form-control"
                    	placeholder="Username" autofocus="true"></form:input>
                    <form:errors path="username"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="password" class="form-control"
                    	placeholder="Password"></form:input>
                    <form:errors path="password"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="passwordConfirm">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="password" path="passwordConfirm" class="form-control"
                    	placeholder="Confirm your password"></form:input>
                    <form:errors path="passwordConfirm"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="accountType">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:select path="accountType">
    					<form:options items="${accountTypeList}" />
					</form:select>
                    
                </div>
            </spring:bind>
            <spring:bind path="fullname">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="fullname" class="form-control"
                    	placeholder="Ho ten"></form:input>
                    <form:errors path="fullname"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="address">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="address" class="form-control"
                    	placeholder="Dia chi"></form:input>
                    <form:errors path="address"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="phoneNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="phoneNumber" class="form-control"
                    	placeholder="So dien thoai"></form:input>
                    <form:errors path="phoneNumber"></form:errors>
                </div>
            </spring:bind>
            <spring:bind path="idCard">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="idCard" class="form-control"
                    	placeholder="CMND"></form:input>
                    <form:errors path="idCard"></form:errors>
                </div>
            </spring:bind>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Tao</button>
            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
            <a href="${contextPath}/home">
            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
            </a>
        </form:form>
    </div>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>">
    </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </body>
</html>
