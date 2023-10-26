package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.domains.Beneficiario;
import com.gft.testesulamerica.dtos.beneficiario.BeneficiarioDto;
import com.gft.testesulamerica.servises.BeneficiarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BeneficiarioControllerTest {


    @InjectMocks
    private BeneficiarioController beneficiarioController;

    @Mock
    private BeneficiarioService beneficiarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBeneficiarios() {
        List<Beneficiario> beneficiarios = Arrays.asList(
                new Beneficiario("1234567890", "John Doe", null),
                new Beneficiario("9876543210", "Jane Smith", null)
        );
        when(beneficiarioService.getAll()).thenReturn(beneficiarios);

        List<BeneficiarioDto> result = beneficiarioController.getAllBeneficiarios();

        assertEquals(beneficiarios.size(), result.size());
    }

    @Test
    void testFindBeneficiariosFound() {

        String cpf = "1234567890";
        Beneficiario beneficiario = new Beneficiario(cpf, "John Doe", null);
        when(beneficiarioService.findBeneficiarios(cpf)).thenReturn(Optional.of(beneficiario));

        ResponseEntity<BeneficiarioDto> response = beneficiarioController.findBeneficiarios(cpf);

        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testFindBeneficiariosNotFound() {

        String cpf = "1234567890";
        when(beneficiarioService.findBeneficiarios(cpf)).thenReturn(Optional.empty());

        ResponseEntity<BeneficiarioDto> response = beneficiarioController.findBeneficiarios(cpf);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCriaBeneficiario() {
        BeneficiarioDto beneficiarioDto = new BeneficiarioDto("1234567890", "John Doe", null);
        when(beneficiarioService.save(beneficiarioDto)).thenReturn(new Beneficiario("1234567890", "John Doe", null));

        BeneficiarioDto result = beneficiarioController.criaBeneficiario(beneficiarioDto);

        assertEquals(beneficiarioDto.cpf(), result.cpf());
    }

}