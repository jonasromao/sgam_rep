$(document).ready(function(){
	
	$('#tableListagemFornecedoresModal').dataTable({
		"pageLength": 5,
		"lengthMenu": [ 5 ],
		"searching": false,
		"lengthChange": false,
		"info":     false,
		"language": {
			"search": "Pesquisar: ",
			"lengthMenu": "_MENU_",
			    "info": "Exibindo de _START_ até _END_ de um total de _MAX_ registros",
			    "paginate": {
				"first": "Primeira Página",
				"last": "Última Página",
				"previous": "Anterior",
				"next": "Próxima"
			    }
		}
	});

	$('#btnFiltrarFornecedor').on('click', function(event){
		event.preventDefault();
		
		var url = '';
		var nome = $('#nomeFornecedorModal').val();
		
		if(nome == null || nome == ''){
			url = '/sgam/fornecedor/fornecedoresModal';
		}
		else {
			url = '/sgam/fornecedor/fornecedoresModal/'+ nome;
		}
		
		$.ajax({
			url: url,
			type: 'GET'
		}).done(function(data, textStatus, jqXHR) {
			adicionarLinhasTabelaModalFornecedor(data);
		}).fail(function(jqXHR, textStatus, errorThrown){
			swal('Erro', 'Erro ao buscar os fornecedores', 'error');
		});
	});
	
	$('#btnSelecionarModalFornecedor').on('click', function(event){
		insereInformacoesTelaOrigemFornecedor();
	});

});

var mapaFornecedoresPesquisa = {};

var abrirModalFornecedor = function(origemTela){
	limpaTabelaModalFornecedor();
	
	$('#origemTelaModalFornecedor').val(origemTela);
	$('#modalSelecaoFornecedor').modal('show');
}

var limpaTabelaModalFornecedor= function(){
	mapaFornecedoresPesquisa = {};
	
	var tabela = $('#tableListagemFornecedoresModal').DataTable();
	tabela.clear().draw();
}

var adicionarLinhasTabelaModalFornecedor = function(data){
	var tabela = $('#tableListagemFornecedoresModal').DataTable();
	
	for(var i=0; i<data.fornecedores.length; i++){
		var fornecedor = data.fornecedores[i];

		var btnRadio = '';
		btnRadio += '<div class="radio radio-success" > ';
		btnRadio += '<input type="radio" id='+fornecedor.id+' name="radio" onclick="selecionarRadioModalFornecedor()" value=\"' + fornecedor.id + ':' + fornecedor.nome + "\">";
		btnRadio += '<label for='+fornecedor.id+'>'+fornecedor.nome+'</label>';
		btnRadio += '</div>';

		tabela.row.add([
		    btnRadio
		]).draw(false);
		
		mapaFornecedoresPesquisa[fornecedor.id] = {fornecedor: fornecedor};
	}
}

var selecionarRadioModalFornecedor = function(){
	var info = $('input[name=radio]:checked').val();
	var fornecedor = info.split(':');
	
	$('#idFornecedorModal').val(fornecedor[0]);
}

var insereInformacoesTelaOrigemFornecedor = function(){
	var idFornecedor   = $('#idFornecedorModal').val();
	var origemTela = $('#origemTelaModalFornecedor').val();

	var dadosFornecedor = mapaFornecedoresPesquisa[idFornecedor].fornecedor;

	switch(origemTela) {
	    case 'contasPagar':
	    	insereDadosFornecedorContasPagar(dadosFornecedor);
	        break;
	}
	
	$('#modalSelecaoFornecedor').modal('hide');
}


