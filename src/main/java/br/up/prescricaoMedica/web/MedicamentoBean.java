package br.up.prescricaoMedica.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.up.prescricaoMedica.entidade.Medicamento;
import br.up.prescricaoMedica.servico.ServicoMedicamento;

@Named
@RequestScoped
public class MedicamentoBean {

	@EJB
	private ServicoMedicamento servicoMedicamento;
	private Medicamento medicamento;
	private List<Medicamento> medicamentos;
	private MedicamentoBean() {
		this.medicamento = new Medicamento();
	}

	public ServicoMedicamento getServicoMedicamento() {
		return servicoMedicamento;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setServicoMedicamento(ServicoMedicamento servicoMedicamento) {
		this.servicoMedicamento = servicoMedicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	
	public List<Medicamento> listarMedicamentos() {
		return this.servicoMedicamento.listarMedicamento();
	}
	
	
	public void cadastrarMedicamento() throws Exception {
		try {
			this.servicoMedicamento.cadastrarMedicamento(medicamento);
			JSFUtils.enviarMensagemDeInformacao("Medicamento cadastrado com sucesso");
			this.medicamento = new Medicamento();
		} catch (Exception e) {
			JSFUtils.enviarMensagemDeAtencao(e.getMessage());
		}
	}
	
	
	public void excluirMedicamento(Medicamento medicamento) {
		this.servicoMedicamento.excluirMedicamento(medicamento);
		JSFUtils.enviarMensagemDeAtencao("medicamento foi Excluido com Sucesso");
	}

	public List<Medicamento> getMedicamentos() {
		if(this.medicamentos==null) {
			this.medicamentos = this.servicoMedicamento.listarMedicamento();
		}
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
}
