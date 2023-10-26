package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.domains.Beneficiario;
import com.gft.testesulamerica.dtos.beneficiario.BeneficiarioDto;
import com.gft.testesulamerica.servises.BeneficiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;

    @GetMapping
    public List<BeneficiarioDto> getAllBeneficiarios() {
        return beneficiarioService.getAll().stream()
                .map(BeneficiarioDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<BeneficiarioDto> findBeneficiarios(@PathVariable String cpf) {
        Optional<Beneficiario> beneficiario = beneficiarioService.findBeneficiarios(cpf);
        if (beneficiario.isPresent()) {
            BeneficiarioDto dto = new BeneficiarioDto(beneficiario.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public BeneficiarioDto criaBeneficiario(@RequestBody BeneficiarioDto beneficiarioDto) {
        return new BeneficiarioDto(beneficiarioService.save(beneficiarioDto));
    }

}
