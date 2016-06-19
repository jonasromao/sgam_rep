package br.com.setaprox.sgam.DAO.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.FornecedorDAO;
import br.com.setaprox.sgam.model.Fornecedor;

@Stateless
@LocalBean
public class FornecedorDAOImpl extends AbstractDAO<Fornecedor> implements
		FornecedorDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(Fornecedor.class);

	}

	@Override
	public void editar(Fornecedor fornecedor) {
		em.merge(fornecedor);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Fornecedor.class, id ));
	}

	@Override
	public List<Fornecedor> findByNome(String nome) {
		TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f WHERE f.nome like :nome", Fornecedor.class);
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}

}
