<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.thumbnail {
	border: thin solid;
	float: left;
	margin: 1px;
	padding: 1px
}

img {
	display: block;
	margin: auto;
}
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.11.4/ckeditor.js"></script>
<script>
	$(document).ready(function() {
		var funcNum = 0;
		$('#fileExplorer').on('click', 'img', function() {
			var fileUrl = '/upload/' + $(this).attr('title');
			window.opener.CKEDITOR.tools.callFunction(funcNum, fileUrl);
			window.close();
		}).hover(function() {
			$(this).css('cursor', 'pointer');
		});
	});
</script>
</head>
<body>
	<div id="fileExplorer">
		<c:forEach var="file" items="${files}">
			<div class="thumbnail">
				<img src="${pageContext.request.contextPath}/upload/${file.name}" title="${file.name}" height="100px" width="100px">
				<br>
				${file.name}
			</div>
		</c:forEach>
	</div>
</body>
</html>