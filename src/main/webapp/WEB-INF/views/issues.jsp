<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Issues</title>
	</head>
	<body>
		<h3>Issues</h3>
		<c:if  test="${!empty issues}">
		<table>
		<c:forEach items="${issues}" var="issue">
		    <tr>
		        <td>${issue.description} </td>
		        <!--td><a href="delete/${issue.id}">delete</a></td-->
		    </tr>
		</c:forEach>
		</table>
		</c:if>
	</body>
</html>
