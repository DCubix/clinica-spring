package br.teknet.clinica.records;

import br.teknet.clinica.model.Medico;

public record DadosListMedico(
    Long id,
    String nome,
    String email,
    String crm,
    Especialidade especialidade
) {

    public DadosListMedico(Medico med) {
        this(med.getId(), med.getNome(), med.getEmail(), med.getCrm(), med.getEspecialidade());
    }
}
