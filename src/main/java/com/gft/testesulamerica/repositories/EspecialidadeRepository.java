package com.gft.testesulamerica.repositories;

import com.gft.testesulamerica.domains.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {

    Optional<Especialidade> findByNmEspecialidade(String nome);
}