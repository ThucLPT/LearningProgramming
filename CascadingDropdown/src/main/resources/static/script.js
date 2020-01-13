$(document).ready(function() {
	$('#city').on('change', function() {
		$('#ward option').remove();
		var cityId = $('#city option:selected').val();
		$.ajax({
			type : 'GET',
			url : 'getDistricts/' + cityId,
			success : function(result) {
				var s = '<option disabled selected>Select a District</option>';
				for (var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				}
				$('#district').html(s);
			}
		});
	});
	$('#district').on('change', function() {
		var districtId = $('#district option:selected').val();
		$.ajax({
			type : 'GET',
			url : 'getWards/' + districtId,
			success : function(result) {
				var s = '<option disabled selected>Select a Ward</option>';
				for (var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
				}
				$('#ward').html(s);
			}
		});
	});
});