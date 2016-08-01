<%@ include file="/WEB-INF/pages/cmm/header.jsp" %>
<body>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp" %>

<div class="container">

	<h1>Auction: ${auction.title}</h1>
	<button class="btn btn-default">Make an offer</button>
	<br />

	<div class="row">
		<label class="col-sm-2">Number</label>
		<div class="col-sm-10">${auction.id}</div>
	</div>

</div>


<%@ include file="/WEB-INF/pages/cmm/footer.jsp" %>