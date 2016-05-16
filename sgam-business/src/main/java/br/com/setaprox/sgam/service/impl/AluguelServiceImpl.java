package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AluguelDAO;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.service.AluguelService;

@Stateless
@LocalBean
public class AluguelServiceImpl implements AluguelService  {

	@EJB
	private AluguelDAO aluguelDAO;

	@Override
	public void persist(Aluguel aluguel) {
		
		aluguelDAO.persist(aluguel);
		
	}

	@Override
	public void remove(Aluguel aluguel) {
		
		aluguelDAO.remove(aluguel);
		
	}

	@Override
	public void remove(Long id) {
		
		aluguelDAO.remove(id);
		
	}

	@Override
	public void editar(Aluguel aluguel) {
		
		aluguelDAO.editar(aluguel);
		
	}

	@Override
	public Aluguel find(Long id) {
		
		return aluguelDAO.find(id);
		
	}

	@Override
	public List<Aluguel> findAll() {
		
		return aluguelDAO.findAll();
		
	}
	

}
