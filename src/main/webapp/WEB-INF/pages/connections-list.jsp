<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.even {
	background-color: silver;
}
</style>
<title>Connections List Page</title>
</head>
<body>


<c:if test="${fn:length(connectionsList) > 0}">
	<table cellpadding="5">
		<tr class="even">
			<th>Id</th>
			<th>Browser Data</th>
			<th>IP Address</th>
			<th>Time</th>
		</tr>
		<c:forEach items="${connectionsList}" var="connection" varStatus="status">
			<tr class="<c:if test="true">even</c:if>">
				<td>${connection.id}</td>
				<td>${connection.browserName}</td>
				<td>${connection.ipAddress}</td>
				<td>${connection.time}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
