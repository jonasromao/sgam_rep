
$(document).ready(function(){
	
	$(".qtde").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('#qtdePessoasAluguelComercio').keypress(somenteNumeros);
	
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('.periodo').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY HH:mm',
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
	
	$('#aluguelComercioForm').validate({
        rules: {
            'aluguelComercio.aluguel.morador.nome': {
            	required: true
            },
            'aluguelComercio.aluguel.dataInicial': {
            	required: true
            },
            'aluguelComercio.aluguel.dataFinal': {
            	required: true
            },
            'aluguelComercio.aluguel.recurso.id': {
            	required: true,
            	min: 1
            },
            'aluguelComercio.nome': {
            	required: true
            },
            'aluguelComercio.numeroAlvara': {
            	required: true
            },
            'aluguelComercio.dataEmissao': {
            	required: true
            },
            'aluguelComercio.dataVencimento': {
            	required: true
            },
            'aluguelComercio.equipamentos': {
            	required: true
            },
            'aluguelComercio.produtos': {
            	required: true
            }
        }
    });
});

var insereDadosMoradorFaturamento = function(morador){
	$('#nomeMoradorFaturamento').val(morador.nome);
	$('#idMoradorFaturamento').val(morador.id);
}

