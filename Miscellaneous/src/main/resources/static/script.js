$(function() {
	$('#dropSection').filedrop({
		fallback_id : 'btnUpload',
		fallback_dropzoneClick : true,
		url : 'upload',
		allowedfileextensions : [ '.jpg', '.jpeg', '.png', '.gif' ],
		paramname : 'file',
		maxfiles : 5,
		maxfilesize : 2,
		dragOver : function() {
			$('#dropSection').addClass('active');
		},
		dragLeave : function() {
			$('#dropSection').removeClass('active');
		},
		drop : function() {
			$('#dropSection').removeClass('active');
		},
		uploadFinished : function(i, file, response, time) {
			$('#uploadedFiles').append(file.name + '<br>');
		}
	});
});