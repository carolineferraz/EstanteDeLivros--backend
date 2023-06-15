package com.estantedelivros.api.Service.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import javax.persistence.Column;

public record DadosCadastroUsuario(

        @NotBlank(message = "Este campo não pode estar em branco")
        String nome,

        @NotBlank(message = "Este campo não pode estar em branco")
        @Email(message = "Este campo não contém um formato de e-mail válido")
        @Column(unique=true)
        String email,

        @NotBlank(message = "Este campo não pode estar em branco")
        @Size(min = 6, max = 28, message = "Este campo deve conter no mínimo 6 e no máximo 28 caracteres")
        String senha
) {
}