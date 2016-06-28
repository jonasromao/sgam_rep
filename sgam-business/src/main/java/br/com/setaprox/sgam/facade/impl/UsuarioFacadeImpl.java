package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.UsuarioFacade;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.service.UsuarioService;
import br.com.setaprox.sgam.utils.BusinessException;

@Named
@RequestScoped
public class UsuarioFacadeImpl implements UsuarioFacade {

	@EJB
	UsuarioService usuarioService;
	
	@Override
	public Usuario find(String login) throws BusinessException {
		
		return usuarioService.findByLogin(login);
		
	}

	@Override
	public List<Usuario> findAll() {
		
		return usuarioService.findAll();
		
	}

	@Override
	public Usuario merge( Usuario usuario ) throws BusinessException {
			
		return usuarioService.merge(usuario);
	}

	@Override
	public Usuario find(Long id) throws BusinessException {
		
		return usuarioService.findById(id);
		
	}

	@Override
	public void remove(Usuario usuario) throws BusinessException {
		
		usuarioService.remove(usuario);
		
	}

	@Override
	public void remove(Long id) throws BusinessException {
		
		usuarioService.remove(id);
		
	}

	@Override
	public void persist(Usuario usuario) throws BusinessException {
		usuarioService.persist(usuario);
	}

}
