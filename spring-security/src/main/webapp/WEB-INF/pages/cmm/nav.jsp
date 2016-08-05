<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authentication var="principal" property="principal" />
<nav role="navigation" class="navbar navbar-inverse">
	<div class="navbar-header">
		<a href="${contextPath}" class="navbar-brand">Sping auction</a>
	</div>

	<div class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<spring:url value="/auctions" var="auctionsUrl" />
			<li><a href="${auctionsUrl}">Auctions</a></li>
			<li><a href="${contextPath}/rest/auctions">Auctions as json</a></li>
			<li><a href="${contextPath}/swagger-ui.html">Swagger</a></li>
			<sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_CREATOR')">
				<li><a href="${contextPath}/auctions/new">Add auction</a></li>
			</sec:authorize>
		</ul>

		<ul class="nav navbar-nav navbar-right">

			<li><a href="${contextPath}/login">Login</a></li>
			<li><a href="${contextPath}/logout">Logout <sec:authorize
						access="isAuthenticated()">
						<i style="color: white" class="glyphicon glyphicon-user glyphicon"></i>
						<span style="color: white"> ${principal.username} </span>
					</sec:authorize>
			</a></li>
		</ul>
	</div>
</nav>

<c:if test="${not empty param.status}">
	<div class="alert alert-danger" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<strong>${param.status}</strong>
	</div>
</c:if>
<div class="container">