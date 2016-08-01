<nav role="navigation" class="navbar navbar-inverse">
		<div class="navbar-header">
			<a href="${contextPath}" class="navbar-brand">Sping auction</a>
		</div>

		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<spring:url value="/auctions" var="auctionsUrl" />
				<li ><a href="${auctionsUrl}">Auctions</a></li>
				<li><a href="#">Offers</a></li>
				<li><a href="#">Add auction</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
			</ul>
		</div>
	</nav>