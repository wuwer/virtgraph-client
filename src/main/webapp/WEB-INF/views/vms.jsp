<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Available virtual machines</title>
		<!--  works because of mvc:resource mapping in servlet-context.xml -->
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.2.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/script.js"/>" ></script>
	</head>
	<body>
		<h3>Virtual Machines</h3>
		<c:if  test="${!empty vmlist}">
		<table>
		<c:forEach items="${vmlist}" var="vm">
		    <tr>
		        <td class="row" onclick="startvm(this)"> ${vm.name} ${vm.id} ${vm.running}</td>
		        <!--td><a href="delete/${issue.id}">delete</a></td-->
		    </tr>
		</c:forEach>
		</table>
		</c:if>
	</body>
</html>
