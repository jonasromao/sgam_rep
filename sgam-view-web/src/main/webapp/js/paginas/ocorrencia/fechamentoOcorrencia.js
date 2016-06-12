$(document).ready(function(){
	
	$('.height-scroll').slimscroll({
        height: '485px'
    });
	
	$('#dataFechamento').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

	$('#btnSalvar').click(function() {
		$('#descricaoFechamentoOcorrencia').summernote({focus: true});
		var descricaoFechamento = $('#descricaoFechamentoOcorrencia').code();
		var dataInicio = $('#dataInicioFechamentoOcorrencia').text();
		var dataFechamento = $('#dataFechamento').val();
		
	 	$('#dataInicioHidden').val(dataInicio);
	 	$('#dataFechamentoHidden').val(dataFechamento);
	 	$('#descricaoHidden').val(descricaoFechamento);

	 	$('#descricaoFechamentoOcorrencia').destroy();
	 });
});