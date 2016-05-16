package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.AluguelDAO;
import br.com.setaprox.sgam.model.Aluguel;

@Stateless
@LocalBean
public class AluguelDAOImpl extends AbstractDAO<Aluguel> implements AluguelDAO {

	
	@PostConstruct
	private void postConstruct() {
		
		setPersistentClass( Aluguel.class );
		
	}
	
	@Override
	public void editar(Aluguel aluguel) {
		em.merge( aluguel );
		em.flush();
	}


}
