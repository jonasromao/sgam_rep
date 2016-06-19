package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.RecursoFacade;
import br.com.setaprox.sgam.model.Recurso;

@Convert(Recurso.class)
@ApplicationScoped
public class RecursoConverter implements Converter<Recurso> {

	@Inject
	private RecursoFacade recursoFacade;
	
	@Override
	public Recurso convert(String value, Class<? extends Recurso> type) {
		if(value != null && !value.isEmpty()){
			try {
				return recursoFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Recurso();
	}

}
