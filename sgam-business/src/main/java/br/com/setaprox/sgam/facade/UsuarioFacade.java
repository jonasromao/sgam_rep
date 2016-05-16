package br.com.setaprox.sgam.facade;

import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.BusinessException;
import java.util.List;

public interface UsuarioFacade {

	Usuario find(String login) throws BusinessException;
	
	Usuario find(Long id) throws BusinessException;
	
	void remove( Usuario usuario ) throws BusinessException;
	
	void remove( Long id ) throws BusinessException;
	
	List<Usuario> findAll();
	
	Usuario merge( Usuario usuario ) throws BusinessException;
}
