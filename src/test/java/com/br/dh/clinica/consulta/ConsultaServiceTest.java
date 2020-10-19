package com.br.dh.clinica.consulta;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.br.dh.clinica.model.repositories.ConsultaRepository;
import com.br.dh.clinica.services.ConsultaServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ConsultaServiceTest {

	@InjectMocks
	ConsultaServiceImpl consultaServiceMock;

	@Mock
	ConsultaRepository consultaRepositoryMock;

	private Consulta c1, c2;

	private List<Consulta> consultasMock = new ArrayList<>();

	@Before
	public void configTest() {
		c1 = new Consulta(new Date(), 123.45, "consulta teste 1");
		c2 = new Consulta(new Date(), 456.78, "consulta teste 2");

		c1.setCodigo(1);
		c2.setCodigo(2);

		consultasMock.add(c1);
		consultasMock.add(c2);

		when(consultaRepositoryMock.save(any(Consulta.class))).thenReturn(c1);
		when(consultaRepositoryMock.findById(1)).thenReturn(Optional.of(c1));
		when(consultaRepositoryMock.findById(2)).thenReturn(Optional.of(c2));
		when(consultaRepositoryMock.findAll()).thenReturn(consultasMock);
	}

	@Test
	public void saveConsulta() {
		Consulta consulta = consultaServiceMock.saveConsulta(c1);

		assertEquals(consulta.getCodigo(), 1);
	}

	@Test
	public void getAllConsultas() {
		List<Consulta> consultas = consultaServiceMock.getAllConsultas();

		assertEquals(consultas, consultasMock);
	}

	@Test
	public void getConsultaByCod() {
		Consulta c1 = consultaServiceMock.getConsultaByCod(1);
		Consulta c2 = consultaServiceMock.getConsultaByCod(2);

		assertEquals(c1.getCodigo(), 1);
		assertEquals(c2.getCodigo(), 2);
	}
	
	@Test
	public void deletePacienteByCpf() {
		consultaServiceMock.deleteConsulta(1);

		verify(consultaRepositoryMock, times(1)).deleteById(anyInt());
	}
}
