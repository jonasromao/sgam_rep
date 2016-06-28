package br.com.setaprox.sgam.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.ContasPagarDAO;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.ContasPagar;

@Stateless
@LocalBean
public class ContasPagarDAOImpl extends AbstractDAO<ContasPagar> implements ContasPagarDAO {

	@PostConstruct
	private void postConstruct() {

		setPersistentClass(ContasPagar.class);

	}

	@Override
	public void editar(ContasPagar contaPagar) {
		em.merge(contaPagar);
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( ContasPagar.class, id ));
	}
	
	@Override
	public List<ContasPagar> findAll(){
		TypedQuery<ContasPagar> query = em.createQuery("Select cp from ContasPagar cp order by cp.dataVencimento, cp.status asc", ContasPagar.class);
		return query.getResultList(); 
	}
	
	@Override
	public List<ContasPagar> contasVencimentoMensal(Date data){
		DateTime dt = new DateTime(data);
		
		DateTime dataInicio = dt.dayOfMonth().withMinimumValue();
		DateTime dataFim = dataInicio.dayOfMonth().withMaximumValue();
		
		TypedQuery<ContasPagar> query = em.createQuery("from ContasPagar c where ( c.dataVencimento >= :inicio and c.dataVencimento <= :fim ) or ( c.status = :status ) order by c.dataVencimento, c.status asc ", ContasPagar.class);  
		query.setParameter("inicio", dataInicio.toDate());     
		query.setParameter("fim", dataFim.toDate());
		query.setParameter("status", Status.ATRASADA.getCodigo());
	   
		return query.getResultList(); 
	}
	
	@Override
	public List<ContasPagar> findAllByPeriodo(Date dataInicio, Date dataFim, String status){
		
		DateTime inicio = new DateTime(dataInicio).withTimeAtStartOfDay();
		DateTime fim = new DateTime(dataFim).withTimeAtStartOfDay();
		
		TypedQuery<ContasPagar> query = null; 
		
		if(status.equals("P")){
			query = em.createQuery("from ContasPagar cr where (cr.dataVencimento >= :inicio and cr.dataVencimento <= :fim) and cr.status = :status order by cr.dataVencimento asc", ContasPagar.class);
			query.setParameter("status", Status.PAGA.getCodigo());
		}
		else if(status.equals("NP")){
			query = em.createQuery("from ContasPagar cr where (cr.dataVencimento >= :inicio and cr.dataVencimento <= :fim) and cr.status <> :status order by cr.dataVencimento asc", ContasPagar.class);
			query.setParameter("status", Status.PAGA.getCodigo());
		}
		else {
			query = em.createQuery("from ContasPagar cr where (cr.dataVencimento >= :inicio and cr.dataVencimento <= :fim) order by cr.dataVencimento asc", ContasPagar.class);
		}
				  
		query.setParameter("inicio", inicio.toDate());     
		query.setParameter("fim", fim.toDate());

		return query.getResultList(); 
	}

}
