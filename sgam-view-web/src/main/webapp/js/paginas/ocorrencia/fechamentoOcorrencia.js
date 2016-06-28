$(document).ready(function(){
	
	$('.height-scroll').slimscroll({
        height: '485px'
    });
	
	$('#descricaoFechamentoOcorrencia').summernote({
		 focus: true,
		 height: 333,
		 toolbar: [
		     ['style', ['fontname', 'bold', 'italic', 'underline', 'clear']],
			 ['fontsize', ['fontsize']],
		     ['color', ['color']],
		     ['para', ['ul', 'ol', 'paragraph']],
		     ['height', ['height']],
		     ['misc', ['fullscreen']]
		]
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