var myBarChart = null;

$(document).ready(function() {
	montaGrafico('Dia');
	
	$('#btnGraficoDiario').click(function(){
		myBarChart.destroy();
		montaGrafico('Dia');
	});
	
	$('#btnGraficoMensal').click(function(){
		myBarChart.destroy();
		montaGrafico('Mês');
	});
    
});

var montaGrafico = function(agrupamento){
	$.ajax({
		url: '/sgam/metricas/motaGrafico/'+ agrupamento,
		type: 'GET'
	}).done(function(data, textStatus, jqXHR) {
		var dadosGrafico = data.dados;
		
		$('#valorTotal').text('R$ ' + formatNumber(dadosGrafico.valorTotal, 2, ',',  '.'));
		var rotulos = [];
		var valores = [];
		
		if(agrupamento == 'Dia'){
			$.each(dadosGrafico.datas, function (i, data) {
			    rotulos.push(moment(data).format("DD/MM"));	
			});
		}
	    else if(agrupamento == 'Mês'){
	    	rotulos = dadosGrafico.nomeMeses;
	    }
	    
	    valores = dadosGrafico.valores;
		
		var dados = {
		    labels: rotulos,
		    datasets: [
		        {
		            label: "Valor recebido",
		            backgroundColor: "rgba(255,99,132,0.2)",
		            borderColor: "rgba(255,99,132,1)",
		            borderWidth: 1,
		            hoverBackgroundColor: "rgba(255,99,132,0.4)",
		            hoverBorderColor: "rgba(255,99,132,1)",
		            data: valores,
		        }
		    ]
		};
		
		var config = {
		    type: 'bar',
		    responsive: true,
		    data: dados,
		    options: {
		        scales: {
	                xAxes: [{
	                        stacked: true
	                }],
	                yAxes: [{
	                        stacked: true
	                }]
	            },
	            legend: {
	                display: false
	             },
	            tooltips: {
	                callbacks: {
	                    label: function(tooltipItem, data) {
	                    	var value = data.datasets[tooltipItem.datasetIndex].data[tooltipItem.index];
	                        return 'Valor: R$ ' + formatNumber(value, 2, ',',  '.');
	                    }
	                }
	            }
		
	        }
		    
		}

		var ctx = $('#grafico');
		myBarChart = new Chart(ctx, config);

	}).fail(function(jqXHR, textStatus, errorThrown){
		swal('Erro', 'Erro ao buscar dados do gráfico', 'error');
	});
}