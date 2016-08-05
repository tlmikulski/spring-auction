<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>

	<div class="well row searchBar">
		<div class="col-xs-8">
			<i>Current active Auctions</i>
		</div>
		<div class="col-xs-4">
			<div class="input-group">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span> <input type="text" class="form-control searcher"
					placeholder="Wyszukaj..."> <span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-refresh"></i>
					</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
	</div>

	<c:if test="${not empty msg}">
		<div class="alert alert-success" role="alert">
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Well done!</strong> ${msg}
		</div>
	</c:if>

	<table class="table table-striped table-hover">
		<tr>
			<th>Number</th>
			<th>Current price</th>
			<th>Auction Type</th>
			<th>Expiry date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="auction" items="${auctions}">
			<tr>
				<td>${auction.number}</td>
				<td>${auction.currentPrice}</td>
				<td>${auction.auctionType.fullName}</td>
				<td>${auction.expiryDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))}</td>
				<td><a href="#show"><i
						class=" glyphicon glyphicon-search"></i></a>
						 
						<a href="auctions/${auction.id}/edit"><i
						class=" glyphicon glyphicon-pencil"></i></a>
						
						<a href="auctions/${auction.id}/delete"><i
						class=" glyphicon glyphicon-remove-circle"></i></a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="/WEB-INF/pages/cmm/footer.jsp"%>
