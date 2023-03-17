package br.teknet.clinica.model;

import br.teknet.clinica.records.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    
    private String logradouro, bairro, cep,
                cidade, uf, numero,
                complemento;

    public Endereco(DadosEndereco endereco) {
        logradouro = endereco.logradouro();
        bairro = endereco.bairro();
        cep = endereco.cep();
        cidade = endereco.cidade();
        uf = endereco.uf();
        numero = endereco.numero();
        complemento = endereco.complemento();
    }

    public void atualiza(DadosEndereco dados) {
        logradouro = dados.logradouro() != null ? dados.logradouro() : logradouro;
        bairro = dados.bairro() != null ? dados.bairro() : bairro;
        cep = dados.cep() != null ? dados.cep() : cep;
        cidade = dados.cidade() != null ? dados.cidade() : cidade;
        uf = dados.uf() != null ? dados.uf() : uf;
        numero = dados.numero() != null ? dados.numero() : numero;
        complemento = dados.complemento() != null ? dados.complemento() : complemento;
    }

}
