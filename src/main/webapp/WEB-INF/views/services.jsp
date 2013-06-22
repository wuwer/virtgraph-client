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
		<img src="<c:url value="/resources/img/virtgraph.gif"/>" alt="logo">
		<h3>Services</h3>
		<c:if  test="${!empty servicelist}">
		<table>
		<c:forEach items="${servicelist}" var="service">
		    <tr>
		        <td class="row" onclick="startservice(this, '${service.name}', '${vmid}', '${hostAddr}'  )"> ${service.name} running: ${service.start}</td>
		    </tr>
		</c:forEach>
		</table>
		</c:if>
    	<a href="/virtgraph-client/">Home</a> 
	</body>
</html>
