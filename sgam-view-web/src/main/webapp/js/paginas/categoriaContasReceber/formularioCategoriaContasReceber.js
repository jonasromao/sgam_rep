$(document).ready(function(){
	
	$('#txtValorCategoria').focus();
	$("#txtValorCategoria").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('#categoriaContasReceberForm').validate({
        rules: {
            'categoria.valor': {
            	required: true
            }
        }
    });

});