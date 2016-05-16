package br.com.setaprox.sgam.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
	
	public void editar(Morador morador ) {
		em.merge( morador );
		em.flush();
	}

}
