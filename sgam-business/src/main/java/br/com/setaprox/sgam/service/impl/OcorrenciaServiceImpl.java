package br.com.setaprox.sgam.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.com.setaprox.sgam.DAO.OcorrenciaDAO;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.Ocorrencia;
import br.com.setaprox.sgam.service.OcorrenciaService;

@Stateless
@LocalBean
public class OcorrenciaServiceImpl implements OcorrenciaService {

	@EJB
	private OcorrenciaDAO ocorrenciaDAO;

	@Override
	public List<Ocorrencia> findAll() {
		return ocorrenciaDAO.findAll();
	}

	@Override
	public Ocorrencia find(Long id) {
		return ocorrenciaDAO.find(id);
	}

	@Override
	public void persist(Ocorrencia ocorrencia) {
		this.atualizaStatus(ocorrencia);
		ocorrenciaDAO.persist(ocorrencia);
	}

	@Override
	public Ocorrencia merge(Ocorrencia ocorrencia) {
		this.atualizaStatus(ocorrencia);
		return ocorrenciaDAO.merge(ocorrencia);
	}

	@Override
	public void remove(Ocorrencia ocorrencia) {
		ocorrenciaDAO.remove(ocorrencia);
	}

	@Override
	public void remove(Long id) {
		ocorrenciaDAO.remove(id);
	}

	@Override
	public List<Ocorrencia> ocorrenciasPorStatus(String status) {
		return ocorrenciaDAO.ocorrenciasPorStatus(status);
	}
	
	private void atualizaStatus(Ocorrencia ocorrencia){
		if(ocorrencia != null){
			if(ocorrencia.getDataFim() == null){
				ocorrencia.setStatus(Status.ABERTA.getCodigo());	
			}
			else {
				ocorrencia.setStatus(Status.FECHADA.getCodigo());
			}	
		}
	}
	
}
