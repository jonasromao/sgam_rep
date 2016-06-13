
$(document).ready(function(){
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('#btnAbreModalMoradorFaturamento').click(function(){
		abrirModalMorador('faturamento');
	});
});

var insereDadosMoradorFaturamento = function(morador){
	$('#nomeMoradorFaturamento').val(morador.nome);
	$('#idMoradorFaturamento').val(morador.id);
}