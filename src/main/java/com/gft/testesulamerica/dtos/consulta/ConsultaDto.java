package com.gft.testesulamerica.dtos.consulta;

public record ConsultaDto(
        String cpfBenficiario,
        String nomeEspecialidade,
        String data,
        String hora
) {
}
