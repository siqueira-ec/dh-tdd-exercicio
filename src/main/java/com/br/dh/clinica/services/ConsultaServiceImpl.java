package com.br.dh.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.br.dh.clinica.model.entities.Consulta;
import com.br.dh.clinica.model.repositories.ConsultaRepository;

public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	ConsultaRepository consultaRepository;

	@Override
	public List<Consulta> getAllConsultas() {
		return (List<Consulta>) consultaRepository.findAll();
	}

	@Override
	public Consulta getConsultaByCod(Integer cod) {
		return consultaRepository.findById(cod).orElse(null);
	}

	@Override
	public Consulta saveConsulta(Consulta consulta) {
		return consultaRepository.save(consulta);
	}

	@Override
	public void deleteConsulta(Integer codigo) {
		consultaRepository.deleteById(codigo);

	}

}
