package br.com.setaprox.sgam.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.Aluguel;

@Local
public interface AluguelService {

	void persist(Aluguel aluguel);

	void remove(Aluguel aluguel);

	void remove(Long id);

	void editar(Aluguel aluguel);

	Aluguel find(Long id);

	List<Aluguel> findAll();
	
	List<Aluguel> reservasPorDia(Date data);

}
