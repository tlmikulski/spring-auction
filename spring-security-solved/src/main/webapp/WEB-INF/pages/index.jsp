<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>Spring sample app</p>
  </div>
  
<%@ include file="/WEB-INF/pages/cmm/footer.jsp"%>

<script>
$(document).ready(function(){
	var xsrf = document.cookie.split("=")[1];
	$.ajax({
		  type: "POST",
		  url: 'http://localhost:8080/auction-security-solved/rest/auctions',
		  data: {},
		  headers :{'X-XSRF-TOKEN': xsrf},
		  success: function(a,b,c){
		  },
		  error: function (a, b, c) {
		   }
		});
})
</script>