package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.PersistenceException;

import br.com.setaprox.sgam.model.Comercio;

@Local
public interface ComercioDAO {
	void persist(Comercio comercio) ;
	
	void remove(Comercio comercio);
	
	void remove(Long id) throws PersistenceException;
	
	void editar(Comercio comercio);
	
	Comercio find(Long id) ;
	
	List<Comercio> findAll();
}
