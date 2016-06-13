$(document).ready(function(){
	
	$('#txtNomeRecurso').focus();
	
	$("#txtValorRecurso").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});

});