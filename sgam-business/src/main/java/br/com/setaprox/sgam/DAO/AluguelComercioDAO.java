package br.com.setaprox.sgam.DAO;

import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.model.AluguelComercio;

@Local
public interface AluguelComercioDAO {
	
	void persist(AluguelComercio aluguelComercio ) ;
	
	void remove(AluguelComercio aluguelComercio);
	
	void remove(Long id);
	
	void editar(AluguelComercio aluguelComercio );
	
	AluguelComercio find( Long id ) ;

	List<AluguelComercio> findAll();
}
