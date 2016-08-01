<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>

	<spring:url value="/users" var="userActionUrl" />
<div class="container">
	<c:choose>
		<c:when test="${auction.id==null}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>
	
	<form:form class="form-horizontal" method="post" 
	modelAttribute="auction" action="${userActionUrl}">
		<form:hidden path="id" />
		

		<spring:bind path="title">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="col-sm-2 control-label">Title</label>
				<div class="col-sm-10">
					<form:input path="title" type="text" class="form-control " id="title"
						placeholder="Title" />
					<form:errors path="title" class="control-label" />
				</div>
			</div>
		</spring:bind>
	</form:form>
	</div>
</body>
</html>