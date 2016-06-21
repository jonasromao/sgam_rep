
$(document).ready(function(){
	$('#nomeFornecedor').focus();
	
	$('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
	
	$('#fornecedorForm').validate({
        rules: {
            'fornecedor.nome': {
                required: true,
                maxlength: 45
            },
            'fornecedor.endereco.rua': {
            	required: true
            },
            'fornecedor.endereco.numero': {
            	required: true
            },
            'fornecedor.endereco.bairro': {
            	required: true
            },
            'fornecedor.endereco.cidade': {
            	required: true
            }
        }
    });
});