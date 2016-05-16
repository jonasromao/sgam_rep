package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Recurso;

@Local
public interface RecursoDAO {
	void persist( Recurso recurso ) ;
	
	void remove(Recurso recurso);
	
	void remove(Long id);
	
	void editar( Recurso recurso );
	
	Recurso find( Long id ) ;
	
	List<Recurso> findAll();
}
