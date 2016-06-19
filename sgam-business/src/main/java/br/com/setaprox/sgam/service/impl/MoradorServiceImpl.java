package br.com.setaprox.sgam.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.MoradorDAO;
import br.com.setaprox.sgam.dto.MoradorDTO;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.service.MoradorService;

@Stateless
@LocalBean
public class MoradorServiceImpl implements MoradorService {
	
	@EJB
	private MoradorDAO moradorDAO;

	@Override
	public void persist(Morador morador) {
		
		moradorDAO.persist(morador);
		
	}

	@Override
	public void remove(Morador morador) {
		
		moradorDAO.remove(morador);
		
	}

	@Override
	public void remove(Long id) {
		
		moradorDAO.remove(id);
		
	}

	@Override
	public void editar(Morador morador) {
		
		moradorDAO.editar(morador);
		
	}

	@Override
	public Morador find(Long id) {
		
		return moradorDAO.find(id);
	}

	@Override
	public List<Morador> findMoradores(MoradorDTO moradorDTO) {

		return moradorDAO.findMoradores(moradorDTO);
		
	}

	@Override
	public List<Morador> findAll() {
		
		return moradorDAO.findAll();
		
	}

	@Override
	public List<Morador> findByNome(String nome) {
		return moradorDAO.findByNome(nome);
	}

	@Override
	public long totalMoradores() {
		return moradorDAO.totalMoradores();
	}

	@Override
	public long totalAssociados(Date inicio, Date fim) {
		return moradorDAO.totalAssociados(inicio, fim);
	}

}
