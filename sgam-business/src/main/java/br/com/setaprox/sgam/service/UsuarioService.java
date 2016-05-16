package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.BusinessException;

@Local
public interface UsuarioService {

	Usuario findByLogin( String login ) throws BusinessException;
	
	Usuario findById( Long id ) throws BusinessException;
	
	List<Usuario> findAll();
	
	Usuario merge( Usuario usuario ) throws BusinessException;
	
	void remove( Usuario usuario ) throws BusinessException;
	
	void remove( Long id ) throws BusinessException;
	
}
