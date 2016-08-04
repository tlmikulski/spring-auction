<%@ include file="/WEB-INF/pages/cmm/header.jsp" %>
<body>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp" %>

	
	<h1>Auction: ${auction.title}</h1>
	<br />
<form:form class="form-horizontal" modelAttribute="auction">
			
	<div class="row">
		<label class="col-sm-2">Number</label>
		<form:input path="number" type="text" class="col-sm-10" readonly="true"/>
	</div>
	<div class="row">
		<label class="col-sm-2">Title</label>
		<form:input path="title" type="text" class="col-sm-10" readonly="true"/>
	</div>
	<div class="row">
		<label class="col-sm-2">Description</label>
		<form:textarea path="description" type="text" class="col-sm-10" readonly="true"/>
	</div>
	<div class="row">
		<label class="col-sm-2">Current price</label>
		<form:input path="currentPrice" type="text" class="col-sm-10" readonly="true"/>
	</div>
	<div class="row">
		<label class="col-sm-2">Shipping price</label>
		<form:input path="shippingPrice" type="text" class="col-sm-10" readonly="true"/>
	</div>
</form:form>

<%@ include file="/WEB-INF/pages/cmm/footer.jsp" %>