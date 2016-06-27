$(document).ready(function(){
	$('#tableListagemAluguel').dataTable({
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
		"order": [],
		"columnDefs": [
		    { "orderable": false, "targets": [4,5,6]}
		],
		dom: '<"html5buttons"B>lTfgitp',
        buttons: [
            {extend: 'excel', title: 'Espaços alugados', exportOptions: {columns: [0,1,2,3,4]}},
            {extend: 'pdf', title: 'Espaços alugados', orientation: 'landscape', exportOptions: {columns: [0,1,2,3,4]}},
            {extend: 'print', title: 'Espaços alugados', text: 'Imprimir', exportOptions: {columns: [0,1,2,3,4]},
                customize: function (win){
                    $(win.document.body).addClass('white-bg');
                    $(win.document.body).css('font-size', '10px');
                    $(win.document.body).find('table').addClass('compact').css('font-size', 'inherit');
                }
            }
        ],
		"lengthChange": false
	}); 
	
	$('.remover').on('click', function(event){
		event.preventDefault();
		var link = $(this);
		var aluguel = $(this).closest('.linhaAluguel');

		swal({
            title: "Excluir faturamento?",
            text: "Não será possível recuperar esse cadastro.",
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
				aluguel.fadeOut();
			}).fail(function(jqXHR, textStatus, errorThrown){
				var mensagem = jqXHR.responseText;
				var start = mensagem.search('<body>');
				var end = mensagem.search('</body>');
				
				swal("Atenção!", mensagem.slice(start+6, end), "warning");
			});
        });
	});
	
});