package com.gft.testesulamerica.servises;

import com.gft.testesulamerica.domains.Consulta;
import com.gft.testesulamerica.domains.Especialidade;
import com.gft.testesulamerica.dtos.consulta.ConsultaDto;
import com.gft.testesulamerica.dtos.especialidade.EspecialidadeDto;
import com.gft.testesulamerica.repositories.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final EspecialidadeService especialidadeService;

    public void deleteAll() {
        consultaRepository.deleteAll();
    }

    public EspecialidadeDto.ConsultaSaidaDto save(ConsultaDto consultaDto) {

        Date dataDate;

        try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dataDate = dateFormat.parse(consultaDto.data() + " " + consultaDto.hora() + ":00");
        } catch (ParseException e) {
            throw new RuntimeException("Data format error");
        }

        Especialidade especialidade = especialidadeService.findByNomeEspecialidade(consultaDto.nomeEspecialidade());

        Consulta consulta = Consulta.builder()
                            .dataHoraConsulta(dataDate)
                            .cpfBeneficiario(consultaDto.cpfBenficiario())
                            .codEspecialidade(Math.toIntExact(especialidade.getCodEspecialidade()))
                            .build();

        return new EspecialidadeDto.ConsultaSaidaDto(consultaRepository.save(consulta));
    }
}
