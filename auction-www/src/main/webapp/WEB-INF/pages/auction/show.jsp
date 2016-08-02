<%@ include file="/WEB-INF/pages/cmm/header.jsp" %>
<body>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp" %>



	
	<div class="pull-right">
		<spring:url value="" var="offerSaveUrl" />
		<form:form class="form-horizontal" method="post"
			modelAttribute="offer" action="${offerSaveUrl}">
			<spring:bind path="bid">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<div class="col-sm-10">
						<form:input path="bid" type="text" class="form-control "
							id="bid" placeholder="Your offer" />
						<form:errors path="bid" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<button class="btn btn-primary center">Make an offer</button>
		</form:form>
	</div>
	<h1>Auction: ${auction.title}</h1>
	<br />

	<div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${auction.number}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Title</label>
		<div class="col-sm-10">${auction.title}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Description</label>
		<div class="col-sm-10">${auction.description}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Current price</label>
		<div class="col-sm-10">${auction.currentPrice}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Shipping price</label>
		<div class="col-sm-10">${auction.shippingPrice}</div>
	</div>
	<div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${auction.shippingPrice}</div>
	</div>



<%@ include file="/WEB-INF/pages/cmm/footer.jsp" %>