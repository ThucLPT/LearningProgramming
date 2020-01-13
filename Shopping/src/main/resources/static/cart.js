function displayCart(data) {
	var s = '';
	var sum = 0;
	for (var i = 0; i < data.length; i++) {
		sum += parseInt(data[i].product.price) * parseInt(data[i].quantity) ;
		s += '<tr class="text-center">';
		s += '<td>' + data[i].product.name + '</td>';
		s += '<td>' + data[i].product.price + '</td>';
		s += '<td><input type="number" class="form-control" value="' + data[i].quantity + '" name="quantity" min="1" required></td>';
		s += '<td>' + parseInt(data[i].product.price) * parseInt(data[i].quantity) + '</td>';
		s += '<td><button type="button" class="btn btn-danger" onclick="remove(' + data[i].product.id + ')"><i class="fa fa-remove"></i></button></td>';
		s += '</tr>';
	}
	$('#cart tbody').html(s);
	$('#cart tfoot').html('<tr class="text-center"><td colspan="3"></td><th>' + sum + '</th><td></td></tr>');
}
function add(id) {
	$.ajax({
		type : 'GET',
		dataType : 'json',
		url : 'add/' + id,
		success : function(data) {
			displayCart(data);
		}
	});
}
function remove(id) {
	$.ajax({
		type : 'GET',
		dataType : 'json',
		url : 'remove/' + id,
		success : function(data) {
			displayCart(data);
		}
	});
}