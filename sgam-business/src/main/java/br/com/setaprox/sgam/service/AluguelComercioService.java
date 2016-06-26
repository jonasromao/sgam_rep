package br.com.setaprox.sgam.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.AluguelComercio;

@Local
public interface AluguelComercioService {

	void persist(AluguelComercio aluguelComercio);

	void remove(AluguelComercio aluguelComercio);

	void remove(Long id);

	void editar(AluguelComercio aluguelComercio);

	AluguelComercio find(Long id);

	List<AluguelComercio> findAll();
	
	List<AluguelComercio> reservasPorDia(Date data);

}
