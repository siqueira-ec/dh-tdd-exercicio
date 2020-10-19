package com.br.dh.clinica.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Receita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receita")
	private Integer codReceita;
	
	private String descricao;
	private Integer tempo;
	private String dosagem;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = "receita")
	private Consulta consulta;
	
	public Receita() {}

	public Receita(String descricao, Integer tempo, String dosagem) {
		this.descricao = descricao;
		this.tempo = tempo;
		this.dosagem = dosagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Integer getCodReceita() {
		return codReceita;
	}
}
