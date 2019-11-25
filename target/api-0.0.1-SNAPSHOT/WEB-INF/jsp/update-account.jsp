<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Update an account</title>
      <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/common.css"/>" rel="stylesheet">
      <script src="<c:url
      	value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"/>"></script>
      <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </head>
  <body>
    <div class="container">
        <form method="POST" action="${contextPath}/account/update" class="form-signin">
            <h2 class="form-signin-heading">Cap nhat tai khoan</h2>
            <input type="hidden" id="idUser" name="idUser" class="form-control"
            	value="${account.idUser}"/>
            <script type="text/javascript">
            	function confirmUsername(val){
	            	if ((val.length < 3) || (val.length > 25)) {
	            		alert("Username tu 3 den 25 ky tu");
	                }
	            }
            </script>
            <input type="text" id="username" name="username" class="form-control"
            	placeholder="Username" autofocus="autofocus" value="${account.username}"
            	required="required" onChange="confirmUsername(this.value);"/>
            <script type="text/javascript">
            	function confirmPassword(val){
	            	if ((val.length < 8) || (val.length > 32)) {
	            		alert("Password tu 8 den 32 ky tu.");
	                }
	            }
            </script>
            <input type="password" id="password" name="password" class="form-control"
            	placeholder="Password" required="required" onChange="confirmPassword(this.value);"/>
            <script type="text/javascript">
            	function matchPassword(val){
	            	if (val != password.value) {
	            		alert("Password not matched.");
	                }
	            }
            </script>
            <input type="password" id="confirmPassword" class="form-control"
            	placeholder="Xac nhan password" required="required"
            	onChange="matchPassword(this.value);"/>
            <c:if test="${account.accountType.toString() == 'ADMIN'}">
        		<label for="accountType">Loai tai khoan:</label>
        		<select name='accountType' id="accountType">
				    <option value="${account.accountType}" selected>${account.accountType}
				    </option>
				    <c:forEach items="${accountTypes}" var="accountType">
				        <c:if test="${accountType != account.accountType}">
				            <option value="${accountType}">${accountType}</option>
				        </c:if>
				    </c:forEach>
				</select>
    		</c:if>
    		<c:if test="${account.accountType.toString() != 'ADMIN'}">
	    		<label for="accountType">Loai tai khoan:</label>
	    		<select name="accountType" id="accountType">
	    			<option value="${account.accountType}" selected>${account.accountType}</option>
	    		</select>
	    	</c:if>
            <script type="text/javascript">
            	function confirmFullname(val){
	            	if ((val.length < 2) || (val.length > 25)) {
	            		alert("Fullname tu 2 den 25 ky tu.");
	                }
	            }
            </script>
            <input type="text" id="fullname" name="fullname" class="form-control"
            	placeholder="Ho ten" value="${account.fullname}" 
            	required="required" onChange="confirmFullname(this.value);"/>
            <input type="text" name="address" class="form-control" placeholder="Dia chi"
            	value="${account.address}"></input>
            <script type="text/javascript">
            	function confirmPhoneNumber(val){
            		var phone_regex = /((09|03|07|08|05)+([0-9]{8})\b)/g;
	            	if (val != null && phone_regex.test(val) == false) {
	            		alert("So dien thoai khong hop le.");
	                }
	            }
            </script>
            <input type="text" id="phoneNumber" name="phoneNumber" class="form-control"
            	placeholder="So dien thoai" value="${account.phoneNumber}"
            	onChange="confirmPhoneNumber(this.value);"/>
            <script type="text/javascript">
            	function confirmIdCard(val){
	            	if (val != null && val.length < 9) {
	            		alert("CMND khong hop le.");
	                }
	            }
            </script>
            <input type="text" id="idCcard" name="idCard" class="form-control" placeholder="CMND"
            	value="${account.idCard}" onChange="confirmIdCard(this.value);"></input>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Cap nhat</button>
            <button class="btn btn-lg btn-primary btn-block" type="reset">Reset</button>
            <a href="${contextPath}/home" style="text-decoration: none">
            	<button class="btn btn-lg btn-primary btn-block">Trang chu</button>
            </a>
        </form>
    </div>
  </body>
</html>
