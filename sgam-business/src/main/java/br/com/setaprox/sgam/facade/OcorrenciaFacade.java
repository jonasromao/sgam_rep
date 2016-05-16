package br.com.setaprox.sgam.facade;

import java.util.List;

import br.com.setaprox.sgam.model.Ocorrencia;

public interface OcorrenciaFacade {

	List<Ocorrencia> findAll();

	Ocorrencia find(Long id);

	void persist(Ocorrencia ocorrencia);

	Ocorrencia merge(Ocorrencia ocorrencia);

	void remove(Ocorrencia ocorrencia);
	
	void remove(Long id);

}
