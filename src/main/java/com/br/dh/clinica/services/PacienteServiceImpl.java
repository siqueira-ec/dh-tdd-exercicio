package com.br.dh.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.dh.clinica.model.entities.Paciente;
import com.br.dh.clinica.model.repositories.PacienteRepository;

public class PacienteServiceImpl implements PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public List<Paciente> getAllPacientes() {
		return (List<Paciente>) pacienteRepository.findAll();
	}

	@Override
	public Paciente getPacienteByCpf(String cpf) {
		return pacienteRepository.findById(cpf).orElse(null);
	}

	@Override
	public Paciente savePaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	@Override
	public void deletePaciente(String cpf) {
		pacienteRepository.deleteById(cpf);
	}

}
