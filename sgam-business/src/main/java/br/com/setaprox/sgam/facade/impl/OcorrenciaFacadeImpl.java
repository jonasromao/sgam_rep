package br.com.setaprox.sgam.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.facade.OcorrenciaFacade;
import br.com.setaprox.sgam.model.Ocorrencia;
import br.com.setaprox.sgam.service.OcorrenciaService;

@Named
@RequestScoped
public class OcorrenciaFacadeImpl implements OcorrenciaFacade {

	@EJB
	private OcorrenciaService ocorrenciaService;
	
	@Override
	public List<Ocorrencia> findAll() {
		return ocorrenciaService.findAll();
	}

	@Override
	public Ocorrencia find(Long id) {
		return ocorrenciaService.find(id);
	}

	@Override
	public void persist(Ocorrencia ocorrencia) {
		ocorrenciaService.persist(ocorrencia);
	}

	@Override
	public Ocorrencia merge(Ocorrencia ocorrencia) {
		return ocorrenciaService.merge( ocorrencia );
	}

	@Override
	public void remove(Ocorrencia ocorrencia) {
		ocorrenciaService.remove(ocorrencia);
	}

	@Override
	public void remove(Long id) {
		ocorrenciaService.remove(id);
	}

	@Override
	public List<Ocorrencia> ocorrenciasPorStatus(String status) {
		return ocorrenciaService.ocorrenciasPorStatus(status);
	}

}
