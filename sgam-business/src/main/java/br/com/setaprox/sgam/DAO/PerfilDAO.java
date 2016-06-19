package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Perfil;

@Local
public interface PerfilDAO {
	void persist(Perfil perfil ) ;
	
	void remove(Perfil perfil);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Perfil perfil);
	
	Perfil find( Long id ) ;
	
	List<Perfil> findAll();
}
