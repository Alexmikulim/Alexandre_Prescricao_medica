package br.up.prescricaoMedica.servico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.up.prescricaoMedica.entidade.Paciente;

@Stateless
public class ServicoPaciente {
	
	@PersistenceContext
	private EntityManager em;
	
	public void cadastrarPaciente(Paciente paciente) throws Exception {
		if (pacienteMesmoCpf(paciente).isEmpty()) {
			this.em.persist(paciente);	
		}else {
			throw new Exception("Paciente com o CPF digitado já esta cadastrado");
		}
	
	}
	
	public List<Paciente> listarPaciente(){
		Query query = this.em.createQuery("SELECT p FROM Paciente p", Paciente.class);
		return query.getResultList();
	}
	
	public void excluirPaciente(Paciente paciente) {
		this.em.remove(this.em.merge(paciente));
	}

	
	public List<Paciente> pacienteMesmoCpf(Paciente paciente){
		Query query = this.em.createQuery("SELECT p FROM Paciente p WHERE p.cpf=:p1", Paciente.class);
		query.setParameter("p1", paciente.getCpf());
		return query.getResultList();
	}
	
}
