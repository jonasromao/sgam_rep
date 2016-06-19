package br.com.setaprox.sgam.facade;

import java.util.Date;
import java.util.List;

import br.com.setaprox.sgam.model.Aluguel;

public interface AluguelFacade {
	
	void persist(Aluguel aluguel ) ;
	
	void editar(Aluguel aluguel );
	
	Aluguel find( Long id ) ;
	
	List<Aluguel> findAll();
	
	void remove(Long id);
	
	List<Aluguel> reservasPorDia(Date data);
	

}
