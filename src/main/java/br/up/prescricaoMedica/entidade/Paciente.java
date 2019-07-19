package br.up.prescricaoMedica.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONTADOR_PACIENTE")
	@SequenceGenerator(name = "CONTADOR_PACIENTE", sequenceName = "NUM_SEQ_PACIENTE", allocationSize = 0)
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private Integer idade;
	@NotNull
	@CPF
	private String cpf;
	@NotNull
	private String sexo;
	@NotNull
	private Date dataInternação;
	
	
	public Paciente() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public String getCpf() {
		return cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public Date getDataInternação() {
		return dataInternação;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public void setDataInternação(Date dataInternação) {
		this.dataInternação = dataInternação;
	}

}
