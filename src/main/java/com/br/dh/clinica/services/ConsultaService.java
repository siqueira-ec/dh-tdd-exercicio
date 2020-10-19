package com.br.dh.clinica.services;

import java.util.List;

import com.br.dh.clinica.model.entities.Consulta;

public interface ConsultaService {
	List<Consulta> getAllConsultas();

	Consulta getConsultaByCod(Integer cod);

	Consulta saveConsulta(Consulta consulta);

	void deleteConsulta(Integer codigo);
}
