package br.com.setaprox.sgam.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.AluguelDAO;
import br.com.setaprox.sgam.model.Aluguel;

@Stateless
@LocalBean
public class AluguelDAOImpl extends AbstractDAO<Aluguel> implements AluguelDAO {

	
	@PostConstruct
	private void postConstruct() {
		
		setPersistentClass( Aluguel.class );
		
	}
	
	@Override
	public void editar(Aluguel aluguel) {
		em.merge( aluguel );
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Aluguel.class, id ));
	}
	
	@Override
	public List<Aluguel> findAll(){
		TypedQuery<Aluguel> query = em.createQuery("Select a from Aluguel a order by a.dataEmissaoFaturamento desc", Aluguel.class);
		return query.getResultList(); 
	}
	
	@Override
	public List<Aluguel> reservasPorDia(Date data){
		DateTime dt = new DateTime(data);
		
		DateTime dataInicio = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 0, 0);
		DateTime dataFim = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59);
		
		TypedQuery<Aluguel> query = em.createQuery("from Aluguel a where a.dataInicial <= :inicio and a.dataFinal >= :fim order by a.dataEmissaoFaturamento desc", Aluguel.class);  
		query.setParameter("inicio", dataInicio.toDate());     
		query.setParameter("fim", dataFim.toDate());     
	   
		return query.getResultList(); 
	}


}
