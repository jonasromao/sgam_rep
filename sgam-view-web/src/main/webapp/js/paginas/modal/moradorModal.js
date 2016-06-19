$(document).ready(function(){
	
	$('#tableListagemMoradoresModal').dataTable({
		"pageLength": 5,
		"lengthMenu": [ 5 ],
		"searching": false,
		"lengthChange": false,
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

	$('#btnFiltrar').on('click', function(event){
		event.preventDefault();
		
		var url = '';
		var nome = $('#nomeModalMorador').val();
		
		if(nome == null || nome == ''){
			url = '/sgam/morador/moradoresModal';
		}
		else {
			url = '/sgam/morador/moradoresModal/'+ nome;
		}
		
		$.ajax({
			url: url,
			type: 'GET'
		}).done(function(data, textStatus, jqXHR) {
			limpaTabelaModalMorador();
			adicionarLinhasTabela(data);
		}).fail(function(jqXHR, textStatus, errorThrown){
			swal('Erro', 'Erro ao buscar os moradores', 'error');
		});
	});
	
	$('#btnSelecionarModal').on('click', function(event){
		insereInformacoesTelaOrigem();
	});

});

var mapaMoradoresPesquisa = {};

var abrirModalMorador = function(origemTela){
	limpaTabelaModalMorador();
	
	$('#origemTelaModal').val(origemTela);
	$('#modalSelecaoMorador').modal('show');
}

var limpaTabelaModalMorador = function(){
	mapaMoradoresPesquisa = {};
	
	var tabela = $('#tableListagemMoradoresModal').DataTable();
	tabela.clear().draw();
}

var adicionarLinhasTabela = function(data){
	var tabela = $('#tableListagemMoradoresModal').DataTable();
	
	for(var i=0; i<data.moradores.length; i++){
		var morador = data.moradores[i];
		var btnRadio = '';
		btnRadio += '<div class="radio radio-success" > ';
		btnRadio += '<input type="radio" id='+morador.id+' name="radio" onclick="selecionarRadio()" value=\"' + morador.id + ':' + morador.nome + "\">";
		btnRadio += '<label for='+morador.id+'>'+morador.nome+'</label>';
		btnRadio += '</div>';

		tabela.row.add([
		    btnRadio
		]).draw(false);
		
		mapaMoradoresPesquisa[morador.id] = {morador: morador};
	}
}

var selecionarRadio = function(){
	var info = $('input[name=radio]:checked').val();
	var morador = info.split(':');
	
	$('#idMoradorModal').val(morador[0]);
}

var insereInformacoesTelaOrigem = function(){
	var idMorador   = $('#idMoradorModal').val();
	var origemTela = $('#origemTelaModal').val();

	var dadosMorador = mapaMoradoresPesquisa[idMorador].morador;

	switch(origemTela) {
	    case 'ocorrencia':
	    	insereDadosMoradorOcorrencia(dadosMorador);
	        break;
	    case 'faturamento':
	    	insereDadosMoradorFaturamento(dadosMorador);
	        break;
	}
	
	$('#modalSelecaoMorador').modal('hide');
}


