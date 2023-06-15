package com.estantedelivros.api.Service.Livro;

import com.estantedelivros.api.Domain.Categoria;
import com.estantedelivros.api.Domain.Livro;

import java.util.UUID;

public record DadosListagemDeLivros(UUID id, String titulo, Categoria categoria, String foto) {

    public DadosListagemDeLivros(Livro livro){
        this(livro.getId(), livro.getTitulo(), livro.getCategoria(), livro.getFoto());
    }
}
