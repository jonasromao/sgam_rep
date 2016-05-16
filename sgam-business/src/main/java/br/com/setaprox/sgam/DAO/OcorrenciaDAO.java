package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Ocorrencia;

@Local
public interface OcorrenciaDAO {
	
	void persist( Ocorrencia ocorrencia ) ;
	
	void remove(Ocorrencia ocorrencia);
	
	void remove(Long id);
		
	void editar( Ocorrencia ocorrencia );
	
	Ocorrencia find( Long id ) ;
	
	List<Ocorrencia> findAll();
	
	Ocorrencia merge( Ocorrencia ocorrencia );
	
}
