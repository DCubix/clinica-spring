package br.teknet.clinica.records;

import br.teknet.clinica.model.Endereco;
import br.teknet.clinica.model.Medico;

public record DadosDetalhamentoMedico(
    Long id,
    String nome,
    String email,
    String crm,
    String telefone,
    Especialidade especialidade,
    Endereco endereco
) {
    public DadosDetalhamentoMedico(Medico med) {
        this(med.getId(), med.getNome(), med.getEmail(), med.getCrm(), med.getTelefone(), med.getEspecialidade(), med.getEndereco());
    }
}
