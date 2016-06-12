$(document).ready(function(){
	$('#txtNumeroCP').focus();
	
	$('.date').datetimepicker({
		locale:"pt-br",
		format: 'DD/MM/YYYY',
		allowInputToggle: true,
		showClear: true
	});

});