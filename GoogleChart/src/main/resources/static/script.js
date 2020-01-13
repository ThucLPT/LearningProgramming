$(document).ready(
		function() {
			$.ajax({
				type : 'GET',
				dataType : 'json',
				contentType : 'application/json',
				url : 'api',
				success : function(result) {
					google.charts.load('current', {
						'packages' : [ 'corechart' ]
					});
					google.charts.setOnLoadCallback(function() {
						drawChart(result);
					});
				}
			});
			function drawChart(result) {
				var data = new google.visualization.DataTable();
				data.addColumn('string', 'Name');
				data.addColumn('number', 'Quantity');
				var dataArray = [];
				$.each(result, function(i, obj) {
					dataArray.push([ obj.name, obj.quantity ]);
				});
				data.addRows(dataArray);
				var option = {
					width : 400,
					height : 300
				};
				var piechart = new google.visualization.PieChart(document.getElementById('piechart_div'));
				piechart.draw(data, option);
				var barchart = new google.visualization.BarChart(document.getElementById('barchart_div'));
				barchart.draw(data, option);
			}
		});