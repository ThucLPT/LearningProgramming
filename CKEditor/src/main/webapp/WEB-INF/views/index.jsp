<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.11.4/ckeditor.js"></script>
<script>
	$(document).ready(function() {
		CKEDITOR.replace('editor', {
			filebrowserBrowseUrl : 'browse',
			filebrowserUploadUrl : 'upload',
			filebrowserWindowHeight : '100%',
			filebrowserWindowWidth : '100%',
			resize_enabled : false
		});
	});
</script>
</head>
<body>
	<textarea id="editor"></textarea>
</body>
</html>