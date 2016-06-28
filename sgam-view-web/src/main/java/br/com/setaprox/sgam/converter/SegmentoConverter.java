package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.SegmentoFacade;
import br.com.setaprox.sgam.model.Segmento;

@Convert(Segmento.class)
@ApplicationScoped
public class SegmentoConverter implements Converter<Segmento> {
	
	@Inject
	private SegmentoFacade segmentoFacade;
	
	@Override
	public Segmento convert(String value, Class<? extends Segmento> type) {
		if(value != null && !value.isEmpty()){
			try {
				return segmentoFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Segmento();
	}
}
