<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	   <meta charset="utf-8"/>
	   <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	   <title>Staff Accounts</title>
	   <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"/>
	   <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
	   <script src="${contextPath}/resources/js/jquery-3.4.1.min.js"></script>
	   <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
	        <div class="container">
	            <div class="navbar-header">
	                <button type="button" class="navbar-toggle collapsed"
	                    data-toggle="collapse" data-target="#navbar" aria-expanded="false"
	                    aria-controls="navbar">
	                    <span class="sr-only">Toggle navigation</span> 
	                    <span class="icon-bar"></span> 
	                    <span class="icon-bar"></span> 
	                    <span class="icon-bar"></span>
	                </button>
	                <a class="navbar-brand" href="${contextPath}/account/show-all/staff">
	                	Danh Sach Tai Khoan Nhan Vien</a>
	            </div>
	        </div>
    	</nav>
    	<div class="container main-content list">
		<div th:if="${success}"
			class="row alert alert-success alert-dismissible">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<span th:text="${success}"></span>
		</div>
		<div class="row">
			<a th:href="@{/employee/create}" class="btn btn-success pull-left">
				<span class="glyphicon glyphicon-plus"></span> Add new employee
			</a>
			<form class="form-inline pull-right" action="#"
				th:action="@{/employee/search}" method="GET">
				<div class="form-group">
					<input type="text" class="form-control" name="s"
						placeholder="Type employee name..." />
				</div>
				<button type="submit" class="btn btn-primary">Search</button>
			</form>
		</div>
		<th:block th:if="${#lists.isEmpty(employees)}">
			<h3>No employee</h3>
		</th:block>

		<th:block th:unless="${#lists.isEmpty(employees)}">
			<div class="row">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>No</th>
							<th>Name</th>
							<th>Phone</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr th:each="contact,iterStat : ${employees}">
							<td th:text="${iterStat.count}"></td>
							<td th:text="${contact.name}"></td>
							<td th:text="${contact.phone}"></td>
							<td><a th:href="@{/employee/{id}/edit(id=${contact.id})}"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
							<td><a th:href="@{/employee/{id}/delete(id=${contact.id})}"><span
									class="glyphicon glyphicon-trash"></span></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</th:block>
	</div>
	</body>
</html>