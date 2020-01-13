$(function() {
	function split(val) {
		return val.split(/,\s*/);
	}
	function extractLast(term) {
		return split(term).pop();
	}
	function displayProduct(product) {
		var s = '';
		for (var i = 0; i < product.length; i++) {
			s += '<tr class="text-center">';
			s += '<td>';
			s += '<img src="' + product[i].img + '" height="200px" width="200px">';
			s += '<h3>' + product[i].name + '</h3>';
			s += '<h4>' + product[i].price + '</h4>';
			s += '<a class="btn btn-primary" href="add/' + product[i].id + '"><i class="fa fa-cart-plus"></i></a></td>';;
			s += '</td>';
			s += '</tr>';
		}
		$('#tableProductList').html(s);
	}
	$('#myAutocomplete').autocomplete({
		source : function(request, response) {
			$.getJSON('search', {
				term : extractLast(request.term)
			}, response);
		},
		multiselect : true
	});
	$("#searchForm").submit(function(e) {
		e.preventDefault();
		$.ajax({
			type : 'GET',
			dataType : 'json',
			url : 'find',
			data : $('#searchForm .keyword').serialize(),
			success : function(product) {
				displayProduct(product);
				$("div").remove(".ui-autocomplete-multiselect-item");
			}
		});
	});
	$("#slider-range").slider({
		range : true,
		min : 0,
		max : 10000,
		step : 1000,
		slide : function(event, ui) {
			$("#amount").val(ui.values[0] + " - " + ui.values[1]);
			var min = ui.values[0];
			var max = ui.values[1];
			$.get('search/' + min + '/' + max, function(product) {
				displayProduct(product);
			});
		}
	});
});