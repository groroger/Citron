

google.charts.load("current", {
	packages : [ "corechart" ]
});
google.charts.setOnLoadCallback(drawChart);
var virtuel = document.getElementById("stockVirtuel").innerHTML;
var total = document.getElementById("stockTotal").innerHTML;
function drawChart() {
	var data = google.visualization.arrayToDataTable([
			[ 'Stocks', 'reste disponible' ], [ 'Stocks Virtuel', 75 ],
			[ 'Stocks Physiques', 25 ] ]);

	var options = {
		title : 'Mes Stocks',

		is3D : true,
		slices : {
			0 : {
				color : 'yellow'
			},
			1 : {
				color : '4DFF11'
			}
		}
	};

	var chart = new google.visualization.PieChart(document
			.getElementById('donutchart'));
	chart.draw(data, options);
}
      
