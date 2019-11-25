<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <title>Update a schedule</title>
      	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
	    <script src="<c:url
	    	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
	    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	</head>
  	<body>
	    <div class="container">
	    	<h2 class="form-signin-heading" align="center">Cap nhat tuyen duong</h2><br/>
	        <form method="POST" action="${contextPath}/schedule/update" class="form-signin">
	            <label for="idSchedule">ID:</label>
	            <input type="text" id="idSchedule" name="idSchedule" class="form-control"
	            	value="${schedule.idSchedule}" readonly="readonly"/>
	            <label for="nameSchedule">Ten tuyen duong:</label>
	            <input type="text" id="nameSchedule" name="nameSchedule" class="form-control"
	            	value="${schedule.nameSchedule}" autofocus="autofocus" required="required"/>
	            <label for="visitingPorts">Cang ghe qua:</label>
	            <c:forEach items="${schedule.visitingPorts}" var="port">
	        		<select id="visitingPorts">
						<option value="${port.namePort}" selected>${port.namePort}</option>
					</select>
				</c:forEach>
				<input type="hidden" name="visitingPorts" class="form-control"
	            	value="${schedule.visitingPorts}" readonly="readonly"/>
				<br/>
				<br/>
	            <label for="estimateDistance">Khoang cach (km):</label>
	            <input type="text" id="estimateDistance" name="estimateDistance" class="form-control"
	            	placeholder="Khoang cach (km)" value="${schedule.estimateDistance}"
	            	required="required"/>
	            <label for="estimateTime">Thoi gian (h):</label>
	            <input type="text" id="estimateTime" name="estimateTime" class="form-control"
	            	placeholder="Thoi gian (h)" value="${schedule.estimateTime}" required="required"/>
	            <label for="dateDepart">Ngay khoi hanh:</label>
	            <input type="datetime" id="dateDepart" name="dateDepart" class="form-control"
	            	placeholder="Ngay khoi hanh" value="${schedule.dateDepart}" required="required"/>
	            <label for="dateArrive">Ngay den:</label>
	            <input type="datetime" id="dateArrive" name="dateArrive" class="form-control"
	            	placeholder="Ngay den" value="${schedule.dateArrive}" required="required"/>
	            
	            <select name="idWhoManage" id="idWhoManage">
        			<c:forEach items="${accounts}" var="account">
					    <c:if test="${account.idUser == schedule.idWhoManage}">
						    <option value="${account.idUser}" selected>${account.fullname}</option>
					    </c:if>
					    <c:if test="${account.idUser != schedule.idWhoManage}">
					    	<option value="${account.idUser}">${account.fullname}</option>
					    </c:if>
				    </c:forEach>
				</select>
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Cap nhat</button>
	            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
	            <a href="${contextPath}/home-manager" style="text-decoration: none">
	            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
	            </a>
	        </form>
	    </div>
	</body>
</html>
