package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.model.Morador;

@Stateless
@LocalBean
public class ContasReceberDAOImpl extends AbstractDAO<ContasReceber> implements ContasReceberDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(ContasReceber.class);

	}

	@Override
	public void editar(ContasReceber contasReceber) {
		em.merge(contasReceber);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( ContasReceber.class, id ));
	}
	
	@Override
	public List<ContasReceber> findAll(){
		TypedQuery<ContasReceber> query = em.createQuery("Select cr from ContasReceber cr order by cr.dataVencimento, cr.status asc", ContasReceber.class);
		return query.getResultList(); 
	}
	
	@Override
	public List<ContasReceber> findAllByCategoria(String nomeCategoria){
		TypedQuery<ContasReceber> query = em.createQuery("SELECT cr FROM ContasReceber cr WHERE cr.categoria.nome = :nomeCategoria order by cr.dataVencimento asc, cr.status asc", ContasReceber.class);
		query.setParameter("nomeCategoria", nomeCategoria);
		
		return query.getResultList();
	}
	
	@Override
	public List<ContasReceber> findAllByMorador(Long idMorador){
		TypedQuery<ContasReceber> query = em.createQuery("SELECT cr FROM ContasReceber cr WHERE cr.morador.id = :idMorador order by cr.dataVencimento asc, cr.status asc", ContasReceber.class);
		query.setParameter("idMorador", idMorador);
		
		return query.getResultList();
	}

}
