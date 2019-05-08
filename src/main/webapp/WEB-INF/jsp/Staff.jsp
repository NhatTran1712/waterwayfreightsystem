<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<c:url var="home" value="http://localhost:8080/account" scope="request" />
		<title>User Account</title>
		<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	</head>
	<body>
		<input type="button" name="clickme" id="json-click" value="Get List By Json"/>
		<script type="text/javascript">
			$(document).ready(function(){
				$('#json-click').click(function(){
					$.ajax({
						type: 'GET',
						url: '${home}/staff/',
						headers: {
							Accept: "application/json; charset = utf-8",
							"Content-Type" : "application/json; charset = utf-8"
					},
					success : function(rawAccountOutputs) {
						var html = '';
                        
						html += '<table border="1" cellspacing="0" cellpadding="10">';
                        html += '<tr>';
                           html += '<td>';
                                html += 'ID';
                                html += '</td>';
                                html += '<td>';
                                html += 'Fullname';
                           		html += '</td>';
                           		html += '<td>';
                                html += 'Address';
                           		html += '</td>';
                           		html += '<td>';
                                html += 'PhoneNumber';
                           		html += '</td>';
                           		html += '<td>';
                                html += 'IdCard';
                           		html += '</td>';
                           		html += '<td>';
                                html += 'AccountType';
                           	html += '</td>';
                        html += '</tr>';                         
                        // Kết quả là một object json
                        // Nên ta sẽ loop result
                        $.each (rawAccountOutputs, function (key, item){
                            html +=  '<tr>';
                                html +=  '<td>';
                                    html +=  item['idUser'];
                                html +=  '</td>';
                                html +=  '<td>';
                                    html +=  item['fullname'];
                                html +=  '</td>';
                                html +=  '<td>';
                                	html +=  item['address'];
                            	html +=  '</td>';
                            	html +=  '<td>';
                            		html +=  item['phoneNumber'];
                        		html +=  '</td>';
                        		html +=  '<td>';
                        			html +=  item['idCard'];
                    			html +=  '</td>';
                    			html +=  '<td>';
                    				html +=  item['accountType'];
                				html +=  '</td>';
                            html +=  '</tr>';
                        });
                        html +=  '</table>';
                        $('#result2').html(html);
					}
					});
				});
			});
		</script>
		<div id="result2">JSON</div>
	</body>
</html>
