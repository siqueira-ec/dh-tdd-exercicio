package com.br.dh.clinica.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Integer codigo;
	
	private Date data;
	private Double valor;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "fk_paciente")
	@JsonIgnoreProperties(value = "consultas")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "fk_medico")
	@JsonIgnoreProperties(value = "consultas")
	private Medico medico;
	
	@OneToOne(mappedBy = "consulta", fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_receita")
	@JsonIgnoreProperties(value = "consulta")
	private Receita receita;

	public Consulta() {}

	public Consulta(Date data, Double valor, String descricao) {
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
