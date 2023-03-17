package br.teknet.clinica.model;

import br.teknet.clinica.records.DadosCadastroPaciente;
import br.teknet.clinica.records.DadosUpdatePaciente;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "paciente")
@Entity(name = "Paciente")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome, email, cpf, telefone;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Paciente(DadosCadastroPaciente paciente) {
        id = null;
        nome = paciente.nome();
        email = paciente.email();
        cpf = paciente.cpf();
        telefone = paciente.telefone();
        endereco = new Endereco(paciente.endereco());
        ativo = true;
    }

    public void atualiza(DadosUpdatePaciente dados) {
        nome = dados.nome() != null ? dados.nome() : nome;
        telefone = dados.telefone() != null ? dados.telefone() : telefone;
        if (dados.endereco() != null) {
            endereco.atualiza(dados.endereco());
        }
    }

    public void excluir() {
        ativo = false;
    }

}
