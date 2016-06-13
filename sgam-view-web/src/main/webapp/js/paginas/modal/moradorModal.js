$(document).ready(function(){
	
	$('#tableListagemMoradoresModal').dataTable({
		"pageLength": 5,
		"lengthMenu": [ 5 ],
		"lengthChange": true,
		"autoWidth": false,
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
		},
		"columns": [
		    {"width": "5%"},
		    null
		]
	});

	$('#btnFiltrar').on('click', function(event){
		event.preventDefault();
		
		var link = $(this);
		
		$.ajax({
			url: link.attr("href"),
			type: 'GET'
		}).done(function(data, textStatus, jqXHR) {
			adicionarLinhasTabela(data);
		}).fail(function(jqXHR, textStatus, errorThrown){
			alert('Deu erro!');
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
		btnRadio += '<input type="radio" name="radio" onclick="selecionarRadio()" value=\"' + morador.id + ':' + morador.nome + "\">";
		btnRadio += '<label for="btnRadio"></label>';
		btnRadio += '</div>';
		
		var nome = morador.nome;

		tabela.row.add([
		    btnRadio,
		    nome
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


