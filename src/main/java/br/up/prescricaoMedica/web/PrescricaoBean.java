package br.up.prescricaoMedica.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import br.up.prescricaoMedica.entidade.Prescricao;
import br.up.prescricaoMedica.servico.ServicoPrescricao;

@Named
@RequestScoped
public class PrescricaoBean {
	
	@EJB
	private ServicoPrescricao servicoPrescricao;
	private Prescricao prescricao;
	private PrescricaoBean() {
		this.prescricao = new Prescricao();	
	}
	public ServicoPrescricao getServicoPrescricao() {
		return servicoPrescricao;
	}
	public void setServicoPrescricao(ServicoPrescricao servicoPrescricao) {
		this.servicoPrescricao = servicoPrescricao;
	}
	public Prescricao getPrescricao() {
		return prescricao;
	}
	public void setPrescricao(Prescricao prescricao) {
		this.prescricao = prescricao;
	}
	
	
	public List<Prescricao> listarPrescricao() {
		return this.servicoPrescricao.listarPrescricao();
	}
	
	
	public void cadastrarPrescricao() {
		this.servicoPrescricao.cadastrarPrescricao(prescricao);
		JSFUtils.enviarMensagemDeInformacao("Prescrição Cadastrada");
		this.prescricao = new Prescricao();
	}
	
	public void excluirPrescricao(Prescricao prescricao) {
		this.servicoPrescricao.excluirPrescricao(prescricao);
		JSFUtils.enviarMensagemDeAtencao("Prescrição foi excluida");
	}
}
