package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.CategoriaContasReceberDAO;
import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.model.CategoriaContasReceber;

@Stateless
@LocalBean
public class CategoriaContasReceberDAOImpl extends AbstractDAO<CategoriaContasReceber> implements CategoriaContasReceberDAO {

	@PostConstruct
	private void postConstruct() {
		setPersistentClass(CategoriaContasReceber.class );
	}
	
	@Override
	public void editar(CategoriaContasReceber categoria) {
		em.merge(categoria);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove(em.getReference(CategoriaContasReceber.class, id));
	}

	@Override
	public CategoriaContasReceber find(String nome) {
		TypedQuery<CategoriaContasReceber> query = em.createQuery("SELECT m FROM CategoriaContasReceber m WHERE m.nome = :nome", CategoriaContasReceber.class);
		query.setParameter("nome", nome);
		
		query.setMaxResults(1);
		
	    List<CategoriaContasReceber> list = query.getResultList();
	    if (list == null || list.isEmpty()) {
	        return null;
	    }

	    return list.get(0);
	}
	
	@Override
	public List<CategoriaContasReceber> findAll() {
		TypedQuery<CategoriaContasReceber> query = em.createQuery("SELECT m FROM CategoriaContasReceber m WHERE m.nome <> :nome", CategoriaContasReceber.class);
		query.setParameter("nome", Categoria.ALUGUEL.getCodigo());
		
		return query.getResultList();
	}

}
