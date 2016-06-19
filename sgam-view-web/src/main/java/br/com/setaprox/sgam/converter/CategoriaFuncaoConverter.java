package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.CategoriaFuncaoFacade;
import br.com.setaprox.sgam.model.CategoriaFuncao;

@Convert(CategoriaFuncao.class)
@ApplicationScoped
public class CategoriaFuncaoConverter implements Converter<CategoriaFuncao> {
	
	@Inject
	private CategoriaFuncaoFacade categoriaFuncaoFacade;
	
	@Override
	public CategoriaFuncao convert(String value, Class<? extends CategoriaFuncao> type) {
		if(value != null && !value.isEmpty()){
			try {
				return categoriaFuncaoFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new CategoriaFuncao();
	}
}
