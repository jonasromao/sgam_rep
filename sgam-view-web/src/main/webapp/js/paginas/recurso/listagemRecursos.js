$(document).ready(function(){
	$('#tableListagemRecursos').dataTable({
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
		    {"width": "60%"},
		    {"width": "15%"},
		    {"width": "15%"},
		    {"width": "10%"}
		],
		"columnDefs": [
  		    { "orderable": false, "targets": [3]}
  		],
		"lengthChange": false
	}); 
	
	$('.remover').on('click', function(event){
		event.preventDefault();
		var link = $(this);
		var recurso = $(this).closest('.linhaRecurso');

		swal({
            title: "Excluir Recurso?",
            text: "Não será possível recuperar o cadastro desse recurso.",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            cancelButtonText: "Cancelar",
            confirmButtonText: "Sim, excluir!",
            closeOnConfirm: false
        }, function () {

            $.ajax({
				url: link.attr("href"),
				type: 'POST',
				data: { _method: "DELETE"}
			}).done(function(data, textStatus, jqXHR) {
				swal("Excluído!", data.mensagem, "success");
				recurso.fadeOut();
			}).fail(function(jqXHR, textStatus, errorThrown){
				var mensagem = jqXHR.responseText;
				var start = mensagem.search('<body>');
				var end = mensagem.search('</body>');
				
				swal("Atenção!", mensagem.slice(start+6, end), "warning");
			});
        });
	});
	
});