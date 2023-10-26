package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.dtos.consulta.ConsultaDto;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.servises.ConsultaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ConsultaControllerTest {

    @InjectMocks
    private ConsultaController consultaController;

    @Mock
    private ConsultaService consultaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateConsulta() throws ParseException {

        Date expectedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-11-26 14:30:00");
        ConsultaDto consultaDto = new ConsultaDto("1234567890", "EspecialidadeXYZ", "2023-11-26", "14:30");
        EspecialidadeDto.ConsultaSaidaDto expectedDto = new EspecialidadeDto.ConsultaSaidaDto(1L, 2, "1234567890", expectedDate);

        when(consultaService.save(consultaDto)).thenReturn(expectedDto);

        EspecialidadeDto.ConsultaSaidaDto result = consultaController.createConsulta(consultaDto);

        assertEquals(expectedDto, result);
    }

}