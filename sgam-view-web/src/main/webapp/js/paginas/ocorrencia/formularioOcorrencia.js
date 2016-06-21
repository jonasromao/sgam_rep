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

	 $('#ocorrenciaForm').validate({
	        rules: {
	            'ocorrencia.titulo': {
	                required: true,
	                maxlength: 100
	            },
	            'ocorrencia.morador.nome': {
	                required: true
	            },
	            'ocorrencia.local': {
	            	required: true
	            },
	            'ocorrencia.dataInicio': {
	            	required: true
	            },
	            'ocorrencia.descricao': {
	            	required: true
	            }
	        },
			submitHandler: function (form) {
				var textoDescricao = $('#descricaoOcorrencia').code();
			 	$('#descricaoOcorrencia').destroy();
			 	$('#descricaoOcorrenciaHidden').val(textoDescricao);
				
				$(form).submit();		
		    }
	    });

});

var insereDadosMoradorOcorrencia = function(morador){
	$('#nomeMoradorOcorrencia').val(morador.nome);
	$('#idMoradorOcorrencia').val(morador.id);
}