
$(document).ready(function(){
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY HH:mm',
		allowInputToggle: true,
		showClear: true
	});
	
	$('#dataPagamentoAluguel').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('#btnAbreModalMoradorFaturamento').click(function(){
		abrirModalMorador('faturamento');
	});
	
	$('#btnSalvarAluguel').click(function(){
		var dataHoraInicio = $('#dataInicioAluguel').val();
		var dataHoraFinal = $('#dataFinalAluguel').val();
		
		$('#dataHoraInicioAluguel').val(dataHoraInicio);
		$('#dataHoraFinalAluguel').val(dataHoraFinal);
	});
});

var insereDadosMoradorFaturamento = function(morador){
	$('#nomeMoradorFaturamento').val(morador.nome);
	$('#idMoradorFaturamento').val(morador.id);
	
	$('#txtEmailMoradorAluguel').text(morador.email);
	$('#txtCelularMoradorAluguel').text(morador.telefoneCelular);
	$('#txtTelefoneMoradorAluguel').text(morador.telefoneResidencial);
	//$('#txtEnderecoMoradorAluguel').text(morador.endereco.rua + ', ' + morador.endereco.numero, + ' - ' + morador.endereco.bairro + ' - ' + morador.endereco.cidade);
}