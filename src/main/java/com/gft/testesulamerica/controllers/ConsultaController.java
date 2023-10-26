package com.gft.testesulamerica.controllers;

import com.gft.testesulamerica.dtos.consulta.ConsultaDto;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.servises.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public EspecialidadeDto.ConsultaSaidaDto createConsulta(@RequestBody ConsultaDto consultaDto) {
        return consultaService.save(consultaDto);
    }
}
