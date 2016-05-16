package br.com.setaprox.sgam.DAO.impl;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.BusinessException;

@Stateless
@LocalBean
public class UsuarioDAOImpl extends AbstractDAO<Usuario> implements UsuarioDAO {
	
	@PostConstruct
	private void postConstruct() {

		setPersistentClass(Usuario.class);

	}
	
	@Override
	public Usuario findByLogin(String login) throws BusinessException {
		try {
			
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class).setParameter("login", login);
			return query.getSingleResult();
			
		} catch (NoResultException e) {
			
			throw new BusinessException("Nenhum resultado encontrado com os parametros informados.");
			
		}
	}

}
