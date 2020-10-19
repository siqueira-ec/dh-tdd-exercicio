package com.br.dh.clinica.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Paciente {
	@Id
	@Column(name="cpf")
	private String cpf;
	
	private String nome;
	private String endereco;
	
	@Column(name="dt_nascimento")
	private Date dataNascimento;
	
	private String telefone;
	
	@Column(name="dt_primeira_consulta")
	private Date dataPrimeiraConsulta;
	
	private String email;
	private Integer peso;
	private Integer altura;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
	@JsonIgnoreProperties(value = "paciente")
	private List<Consulta> consultas;

	public Paciente() {}

	public Paciente(String nome, String endereco, Date dataNascimento, String telefone, Date dataPrimeiraConsulta,
			String email, Integer peso, Integer altura, String cpf) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataPrimeiraConsulta() {
		return dataPrimeiraConsulta;
	}

	public void setDataPrimeiraConsulta(Date dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}
