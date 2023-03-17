package br.teknet.clinica.records;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(
    Long id,
    Long idMedico,
    Long idPaciente,
    LocalDateTime data
) {
}
