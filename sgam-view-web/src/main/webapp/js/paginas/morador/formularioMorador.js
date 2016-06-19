
$(document).ready(function(){
	$('#nome').focus();
	$('#tempoMorador').keypress(somenteNumeros);
	$('#numeroMorador').keypress(somenteNumeros);
	
	$('#divDataNascimento').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
	
	$('#moradorForm').validate({
        rules: {
            'morador.nome': {
                required: true,
                maxlength: 100
            },
            'morador.cpf': {
                required: true
            },
            'morador.dataNascimento': {
            	required: true
            },
            'morador.inicioMoradia': {
            	required: true
            },
            'morador.telefoneCelular': {
            	required: true
            },
            'morador.email': {
            	email: true
            },
            'morador.endereco.rua': {
            	required: true
            },
            'morador.endereco.numero': {
            	required: true
            },
            'morador.endereco.bairro': {
            	required: true
            },
            'morador.endereco.cidade': {
            	required: true
            }
        },
		submitHandler: function (form) {
			$(form).submit();		
	    }
    });
});
