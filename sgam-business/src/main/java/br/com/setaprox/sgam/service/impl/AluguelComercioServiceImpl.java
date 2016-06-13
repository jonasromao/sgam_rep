package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.AluguelComercioDAO;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.service.AluguelComercioService;

@Stateless
@LocalBean
public class AluguelComercioServiceImpl implements AluguelComercioService  {

	@EJB
	private AluguelComercioDAO aluguelComercioDAO;

	@Override
	public void persist(AluguelComercio aluguelComercio) {
		aluguelComercioDAO.persist(aluguelComercio);
	}

	@Override
	public void remove(AluguelComercio aluguelComercio) {
		
		aluguelComercioDAO.remove(aluguelComercio);
		
	}

	@Override
	public void remove(Long id) {
		
		aluguelComercioDAO.remove(id);
		
	}

	@Override
	public void editar(AluguelComercio aluguelComercio) {
		
		aluguelComercioDAO.editar(aluguelComercio);
		
	}

	@Override
	public AluguelComercio find(Long id) {
		
		return aluguelComercioDAO.find(id);
		
	}

	@Override
	public List<AluguelComercio> findAll() {
		
		return aluguelComercioDAO.findAll();
		
	}
	

}
