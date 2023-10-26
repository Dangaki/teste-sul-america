package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Beneficiario;
import com.gft.testesulamerica.dtos.beneficiario.BeneficiarioDto;
import com.gft.testesulamerica.repositories.BeneficiarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BeneficiarioServiceTest {

    @InjectMocks
    private BeneficiarioService beneficiarioService;

    @Mock
    private BeneficiarioRepository beneficiarioRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<Beneficiario> beneficiarios = new ArrayList<>();

        Mockito.when(beneficiarioRepository.findAll()).thenReturn(beneficiarios);

        List<Beneficiario> result = beneficiarioService.getAll();
        assertEquals(beneficiarios, result);
    }

    @Test
    void testDeleteAll() {
        beneficiarioService.deleteAll();
        Mockito.verify(beneficiarioRepository, Mockito.times(1)).deleteAll();
    }

    @Test
    void testSave() {
        String dateStr = "1990-01-15";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date;

        try {
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Erro na data");
        }

        BeneficiarioDto beneficiarioDto = new BeneficiarioDto("12345", "John Doe", date);
        Beneficiario beneficiario = new Beneficiario();
        Mockito.when(beneficiarioRepository.save(Mockito.any(Beneficiario.class))).thenReturn(beneficiario);

        Beneficiario result = beneficiarioService.save(beneficiarioDto);
        assertEquals(beneficiario, result);
    }

    @Test
    void testFindBeneficiarios() {
        String cpf = "12345678901";
        Beneficiario beneficiario = new Beneficiario();
        Mockito.when(beneficiarioRepository.findByCpf(cpf)).thenReturn(Optional.of(beneficiario));

        Optional<Beneficiario> result = beneficiarioService.findBeneficiarios(cpf);
        assertTrue(result.isPresent());
        assertEquals(beneficiario, result.get());
    }
}