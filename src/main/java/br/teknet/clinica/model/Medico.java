package br.teknet.clinica.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import br.teknet.clinica.records.DadosCadastroMedico;
import br.teknet.clinica.records.DadosUpdateMedico;
import br.teknet.clinica.records.Especialidade;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome, email, telefone, crm;

    @Column(name = "data_cadastro")
    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosCadastroMedico medico) {
        id = null;
        nome = medico.nome();
        email = medico.email();
        telefone = medico.telefone();
        crm = medico.crm();
        especialidade = medico.especialidade();
        endereco = new Endereco(medico.endereco());
        ativo = true;
    }

    public void atualiza(DadosUpdateMedico dados) {
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
