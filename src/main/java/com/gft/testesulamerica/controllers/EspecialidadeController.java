package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.dtos.beneficiario.BeneficiarioDto;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.servises.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/especialidades")
@RequiredArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @GetMapping
    public List<EspecialidadeDto> getAllEspecialidades() {
        return especialidadeService.findAll().stream()
                .map(EspecialidadeDto::new)
                .collect(Collectors.toList());
    }

}
