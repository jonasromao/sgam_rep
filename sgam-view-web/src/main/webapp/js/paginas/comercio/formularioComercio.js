
$(document).ready(function(){
	$('#nomeFantasia').focus();
	$('#numeroComercio').keypress(somenteNumeros);

	$('#divInicioAtividade').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

	$('#comercioForm').validate({
        rules: {
            'comercio.nomeFantasia': {
                required: true,
                maxlength: 100
            },
            'comercio.razaoSocial': {
                required: true
            },
            'comercio.cnpj': {
            	required: true
            },
            'comercio.telefone': {
            	required: true
            },
            'comercio.responsavel': {
            	required: true
            },
            'comercio.endereco.rua': {
            	required: true
            },
            'comercio.endereco.bairro': {
            	required: true
            },
            'comercio.endereco.cidade': {
            	required: true
            },
            'comercio.segmento.id': {
            	min: 1
            }
        }
    });
});
