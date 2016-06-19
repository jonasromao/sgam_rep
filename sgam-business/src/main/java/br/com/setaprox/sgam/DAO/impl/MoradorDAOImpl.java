package br.com.setaprox.sgam.DAO.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.DAO.AbstractDAO;
import br.com.setaprox.sgam.DAO.MoradorDAO;
import br.com.setaprox.sgam.dto.MoradorDTO;
import br.com.setaprox.sgam.model.Morador;

@Stateless
@LocalBean
public class MoradorDAOImpl extends AbstractDAO<Morador> implements MoradorDAO {
	
	@PostConstruct
	private void postConstruct() {
		
		setPersistentClass( Morador.class );
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Morador> findMoradores(MoradorDTO moradorDTO) {
		
		StringBuilder strQuery = new StringBuilder();
		strQuery.append("select m from morador m where 1 = 1");
		
		if(moradorDTO != null) {
			
			if(!moradorDTO.getNome().isEmpty()) {
				
				strQuery.append(" and m.nome like " + "%" + moradorDTO.getNome() + "%");
				
			}
			
		}
		
		Query query = super.em.createQuery(strQuery.toString());
		
		
		try {
		
			return query.getResultList();
			
		} catch (NoResultException no) {
			
			return new ArrayList<Morador>();
			
		}

	}
	
	@Override
	public void editar(Morador morador ) {
		em.merge( morador );
		em.flush();
	}
	
	@Override
	public void remove(Long id) {
		em.remove( em.getReference( Morador.class, id ));
	}

	@Override
	public List<Morador> findByNome(String nome) {
		TypedQuery<Morador> query = em.createQuery("SELECT m FROM Morador m WHERE m.nome like :nome", Morador.class);
		query.setParameter("nome", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public long totalMoradores(){
		return (Long) em.createQuery("select count(*) from Morador").getSingleResult();
	}
	
	public long totalAssociados(Date inicio, Date fim){
		Query query = null;
		
		if(inicio != null && fim != null){
			DateTime dtIni = new DateTime(inicio);
			DateTime dtFim = new DateTime(fim);
			
			DateTime dataInicio = dtIni.hourOfDay().withMinimumValue();
			DateTime dataFim = dtFim.hourOfDay().withMaximumValue();
			
			query = em.createQuery("select count(*) from Morador m where ( m.dataAssociado >= :inicio and m.dataAssociado <= :fim ) and ( m.associado = :socio ) ");
			query.setParameter("inicio", dataInicio.toDate());
			query.setParameter("fim", dataFim.toDate());
			query.setParameter("socio", "Sim");
		}
		else {
			query = em.createQuery("select count(*) from Morador m where m.associado = :socio ");
			query.setParameter("socio", "Sim");
		}
		
		
		
		return (Long) query.getSingleResult();
	}

}
