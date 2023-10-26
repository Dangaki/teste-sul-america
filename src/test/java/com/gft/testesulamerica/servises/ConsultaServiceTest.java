package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Consulta;
import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.dtos.consulta.ConsultaDto;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.repositories.ConsultaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ConsultaServiceTest {

    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepository consultaRepository;

    @Mock
    private EspecialidadeService especialidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeleteAll() {
        consultaService.deleteAll();
        Mockito.verify(consultaRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    void testSave() throws ParseException {
        ConsultaDto consultaDto = new ConsultaDto("1234567890", "EspecialidadeXYZ", "2023-11-26", "14:30");
        Especialidade especialidade = new Especialidade(1L, "EspecialidadeXYZ");

        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-11-26 14:30:00");
        Consulta expectedConsulta = Consulta.builder()
                                            .codEspecialidade(1)
                                            .dataHoraConsulta(expectedDate)
                                            .cpfBeneficiario("1234567890")
                                            .build();

        when(especialidadeService.findByNomeEspecialidade("EspecialidadeXYZ")).thenReturn(especialidade);
        when(consultaRepository.save(Mockito.any(Consulta.class))).thenReturn(expectedConsulta);

        EspecialidadeDto.ConsultaSaidaDto result = consultaService.save(consultaDto);

        assertEquals(expectedConsulta.getDataHoraConsulta(), result.dataHoraConsulta());
        assertEquals(expectedConsulta.getCpfBeneficiario(), result.cpfBeneficiario());
        assertEquals(expectedConsulta.getCodEspecialidade(), result.codEspecialidade());
    }

}