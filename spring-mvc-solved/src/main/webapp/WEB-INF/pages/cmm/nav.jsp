<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<nav role="navigation" class="navbar navbar-inverse">
		<div class="navbar-header">
			<a href="${contextPath}" class="navbar-brand">Sping auction</a>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<spring:url value="/auctions" var="auctionsUrl" />
				<li ><a href="${auctionsUrl}">Auctions</a></li>
				<li><a href="${contextPath}/rest/auctions">Auctions as json</a></li>
				<li><a href="${contextPath}/swagger-ui.html">Swagger</a></li>
				<li><a href="${contextPath}/auctions/new">Add auction</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="${contextPath}/login">Login</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">