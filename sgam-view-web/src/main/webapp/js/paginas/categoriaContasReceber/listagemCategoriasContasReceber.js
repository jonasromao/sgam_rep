$(document).ready(function(){
	$('#tableListagemCategorias').dataTable({
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
		"autoWidth": false,
		"columns": [
		    {"width": "15%"},
		    {"width": "60%"},
		    {"width": "15%"},
		    {"width": "10%"}
		],
		"columnDefs": [
		    { "orderable": false, "targets": [1,3]}
		],
		"lengthChange": false
	}); 
	
});