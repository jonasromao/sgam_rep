package br.com.setaprox.sgam.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.AluguelComercioDAO;
import br.com.setaprox.sgam.model.AluguelComercio;

@Stateless
@LocalBean
public class AluguelComercioDAOImpl extends AbstractDAO<AluguelComercio> implements AluguelComercioDAO {

	
	@PostConstruct
	private void postConstruct() {
		
		setPersistentClass( AluguelComercio.class );
		
	}
	
	@Override
	public void editar(AluguelComercio aluguelComercio) {
		em.merge( aluguelComercio );
		em.flush();
	}

	@Override
	public void remove(Long id) {
		em.remove( em.getReference( AluguelComercio.class, id ));
	}
	
	@Override
	public List<AluguelComercio> findAll(){
		TypedQuery<AluguelComercio> query = em.createQuery("Select a from AluguelComercio a order by a.aluguel.dataEmissaoFaturamento desc", AluguelComercio.class);
		return query.getResultList(); 
	}

	@Override
	public List<AluguelComercio> reservasPorDia(Date data){
		DateTime dt = new DateTime(data);
		
		DateTime dataInicio = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 0, 0);
		DateTime dataFim = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59);
		
		TypedQuery<AluguelComercio> query = em.createQuery("SELECT ac FROM AluguelComercio ac JOIN ac.aluguel a WHERE a.dataInicial >= :inicio and a.dataInicial <= :fim", AluguelComercio.class);  
		query.setParameter("inicio", dataInicio.toDate());     
		query.setParameter("fim", dataFim.toDate());     
	   
		return query.getResultList(); 
	}
}
