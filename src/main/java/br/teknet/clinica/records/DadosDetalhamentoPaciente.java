package br.teknet.clinica.records;

import br.teknet.clinica.model.Endereco;
import br.teknet.clinica.model.Paciente;

public record DadosDetalhamentoPaciente(
    Long id,
    String nome, 
    String email,
    String cpf,
    String telefone,
    Endereco endereco
) {
    public DadosDetalhamentoPaciente(Paciente pac) {
        this(pac.getId(), pac.getNome(), pac.getEmail(), pac.getCpf(), pac.getTelefone(), pac.getEndereco());
    }
}
