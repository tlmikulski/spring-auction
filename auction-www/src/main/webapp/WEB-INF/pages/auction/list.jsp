<%@ include file="/WEB-INF/pages/cmm/header.jsp" %>
<body>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp" %>

	<div class="well">
		<i>Current active Auctions</i>
		<div class="pull-right">
			<div class="input-group">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</span> <input type="text" 
					class="form-control searcher" placeholder="Wyszukaj...">
				<span class="input-group-btn">
					<button  class="btn btn-default" type="button">
						<i class="glyphicon glyphicon-refresh"></i>
					</button>
				</span>
			</div>
			<!-- /input-group -->
		</div>
	</div>
	<table class="table table-striped table-hover">
		<tr>
			<th>Number</th>
			<th>Title</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="auction" items="${auctions}">
			<tr>
				<td><a href="auctions/${auction.id}/show">${auction.number}</a></td>
				<td>${auction.title}</td>
				<td><a href="auctions/${auction.id}/show"><i class=" glyphicon glyphicon-search"></i></a>
				<a href="#"><i class="glyphicon glyphicon-shopping-cart"></i></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
<%@ include file="/WEB-INF/pages/cmm/footer.jsp" %>
