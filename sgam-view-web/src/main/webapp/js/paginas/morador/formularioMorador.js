
$(document).ready(function(){
	$('#nome').focus();
	$('#tempoMorador').keypress(somenteNumeros);
	$('#numeroMorador').keypress(somenteNumeros);
	
	var diaPagamento = $('#cmbDiaPagamentoMorador').val();
	if(diaPagamento > 0){
		$('#cmbDiaPagamentoMorador').attr({disabled: false});
	}
	else {
		$('#cmbDiaPagamentoMorador').attr({disabled: true});
	}
	
	$('#divDataNascimento').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$("input[name='morador.associado']:radio").change(function(){
		if(this.value == 'Sim'){
			$('#cmbDiaPagamentoMorador').attr({disabled: false});
		}
		else {
			$('#cmbDiaPagamentoMorador').val(0).change();
			$('#cmbDiaPagamentoMorador').attr({disabled: true});
		}
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
            },
            'morador.diaPagamento': {
            	min: 1
            }
        }
    });
});
