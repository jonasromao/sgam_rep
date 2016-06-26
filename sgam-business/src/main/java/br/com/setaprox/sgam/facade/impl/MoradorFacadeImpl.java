package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.service.CategoriaContasReceberService;
import br.com.setaprox.sgam.service.ContasReceberService;
import br.com.setaprox.sgam.service.MoradorService;

@Named
@RequestScoped
public class MoradorFacadeImpl implements MoradorFacade {

	@EJB
	private MoradorService moradorService;
	
	@EJB
	private CategoriaContasReceberService categoriaService;
	
	@EJB
	private ContasReceberService contasReceberService;
	
	@Override
	public List<Morador> findAll() {
		return moradorService.findAll();
	}

	@Override
	public void editar(Morador morador) {
		moradorService.editar(morador);
		this.analisaMoradorAssociado(morador);
	}

	@Override
	public void persist(Morador morador) {
		moradorService.persist(morador);
		this.analisaMoradorAssociado(morador);
	}

	@Override
	public Morador find(Long id) {
		return moradorService.find(id);
	}

	@Override
	public void remove(Long id) {
		moradorService.remove(id);
	}

	@Override
	public List<Morador> findByNome(String nome) {
		List<Morador> moradores = null;
		
		if(nome != null && !nome.isEmpty()){
			nome = nome.trim();
			
			moradores = moradorService.findByNome(nome);
		}
		else {
			moradores = this.findAll();
		}
		
		return moradores;
	}

	@Override
	public long totalMoradores() {
		return moradorService.totalMoradores();
	}

	@Override
	public long totalAssociados(Date inicio, Date fim) {
		return moradorService.totalAssociados(inicio, fim);
	}
	
	private void analisaMoradorAssociado(Morador morador){
		if(morador.getAssociado().equalsIgnoreCase("Sim")){
			List<ContasReceber> contasMorador = contasReceberService.findAllByMorador(morador.getId());
			
			if(contasMorador == null || contasMorador.isEmpty()){
				CategoriaContasReceber categoria = categoriaService.find(Categoria.ASSOCIADO.getCodigo());
				contasReceberService.registraContaReceber(morador, categoria);	
			}
		}
	}
	
}
