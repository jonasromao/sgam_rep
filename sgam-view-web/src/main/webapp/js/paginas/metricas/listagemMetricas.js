$(document).ready(function(){
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});
	
	$('#tabelaAssociadosMetricas').dataTable({
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
		    {"width": "55%"},
		    {"width": "15%"},
		    {"width": "15%"},
		    {"width": "15%"}
		],
		"lengthChange": false,
		dom: '<"html5buttons"B>lTfgtpi',
        buttons: [
            {extend: 'excel', title: 'Pagamento dos associados', footer: true},
            {extend: 'pdf', title: 'Pagamento dos associados', orientation: 'landscape', footer: true},
            {extend: 'print', title: 'Pagamento dos associados', text: 'Imprimir', footer: true,
                 customize: function (win){
                     $(win.document.body).addClass('white-bg');
                     $(win.document.body).css('font-size', '10px');
                     $(win.document.body).find('table').addClass('compact').css('font-size', 'inherit');
                 }
            }
        ]
	});
	
	$('#tabelaRecursosMetricas').dataTable({
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
		"lengthChange": false,
		"columnDefs": [
		    { "visible": false, "targets": 0 }
        ],
        dom: '<"html5buttons"B>lTfgtpi',
        buttons: [
            {extend: 'excel', title: 'Pagamento por recursos', footer: true},
            {extend: 'pdf', title: 'Pagamento por recursos', orientation: 'landscape', footer: true},
            {extend: 'print', title: 'Pagamento por recursos', text: 'Imprimir', footer: true,
                customize: function (win){
                    $(win.document.body).addClass('white-bg');
                    $(win.document.body).css('font-size', '10px');
                    $(win.document.body).find('table').addClass('compact').css('font-size', 'inherit');
                }
            }
        ],
        "drawCallback": function ( settings ) {
            var api = this.api();
            var rows = api.rows( {page:'current'} ).nodes();
            var last=null;
 
            api.column(0, {page:'current'} ).data().each( function ( group, i ) {
                if ( last !== group ) {
                    $(rows).eq( i ).before(
                        '<tr style="background-color: #ddd !important;"><td colspan="5">'+group+'</td></tr>'
                    );
 
                    last = group;
                }
            } );
        }
	});
	
	$('#tabelaRecursosMetricas tbody').on( 'click', 'tr.group', function () {
        var currentOrder = table.order()[0];
        if ( currentOrder[0] === 0 && currentOrder[1] === 'asc' ) {
            table.order( [ 0, 'desc' ] ).draw();
        }
        else {
            table.order( [ 0, 'asc' ] ).draw();
        }
    } );
	

	
});
