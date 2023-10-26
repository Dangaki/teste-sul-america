package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.servises.BeneficiarioService;
import com.gft.testesulamerica.servises.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SistemaController {

    private final BeneficiarioService beneficiarioService;
    private final ConsultaService consultaService;

    @PostMapping("/reset")
    public ResponseEntity<Void> resetaSistema() {
        consultaService.deleteAll();
        beneficiarioService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
