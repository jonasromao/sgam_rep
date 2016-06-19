$(document).ready(function(){
	$('#tabelaFuncoes').dataTable({
		searching: true,
		ordering: false,
		"scrollY":        "500px",
        "scrollCollapse": true,
        "paging":         false,
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
	
});
