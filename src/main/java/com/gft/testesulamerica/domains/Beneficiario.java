package com.gft.testesulamerica.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbbeneficiario")
public class Beneficiario {
    @Id
    @Column(name = "CPF", length = 11, nullable = false)
    private String cpf;

    @Column(name = "NM_BENEFICIARIO", length = 55, nullable = false)
    private String nmBeneficiario;

    @Column(name = "DT_NASCIMENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

}
