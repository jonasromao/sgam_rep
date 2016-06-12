function marcarMenuAtivo(menu, submenu, collapse){
	var menuAnterior = localStorage.getItem('menu');
	var submenuAnterior = localStorage.getItem('submenu');
	var collapseAnterior = localStorage.getItem('collapse');
	
	localStorage.clear();
	
	if(menuAnterior != null && submenuAnterior != null && collapseAnterior != null){
		localStorage.setItem('menuAnterior', menuAnterior);
		localStorage.setItem('submenuAnterior', submenuAnterior);
		localStorage.setItem('collapseAnterior', collapseAnterior);
	}
	
	localStorage.setItem('menu', menu);
	localStorage.setItem('submenu', submenu);
	localStorage.setItem('collapse', collapse);
}

function loadMarcacaoMenu(){

	var menuAnterior = localStorage.getItem('menuAnterior');
	var submenuAnterior = localStorage.getItem('submenuAnterior');
	var collapseAnterior = localStorage.getItem('collpaseAnterior');

	var menu = localStorage.getItem('menu');
	var submenu = localStorage.getItem('submenu');
	var collapse = localStorage.getItem('collapse');

	if(menuAnterior != null && submenuAnterior != null && collapseAnterior != null){
		$('#'+menuAnterior).removeClass('active');
		if(submenuAnterior != '' && collpaseAnterior != null){
			$('#'+submenuAnterior).removeClass('active');
			$('#'+collapseAnterior).removeClass('in');
		}
	}
	
	if(menu != null){
		$('#'+menu).addClass('active');
	}

	if(submenu != null && collapse != null){
		$('#'+collapse).addClass('in');
		$('#'+submenu).addClass('active');
	}
}