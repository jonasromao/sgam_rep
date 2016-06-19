package br.com.setaprox.sgam.service;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Ocorrencia;

@Local
public interface OcorrenciaService {

	List<Ocorrencia> findAll();
	
	Ocorrencia find( Long id );
	
	void persist( Ocorrencia ocorrencia );
	
	Ocorrencia merge( Ocorrencia ocorrencia );
	
	void remove( Ocorrencia ocorrencia );
	
	void remove( Long id );
	
	List<Ocorrencia> ocorrenciasPorStatus(String status);
}
