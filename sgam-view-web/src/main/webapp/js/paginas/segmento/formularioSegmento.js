$(document).ready(function(){
	
	$('#nomeSegmento').focus();
	
	$('#segmentoForm').validate({
        rules: {
            'segmento.nome': {
                required: true,
                maxlength: 65
            }
        }
    });

});