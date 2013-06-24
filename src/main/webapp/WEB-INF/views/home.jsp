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
		<img src="<c:url value="/resources/img/virtgraph.gif"/>" alt="logo">
		<h3>Home</h3>
    	<a href="/virtgraph-client/hosts">All registered hosts </a>
    	<br>
    	<a href="/virtgraph-client/services"> All available services </a>
	</body>
</html>
