<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
	<head>
	   <meta charset="utf-8"/>
	   <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
	   <title>Schedules</title>
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
					<a href="${contextPath}/home-manager">
						<button class="btn btn-primary">Trang chu</button>
					</a>
					<a href="${contextPath}/schedule">
						<button class="btn btn-primary">Danh sach</button>
					</a>
				</div>
				<form method="GET" class="form-inline pull-right"
					action="${contextPath}/schedule/search">
					<div class="form-group">
						<input type="text" class="form-control" name="nameSchedule"
							placeholder="Nhap ten dia diem..."/>
					</div>
				<button type="submit" class="btn btn-primary">Tim kiem</button>
				</form>
			</div>
			<c:if test="${schedules.isEmpty()}">
				<h3>Khong co tuyen duong</h3>
			</c:if>
			<c:if test="${!schedules.isEmpty()}">
				<div class="row">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>Ten tuyen duong</th>
								<th>Cang ghe qua</th>
								<th>Khoang cach</th>
								<th>Thoi gian</th>
								<th>Ngay gio xuat phat</th>
								<th>Ngay gio den</th>
								<th>Nguoi quan ly</th>
								<th>Cap nhat</th>
								<th>Xoa</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${schedules}" var="schedule">
								<tr>
									<td>${schedule.idSchedule}</td>
									<td>${schedule.nameSchedule}</td>
									<td>
									    <c:forEach items="${schedule.visitingPorts}" var="port">
									    	<a href="${contextPath}/port/show?id=${port.idPort}">
												${port.namePort}-</a>&nbsp;&nbsp;
									    </c:forEach>
									</td>
									<td>${schedule.estimateDistance}</td>
									<td>${schedule.estimateTime}</td>
									<td>${schedule.dateDepart}</td>
									<td>${schedule.dateArrive}</td>
									<td>
										<c:forEach items="${accounts}" var="account">
									        <c:if test="${account.idUser == schedule.idWhoManage}">
									            <a href="${contextPath}/account/show?username=${account.username}">
												${account.fullname}</a>
									        </c:if>
									    </c:forEach>
									</td>
									<td>
										<a href="${contextPath}/schedule/update?id=${schedule.idSchedule}">
											<span class="glyphicon glyphicon-pencil"></span>
										</a>
									</td>
									<td>
										<a href="${contextPath}/schedule/delete?id=${schedule.idSchedule}">
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