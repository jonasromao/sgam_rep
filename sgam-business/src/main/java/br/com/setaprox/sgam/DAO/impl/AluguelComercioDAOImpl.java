package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.AluguelComercioDAO;
import br.com.setaprox.sgam.model.AluguelComercio;

@Stateless
@LocalBean
public class AluguelComercioDAOImpl extends AbstractDAO<AluguelComercio> implements AluguelComercioDAO {

	
	@PostConstruct
	private void postConstruct() {
		
		setPersistentClass( AluguelComercio.class );
		
	}
	
	@Override
	public void editar(AluguelComercio aluguelComercio) {
		em.merge( aluguelComercio );
		em.flush();
	}


}
