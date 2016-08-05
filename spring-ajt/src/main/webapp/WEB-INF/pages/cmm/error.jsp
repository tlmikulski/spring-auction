<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron">
  <h1>Ups :-/</h1>
  <p><spring:message code="error.msg" /></p>
  </div>
  
  <c:forEach items="${exception.stackTrace}" var="element">
    <c:out value="${element}" />
</c:forEach>

<%@ include file="/WEB-INF/pages/cmm/footer.jsp"%>
