package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.model.Morador;

@Convert(Morador.class)
@ApplicationScoped
public class MoradorConverter implements Converter<Morador> {

	@Inject
	private MoradorFacade moradorFacade;
	
	@Override
	public Morador convert(String value, Class<? extends Morador> type) {
		if(value != null && !value.isEmpty()){
			try {
				return moradorFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Morador();
	}

}
