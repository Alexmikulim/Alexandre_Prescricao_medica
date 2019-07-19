package br.up.prescricaoMedica.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.prescricaoMedica.entidade.Medicamento;

@Stateless
public class ServicoMedicamento {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void cadastrarMedicamento(Medicamento medicamento) throws Exception {
		if (medicamentoMesmoNome(medicamento).isEmpty()) {
			this.em.persist(medicamento);
		}else {
			throw new Exception("Medicamento com o nome digitado já é cadastrado");
		}
		
	}
	
	public List<Medicamento> listarMedicamento(){
		Query query = this.em.createQuery("SELECT m FROM Medicamento m", Medicamento.class);
		return query.getResultList();
	}

	
	public void excluirMedicamento(Medicamento medicamento) {
		this.em.remove(this.em.merge(medicamento));
	}
	
	public List<Medicamento> medicamentoMesmoNome(Medicamento medicamento){
		Query query = this.em.createQuery("SELECT m FROM Medicamento m WHERE m.nome=:p1", Medicamento.class);
		query.setParameter("p1", medicamento.getNome());
		return query.getResultList();
	}
}
