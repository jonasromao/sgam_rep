$(document).ready(function(){
	$('#txtNumeroCR').focus();
	
	$("#txtValorCR").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

});

var insereDadosMoradorContasReceber = function(morador){
	$('#nomeMoradorOcorrencia').val(morador.nome);
	$('#idMoradorOcorrencia').val(morador.id);
}