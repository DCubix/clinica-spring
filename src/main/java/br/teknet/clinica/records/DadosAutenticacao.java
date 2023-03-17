package br.teknet.clinica.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(@Email @NotBlank String login, @NotBlank String senha) {
}
