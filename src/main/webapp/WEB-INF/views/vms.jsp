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
		<h3>Virtual Machines</h3>
		<c:if  test="${!empty vmlist}">
		<table>
		<c:forEach items="${vmlist}" var="vm">
		    <tr>
			    <c:choose>
				      <c:when test="${vm.running=='true'}">
					        <td class="activerow" onclick="startvm(this, '${vm.id}', '${hostAddr}')"> ${vm.name} ${vm.id} ${vm.running}
					        	<a href="/virtgraph-client/services/?address=${hostAddr}&vmid=${vm.id}">services</a> 
					        </td>
				      </c:when>
				      <c:otherwise>
					        <td class="row" onclick="startvm(this, '${vm.id}', '${hostAddr}')"> ${vm.name} ${vm.id} ${vm.running}
					        	<a href="/virtgraph-client/services/?address=${hostAddr}&vmid=${vm.id}">services</a> 
					        </td>
				      </c:otherwise>
				</c:choose>
		    </tr>
		</c:forEach>
		</table>
		</c:if>
    	<a href="/virtgraph-client/">Home</a> 
	</body>
</html>
