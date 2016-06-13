$(document).ready(function(){
	$('#txtNumeroCP').focus();
	
	$("#txtValorCP").maskMoney({symbol:'', showSymbol:true, thousands:'.', decimal:',', symbolStay: false, allowZero: true});
	
	$('.data').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

	
	$('#btnModalFornecedorCP').click(function(){
		abrirModalFornecedor('contasPagar');
	});

});

var insereDadosFornecedorContasPagar = function(fornecedor){
	$('#nomeFornecedorCP').val(fornecedor.nome);
	$('#idFornecedorCP').val(fornecedor.id);
	
	$('#txtEmailFornecedorCP').text(fornecedor.email);
	$('#txtCelularFornecedorCP').text(fornecedor.celular);
	$('#txtTelefoneFornecedorCP').text(fornecedor.telefone);
	//$('#txtEnderecoFornecedorCP').text(fornecedor.endereco.rua + ', ' + fornecedor.endereco.numero, + ' - ' + fornecedor.endereco.bairro + ' - ' + fornecedor.endereco.cidade);
}