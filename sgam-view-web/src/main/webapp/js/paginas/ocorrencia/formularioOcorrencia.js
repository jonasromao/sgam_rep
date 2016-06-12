$(document).ready(function(){
	
	$('#divDataOcorrencia').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

	 $('#descricaoOcorrencia').summernote({
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
	 
	 $('#btnModalMoradorOcorrencia').click(function(){
		 abrirModalMorador('ocorrencia');
	 });

	 $('#btnSalvar').click(function() {
	 	var textoDescricao = $('#descricaoOcorrencia').code();
	 	$('#descricaoOcorrencia').destroy();
	 	$('#descricaoOcorrenciaHidden').val(textoDescricao);

	 });


});

var insereDadosMoradorOcorrencia = function(morador){
	$('#nomeMoradorOcorrencia').val(morador.nome);
	$('#idMoradorOcorrencia').val(morador.id);
}