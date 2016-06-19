package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.EnderecoDAO;
import br.com.setaprox.sgam.model.Endereco;

@Stateless
@LocalBean
public class EnderecoDAOImpl extends AbstractDAO<Endereco> implements EnderecoDAO {
	
	@PostConstruct
	private void postConstruct() {

		setPersistentClass(Endereco.class);

	}
	
	public Endereco find(Long id){
		return em.find(Endereco.class, id );
	}

	@Override
	public void editar(Endereco endereco) {
		em.merge(endereco);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Endereco.class, id ));
	}
}
