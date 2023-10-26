package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.servises.EspecialidadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EspecialidadeControllerTest {

    @InjectMocks
    private EspecialidadeController especialidadeController;

    @Mock
    private EspecialidadeService especialidadeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllEspecialidades() {
        List<Especialidade> especialidades = Arrays.asList(
                new Especialidade(1L, "Especialidade1"),
                new Especialidade(2L, "Especialidade2")
        );

        when(especialidadeService.findAll()).thenReturn(especialidades);

        List<EspecialidadeDto> result = especialidadeController.getAllEspecialidades();

        assertEquals(especialidades.size(), result.size());
    }

}