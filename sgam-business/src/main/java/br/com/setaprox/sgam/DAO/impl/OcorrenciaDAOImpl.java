package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

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
	
	@Override
	public void editar(Ocorrencia ocorrencia ) {
		em.merge( ocorrencia );
		em.flush();
	}

	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Ocorrencia.class, id ));
	}
	
	@Override
	public List<Ocorrencia> ocorrenciasPorStatus(String status) {
		TypedQuery<Ocorrencia> query = em.createQuery("from Ocorrencia o where o.status = :status", Ocorrencia.class);  
		query.setParameter("status", status);
		
		return query.getResultList();
	}

}
