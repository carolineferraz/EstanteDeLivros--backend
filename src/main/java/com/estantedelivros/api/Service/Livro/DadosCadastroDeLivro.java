package com.estantedelivros.api.Service.Livro;

import com.estantedelivros.api.Domain.Categoria;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDeLivro(

        @NotBlank(message = "Este campo não pode estar em branco")
        String titulo,
        String descricao,
        int qtdPaginas,
        Categoria categoria,
        String foto
) {
}
