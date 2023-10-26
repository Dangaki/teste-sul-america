package com.gft.testesulamerica.dtos.beneficiario;

import com.gft.testesulamerica.domains.Beneficiario;

import java.util.Date;

public record BeneficiarioDto(
        String cpf,
        String nome,
        Date dataNascimento

) {

    public BeneficiarioDto(Beneficiario beneficiario) {

        this(
                beneficiario.getCpf().trim(),
                beneficiario.getNmBeneficiario().trim(),
                beneficiario.getDtNascimento()
        );
    }

}
