$(document).ready(function(){
	$('#tabelaFuncoes').dataTable({
		searching: true,
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
		
		"columnDefs": [
		    { "visible": false, "targets": 2 }
        ],
        "drawCallback": function ( settings ) {
            var api = this.api();
            var rows = api.rows( {page:'current'} ).nodes();
            var last=null;
 
            api.column(2, {page:'current'} ).data().each( function ( group, i ) {
                if ( last !== group ) {
                    $(rows).eq( i ).before(
                        '<tr style="background-color: #ddd !important;"><td colspan="4">'+group+'</td></tr>'
                    );
 
                    last = group;
                }
            } );
        }
	});
	
	$('#tabelaFuncoes tbody').on( 'click', 'tr.group', function () {
        var currentOrder = table.order()[0];
        if ( currentOrder[0] === 2 && currentOrder[1] === 'asc' ) {
            table.order( [ 2, 'desc' ] ).draw();
        }
        else {
            table.order( [ 2, 'asc' ] ).draw();
        }
    } );
	
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
	
	$('.funcoesMarcadas').each(function(){
		var funcaoMarcada = $(this).val();
		
		$('.marcar').each(function(){
			var funcao = $(this).val();
			
			if(funcao == funcaoMarcada){
				$(this).prop("checked", true);
			}
		});
	});
	
});
