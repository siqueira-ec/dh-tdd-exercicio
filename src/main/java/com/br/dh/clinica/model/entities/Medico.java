package com.br.dh.clinica.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Medico {
	@Id
	@Column(name="crm")
	String crm;
	
	String nome;
	String especialidade;
	
	@OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = "medico")
	List<Consulta> consultas;

	public Medico() {}
	
	public Medico(String crm, String nome, String especialidade) {
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public String getCrm() {
		return crm;
	}
}
