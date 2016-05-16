package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.service.UsuarioService;
import br.com.setaprox.sgam.utils.BusinessException;

@Stateless
@LocalBean
public class UsuarioServiceImpl implements UsuarioService {

	@EJB
	UsuarioDAO usuarioDAO;

	@Override
	public Usuario findByLogin(String login) throws BusinessException {

		return usuarioDAO.findByLogin(login);

	}

	@Override
	public List<Usuario> findAll() {

		return usuarioDAO.findAll();

	}

	@Override
	public Usuario merge(Usuario usuario) throws BusinessException {

		if (usuario.getId() != null && usuario.getId() > 0) {

			return usuarioDAO.merge(usuario);

		} else {

			validar( usuario );
			usuarioDAO.persist(usuario);
			return null;

		}

	}

	private void validar(Usuario usuario) throws BusinessException {

		Usuario usuarioCadastrado = usuarioDAO.find(usuario.getId());

		if (usuarioCadastrado != null
				&& usuarioCadastrado.getId() != usuario.getId()) {
			throw new BusinessException("Login já existente.");
		}

		if (usuario.getId() == 0
				&& (usuario.getSenha() == null || usuario.getSenha().isEmpty())) {
			throw new BusinessException("Senha deve ser preenchida.");
		}
	}

	@Override
	public Usuario findById(Long id) throws BusinessException {
		return usuarioDAO.find(id);
	}

	@Override
	public void remove(Usuario usuario) throws BusinessException {

		usuarioDAO.remove(usuario);
		
	}

	@Override
	public void remove(Long id) throws BusinessException {
		
		usuarioDAO.remove(id);
		
	}

}
