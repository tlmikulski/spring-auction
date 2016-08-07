<%@ include file="/WEB-INF/pages/cmm/header.jsp"%>
<%@ include file="/WEB-INF/pages/cmm/nav.jsp"%>

<div class="jumbotron">
  <h1>Hello, world!</h1>
  <p>Spring sample app</p>
  </div>
  
<%@ include file="/WEB-INF/pages/cmm/footer.jsp"%>

<script>
$(document).ready(function(){
	$.ajax({
		  type: "POST",
		  url: 'http://localhost:9000/resource/',
		  data: {},
		  success: function(a,b,c){
			  alert(c.getResponseHeader('Cookie'));
		  },
		  error: function (a, b, c) {
			  alert(a.getAllResponseHeaders());
		   }
		});
	
})
</script>