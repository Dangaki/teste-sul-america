package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.servises.BeneficiarioService;
import com.gft.testesulamerica.servises.ConsultaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SistemaControllerTest {

    @InjectMocks
    private SistemaController sistemaController;

    @Mock
    private BeneficiarioService beneficiarioService;

    @Mock
    private ConsultaService consultaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testResetaSistema() {

        doNothing().when(consultaService).deleteAll();
        doNothing().when(beneficiarioService).deleteAll();

        ResponseEntity<Void> response = sistemaController.resetaSistema();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(consultaService).deleteAll();
        verify(beneficiarioService).deleteAll();
    }

}