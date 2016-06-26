package br.com.setaprox.sgam.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Weeks;
import org.joda.time.Years;

import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.CategoriaContasReceber;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.service.ContasReceberService;

@Stateless
@LocalBean
public class ContasReceberServiceImpl implements ContasReceberService {

	@EJB
	private ContasReceberDAO contasReceberDAO; 
	
	@Override
	public void persist(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.persist(contaReceber);
	}
	
	@Override
	public void registraContaReceber(Aluguel aluguel, CategoriaContasReceber categoria){
		String historico = String.format("Aluguel da(o) %s", aluguel.getRecurso().getNome());
		ContasReceber conta = criaContaReceber(aluguel, historico, categoria);
		this.persist(conta);
	}
	
	@Override
	public void registraContaReceber(AluguelComercio aluguelComercio, CategoriaContasReceber categoria){
		Aluguel aluguel = aluguelComercio.getAluguel();
		String historico = String.format("Comércio informal - Atividade %s", aluguelComercio.getNome());
		ContasReceber conta = criaContaReceber(aluguel, historico, categoria);
		this.persist(conta);
	}
	
	@Override
	public void registraContaReceber(Morador morador, CategoriaContasReceber categoria){
		ContasReceber conta = criaContaReceber(morador, categoria);
		this.persist(conta);
	}
	
	@Override
	public void merge(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.editar(contaReceber);
		
		if(contaReceber.getCategoria().getNome().equalsIgnoreCase(Categoria.ASSOCIADO.getCodigo())){
			if(contaReceber.getStatus().equalsIgnoreCase(Status.RECEBIDA.getCodigo())){
				ContasReceber novaConta = this.criaContaReceber(contaReceber);
				this.persist(novaConta);
			}
		}
	}
	
	@Override
	public List<ContasReceber> findAll() {
		return contasReceberDAO.findAll();
	}

	@Override
	public ContasReceber find(Long id) {
		return contasReceberDAO.find(id);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		contasReceberDAO.remove(id);
	}
	
	@Override
	public List<ContasReceber> findAllByCategoria(String nomeCategoria) {
		return contasReceberDAO.findAllByCategoria(nomeCategoria);
	}

	@Override
	public List<ContasReceber> findAllByMorador(Long idMorador) {
		return contasReceberDAO.findAllByMorador(idMorador);
	}
	
	private void analistaStatus(ContasReceber contaReceber){
		Date atual = new Date();
		
		if(contaReceber.getDataPagamento() != null){
			contaReceber.setStatus(Status.RECEBIDA.getCodigo());
		}	
		else if(contaReceber.getDataVencimento() != null && contaReceber.getDataVencimento().compareTo(atual) < 0){
			contaReceber.setStatus(Status.ATRASADA.getCodigo());
		}
		else{
			contaReceber.setStatus(Status.PENDENTE.getCodigo());
		}
	}
	
	private ContasReceber criaContaReceber(Aluguel aluguel, String historico, CategoriaContasReceber categoria){
		DateTime dataEmissao = new DateTime();
		DateTime dataInicio = new DateTime(aluguel.getDataInicial());
		DateTime dataFim = new DateTime(aluguel.getDataFinal());

		DateTime dataHoraFim = new DateTime(dataInicio.getYear(), dataInicio.getMonthOfYear(), dataInicio.getDayOfMonth(), dataFim.getHourOfDay(), dataFim.getMinuteOfHour());

		String unidadeMedida = aluguel.getRecurso().getUnidadeMedida(); 
		double qtdeMedida = 1.0;
		
		switch(unidadeMedida) {
			case "Hora":
				qtdeMedida = this.calculaHoras(dataInicio, dataHoraFim, dataFim);
				break;
			case "Dia":
				qtdeMedida = Days.daysBetween(dataInicio.withTimeAtStartOfDay() , dataFim.withTimeAtStartOfDay()).getDays();	
				break;
			case "Semana":
				qtdeMedida = Weeks.weeksBetween(dataInicio.withTimeAtStartOfDay(), dataFim.withTimeAtStartOfDay()).getWeeks();
				break;
			case "Mês":
				qtdeMedida = Months.monthsBetween(dataInicio.withTimeAtStartOfDay(), dataFim.withTimeAtStartOfDay()).getMonths();
				break;
			case "Ano":
				qtdeMedida = Years.yearsBetween(dataInicio.withTimeAtStartOfDay(), dataFim.withTimeAtStartOfDay()).getYears();
				break;
		}
		
		double valorAluguel = aluguel.getRecurso().getValor() * qtdeMedida;
		
		ContasReceber conta = new ContasReceber();
		conta.setNome(aluguel.getMorador().getNome());
		conta.setHistorico(historico);
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(aluguel.getDataFinal());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setAluguel(aluguel);
		conta.setDataPagamento(aluguel.getDataPagamento());
		conta.setValor(valorAluguel);
		conta.setCategoria(categoria);
		
		return conta;
	}
	
	private ContasReceber criaContaReceber(Morador morador, CategoriaContasReceber categoria){
		DateTime dataEmissao = new DateTime();
		int diaVencimento = morador.getDiaPagamento();
		int mes = dataEmissao.getMonthOfYear();
		int ano = dataEmissao.getYear();
		
		DateTime vencimento = new DateTime(ano,mes,diaVencimento,0,0);
		
		ContasReceber conta = new ContasReceber();
		conta.setNome(morador.getNome());
		conta.setHistorico("Mensalidade do morador associado");
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(vencimento.toDate());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setValor(categoria.getValor());
		conta.setMorador(morador);
		conta.setCategoria(categoria);
		
		return conta;
	}
	
	private ContasReceber criaContaReceber(ContasReceber contaReceber){
		DateTime dataEmissao = new DateTime();
		
		DateTime vencimentoAnterior = new DateTime(contaReceber.getDataVencimento());
		DateTime vencimentoAtual = vencimentoAnterior.plusMonths(1);
		
		ContasReceber conta = new ContasReceber();
		conta.setNome(contaReceber.getNome());
		conta.setHistorico(contaReceber.getHistorico());
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(vencimentoAtual.toDate());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setValor(contaReceber.getCategoria().getValor());
		conta.setMorador(contaReceber.getMorador());
		conta.setCategoria(contaReceber.getCategoria());
		
		return conta;
	}
	
	private double calculaHoras(DateTime dataHoraInicio, DateTime dataHoraFim, DateTime dataFim){
		double qtdeMinutos = Minutes.minutesBetween(dataHoraInicio, dataHoraFim).getMinutes();
		double qtdeDias = Days.daysBetween(dataHoraInicio.withTimeAtStartOfDay() , dataFim.withTimeAtStartOfDay()).getDays() + 1;
		double qtdeHoras = qtdeMinutos / 60;
		
		return qtdeHoras * qtdeDias;
	}

	

}
