<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>

	<spring:url value="" var="auctionSaveUrl" />
	<div class="container">
		<c:choose>
			<c:when test="${auction.id==null}">
				<h1>Add auction</h1>
			</c:when>
			<c:otherwise>
				<h1>Update auction</h1>
			</c:otherwise>
		</c:choose>

		<form:form class="form-horizontal" method="post"
			modelAttribute="auction" action="${auctionSaveUrl}">
			<form:hidden path="id" />
			<form:hidden path="number" />
			<form:hidden path="currentPrice" />


			<spring:bind path="title">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Title</label>
					<div class="col-sm-10">
						<form:input path="title" type="text" class="form-control "
							id="title" placeholder="Title" />
						<form:errors path="title" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="description">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Description</label>
					<div class="col-sm-10">
						<form:textarea path="description" type="text"
							class="form-control " id="description" placeholder="Description" />
						<form:errors path="description" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="shippingPrice">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Shipping price</label>
					<div class="col-sm-10">
						<form:input path="shippingPrice" type="text" class="form-control "
							id="shippingPrice" placeholder="Shipping price" />
						<form:errors path="shippingPrice" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="auctionType">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Auction type</label>
					<div class="col-sm-10">
						<form:select path="auctionType" type="text" class="form-control "
							id="auctionType" placeholder="Auction type" >
							<form:options  itemLabel="fullName"/>
							</form:select>
						<form:errors path="auctionType" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="expiryDate">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Expiry date</label>
					<div class="col-sm-10">
						<form:input path="expiryDate" type="datetime" class="form-control "
							id="auctionType" placeholder="Expiry date" />
						<form:errors path="expiryDate" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<button type="submit" class="btn btn-primary pull-right">Save
                             </button>
		</form:form>
	</div>
</body>
</html>