package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.OcorrenciaDAO;
import br.com.setaprox.sgam.model.Ocorrencia;

@Stateless
@LocalBean
public class OcorrenciaDAOImpl extends AbstractDAO<Ocorrencia> implements OcorrenciaDAO {
	
	@PostConstruct
    private void postConstruct() {
    	
    	setPersistentClass( Ocorrencia.class );
    	
    }
	
	public void editar(Ocorrencia ocorrencia ) {
		em.merge( ocorrencia );
		em.flush();
	}


}
