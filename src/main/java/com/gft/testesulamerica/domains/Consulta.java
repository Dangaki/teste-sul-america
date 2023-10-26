package com.gft.testesulamerica.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbconsulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CONSULTA")
    private Long codConsulta;

    @Column(name = "COD_ESPECIALIDADE")
    private Integer codEspecialidade;

    @Column(name = "CPF_BENEFICIARIO")
    private String cpfBeneficiario;

    @Column(name = "DATA_HORA_CONSULTA")
    private Date dataHoraConsulta;
}