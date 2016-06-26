$(document).ready(function(){
	
	$('#txtNomeRecurso').focus();
	$("#txtValorRecurso").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('#recursoForm').validate({
        rules: {
            'recurso.nome': {
                required: true,
                maxlength: 45
            },
            'recurso.valor': {
            	required: true
            }/*,
            'recurso.unidadeMedida': {
            	min: 1
            }*/
        }
    });

});