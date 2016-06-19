package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.FuncaoFacade;
import br.com.setaprox.sgam.model.Funcao;

@Convert(Funcao.class)
@ApplicationScoped
public class FuncaoConverter implements Converter<Funcao> {
	
	@Inject
	private FuncaoFacade funcaoFacade;
	
	@Override
	public Funcao convert(String value, Class<? extends Funcao> type) {
		if(value != null && !value.isEmpty()){
			try {
				return funcaoFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Funcao();
	}
}
