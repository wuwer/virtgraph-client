<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Available hosts</title>
		<!--  works because of mvc:resource mapping in servlet-context.xml -->
		<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
		<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.2.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/script.js"/>" ></script>
	</head>
	<body>
		<h3>Hosts</h3>
		<c:if  test="${!empty hostlist}">
		<table>
		<c:forEach items="${hostlist}" var="host">
		    <tr>
<%-- 		        <td class="row" onclick=""> ${host.name} ${host.address}</td> --%>
		        <td class="row"> 
		        	<a href="/virtgraph-client/vms/?name=${host.name}?address=${host.address}">"${host.name}"</a> 
	        	</td>
		    </tr>
		</c:forEach>
		</table>
		</c:if>
	</body>
</html>
