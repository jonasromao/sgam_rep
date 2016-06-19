package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.PerfilFacade;
import br.com.setaprox.sgam.model.Perfil;

@Convert(Perfil.class)
@ApplicationScoped
public class PerfilConverter implements Converter<Perfil>  {

	@Inject
	private PerfilFacade perfilFacade;
	
	@Override
	public Perfil convert(String value, Class<? extends Perfil> type) {
		if(value != null && !value.isEmpty()){
			try {
				return perfilFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Perfil();
	}
}
