package com.br.dh.clinica.paciente;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.dh.clinica.model.entities.Consulta;
import com.br.dh.clinica.model.entities.Paciente;
import com.br.dh.clinica.model.repositories.PacienteRepository;
import com.br.dh.clinica.services.PacienteServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PacienteServiceTest {

	@InjectMocks
	PacienteServiceImpl pacienteServiceMock;

	@Mock
	PacienteRepository pacienteRepositoryMock;

	private Paciente p1, p2;
	private Consulta c1, c2;
	private List<Consulta> consultasMock = new ArrayList<>();
	private List<Paciente> pacientesMock = new ArrayList<>();

	@Before
	public void configTest() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		c1 = new Consulta(new Date(), 123.45, "consulta teste 1");
		c2 = new Consulta(new Date(), 132.54, "consulta teste 2");

		p1 = new Paciente("matheus", "endereço teste", sdf.parse("11/01/1996"), "(91) 98123-4567", c1.getData(),
				"matheus@email.com", 79, 180, "123.456.789-00");
		p2 = new Paciente("teste", "endereço teste 2", sdf.parse("07/11/2013"), "(91) 98567-4321", c2.getData(),
				"teste@email.com", 28, 130, "132.456.879-10");

		c1.setCodigo(1);
		c1.setPaciente(p1);

		c2.setCodigo(2);
		c2.setPaciente(p2);

		p1.setConsultas(Arrays.asList(new Consulta[] { c1 }));
		p2.setConsultas(Arrays.asList(new Consulta[] { c2 }));

		consultasMock.add(c1);
		consultasMock.add(c2);

		pacientesMock.add(p1);
		pacientesMock.add(p2);

		when(pacienteRepositoryMock.save(any(Paciente.class))).thenReturn(p1);
		when(pacienteRepositoryMock.findById("123.456.789-00")).thenReturn(Optional.of(p1));
		when(pacienteRepositoryMock.findById("132.456.879-10")).thenReturn(Optional.of(p2));
		when(pacienteRepositoryMock.findAll()).thenReturn(pacientesMock);
	}

	@Test
	public void savePaciente() {
		Paciente paciente = pacienteServiceMock.savePaciente(p1);

		assertEquals(paciente.getCpf(), "123.456.789-00");
	}

	@Test
	public void getAllPacientes() {
		List<Paciente> pacientes = pacienteServiceMock.getAllPacientes();

		assertEquals(pacientes, pacientesMock);
	}

	@Test
	public void getPacienteByCpf() {
		Paciente p1Retorno = pacienteServiceMock.getPacienteByCpf("123.456.789-00");
		Paciente p2Retorno = pacienteServiceMock.getPacienteByCpf("132.456.879-10");

		assertEquals(p1Retorno.getCpf(), "123.456.789-00");
		assertEquals(p2Retorno.getCpf(), "132.456.879-10");
	}

	@Test
	public void deletePacienteByCpf() {
		pacienteServiceMock.deletePaciente("123.456.789-00");

		verify(pacienteRepositoryMock, times(1)).deleteById(anyString());
	}
}
