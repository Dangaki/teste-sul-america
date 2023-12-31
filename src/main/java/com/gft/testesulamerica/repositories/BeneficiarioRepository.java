package com.gft.testesulamerica.repositories;

import com.gft.testesulamerica.domains.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, String> {

    Optional<Beneficiario> findByCpf(String cpf);
}