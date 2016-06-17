
$(document).ready(function(){
	
	$(".qtde").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('#qtdePessoasAluguelComercio').keypress(somenteNumeros);
	
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY HH:mm',
		allowInputToggle: true,
		showClear: true
	});
	
	$('.dataAlvara').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	}); 
	
	$('#dataPagamentoAluguelComercio').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('#btnAbreModalMoradorFaturamento').click(function(){
		abrirModalMorador('faturamento');
	});
	
	$('#btnSalvarAluguelComercio').click(function(){
		var dataHoraInicio = $('#dataInicioAluguelComercio').val();
		var dataHoraFinal = $('#dataFinalAluguelComercio').val();
		
		$('#dataHoraInicioAluguelComercio').val(dataHoraInicio);
		$('#dataHoraFinalAluguelComercio').val(dataHoraFinal);
	});
});

var insereDadosMoradorFaturamento = function(morador){
	$('#nomeMoradorFaturamento').val(morador.nome);
	$('#idMoradorFaturamento').val(morador.id);
}

var somenteNumeros = function(e) {
    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        return false;
    }
}