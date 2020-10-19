package com.br.dh.clinica.services;

import java.util.List;

import com.br.dh.clinica.model.entities.Paciente;

public interface PacienteService {
	List<Paciente> getAllPacientes();

	Paciente getPacienteByCpf(String cpf);

	Paciente savePaciente(Paciente paciente);

	void deletePaciente(String cpf);
}
