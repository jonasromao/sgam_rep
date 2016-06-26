$(document).ready(function(){
	$('#tableListagemPerfis').dataTable({
		searching: true,
		ordering: true,
        "paging":         true,
        "info":     false,
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
		},
		"columnDefs": [
	        { "orderable": false, "targets": [1,2]}
        ],
	});
	
});