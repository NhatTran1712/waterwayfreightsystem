<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>Add a cargo</title>
	    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	   		rel="stylesheet" />
	    <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
	    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	    	rel="stylesheet">
	    <script src="<c:url
	    	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
	    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	    <script>
	        $(document).ready(function() { 
	            $("#states").select2({
	                    placeholder: "Select a State",
	                    allowClear: true
	             }); 
	        });
		</script>
	</head>
  	<body>
	    <div class="container">
	    	<h2 class="form-signin-heading" align="center">Tao moi hang hoa</h2><br/>
	        <form method="POST" action="${contextPath}/cargo/add" class="form-signin">
	            <label for="idOwner">Nguoi so huu:</label>&nbsp;&nbsp;&nbsp;&nbsp;
        		<select name="idOwner" id="states" style="width:300px" autofocus="autofocus">
        			<c:forEach items="${accounts}" var="account">
					    <option value="${account.idUser}">${account.fullname}</option>
				    </c:forEach>
				</select>
				<br/>
				<br/>
	            <label for="cargoWeight">Trong luong (kg):</label>
	            <input type="text" id="cargoWeight" name="cargoWeight" class="form-control"
	            	placeholder="Trong luong (kg)" required="required"/><br/>
	            <label for="describe">Mo ta:</label>
	            <input type="text" id="describe" name="describe" class="form-control"
	            	placeholder="Mo ta" required="required"/><br/>
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Tao hang hoa</button>
	            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
	            <a href="${contextPath}/home-manager" style="text-decoration: none">
	            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
	            </a>
	        </form>
	    </div>
	</body>
</html>
