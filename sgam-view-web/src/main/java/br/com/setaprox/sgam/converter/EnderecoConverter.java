package br.com.setaprox.sgam.converter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;
import br.com.setaprox.sgam.facade.EnderecoFacade;
import br.com.setaprox.sgam.model.Endereco;

@Convert(Endereco.class)
@ApplicationScoped
public class EnderecoConverter implements Converter<Endereco> {

	@Inject
	private EnderecoFacade enderecoFacade;
	
	@Override
	public Endereco convert(String value, Class<? extends Endereco> type) {
		if(value != null && !value.isEmpty()){
			try {
				return enderecoFacade.find(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Endereco();
	}

}
