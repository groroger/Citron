
google.charts.load("current", { packages : [ "corechart" ] });

google.charts.setOnLoadCallback(drawChart);

var virtuel = document.getElementById('stockVirtuel').innerHTML;
virtuel = parseInt(virtuel,10);
var total = document.getElementById('stockTotal').innerHTML;
total = parseInt(total,10);

console.log(total +"   " + virtuel);

function drawChart() {
	var data = google.visualization.arrayToDataTable([
			[ 'Stocks', 'reste disponible' ], [ 'Stocks Virtuel', total ],
			[ 'Stocks Physiques', virtuel ] ]);

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

	var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
	
	chart.draw(data, options);
}


var n = document.getElementById('commandesAtraiter').innerHTML;
console.log(n);
var cpt = 0;
var duree = 1;
var delta = Math.ceil((duree * 1000) / n);
var node =  document.getElementById('compteur');
 
function countdown() {
	node.innerHTML = ++cpt;
  
  if( cpt < n ){
     setTimeout(countdown, delta);
  }
}

setTimeout(countdown, delta);



      
