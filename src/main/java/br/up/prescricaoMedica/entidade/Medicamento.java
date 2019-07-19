package br.up.prescricaoMedica.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Medicamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTADOR_MEDICAMENTO")
	@SequenceGenerator(name = "CONTADOR_MEDICAMENTO", sequenceName = "NUM_SEQ_MEDICAMENTO", allocationSize = 0)
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private String concentracao;
	@NotNull
	private String laboratorio;
	@NotNull
	private String tarja;

	
	public Medicamento() {
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getConcentracao() {
		return concentracao;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public String getTarja() {
		return tarja;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setConcentracao(String concentracao) {
		this.concentracao = concentracao;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public void setTarja(String tarja) {
		this.tarja = tarja;
	}
	
}
