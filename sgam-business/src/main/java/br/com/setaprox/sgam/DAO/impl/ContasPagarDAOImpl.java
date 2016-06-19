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
	public List<ContasPagar> contasVencimentoMensal(Date data){
		DateTime dt = new DateTime(data);
		
		DateTime dataInicio = dt.dayOfMonth().withMinimumValue();
		DateTime dataFim = dataInicio.dayOfMonth().withMaximumValue();
		
		TypedQuery<ContasPagar> query = em.createQuery("from ContasPagar c where ( c.dataVencimento >= :inicio and c.dataVencimento <= :fim ) or ( c.status = :status ) ", ContasPagar.class);  
		query.setParameter("inicio", dataInicio.toDate());     
		query.setParameter("fim", dataFim.toDate());
		query.setParameter("status", Status.ATRASADA.getCodigo());
	   
		return query.getResultList(); 
	}

}
