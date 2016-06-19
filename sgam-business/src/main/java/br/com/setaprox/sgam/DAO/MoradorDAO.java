package br.com.setaprox.sgam.DAO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import br.com.setaprox.sgam.dto.MoradorDTO;
import br.com.setaprox.sgam.model.Morador;

@Local
public interface MoradorDAO {
	
	void persist( Morador morador ) ;
	
	void remove(Morador morador);
	
	void remove(Long id);
	
	void editar( Morador morador );
	
	Morador find( Long id ) ;
	
	List<Morador> findMoradores( MoradorDTO moradorDTO ) ;
	
	List<Morador> findAll();
	
	List<Morador> findByNome(String nome);
	
	long totalMoradores();
	
	long totalAssociados(Date inicio, Date fim);
	
}
