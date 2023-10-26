package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.repositories.EspecialidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EspecialidadeServiceTest {

    @InjectMocks
    private EspecialidadeService especialidadeService;

    @Mock
    private EspecialidadeRepository especialidadeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Especialidade> especialidades = Arrays.asList(
                new Especialidade(1L, "Especialidade1"),
                new Especialidade(2L, "Especialidade2")
        );

        when(especialidadeRepository.findAll()).thenReturn(especialidades);

        List<Especialidade> result = especialidadeService.findAll();

        assertEquals(especialidades, result);
    }

    @Test
    void testFindByNomeEspecialidade() {
        String nomeEspecialidade = "Especialidade1";
        Especialidade especialidade = new Especialidade(1L, nomeEspecialidade);

        when(especialidadeRepository.findByNmEspecialidade(nomeEspecialidade)).thenReturn(Optional.of(especialidade));

        Especialidade result = especialidadeService.findByNomeEspecialidade(nomeEspecialidade);

        assertEquals(especialidade, result);
    }

    @Test
    void testFindByNomeEspecialidadeNotFound() {
        String nomeEspecialidade = "NonExistentEspecialidade";

        when(especialidadeRepository.findByNmEspecialidade(nomeEspecialidade)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> especialidadeService.findByNomeEspecialidade(nomeEspecialidade));
    }

}