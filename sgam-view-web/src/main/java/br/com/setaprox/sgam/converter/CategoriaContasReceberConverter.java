package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.CategoriaContasReceberFacade;
import br.com.setaprox.sgam.model.CategoriaContasReceber;

@Convert(CategoriaContasReceber.class)
@ApplicationScoped
public class CategoriaContasReceberConverter implements Converter<CategoriaContasReceber> {

	@Inject
	private CategoriaContasReceberFacade categoriaFacade;
	
	@Override
	public CategoriaContasReceber convert(String value, Class<? extends CategoriaContasReceber> type) {
		if(value != null && !value.isEmpty()){
			try {
				return categoriaFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new CategoriaContasReceber();
	}

}
