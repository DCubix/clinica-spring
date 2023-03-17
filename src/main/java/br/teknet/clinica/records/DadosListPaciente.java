package br.teknet.clinica.records;

import br.teknet.clinica.model.Paciente;

public record DadosListPaciente(
    String nome,
    String email,
    String cpf
) {
    public DadosListPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
