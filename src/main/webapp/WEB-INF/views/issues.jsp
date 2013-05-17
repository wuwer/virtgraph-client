<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Issues</title>
		<!--  works because of mvc:resource mapping in servlet-context.xml -->
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
		<script type="text/javascript" src="<c:url value="/resources/js/issues.js"/>" ></script>
	</head>
	<body>
		<h3>Issues</h3>
		<c:if  test="${!empty issues}">
		<table>
		<c:forEach items="${issues}" var="issue">
		    <tr>
		        <td class="row" onclick="setActive(this)"> ${issue.description} </td>
		        <!--td><a href="delete/${issue.id}">delete</a></td-->
		    </tr>
		</c:forEach>
		</table>
		</c:if>
	</body>
</html>
