package br.up.prescricaoMedica.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.prescricaoMedica.entidade.Prescricao;

@Stateless
public class ServicoPrescricao {
	
	@PersistenceContext
	private EntityManager em;
	

	public void cadastrarPrescricao(Prescricao prescricao) {
		this.em.persist(prescricao);
	}
	
	public List<Prescricao> listarPrescricao(){
		Query query = this.em.createQuery("SELECT p FROM Prescricao p", Prescricao.class);
		return query.getResultList();
	}
	
	public void excluirPrescricao(Prescricao prescricao) {
		this.em.remove(this.em.merge(prescricao));
	}
	

}
