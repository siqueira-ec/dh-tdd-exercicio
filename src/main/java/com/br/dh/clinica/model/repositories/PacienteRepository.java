package com.br.dh.clinica.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.dh.clinica.model.entities.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, String> {

}
