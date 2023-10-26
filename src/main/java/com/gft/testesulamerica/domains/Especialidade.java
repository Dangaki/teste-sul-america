package com.gft.testesulamerica.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbespecialidade")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_ESPECIALIDADE")
    private Long codEspecialidade;

    @Column(name = "NM_ESPECIALIDADE", length = 55, nullable = false)
    private String nmEspecialidade;

}
