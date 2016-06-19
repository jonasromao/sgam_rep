package br.com.setaprox.sgam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Perfil;

public interface PerfilFacade {
	void persist(Perfil perfil ) ;
	
	void remove(Perfil perfil);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Perfil perfil);
	
	Perfil find( Long id ) ;
	
	List<Perfil> findAll();
}
