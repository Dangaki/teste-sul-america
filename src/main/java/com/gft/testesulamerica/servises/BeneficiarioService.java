package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Beneficiario;
import com.gft.testesulamerica.dtos.beneficiario.BeneficiarioDto;
import com.gft.testesulamerica.repositories.BeneficiarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> getAll() {
        return beneficiarioRepository.findAll();
    }

    public void deleteAll() {
        beneficiarioRepository.deleteAll();
    }

    public Beneficiario save(BeneficiarioDto beneficiarioDto) {

        Beneficiario beneficiario =  Beneficiario.builder()
                .cpf(beneficiarioDto.cpf().trim())
                .nmBeneficiario(beneficiarioDto.nome().trim())
                .dtNascimento(beneficiarioDto.dataNascimento())
                .build();

        return beneficiarioRepository.save(beneficiario);
    }

    public Optional<Beneficiario> findBeneficiarios(String cpf) {
        return beneficiarioRepository.findByCpf(cpf);
    }
}