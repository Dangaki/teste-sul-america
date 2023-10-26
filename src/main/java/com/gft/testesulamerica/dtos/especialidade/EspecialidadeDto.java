package com.gft.testesulamerica.dtos.especialidade;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gft.testesulamerica.domains.Consulta;
import com.gft.testesulamerica.domains.Especialidade;

import java.util.Date;

public record EspecialidadeDto (
         Long codEspecialidade,
         String nmEspecialidade
) {

    public EspecialidadeDto(Especialidade especialidade) {
        this(
                especialidade.getCodEspecialidade(),
                especialidade.getNmEspecialidade()
        );
    }

    public static record ConsultaSaidaDto(
            Long codConsulta,
            Integer codEspecialidade,
            String cpfBeneficiario,
            @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "UTC")
            Date dataHoraConsulta
    ) {

        public ConsultaSaidaDto(Consulta consulta){
            this(
                    consulta.getCodConsulta(),
                    consulta.getCodEspecialidade(),
                    consulta.getCpfBeneficiario(),
                    consulta.getDataHoraConsulta()
            );
        }
    }
}
