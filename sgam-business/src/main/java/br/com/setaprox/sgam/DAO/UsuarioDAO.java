package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.BusinessException;

@Local
public interface UsuarioDAO {
	void persist( Usuario usuario ) ;
	
	void remove(Usuario usuario);
	
	void remove(Long id);
	
	public Usuario merge( Usuario usuario );
	
	Usuario find( Long id ) ;
	
	Usuario findByLogin(String login) throws BusinessException;
	
	List<Usuario> findAll();
}
