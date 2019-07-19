package br.up.prescricaoMedica.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.prescricaoMedica.entidade.Paciente;
import br.up.prescricaoMedica.servico.ServicoPaciente;

@Named
@RequestScoped
public class PacienteBean {
	
	@EJB
	private ServicoPaciente servicoPaciente;
	private Paciente paciente;
	private List<Paciente> pacientes;
	private PacienteBean() {
		this.paciente = new Paciente();
	}
	
	public ServicoPaciente getServicoPaciente() {
		return servicoPaciente;
	}
	public void setServicoPaciente(ServicoPaciente servicoPaciente) {
		this.servicoPaciente = servicoPaciente;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public List<Paciente> listarPacientes() {
		return this.servicoPaciente.listarPaciente();
	}
	
	
	public void cadastrarPaciente() throws Exception {
		try {
		this.servicoPaciente.cadastrarPaciente(paciente);
		JSFUtils.enviarMensagemDeInformacao("Paciente Cadastrado");
		this.paciente = new Paciente();
		}catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	
	public void excluirPaciente(Paciente paciente) {
		this.servicoPaciente.excluirPaciente(paciente);
		JSFUtils.enviarMensagemDeAtencao("Paciente foi Excluido");
	}

	public List<Paciente> getPacientes() {
		if(this.pacientes==null) {
			this.pacientes = this.servicoPaciente.listarPaciente();
		}
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
