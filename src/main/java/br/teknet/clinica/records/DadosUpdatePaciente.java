package br.teknet.clinica.records;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosUpdatePaciente(
    @NotNull
    Long id,

    String nome,
    String telefone,

    @Valid
    DadosEndereco endereco
) {
}
