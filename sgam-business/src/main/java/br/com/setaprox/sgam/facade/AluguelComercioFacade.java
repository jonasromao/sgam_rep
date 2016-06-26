package br.com.setaprox.sgam.facade;

import java.util.Date;
import java.util.List;

import br.com.setaprox.sgam.model.AluguelComercio;

public interface AluguelComercioFacade {
	
	void persist(AluguelComercio aluguelComercio ) ;
	
	void editar(AluguelComercio aluguelComercio );
	
	AluguelComercio find( Long id ) ;
	
	List<AluguelComercio> findAll();
	
	void remove(Long id);
	
	List<AluguelComercio> reservasPorDia(Date data);

}
