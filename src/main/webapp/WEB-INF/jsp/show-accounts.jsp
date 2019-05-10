<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	   <meta charset="utf-8"/>
	   <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	   <title>Staff Accounts</title>
	   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	   		rel="stylesheet" />
	   <link href="${contextPath}/resources/css/style.css" rel="stylesheet"/>
	   <script src="${contextPath}/resources/js/jquery-3.4.1.min.js"></script>
	   <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	</head>
	<body>
		<div class="container main-content list">
			<c:if test="${success != null}">
				<div class="row alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<span>${success}</span>
				</div>
			</c:if>
			<div class="row">
				<div class="form-inline pull-left">
					<a href="${contextPath}/home-admin">
						<button class="btn btn-primary">Trang chu</button>
					</a>
					<a href="${contextPath}/account">
						<button class="btn btn-primary">Danh sach</button>
					</a>
				</div>
				<form method="GET" class="form-inline pull-right"
					action="${contextPath}/account/search">
					<div class="form-group">
						<input type="text" class="form-control" name="fullname"
							placeholder="Nhap ho ten..."/>
					</div>
				<button type="submit" class="btn btn-primary">Tim kiem</button>
				</form>
			</div>
			<c:if test="${accounts.isEmpty()}">
				<h3>Khong co tai khoan</h3>
			</c:if>
			<c:if test="${!accounts.isEmpty()}">
				<div class="row">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Username</th>
								<th>Loai tai khoan</th>
								<th>Ho ten</th>
								<th>Dia chi</th>
								<th>So dien thoai</th>
								<th>CMND</th>
								<th>Cap nhat</th>
								<th>Xoa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${accounts}" var="account">
								<tr>
									<td>${account.idUser}</td>
									<td>${account.username}</td>
									<td>${account.accountType.toString()}</td>
									<td>${account.fullname}</td>
									<td>${account.address}</td>
									<td>${account.phoneNumber}</td>
									<td>${account.idCard}</td>
									<td>
										<a href="${contextPath}/account/update?username=${account.username}">
											<span class="glyphicon glyphicon-pencil"></span>
										</a>
									</td>
									<td>
										<a href="${contextPath}/account/delete?username=${account.username}">
											<span class="glyphicon glyphicon-trash"></span>
										</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</body>
</html>