package com.estantedelivros.api.Service.Usuario;

import com.estantedelivros.api.Domain.Usuario;

import java.util.UUID;

public record DadosListagemDeUsuarios(UUID id, String nome, int pontuacao) {

    public DadosListagemDeUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getPontuacao());
    }
}
