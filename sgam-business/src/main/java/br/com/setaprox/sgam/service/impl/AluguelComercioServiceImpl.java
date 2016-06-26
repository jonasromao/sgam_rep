package br.com.setaprox.sgam.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.DAO.AluguelComercioDAO;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.service.AluguelComercioService;

@Stateless
@LocalBean
public class AluguelComercioServiceImpl implements AluguelComercioService  {

	@EJB
	private AluguelComercioDAO aluguelComercioDAO;

	@Override
	public void persist(AluguelComercio aluguelComercio) {
		aluguelComercio.getAluguel().setDataEmissaoFaturamento(new Date());
		this.parseDataHora(aluguelComercio.getAluguel());
		this.analisaStatusAlvara(aluguelComercio);
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
		this.parseDataHora(aluguelComercio.getAluguel());
		this.analisaStatusAlvara(aluguelComercio);
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
	
	private void parseDataHora(Aluguel aluguel){
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			if (aluguel.getDataHoraInicio() != null) {
				aluguel.setDataInicial(format.parse(aluguel.getDataHoraInicio()));
			}
			
			if(aluguel.getDataHoraFinal() != null) {
				aluguel.setDataFinal(format.parse(aluguel.getDataHoraFinal()));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	private void analisaStatusAlvara(AluguelComercio aluguelComercio){
		DateTime vencimentoAlvara = new DateTime(aluguelComercio.getDataVencimento());
		
		if(vencimentoAlvara.isBeforeNow()){
			aluguelComercio.setStatusAlvara(Status.VENCIDO.getCodigo());
		}
		else if(vencimentoAlvara.isEqualNow() || vencimentoAlvara.isAfterNow()){
			aluguelComercio.setStatusAlvara(Status.ATIVO.getCodigo());
		}
	}

	@Override
	public List<AluguelComercio> reservasPorDia(Date data) {
		return aluguelComercioDAO.reservasPorDia(data);
	}
	

}
