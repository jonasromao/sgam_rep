$(document).ready(function(){
	$('#tabelaPerfil').dataTable({
		searching: false,
		ordering: false,
		"scrollY":        "500px",
        "scrollCollapse": true,
        "paging":         false,
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
		},
		"autoWidth": false,
		"columns": [
		    {"width": "4%"},
		    {"width": "96%"}
		],
	});

	
	$('#checkboxAll').on('click',function(event){	
		if(this.checked) {
			$('.marcar').each(function(){
				$(this).prop("checked", true);   
			});	

		}
		else if(!this.checked) {
			$('.marcar').each(function(){
				$(this).prop("checked", false);   
			});
		}	
		
	});
	
	$('.perfisMarcados').each(function(){
		var perfilMarcado = $(this).val();
		
		$('.marcar').each(function(){
			var perfil = $(this).val();
			
			if(perfil == perfilMarcado){
				$(this).prop("checked", true);
			}
		});
	});
	
});
