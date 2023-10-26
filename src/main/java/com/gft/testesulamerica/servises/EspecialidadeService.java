package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.repositories.EspecialidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> findAll() {
        return especialidadeRepository.findAll();
    }

    public Especialidade findByNomeEspecialidade(String nome) {
        return especialidadeRepository.findByNmEspecialidade(nome).orElseThrow(() -> new EntityNotFoundException("Especialidade not found for name: " + nome));
    }
}